package hw4.parallel;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MyArrayListTest {
    MyArrayList myArrayList;

    @Before
    public void setUp(){
        myArrayList = new MyArrayList();
    }

    @Test
    public void testParalelIndexOfExisting() throws InterruptedException {
        myArrayList.add(1);
        myArrayList.add(2);
        myArrayList.add(-1);
        myArrayList.add(100);
        assertEquals(2,myArrayList.parallelIndexOf(-1));
    }

    @Test
    public void testParalelIndexOfNotExist() throws InterruptedException {
        myArrayList.add(1);
        myArrayList.add(2);
        myArrayList.add(-1);
        myArrayList.add(100);
        assertEquals(-1,myArrayList.parallelIndexOf(3));
    }

    @Test
    public void testParalelIndexOfNotExistEmptyArray() throws InterruptedException {
        assertEquals(-1,myArrayList.parallelIndexOf(-1));
    }

    @Test
    public void testParalelIndexOfNotExistOneElement() throws InterruptedException {
        myArrayList.add(1);
        assertEquals(-1,myArrayList.parallelIndexOf(-1));
    }

    @Test
    public void testParalelIndexOfExistingOneElement() throws InterruptedException {
        myArrayList.add(100);
        assertEquals(0,myArrayList.parallelIndexOf(100));
    }

    @Test
    public void testParalelIndexOfExistingNullElement() throws InterruptedException {
        myArrayList.add(1);
        myArrayList.add(2);
        myArrayList.add(null);
        myArrayList.add(100);
        assertEquals(3,myArrayList.parallelIndexOf(null));
    }
}

