package lection01.homework;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;
/**
 * Created by storo_000 on 25.05.2015.
 */
public class ArrayLinkedListCompare {
    private static final int RANGE = 100000;
    public void testAddToStart(){
        ArrayList<Integer> arrayList = new ArrayList<>();
        LinkedList<Integer> linkedList = new LinkedList<>();
        long startTime = System.currentTimeMillis();
        for (int i=0; i<RANGE;i++)
            arrayList.add(0,i);
        long timeArr = System.currentTimeMillis()-startTime;

        startTime = System.currentTimeMillis();
        for (int i=0; i<RANGE;i++)
            linkedList.add(0,i);
        long timeLinked = System.currentTimeMillis()-startTime;

        System.out.println("Adding to start:\n"+"ArrayList: "+timeArr+" ms.\nLinked list: " + timeLinked+ " ms.\n");
    }

    public void testAddToEnd(){
        ArrayList<Integer> arrayList = new ArrayList<>();
        LinkedList<Integer> linkedList = new LinkedList<>();
        long startTime = System.currentTimeMillis();
        for (int i=0; i<RANGE;i++)
            arrayList.add(i);
        long timeArr = System.currentTimeMillis()-startTime;

        startTime = System.currentTimeMillis();
        for (int i=0; i<RANGE;i++)
            linkedList.add(i);
        long timeLinked = System.currentTimeMillis()-startTime;

        System.out.println("Adding to end:\n"+"ArrayList: "+timeArr+" ms.\nLinked list: " + timeLinked+ " ms.\n");
    }

    public void testAddToMiddle(){
        ArrayList<Integer> arrayList = new ArrayList<>();
        LinkedList<Integer> linkedList = new LinkedList<>();
        Random random = new Random();

        long startTime = System.currentTimeMillis();
        for (int i=0; i<RANGE;i++)
            arrayList.add(random.nextInt(i+1),i);
        long timeArr = System.currentTimeMillis()-startTime;

        startTime = System.currentTimeMillis();
        for (int i=0; i<RANGE;i++)
            linkedList.add(random.nextInt(i+1),i);
        long timeLinked = System.currentTimeMillis()-startTime;

        System.out.println("Adding to middle:\n"+"ArrayList: "+timeArr+" ms.\nLinked list: " + timeLinked+ " ms.\n");
    }

    public void testGetting(){
        ArrayList<Integer> arrayList = new ArrayList<>();
        LinkedList<Integer> linkedList = new LinkedList<>();
        for (int i=0; i<RANGE;i++)
            arrayList.add(i);
        for (int i=0; i<RANGE;i++)
            linkedList.add(i);
        long startTime = System.currentTimeMillis();
        for (int i=0; i<RANGE;i++)
            arrayList.get(i);
        long timeArr = System.currentTimeMillis()-startTime;

        startTime = System.currentTimeMillis();
        for (int i=0; i<RANGE;i++)
            linkedList.get(i);
        long timeLinked = System.currentTimeMillis()-startTime;

        System.out.println("Getting element by index:\n"+"ArrayList: "+timeArr+" ms.\nLinked list: " + timeLinked+ " ms.\n");
    }

    public void testDeleteFromStart(){
        ArrayList<Integer> arrayList = new ArrayList<>();
        LinkedList<Integer> linkedList = new LinkedList<>();
        for (int i=0; i<RANGE;i++)
            arrayList.add(i);
        for (int i=0; i<RANGE;i++)
            linkedList.add(i);
        long startTime = System.currentTimeMillis();
        for (int i=0; i<RANGE;i++)
            arrayList.remove(0);
        long timeArr = System.currentTimeMillis()-startTime;

        startTime = System.currentTimeMillis();
        for (int i=0; i<RANGE;i++)
            linkedList.remove(0);
        long timeLinked = System.currentTimeMillis()-startTime;

        System.out.println("Delete element from start:\n"+"ArrayList: "+timeArr+" ms.\nLinked list: " + timeLinked+ " ms.\n");
    }

    public void testIndexOf(){
        ArrayList<Integer> arrayList = new ArrayList<>();
        LinkedList<Integer> linkedList = new LinkedList<>();
        for (int i=0; i<RANGE;i++)
            arrayList.add(i);
        for (int i=0; i<RANGE;i++)
            linkedList.add(i);
        long startTime = System.currentTimeMillis();
        for (int i=0; i<RANGE;i++)
            arrayList.indexOf(i);
        long timeArr = System.currentTimeMillis()-startTime;

        startTime = System.currentTimeMillis();
        for (int i=0; i<RANGE;i++)
            linkedList.indexOf(i);
        long timeLinked = System.currentTimeMillis()-startTime;

        System.out.println("Index of:\n"+"ArrayList: "+timeArr+" ms.\nLinked list: " + timeLinked+ " ms.\n");
    }
}
