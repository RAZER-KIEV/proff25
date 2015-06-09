package hw4.parallel;
import hw4.parallel.MyArrayList;
import static org.junit.Assert.*;
import org.junit.Test;

/**
 * Created by rrudych on 09.06.15.
 */
public class MyArrayListTest {

    @Test
    public void foundExistingElementTest() {
        MyArrayList<Integer> list = new MyArrayList<>();
        for(int i=0; i<1_000; i++) {
            list.add(i);
        }
        Integer expected = 333;
        Integer actual = list.parallelIndexOf(333);
        assertEquals(expected, actual);
    }

    @Test
      public void foundNotExistingElementTest() {
        MyArrayList<Integer> list = new MyArrayList<>();
        for(int i=0; i<1_000; i++) {
            list.add(i);
        }
        Integer expected = -1;
        Integer actual = list.parallelIndexOf(200000);
        assertEquals(expected, actual);
    }

    @Test
    public void foundNotExistingElementInEmptyListTest() {
        MyArrayList<Integer> list = new MyArrayList<>();
        Integer expected = -1;
        Integer actual = list.parallelIndexOf(200000);
        assertEquals(expected, actual);
    }

    @Test
    public void foundNotExistingElementInListWithOneElTest() {
        MyArrayList<Integer> list = new MyArrayList<>();
        list.add(10);
        Integer expected = -1;
        Integer actual = list.parallelIndexOf(200000);
        assertEquals(expected, actual);
    }

    @Test
    public void foundExistingElementInListWithOneElTest() {
        MyArrayList<Integer> list = new MyArrayList<>();
        list.add(10);
        Integer expected = 0;
        Integer actual = list.parallelIndexOf(10);
        assertEquals(expected, actual);
    }

    @Test
    public void foundExistingNullElementTest() {
        MyArrayList<Integer> list = new MyArrayList<>();
        for(int i=0; i<1_000; i++) {
            list.add(i);
        }
        list.add(null);
        Integer expected = 1000;
        Integer actual = list.parallelIndexOf(null);
        assertEquals(expected, actual);
    }
}
