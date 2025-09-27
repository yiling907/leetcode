import bfs.BFSSolution;
import junit.framework.TestCase;
import org.junit.Assert;

public class backtrackingSolutionTest extends TestCase {

    private final BacktrackingSolution backtrackingSolution=new BacktrackingSolution();

    public void testGenerateParenthesis() {

        Assert.assertEquals(-1,backtrackingSolution.generateParenthesis(8));
    }
}