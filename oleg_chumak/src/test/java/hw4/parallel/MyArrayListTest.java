package hw4.parallel;

import org.junit.Before;
import org.junit.Test;

/**
 * Created by oleg on 03.06.15.
 */
public class MyArrayListTest {
    MyArrayList<Integer> list = new MyArrayList<>();

    @Before
    public void setUp(){
        list.clear();
    }

    @Test
//    - существующего элемента
    public void testDefined() throws InterruptedException {
        int expectedValue = 13;
        for (int i = 0; i < 18; i++) {
            list.add(i * 10);
        }
        int facticalValue = list.parallelIndexOf(130);
        org.junit.Assert.assertEquals(expectedValue, facticalValue);
    }


    @Test
//    - не существующего элемента
    public void testUndefined() throws InterruptedException {
        int expectedValue = -1;
        for (int i = 0; i < 18; i++) {
            list.add(i * 10);
        }
        int facticalValue = list.parallelIndexOf(135);
        org.junit.Assert.assertEquals(expectedValue, facticalValue);

    }

    @Test
//    - не существующего элемента в пустом массиве
    public void testEmpty() throws InterruptedException {
        int expectedValue = -1;
        int facticalValue = list.parallelIndexOf(135);
        org.junit.Assert.assertEquals(expectedValue, facticalValue);

    }

    @Test
//    - не существующего элемента в массиве с одним элементом
    public void testUndefinedElementInMonoElementArray() throws InterruptedException {
        int expectedValue = -1;
        list.add(30);
        int facticalValue = list.parallelIndexOf(135);
        org.junit.Assert.assertEquals(expectedValue, facticalValue);

    }

    @Test
//    - существующего элемента в массиве с одним элементом
    public void testDefinedElementInMonoElementArray() throws InterruptedException {
        int expectedValue = 0;
        list.add(30);
        int facticalValue = list.parallelIndexOf(30);
        org.junit.Assert.assertEquals(expectedValue, facticalValue);
    }

    @Test
//    - элемента со значением null, который присутствует в массиве
    public void testDefinedNull() throws InterruptedException {
        int expectedValue = 18;
        for (int i = 0; i < 18; i++) {
            list.add(i * 10);
        }
        list.add(null);
        for (int i = 0; i < 18; i++) {
            list.add(i);
        }
        int facticalValue = list.parallelIndexOf(null);
        org.junit.Assert.assertEquals(expectedValue, facticalValue);
    }

    @Test
//    - элемента со значением null, который отсутствует в массиве
    public void testUndefinedNull() throws InterruptedException {
        int expectedValue = -1;
        for (int i = 0; i < 18; i++) {
            list.add(i * 10);
        }
        int facticalValue = list.parallelIndexOf(null);
        org.junit.Assert.assertEquals(expectedValue, facticalValue);
    }
}