package hw4.parallel;


import org.junit.*;
import org.junit.Test;

import java.util.Random;

/**
 * Created by ivan on 12.07.15.
 */
public class MyArrayListTestCopy extends Assert {

    private MyArrayList<Integer> normalList;
    private MyArrayList<Integer> emptyList;
    private MyArrayList<Integer> oneElementList;
    private MyArrayList<Integer> myArrayList;


    @Before
    public void setUpLists() {
        Random random = new Random();
        normalList = new MyArrayList<Integer>(1000);
        for (int i = 0; i < 1000; i++) {
            normalList.add(random.nextInt(500));
        }
        emptyList = new MyArrayList<Integer>(0);
        oneElementList = new MyArrayList<Integer>();
        oneElementList.add(random.nextInt(10));
        myArrayList = new MyArrayList<Integer>();
    }

    @Ignore
    @Test
    public void parallelIndexOfExcitingElement() {
        Integer exEl = (Integer) normalList.get(100);
        assertEquals("ERROR", 100, normalList.parallelIndexOf(exEl));
    }

    @Test
    public void parallelIndexOfNonexcitingElement() {
        assertEquals("ERROR", -1, normalList.parallelIndexOf(600));
    }

    @Test
    public void parallelIndexOfNonexcitingelementInEmptyList() {
        assertEquals("ERROR", -1, emptyList.parallelIndexOf(10));
    }

    @Test
    public void parallelIndexOfNonexcitingelementInOneElementList() {
        assertEquals("ERROR", -1, oneElementList.parallelIndexOf(11));
    }

    @Ignore
    @Test
    public void parallelIndexOfExcitingelementInEmptyList() {
        Integer element = (Integer)oneElementList.get(0);
        assertEquals("ERROR", 0, oneElementList.parallelIndexOf(3));
    }

    @Test(expected = NullPointerException.class)
    public void parallelIndexOfNullElementInList(){
        normalList.parallelIndexOf(null);
    }

    @After
    public void removeData() {
        normalList.clear();
    }
}
