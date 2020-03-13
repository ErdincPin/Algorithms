import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;

/* *****************************************************************************
 *  Name:Name: Erdinc Pinar
 *  Date: 28 Jan 2020
 *  Description: Coursera Algorithms Part I Percolation Assignment
 **************************************************************************** */
public class PercolationStats {
    private double[] means;
    private int trialcount;

    // perform independent trials on an n-by-n grid
    public PercolationStats(int n, int trials) {
        trialcount = trials;
        for (int i = 0; i < trials; i++) {
            Percolation newPercolation = new Percolation(n);
            int j = 0;
            while (!newPercolation.percolates()) {
                int row = StdRandom.uniform(n);
                int col = StdRandom.uniform(n);
                newPercolation.open(row, col);
                j++;
            }
            means[i]=newPercolation.numberOfOpenSites()/(n*n);

        }

    }

    // sample mean of percolation threshold
    public double mean() {
        return StdStats.mean(means);

    }

    // sample standard deviation of percolation threshold
    public double stddev() {
        return StdStats.stddev(means);
    }

    // low endpoint of 95% confidence interval
    public double confidenceLo() {
        return mean() - 1.96*(stddev()/Math.sqrt(trialcount));
    }

    // high endpoint of 95% confidence interval
    public double confidenceHi() {
        return mean() + 1.96*(stddev()/Math.sqrt(trialcount));
    }



    public static void main(String[] args) {
        //int n = args[0];
        //int T = args[1];
        PercolationStats percStats = new PercolationStats(10, 100);
        System.out.println("mean = " + percStats.mean());
        System.out.println("stddev = " + percStats.stddev());
         System.out.println("95% confidence interval = " + "[" +percStats.confidenceLo() +
                                    ", " + percStats.confidenceHi()+"]");
        System.out.println("test");
    }
}
