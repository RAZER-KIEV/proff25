package hw4.parallel;

import java.util.Random;


public class MyArrayListTest {
    public static void main(String[] args) {
        MyArrayList<Integer> iter = new MyArrayList<>();
        Random ran = new Random();
        for(int i = 0; i < 123; i++) {
            iter.add(ran.nextInt());
        }
        iter.parallelIndexOf(2);
    }
}

