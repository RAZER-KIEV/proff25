package hw4.parallel;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        //description just to understand order of thread execution
        String descriptionCase1 = "thread1----не существующего элемента";
        String descriptionCase2 = "thread2----существующего элемента";
        String descriptionCase3 = "thread3----элемента со значением null";
        String descriptionCase4 = "thread4----не существующего элемента в пустом массиве";
        String descriptionCase5 = "thread5----не существующего элемента в массиве с одним элементом";
        String descriptionCase6 = "thread6----существующего элемента в массиве с одним элементом";

        List<String> createMyList = new ArrayList<String>();
        createMyList.add("V");
        createMyList.add("I");
        createMyList.add("C");
        createMyList.add("T");
        createMyList.add("O");
        createMyList.add("R");

        List<String> createMyListFromOneElement = new ArrayList<String>();
        createMyListFromOneElement.add("X");

        List<String> createMyEmptyList = new ArrayList<String>();

        List<Integer> createMyListOfInteger = new ArrayList<Integer>();
        createMyListOfInteger.add(2);
        createMyListOfInteger.add(3);
        createMyListOfInteger.add(4);


        Thread thr1 = new Thread(new MyArrayList(createMyList, "F", descriptionCase1));//не существующего элемента
        Thread thr2 = new Thread(new MyArrayList(createMyList, "T", descriptionCase2));//существующего элемента
        Thread thr3 = new Thread(new MyArrayList(createMyList, null, descriptionCase3));//элемента со значением null
        Thread thr4 = new Thread(new MyArrayList(createMyEmptyList, "S", descriptionCase4));//не существующего элемента в пустом массиве
        Thread thr5 = new Thread(new MyArrayList(createMyListFromOneElement, "S", descriptionCase5));//не существующего элемента в массиве с одним элементом
        Thread thr6 = new Thread(new MyArrayList(createMyListFromOneElement, "X", descriptionCase6));//существующего элемента в массиве с одним элементом
        Thread thr7 = new Thread(new MyArrayList(createMyListOfInteger, 4, "blank description"));
        thr1.start();
        thr2.start();
        thr3.start();
        thr4.start();
        thr5.start();
        thr6.start();
        thr7.start();
    }
}
