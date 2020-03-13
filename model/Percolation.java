package model;
/*
 *****************************************************************************
 *  Name: Erdinc Pinar
 *  Date: 28 Jan 2020
 *  Description: Coursera Algorithms Part I Percolation Assignment
 ****************************************************************************
 */

import edu.princeton.cs.algs4.WeightedQuickUnionUF;


public class Percolation {
    public boolean[][] newgrid;
    private WeightedQuickUnionUF wquUF;
    private int gridlen;
    private int topnode;
    private int bottomnode;

    // creates n-by-n grid, with all sites initially blocked
    public Percolation(int n) {
        wquUF = new WeightedQuickUnionUF(n * n - 1 + 2 + 1); //+2 are top & bottom nodes
        int gridsize = n * n - 1;
        gridlen = n;
        newgrid = new boolean[n][n];
        topnode = gridsize + 1;
        bottomnode = topnode + 1;
    }

    // opens the site (row, col) if it is not open already
    public void open(int row, int col) {
        if (!isOpen(row, col)) {
            newgrid[row][col] = true;
            if (row == 0) {
                wquUF.union(topnode, col);
            }
            if (row == gridlen - 1) {
                wquUF.union(bottomnode, gridlen * (gridlen - 1) + col);
            }
            if (row > 0 && isOpen(row - 1, col)) {
                wquUF.union(row * gridlen + col, (row - 1) * gridlen + col);
            }
            if (col < gridlen - 1 && isOpen(row, col + 1)) {
                wquUF.union(row * gridlen + col + 1, row * gridlen + col);
            }
            if (col > 0 && isOpen(row, col - 1)) {
                wquUF.union(row * gridlen + col - 1, row * gridlen + col);
            }
            if (row < gridlen - 1 && isOpen(row + 1, col)) {
                wquUF.union(row * gridlen + col, (row + 1) * gridlen + col);
            }
        }
    }

    // is the site (row, col) open?
    public boolean isOpen(int row, int col) {
        return newgrid[row][col];
    }

    // is the site (row, col) full?
    public boolean isFull(int row, int col) {
        return wquUF.connected(topnode, row * gridlen + col);

    }

    // returns the number of open sites
    public int numberOfOpenSites() {
        int k = 0;
        for (int i = 0; i < gridlen; i++) {
            for (int j = 0; j < gridlen; j++) {
                if (isOpen(i, j)) {
                    k++;
                }
            }
        }
        return k;
    }

    // does the system percolate?
    public boolean percolates() {
        return wquUF.connected(topnode, bottomnode);
    }

}
