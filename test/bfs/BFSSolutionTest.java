package bfs;

import org.junit.Assert;
import org.junit.Test;

public class BFSSolutionTest {

    private final BFSSolution bfsSolution=new BFSSolution();

    @Test
    public void testCombine() {
        int[][] grid = {
                {0}
        };

        Assert.assertEquals(-1,bfsSolution.orangesRotting(grid));
    }
}
