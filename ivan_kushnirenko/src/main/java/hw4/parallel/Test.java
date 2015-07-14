package hw4.parallel;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by ivan on 11.07.15.
 */
public class Test<E> {

    public int parallelSearch(List<E> list, E val) {
        long start = System.currentTimeMillis();
        ParallelSearcher<E> searcher1 = new ParallelSearcher<E>(0, list.size() / 2 + 1, val, list);
        ParallelSearcher<E> searcher2 = new ParallelSearcher<E>(list.size() / 2 + 1, list.size(), val, list);
        searcher1.start();
        searcher2.start();
        System.out.println("Time of parallel search: " + (System.currentTimeMillis() - start));
        return searcher1.getResult() > -1 ? searcher1.getResult() : searcher2.getResult();
    }

    public int linearSearch(List list, E val) {
        long start = System.currentTimeMillis();
        LinearSearcher<E> searcher = new LinearSearcher<E>(val, list);
        searcher.start();
        System.out.println("Time of linear search: " + (System.currentTimeMillis() - start));
        return searcher.getResult();
    }

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<Integer>(100000);
        Random random = new Random();
        for (int i = 0; i < 100000; i++) {
            list.add(random.nextInt(500));
        }
        System.out.println(list);

        Test test = new Test<Integer>();

        int linearResult = test.linearSearch(list, 10);
        int parallelResult = test.parallelSearch(list, 10);
        System.out.println("Par res : " + parallelResult + ", lin res : " + linearResult + ".");
        if (linearResult == -1 && parallelResult == -1) {
            System.out.println(list.indexOf(10));
        }
    }


}


class ParallelSearcher<E> extends Thread {

    private int start;
    private int end;
    private E val;
    private List<E> list;
    private volatile int result = -1;
    static boolean interrapt = false;

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }

    public ParallelSearcher(int start, int end, E val, List<E> list) {
        this.start = start;
        this.end = end;
        this.val = val;
        this.list = list;
    }

    @Override
    public void run() {
        for (int i = start; i < end; i++) {
            if (interrapt == true) {
                break;
            }
            if (list.get(i).equals(val)) {
                result = i;
                interrapt = true;
                break;
            }
        }
    }
}

class LinearSearcher<E> extends Thread {

    private E val;
    private List<E> list;
    private volatile int result = -1;

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }

    public LinearSearcher(E val, List<E> list) {
        this.val = val;
        this.list = list;
    }

    @Override
    public void run() {
        for (int i = 0; i < list.size(); i++) {
            if (isInterrupted() || result != -1) {
                break;
            }
            if (list.get(i).equals(val)) {
                result = i;
                Thread.currentThread().interrupt();
            }
        }
    }
}