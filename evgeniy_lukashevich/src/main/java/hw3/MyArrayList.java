package hw3;

import java.util.ArrayList;

/**
 * Реализовать в классе MyArrayList метод
 public int parallelIndexOf(E e), выполняющий линейный многопоточный поиск в списке.
 В тестах проверить поиск:
 - существующего элемента
 - не существующего элемента
 - не существующего элемента в пустом массиве
 - не существующего элемента в массиве с одним элементом
 - существующего элемента в массиве с одним элементом
 - элемента со значением null

 Класс задания:
 hw4.parallel.MyArrayList

 Класс теста:
 hw4.parallel.MyArrayListTest
 * Created by lukashevich.e on 03.06.2015.
 */

public class MyArrayList<E> extends ArrayList<E> {

    private int idx = -1;
    private boolean isInterrupted = false;

    public int parallelIndexOf(E el) throws InterruptedException {
        if(size() == 0) {
            return idx;
        } else if (size() < 3) {
            if (el == null) {
                for (int i = 0; i < size(); i++) {
                    if (get(i) == null) {
                        return i;
                    }
                }
                return idx;
            } else {
                for (int i = 0; i < size(); i++) {
                    if (get(i).equals(el)) {
                        return i;
                    }
                }
                return idx;
            }
        } else {
            int amount = 3;
            ParallelThread pt1 = new ParallelThread(this, el, amount, 1);
            ParallelThread pt2 = new ParallelThread(this, el, amount, 2);
            ParallelThread pt3 = new ParallelThread(this, el, amount, 3);
            pt1.start();
            pt2.start();
            pt3.start();
            pt1.join();
            pt2.join();
            pt3.join();
            return idx;
        }
    }

    class ParallelThread extends Thread {
        private MyArrayList arr;
        private E el;
        private int amountThread;
        private int numberThread;
        public ParallelThread (MyArrayList arr, E el, int amountThread, int numberThread) {
            this.arr = arr;
            this.el = el;
            this.numberThread = numberThread;
            this.amountThread = amountThread;
        }

        private void searchIdxNull() {
            int k = numberThread*(arr.size()/amountThread);
            if (arr.size()%amountThread == 0) {
                for (int i = k - arr.size()/amountThread; i < k; i++){
                    if (!arr.isInterrupted) {
                        if (arr.get(i) == null) {
                            arr.idx = i;
                            arr.isInterrupted = true;
                        }
                    }
                }
            } else {
                for (int i = k - arr.size()/amountThread; i < k; i++){
                    if (!arr.isInterrupted) {
                        if (arr.get(i) == null) {
                            arr.idx = i;
                            arr.isInterrupted = true;
                        }
                    }
                }
                if (amountThread == numberThread){
                    for (int i = k; i < arr.size(); i++){
                        if (!arr.isInterrupted) {
                            if (arr.get(i) == null) {
                                arr.idx = i;
                                arr.isInterrupted = true;
                            }
                        }
                    }
                }
            }
        }

        private void searchIdxNotNull () {
            int k = numberThread*(arr.size()/amountThread);
            if (arr.size()%amountThread == 0) {
                for (int i = k - arr.size()/amountThread; i < k; i++){
                    if (!arr.isInterrupted) {
                        if (arr.get(i).equals(el)) {
                            arr.idx = i;
                            arr.isInterrupted = true;
                        }
                    }
                }
            } else {
                for (int i = k - arr.size()/amountThread; i < k; i++){
                    if (!arr.isInterrupted) {
                        if (arr.get(i).equals(el)) {
                            arr.idx = i;
                            arr.isInterrupted = true;
                        }
                    }
                }
                if (amountThread == numberThread){
                    for (int i = k; i < arr.size(); i++){
                        if (!arr.isInterrupted) {
                            if (arr.get(i).equals(el)) {
                                arr.idx = i;
                                arr.isInterrupted = true;
                            }
                        }
                    }
                }
            }
        }

        @Override
        public void run() {
            if (el == null){
                searchIdxNull();
            } else {
                searchIdxNotNull();
            }
        }
    }

    public static void main (String[] args) throws InterruptedException {
        MyArrayList<Integer> mal = new MyArrayList<>();
        for (int i = 0; i < 20; i++) {
            mal.add((int)(Math.random() * 10));
        }
        System.out.println(mal);
        System.out.println(mal.parallelIndexOf(2));
    }
}