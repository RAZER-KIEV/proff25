package Homework.Homework1;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by just1ce on 24.05.2015.
 */

public class Main {
    public static void main(String[] args) {
        testInsertionWillGrow();
        testClassicIteration();
        testAddingAfterRemoval();

        ArrLinkList arrLinkList = new ArrLinkList();
        arrLinkList.testAddToStart();
        arrLinkList.testAddToEnd();
        arrLinkList.testAddToMiddle();
        arrLinkList.testGetting();
        arrLinkList.testDeleteFromStart();
        arrLinkList.testIndexOf();
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




}
