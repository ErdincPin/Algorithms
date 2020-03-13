/* *****************************************************************************
 *  Name:
 *  Date:
 *  Description:
 **************************************************************************** */

package model;

public class PercolationStat {
    private double mean, stddev, conf95lo, conf95hi;

    public PercolationStat(double mean, double stddev, double conf95lo, double conf95hi){
        this.mean = mean;
        this.stddev = stddev;
        this.conf95lo = conf95lo;
        this.conf95hi = conf95hi;
    }

    public double getMean() {
        return mean;
    }

    public void setMean(double mean) {
        this.mean = mean;
    }

    public double getStddev() {
        return stddev;
    }

    public void setStddev(double stddev) {
        this.stddev = stddev;
    }

    public double getConf95lo() {
        return conf95lo;
    }

    public void setConf95lo(double conf95lo) {
        this.conf95lo = conf95lo;
    }

    public double getConf95hi() {
        return conf95hi;
    }

    public void setConf95hi(double conf95hi) {
        this.conf95hi = conf95hi;
    }
}
