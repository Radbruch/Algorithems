package week1.StandardAnswer;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.WeightedQuickUnionUF;

// https://zhangxycc.github.io/2019/01/23/Coursera-Algorithm-Week1/#more

public class Percolation {
    private boolean[] map; //用了一维数组，因为相比于二维数组，一维的代码更简洁明了.
    private WeightedQuickUnionUF union; // 第一个一维数组，前两位是virtualTop 和 virtualBottom,用union表示，判断是否percolate.
    private WeightedQuickUnionUF backwash; //第二个一维数组，第一位是virtualTop，用backwash表示，判断是否full.
    private int N;
    private int numOpen;
    public Percolation(int n) {
        // create n-by-n grid, with all sites blocked
        if(n <= 0) {
            throw new java.lang.IllegalArgumentException();
        }
        map = new boolean[n * n + 2];
        union = new WeightedQuickUnionUF(n * n +2);
        backwash = new WeightedQuickUnionUF(n * n +1);
        N = n;
        numOpen = 0;

    }
    public void open(int row, int col) {
        // open site (row, col) if it is not open already
        if(row <= 0 || row > N || col <= 0 || col > N) {
            throw new java.lang.IllegalArgumentException();
        }
        int index = (row -1) * N + col + 1;
        if(map[index])	return;
        numOpen++;
        map[index] = true;
        if(row == 1) { // 如果该site是第一行，分别连接 union和backwash 的 virtualTop和site.
            union.union(index, 0);
            backwash.union(index-1, 0);
        }
        if(row == N) { // 如果该site是最后一行，连接 union 上的 virtualBottom 和 site.
            union.union(index, 1);
        }
        if(row != 1 && map[index - N]) { // 如果row不是第一行，且该site上方open了，将 union 和 backwash上的site和site上方的点连接。
            union.union(index, index-N);
            backwash.union(index-1, index-N-1);
        }
        if(row != N && map[index + N]) { // 如果row不是最后一行，且该site下方open了，将 union 和 backwash上的site和site下方的点连接。
            union.union(index, index+N);
            backwash.union(index-1, index+N-1);
        }
        if(col != 1 && map[index - 1]) { // 如果col不是第一列，且该site左边open了，将 union 和 backwash上的site和site左方的点连接。
            union.union(index, index-1);
            backwash.union(index-1, index-2);
        }
        if(col != N && map[index + 1]) { // 如果col不是最后一列，且该site右边open了，将 union 和 backwash上的site和site右边的点连接。
            union.union(index, index+1);
            backwash.union(index-1, index);
        }
    }
    public boolean isOpen(int row, int col) {
        // is site (row, col) open?
        if(row <= 0 || row > N || col <= 0 || col > N) {
            throw new java.lang.IllegalArgumentException();
        }
        return map[(row -1) * N + col + 1];
    }
    public boolean isFull(int row, int col) {
        // is site (row, col) full?
        if(row <= 0 || row > N || col <= 0 || col > N) {
            throw new java.lang.IllegalArgumentException();
        }
        return backwash.connected((row -1) * N + col, 0);
    }
    public int numberOfOpenSites() {
        // number of open sites
        return numOpen;
    }
    public boolean percolates() {
        // does the system percolate?
        return union.connected(0,1);
    }
    public static void main(String[] args) {
        // TODO Auto-generated method stub
    }
}
