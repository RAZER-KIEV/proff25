package session02;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
    Сравнение быстродействия списков ArrayList и LinkedList
 */
public class CompareArrayLinkedLists {
    public static void main (String[] args) {

        long begin;
        long timeArr;
        long timeLink;
        int scoreArr = 0;
        int scoreLink = 0;

        List<Integer> arr = new ArrayList<>();
        for (int i = 0; i < 100_000; i++) {
            arr.add((int)(Math.random()*50_000));
        }
        List<Integer> link = new LinkedList<>(arr);

        System.out.println("Add in begin");
        begin = System.nanoTime();
        arr.add(10, 5);
        timeArr = System.nanoTime() - begin;
        System.out.println("Array = " + timeArr);
        begin = System.nanoTime();
        link.add(10, 5);
        timeLink = System.nanoTime() - begin;
        System.out.println("Linked = " + timeLink);
        if (timeArr > timeLink) {
            System.out.println("Linked wins " + ((double)(timeArr - timeLink)/timeArr *100));
            scoreLink++;
        } else {
            System.out.println("Arr wins " + ((double)(timeLink - timeArr)/timeLink*100));
            scoreArr++;
        }
        System.out.println();

        System.out.println("Add in end");
        begin = System.nanoTime();
        arr.add(99_200, 5);
        timeArr = System.nanoTime() - begin;
        System.out.println("Array = " + timeArr);
        begin = System.nanoTime();
        link.add(99_200, 5);
        timeLink = System.nanoTime() - begin;
        System.out.println("Linked = " + timeLink);
        if (timeArr > timeLink) {
            System.out.println("Linked wins " + ((double)(timeArr - timeLink)/timeArr *100));
            scoreLink++;
        } else {
            System.out.println("Arr wins " + ((double)(timeLink - timeArr)/timeLink*100));
            scoreArr++;
        }
        System.out.println();

        System.out.println("Add in middle");
        begin = System.nanoTime();
        arr.add(50_000, 5);
        timeArr = System.nanoTime() - begin;
        System.out.println("Array = " + timeArr);
        begin = System.nanoTime();
        link.add(50_000, 5);
        timeLink = System.nanoTime() - begin;
        System.out.println("Linked = " + timeLink);
        if (timeArr > timeLink) {
            System.out.println("Linked wins " + ((double)(timeArr - timeLink)/timeArr *100));
            scoreLink++;
        } else {
            System.out.println("Arr wins " + ((double)(timeLink - timeArr)/timeLink*100));
            scoreArr++;
        }
        System.out.println();

        System.out.println("Get element with index");
        begin = System.nanoTime();
        System.out.println(arr.get(25_000));
        timeArr = System.nanoTime() - begin;
        System.out.println("Array = " + timeArr);
        begin = System.nanoTime();
        System.out.println(link.get(25_000));
        timeLink = System.nanoTime() - begin;
        System.out.println("Linked = " + timeLink);
        if (timeArr > timeLink) {
            System.out.println("Linked wins " + ((double)(timeArr - timeLink)/timeArr *100));
            scoreLink++;
        } else {
            System.out.println("Arr wins " + ((double)(timeLink - timeArr)/timeLink*100));
            scoreArr++;
        }
        System.out.println();

        System.out.println("Remove element begin");
        begin = System.nanoTime();
        System.out.println(arr.remove(10));
        timeArr = System.nanoTime() - begin;
        System.out.println("Array = " + timeArr);
        begin = System.nanoTime();
        System.out.println(link.remove(10));
        timeLink = System.nanoTime() - begin;
        System.out.println("Linked = " + timeLink);
        if (timeArr > timeLink) {
            System.out.println("Linked wins " + ((double)(timeArr - timeLink)/timeArr *100));
            scoreLink++;
        } else {
            System.out.println("Arr wins " + ((double)(timeLink - timeArr)/timeLink*100));
            scoreArr++;
        }
        System.out.println();

        System.out.println("Seach element value");
        begin = System.nanoTime();
        System.out.println(arr.indexOf(12));
        timeArr = System.nanoTime() - begin;
        System.out.println("Array = " + timeArr);
        begin = System.nanoTime();
        System.out.println(link.indexOf(12));
        timeLink = System.nanoTime() - begin;
        System.out.println("Linked = " + timeLink);
        if (timeArr > timeLink) {
            System.out.println("Linked wins " + ((double)(timeArr - timeLink)/timeArr *100));
            scoreLink++;
        } else {
            System.out.println("Arr wins " + ((double)(timeLink - timeArr)/timeLink*100));
            scoreArr++;
        }
        System.out.println();
        System.out.println("Score: Arr " + scoreArr + "-" + scoreLink + " Linked");
    }
}