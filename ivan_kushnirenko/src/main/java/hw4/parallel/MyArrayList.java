package hw4.parallel;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;

import java.util.ArrayList;
import java.util.Random;
/**
 * Created by ivan on 07.07.15.
 * hw4.parallel.MyArrayList, hw4.parallel.MyArrayListTest
 */
public class MyArrayList<E> extends ArrayList {

    private ArrayList list;

    public MyArrayList() {
        list = new ArrayList();
    }

    public MyArrayList(int size) {
        this.list = new ArrayList<E>(size);
    }

    public MyArrayList(ArrayList list) {
        this.list = list;
    }

    public ArrayList getList() {
        return list;
    }

    public void setList(ArrayList list) {
        this.list = list;
    }

    public int parallelIndexOf(E el) {

        if (el == null) {
            throw new NullPointerException();
        }

        long start = System.currentTimeMillis();
        Integer[] result = {-1};
        final boolean[] interrupted = {false};

        Thread main = new Thread() {
            @Override
            public void run() {
                for (int i = 0; i < list.size(); i += 1000) {
                    if (interrupted[0] == true) {
                        break;
                    }
                    int[] start = {i};
                    new Thread() {
                        @Override
                        public void run() {
                            for (int j = start[0]; j < start[0] + 1000; j++) {
                                if (interrupted[0] == true) {
                                    break;
                                }
                                if (list.get(j).equals(el)) {
                                    result[0] = j;
                                    interrupted[0] = true;
                                    break;
                                }
                            }
                        }
                    }.start();
                }
            }
        };
        main.run();
        System.out.println("Parallel search time: " + (System.currentTimeMillis() - start));
        return result[0];
    }

    private int linearSerarch(E el) {

        int result = -1;

        long start = System.currentTimeMillis();

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).equals(el)) {
                Thread.currentThread().interrupt();
                System.out.println("Linear search time: " + (System.currentTimeMillis() - start));
                return i;
            }
        }
        System.out.println("Linear search time: " + (System.currentTimeMillis() - start));
        return result;
    }


    public static void main(String[] args) {

    }
}

class MyArrayListTest extends Assert {

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
    @org.junit.Test
    public void parallelIndexOfExcitingElement() {
        Integer exEl = (Integer) normalList.get(100);
        assertEquals("ERROR", 100, normalList.parallelIndexOf(exEl));
    }

    @org.junit.Test
    public void parallelIndexOfNonexcitingElement() {
        assertEquals("ERROR", -1, normalList.parallelIndexOf(600));
    }

    @org.junit.Test
    public void parallelIndexOfNonexcitingelementInEmptyList() {
        assertEquals("ERROR", -1, emptyList.parallelIndexOf(10));
    }

    @org.junit.Test
    public void parallelIndexOfNonexcitingelementInOneElementList() {
        assertEquals("ERROR", -1, oneElementList.parallelIndexOf(11));
    }

    @Ignore
    @org.junit.Test
    public void parallelIndexOfExcitingelementInEmptyList() {
        Integer element = (Integer)oneElementList.get(0);
        assertEquals("ERROR", 0, oneElementList.parallelIndexOf(3));
    }

    @org.junit.Test(expected = NullPointerException.class)
    public void parallelIndexOfNullElementInList(){
        normalList.parallelIndexOf(null);
    }

    @After
    public void removeData() {
        normalList.clear();
    }
}