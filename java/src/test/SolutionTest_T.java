package test;
import JavaAnswer.SolutionTest;
import junit.framework.TestCase;

public class SolutionTest_T extends TestCase {
    public SolutionTest_T(String method) {
        super(method);
    }

    private SolutionTest solution;

    @Override
    protected void setUp() {
        solution = new SolutionTest();
    }

    public void testEmpty() {
        assertEquals(solution.getNext("ababaa"), 11);
    }
}
