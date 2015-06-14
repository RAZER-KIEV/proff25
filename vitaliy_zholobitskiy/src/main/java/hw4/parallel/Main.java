package hw4.parallel;

import java.util.Random;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        MyArrayList<Integer> myArrayList = new MyArrayList<>();
        Random random = new Random();
        for (int i=0;i<104;i++){
            myArrayList.add(random.nextInt(100));
        }
        System.out.println(myArrayList.indexOf(3));
        System.out.println(myArrayList.parallelIndexOf(3));
    }
}
