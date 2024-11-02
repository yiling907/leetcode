package test;

import bfs.BFSSolution;
import org.junit.Assert;
import org.junit.Test;

public class BFSSolutionTest {

    private BFSSolution bfsSolution;

    @Test
    public void testCombine() {
        int[][] grid = {
                {0}
        };

        Assert.assertEquals(-1,bfsSolution.orangesRotting(grid));
    }
}
