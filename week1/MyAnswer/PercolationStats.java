package week1.MyAnswer;
import edu.princeton.cs.algs4.StdStats;
import edu.princeton.cs.algs4.Stopwatch;
import  edu.princeton.cs.algs4.StdRandom;

public class PercolationStats {

    private double[] threshold;
    private Percolation system;
    private int row;
    private int col;
    private double fraction;
    private double numerator;
    private double denumerator;

    // perform independent trials on an n-by-n grid
    public PercolationStats(int n, int trials){
        if (n <= 0 || trials <= 0) throw new IllegalArgumentException();

        threshold = new double[trials];

        for(int i = 1; i <= trials; i++){
            // initialize percolation system.
            Percolation system = new Percolation(n);
            while( system.percolates() == false){
                row = StdRandom.uniform(1,n+1);
                col = StdRandom.uniform(1,n+1);
                system.open(row,col);
            }
            numerator = system.numberOfOpenSites();
            denumerator = (n * n);
            fraction = numerator / denumerator;
            threshold[i-1] = fraction;
        }
    }

    // sample mean of percolation threshold
    public double mean(){
        double ans = StdStats.mean(threshold);
        return ans;
    }

    // sample standard deviation of percolation threshold
    public double stddev(){
        double ans = StdStats.stddev(threshold);
        return ans;
    }

    // low endpoint of 95% confidence interval
    public double confidenceLo(){
        double T = threshold.length;
        double sqrtT = Math.sqrt(T);
        double ans = mean() - (1.96 * stddev() / sqrtT);
        return ans;
    }

    // high endpoint of 95% confidence interval
    public double confidenceHi(){
        double T = threshold.length;
        double sqrtT = Math.sqrt(T);
        double ans = mean() + (1.96 * stddev() / sqrtT);
        return ans;
    }

    // test client (see below)
    public static void main(String[] args) {
        int N = Integer.parseInt(args[0]);
        int T = Integer.parseInt(args[1]);
        PercolationStats percolationStats = new PercolationStats(N, T);
        System.out.println("The Mean is-->" + percolationStats.mean());
        System.out.println("The Standard Deviation is-->" + percolationStats.stddev());
        System.out.println("The 95% confidence interval is-->" + percolationStats.confidenceLo() + ", "
                + percolationStats.confidenceHi());
    }
    //public static void main(String[] args){

    //    Stopwatch stopwatch = new Stopwatch();

    //    PercolationStats a = new PercolationStats(200,10000);
    //    System.out.println(a.mean());
    //    System.out.println(a.stddev());
    //    System.out.println(a.confidenceLo());
    //    System.out.println(a.confidenceHi());

    //    double time = stopwatch.elapsedTime();
    //    System.out.println(time);

    //}
}
