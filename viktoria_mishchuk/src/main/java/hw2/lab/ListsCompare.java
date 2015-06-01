package hw2.lab;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by viktoria on 25.05.15.
 */
public class ListsCompare {


    public static void main(String[] args) {
        int n = 10_000_000;

        List arrayList = new ArrayList(n);

//          Insrert to ArrayList
        long milis = System.currentTimeMillis();
        for (int i = 0; i < n; i++) {
            arrayList.add(i);
        }
        System.out.println("Insert to ArrayList = " + (System.currentTimeMillis() - milis) + " ms");

//        Insert to LinkedList
        List linkedList = new LinkedList();
        milis = System.currentTimeMillis();
        for (int i = 0; i < n; i++) {
            linkedList.add(i);
        }
        System.out.println("Insert to LinkedList = " + (System.currentTimeMillis() - milis) + " ms");

//        Add to the end of ArrayList
        milis = System.currentTimeMillis();
        arrayList.add(n - 1, n + 5);
        System.out.println("Append to the end of ArrayList = " + (System.currentTimeMillis() - milis) + " ms");

//        Add to the end of LinkedList
        milis = System.currentTimeMillis();
        linkedList.add(n - 1, n + 5);
        System.out.println("Appent to the end of linkedList = " + (System.currentTimeMillis() - milis) + " ms");

//        Add at front of ArrayList
        milis = System.currentTimeMillis();
        arrayList.add(0, n);
        System.out.println("Add at front of ArrayList = " + (System.currentTimeMillis() - milis) + " ms");

//        Add at front of LinkedList
        milis = System.currentTimeMillis();
        linkedList.add(0, n);
        System.out.println("Add at front of LinkedList = " + (System.currentTimeMillis() - milis) + " ms");

//        Add at middle of ArrayList
        milis = System.currentTimeMillis();
        arrayList.add(n / 2, n / 2);
        System.out.println("Insert int the middle of ArrayList = " + (System.currentTimeMillis() - milis) + " ms");

//        Add at middle of LinkedList
        milis = System.currentTimeMillis();
        linkedList.add(n / 2, n / 2);
        System.out.println("Insert int the middle of LinkedList = " + (System.currentTimeMillis() - milis) + " ms");

//        Get from index
        milis = System.currentTimeMillis();
        arrayList.get(n / 2);
        System.out.println("get MIDDLE arraylist = " + (System.currentTimeMillis() - milis) + " ms");

        milis = System.currentTimeMillis();
        linkedList.get(n / 2);
        System.out.println("get MIDDLE linkedlist = " + (System.currentTimeMillis() - milis) + " ms");

//        Delete from front
        milis = System.currentTimeMillis();
        arrayList.remove(0);
        System.out.println("del front arraylist = " + (System.currentTimeMillis() - milis) + " ms");

        milis = System.currentTimeMillis();
        linkedList.remove(0);
        System.out.println("del front linkedlist = " + (System.currentTimeMillis() - milis) + " ms");

        //        IndexOf
        milis = System.currentTimeMillis();
        arrayList.indexOf(1_00_000);
        System.out.println("Searching in ArrayList = " + (System.currentTimeMillis() - milis) + " ms");

        milis = System.currentTimeMillis();
        linkedList.indexOf(1_00_000);
        System.out.println("Searching in LinkedList = " + (System.currentTimeMillis() - milis) + " ms");


    }
}