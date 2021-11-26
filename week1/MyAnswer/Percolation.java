package week1.MyAnswer;

public class Percolation {

    //private int system[][];
    private int system[][];
    private int OpenSiteNumber;
    private int range;
    // if isPercolation == 1, system is percolation; else, not percolation.
    private int isPercolation;

    /* creates n-by-n grid, with all sites initially blocked. */
    public Percolation(int n){
        // open == 1, open and full == 2, not open == 0;
        system = new int[n][n];
        OpenSiteNumber = 0;
        range = n;
        isPercolation = 0;
        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++) system[i][j] = 0;
        }
    }

    /* opens the site (row, col) if it is not open already, index begin with 1. */
    public void open(int row, int col){
        row -= 1; col -= 1;
        if (row < 0 || col < 0) throw new IllegalArgumentException("indice must larger than 0");
        if (row >= range || col >= range) throw new IllegalArgumentException("indice out of range");

        if (system[row][col] == 0) {
            system[row][col] = 1;
            OpenSiteNumber += 1;
            // judge if new open site need to be full.
            full(row, col);
        }
    }

    /* this method only executed after being opened, index start from 0. */
    private void full(int row, int col){
        if (row < 0 || col < 0) throw new IllegalArgumentException("indice must larger than 0");
        if (row >= range || col >= range) throw new IllegalArgumentException("indice out of range");
        // if not open or already full, return null.
        if (system[row][col] == 0 || system[row][col] == 2) return;
        // if first row is open, then it must be full.
        if (row == 0 && system[row][col] == 1) {
            system[row][col] = 2;
            // check whether turn to full below first row
            if (isOpen(row+1, col)) full(row+1, col);
        }
        // first column but not last row only has three neighborhoods.
        else if(col == 0 && row != range - 1){
            if (isFull(row-1,col) || isFull(row, col+1) || isFull(row+1, col)) {
                system[row][col] = 2;
                // check if three neighborhoods need to turn to full.
                if (isOpen(row-1, col)) full(row-1, col);
                if (isOpen(row, col+1)) full(row, col+1);
                if (isOpen(row+1, col)) full(row+1, col);
            }
            else return;
        }
        // last column but not last row only has three neighborhoods.
        else if(col == range-1 && row != range -1){
            if (isFull(row, col-1) || isFull(row-1, col) || isFull(row+1, col)) {
                system[row][col] = 2;
                // check if three neighborhoods need to turn to full.
                if (isOpen(row-1, col)) full(row-1, col);
                if (isOpen(row, col-1)) full(row, col-1);
                if (isOpen(row+1, col)) full(row+1, col);
            }
            else return;
        }
        // the bottom left only has two neighborhoods.
        else if(row == range-1 && col == 0){
            if (isFull(row-1, col) || isFull(row, col+1)) {
                system[row][col] = 2;
                if (isPercolation == 0) isPercolation = 1;
                // check if two neighborhoods need to turn to full.
                if (isOpen(row-1, col)) full(row-1, col);
                if (isOpen(row, col+1)) full(row, col+1);
            }
            else return;
        }
        // the bottom right only has two neighborhoods.
        else if(row == range-1 && col ==range-1){
            if (isFull(row-1, col) || isFull(row, col-1)) {
                system[row][col] = 2;
                if (isPercolation == 0) isPercolation = 1;
                // check if two neighborhoods need to turn to full.
                if (isOpen(row-1, col)) full(row-1, col);
                if (isOpen(row, col-1)) full(row, col-1);
            }
            else return;

        }
        // the bottom row expect the most left and right, has three neighborhoods.
        else if (row == range-1 && col != 0 && col != range-1){
            if (isFull(row, col-1) || isFull(row, col+1) || isFull(row-1, col)) {
                system[row][col] = 2;
                if (isPercolation == 0) isPercolation = 1;
                // check if three neighborhoods need to turn to full.
                if (isOpen(row-1, col)) full(row-1, col);
                if (isOpen(row, col-1)) full(row, col-1);
                if (isOpen(row, col+1)) full(row, col+1);
            }
            else return;
        }

        else {
            if (isFull(row, col-1) || isFull(row, col+1) || isFull(row-1, col) || isFull(row+1, col)){
                system[row][col] = 2;
                // check if four neighborhoods need to turn to full.
                if (isOpen(row-1, col)) full(row-1, col);
                if (isOpen(row, col-1)) full(row, col-1);
                if (isOpen(row, col+1)) full(row, col+1);
                if (isOpen(row+1, col)) full(row+1, col);
            }
            else return;
        }
    }


    /* is the site(row,col) open? Index begin with 0. */
    public boolean isOpen(int row, int col){
        //row -= 1; col -= 1;
        if (row < 0 || col < 0) throw new IllegalArgumentException("indice must larger than 0");
        if (row >= range || col >= range) throw new IllegalArgumentException("indice out of range");

        return system[row][col] == 1;
    }

    /* is the site(row, col) full? Index begin with 0. */
    public boolean isFull(int row, int col){
        //row -= 1; col -= 1;
        if (row < 0 || col < 0) throw new IllegalArgumentException("indice must larger than 0");
        if (row >= range || col >= range) throw new IllegalArgumentException("indice out of range");

        return system[row][col] == 2;
    }

    /* returns the number of open sites. */
    public int numberOfOpenSites(){
        return OpenSiteNumber;
    }

    /* does the system percolate? */
    public boolean percolates(){
        return isPercolation == 1;
    }



}

