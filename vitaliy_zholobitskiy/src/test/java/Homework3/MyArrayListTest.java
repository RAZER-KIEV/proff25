package Homework3;

import hw4.parallel.MyArrayList;
import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by just1ce on 07.06.2015.
 */
public class MyArrayListTest extends TestCase {

    MyArrayList<Integer> module;
    @Before
    public void setUp(){
        module = new MyArrayList<>();
        for (int i = 0; i < 1000; i++)
            module.add(i);
    }
    @Test
    public void testExistingElement(){
        int actual = module.parallelIndexOf(502);
        int expected = 502;
        assertEquals(expected, actual);
    }
    @Before
    public void setUp1(){
        module = new MyArrayList<>();
        for (int i = 0; i < 1000; i++)
            module.add(i);
    }
    @Test
    public void testNotExistingElement(){
        int actual = module.parallelIndexOf(15155);
        int expected = -1;
        assertEquals(expected, actual);
    }
    @Before
    public void setUp3(){
        module = new MyArrayList<>();
    }
    @Test
    public void testNotExistingElementInEmptyList(){
        int actual = module.parallelIndexOf(15155);
        int expected = -1;
        System.out.println(module.size());
        assertEquals(expected, actual);
    }

}