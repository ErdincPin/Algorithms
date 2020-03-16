
/* *****************************************************************************
 *  Name:
 *  Date:
 *  Description:
 **************************************************************************** */

import edu.princeton.cs.algs4.StdRandom;
import model.Percolation;
import model.PercolationStat;
import util.PercolationStatUtil;

public class MainApplication {
    private static double[] meansArr;
    private static int[] minsArr;

    public static void initArrs(int size) {
        meansArr = new double[size];
        minsArr = new int[size];
    }

    public static void main(String[] args) {

        PercolationStatUtil percolationStatUtil = new PercolationStatUtil();

        int numGrid = Integer.parseInt(args[0]);
        int trial = Integer.parseInt(args[1]);
        int temp = 10;
        initArrs(trial);

        for (int i = 0; i < trial; i++) {
            Percolation grid = new Percolation(numGrid);
            int min = 0;

            while (!grid.percolates()) {
                int row = StdRandom.uniform(numGrid);
                int col = StdRandom.uniform(numGrid);
                grid.open(row, col);
                min++;
            }

            meansArr[i] = (double)grid.numberOfOpenSites() / (numGrid * numGrid);
            minsArr[i] = min;
        }

        // Stats
        PercolationStat percolationStat = getStats(percolationStatUtil, meansArr, trial);
        System.out.println("mean                    = " + percolationStat.getMean());
        System.out.println("stddev                  = " + percolationStat.getStddev());
        System.out.println("95% confidence interval = [" + percolationStat.getConf95lo() + ", " + percolationStat.getConf95hi() +"]");
    }

    public static PercolationStat getStats(PercolationStatUtil percolationStatUtil, double[] meansArr, int trial){
        percolationStatUtil.setMeans(meansArr);
        percolationStatUtil.setTrialcount(trial);
        return new PercolationStat(percolationStatUtil.mean(), percolationStatUtil.stddev(), percolationStatUtil.confidenceLo(), percolationStatUtil.confidenceHi());
    }
}