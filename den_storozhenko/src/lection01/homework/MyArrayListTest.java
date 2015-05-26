package lection01.homework;

import java.util.Iterator;

/**
 * Created by storo_000 on 26.05.2015.
 */
public class MyArrayListTest {
    public static void main(String[] args) {
        task1test();

    }

    static public void task1test(){

        testInsertionWillGrow();
        testClassicIteration();
        testAddingAfterRemoval();
        crazyTest();

    }



    static public void testInsertionWillGrow() {
        System.out.println("testInsertionWillGrow---------------------------");
        final MyArrayList<String> ml = new MyArrayList<String>();
        ml.add("");
        ml.add("");
        for (int i = 0; i < 100; i++) {
            System.out.println(ml.add(0, "Test"));
        }
    }
    static public void testClassicIteration() {
        System.out.println("testClassicIteration----------------------------");
        final MyArrayList<String> ml = new MyArrayList<String>();
        ml.add("1");
        ml.add("2");
        ml.add("3");
        ml.add("4");
        ml.add("5");
        ml.add("6");
        ml.add("7");
        ml.add("8");
        final Iterator<String> iter = ml.iterator();
        int items = 0;
        while (iter.hasNext()) {
            iter.next();
            items++;
        }
        System.out.println(8 == items);
    }
    static public void testAddingAfterRemoval() {
        System.out.println("testAddingAfterRemoval--------------------------");
        final MyArrayList<String> ml = new MyArrayList<String>();
        ml.add("a");
        ml.add("b");
        ml.remove(1);
        ml.remove(0);
        ml.add("c");
        ml.remove(0);
        ml.add("q");
        ml.add("p");
        System.out.println("q".equals(ml.get(0)));
    }
    static public void crazyTest()
    {
        System.out.println("crazyTest---------------------------------------");
        final MyArrayList<Integer> ml = new MyArrayList<Integer>();
        Integer l1=new Integer(1);
        Integer l2=new Integer(2);
        Integer l3=new Integer(3);
        Integer l4=new Integer(4);
        Integer l5=new Integer(5);
        ml.add(l1);
        ml.add(l2);
        System.out.println(ml.indexOf(l2) == 1);
        ml.remove(0);
        System.out.println(ml.indexOf(l2) == 0);
        try {
            ml.remove(3);
        } catch (IllegalArgumentException e)
        {
            System.out.println(true);
            return;
        }


    }
}
