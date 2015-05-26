package ht1;

import java.util.*;
import java.util.concurrent.SynchronousQueue;

/**
 * Created by ivan on 21.05.15.
 */
public class ArrayListTester {

   static Random r = new Random();

    static public List addToBegin(List list){
        long start = System.currentTimeMillis();
        for (int i = 0; i<10000; i++) {
            list.add(r.nextInt());
        }
        System.out.println(System.currentTimeMillis() - start);
        return  list;
    }

    static public void addToEnd(List list){
        long srart = System.currentTimeMillis();
        for (int i = 0; i <10000; i++) {
            list.add(list.size()-1,r.nextInt());
        }
        System.out.println(System.currentTimeMillis() - srart);
    }

    static public void addToCenter(List list){
        long start =System.currentTimeMillis();
        list.add(r.nextInt());
        for (int i = 0; i <10000; i++) {
            list.add(list.size()/2+1,r.nextInt());
        }
        System.out.println(System.currentTimeMillis() - start);
    }

    static public void getByIndex(List list){
        long start = System.currentTimeMillis();
        for (int i = 0; i <10000; i++) {
            list.get(i);
        }
        System.out.println(System.currentTimeMillis() - start);
    }

    static public void removeFromStart(List list){
        long start = System.currentTimeMillis();
        for(int i = 0; i <10000; i++){
            list.remove(0);
        }
        System.out.println(System.currentTimeMillis()-start);
    }

    static public void indexOf(List list){
        long start = System.currentTimeMillis();
        for (int i = 0; i < 10000; i++) {
            list.indexOf(r.nextInt());
        }
        System.out.println(System.currentTimeMillis() - start);
    }

    public static void main(String[] args) {
        ArrayList<Integer> aList = new ArrayList<Integer>();
        LinkedList<Integer> lList = new LinkedList<Integer>();
        System.out.println("addToBegin: ");
        System.out.println("ArrayList: ");
                addToBegin(aList);
        System.out.println("LinkedList: ");
                addToBegin(lList);
        System.out.println("addToEnd: ");
        System.out.println("ArrayList: ");
            addToEnd(aList);
        System.out.println("LinkedList: ");
            addToEnd(lList);
        System.out.println("addToCentre");
        System.out.println("ArrayList: ");
            addToCenter(aList);
        System.out.println("LinkedList: ");
            addToCenter(lList);
        System.out.println("getByIndex: ");
        System.out.println("ArrayList: ");
            getByIndex(aList);
        System.out.println("LinkedList: ");
            getByIndex(lList);
        System.out.println("indexOf: ");
        System.out.println("ArrayList: ");
            indexOf(aList);
        System.out.println("LinkedList: ");
            indexOf(lList);
        System.out.println("removeFromStart: ");
        System.out.println("ArrayList: ");
            removeFromStart(aList);
        System.out.println("LinkedList: ");
            removeFromStart(lList);

    }
}
