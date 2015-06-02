package hw1.myArr;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by ПК on 02.06.2015.
 */
public class MyArrayListTest {
    MyArrayList<Integer> testMAL;

    @Before
    public void setUp(){testMAL= new MyArrayList<>();}

    @Test
    public void setTestMAL() {

      boolean actual =  testMAL.set(50,500);
      boolean expected = true;
        assertEquals(expected, actual);
    }
    @Test
    public void addTestMAL(){
        boolean actual= testMAL.add(40,400);
        boolean expected = true;
        assertEquals(expected, actual);
    }


}

