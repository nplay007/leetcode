package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import interview.Fruit;
import junit.framework.TestCase;;

public class Fruit_T extends TestCase {
    public Fruit_T(String method) {
        super(method);
    }

    private Fruit solution;
    private List<List<String>> codeList;
    private List<String> shopCart;

    @Override
    protected void setUp() {
        solution = new Fruit();
        codeList = new ArrayList<>();
        shopCart = new ArrayList<>();
    }

    public void testEmpty() {
        assertTrue(solution.getFruit(codeList, shopCart));
    }

    public void testNormal() {
        List<String> l1 = new ArrayList<String>(Arrays.asList("orange", "banana", "orange"));
        List<String> l2 = new ArrayList<String>(Arrays.asList("apple", "apple"));
        codeList.add(l1);
        codeList.add(l2);
        shopCart.addAll(new ArrayList<String>(Arrays.asList("orange", "banana", "orange", "mango", "apple", "apple")));
        assertTrue(solution.getFruit(codeList, shopCart));
    }

    public void testAnything() {
            List<String> l1 = new ArrayList<String>(Arrays.asList("orange", "banana", "orange"));
            List<String> l2 = new ArrayList<String>(Arrays.asList("apple", "apple"));
            List<String> l3 = new ArrayList<String>(Arrays.asList("anything"));
            codeList.add(l1);
            codeList.add(l2);
            codeList.add(l3);
            shopCart.addAll(new ArrayList<String>(Arrays.asList("orange", "banana", "orange", "mango", "apple", "apple", "mango")));
            assertTrue(solution.getFruit(codeList, shopCart));
    }
}
