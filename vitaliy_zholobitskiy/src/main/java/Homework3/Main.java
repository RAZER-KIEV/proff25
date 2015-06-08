package Homework3;

import Homework1.*;

import java.util.Iterator;

/**
 * Created by just1ce on 06.06.2015.
 */
public class Main {
    public static void main(String[] args) {
        MyArrayList<Integer> ml = new MyArrayList<Integer>();
        for(int i=0;i<1000;i++)
            ml.add(i);


        System.out.println(ml.parallelIndexOf(2));
       //System.out.println(ml.parallelIndexOf(3));
    }
}
