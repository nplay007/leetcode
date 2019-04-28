package test;

import junit.framework.*;

import interview.itoa;

public class itoa_T extends TestCase {
    public itoa_T(String method) {
        super(method);
    }

    private itoa solution;

    @Override
    protected void setUp() {
        solution = new itoa();
    }

    public void testEmpty() {
        String expected = "0";
        assertEquals(expected, solution.getItoa(0, 10));
    }

    public void testTenBase() {
        String expected = "12";
        assertEquals(expected, solution.getItoa(12, 10));
    }

    public void testTwoBase() {
        String expected = "1100";
        assertEquals(expected, solution.getItoa(12, 2));
    }

    public void testNegative() {
        String expected = "-12";
        assertEquals(expected, solution.getItoa(-12, 10));
    }
}
