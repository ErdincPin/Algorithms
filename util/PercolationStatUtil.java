package util;

import edu.princeton.cs.algs4.StdStats;

/* *****************************************************************************
 *  Name: Erdinc Pinar
 *  Date: 28 Jan 2020
 *  Description: Coursera Algorithms Part I Percolation Assignment
 **************************************************************************** */
public class PercolationStatUtil {
    private double[] means;
    private int trialcount;



    // Constructor
    public PercolationStatUtil(){

    }

    public PercolationStatUtil(double [] means, int trialcount){
        this.means = means;
        this.trialcount = trialcount;
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

    public double[] getMeans() {
        return means;
    }

    public void setMeans(double[] means) {
        this.means = means;
    }

    public int getTrialcount() {
        return trialcount;
    }

    public void setTrialcount(int trialcount) {
        this.trialcount = trialcount;
    }
}
