package homework3;

import java.util.ArrayList;

/*
 * Created on 07.06.15.
 */
public class MyArrayList<E> {

    private ArrayList<E> arrayList;

    public MyArrayList() {
        arrayList = new ArrayList<>();
    }

    public void add(E value) {
        arrayList.add(value);
    }

    public int size() {
        return arrayList.size();
    }

    @Override
    public String toString() {
        return arrayList.toString();
    }

    private boolean isFound = false;
    private int indexOfFoundValue = -1;

    public int parallelIndexOf(E value) {
        int cores = Runtime.getRuntime().availableProcessors();
        ArrayList<IndexFinderThread<E>> threads = new ArrayList<>(cores);
        int step = (size() - 1) / cores;
        int totalStep = 0;
        for (int i = 0; i < cores; i++) {
            if (i == 0) {
                threads.add(this.new IndexFinderThread<>(0, totalStep+=step, value));
            } else if (i == cores - 1) {
                threads.add(this.new IndexFinderThread<>(totalStep + 1, totalStep+=step, value));                ;
            } else {
                threads.add(this.new IndexFinderThread<>(totalStep + 1, size() - 1, value));
            }
        }
        for (IndexFinderThread<E> thread:threads) {
            thread.start();
        }
        boolean allDead = false;
        while (true) {
            if (isFound) {
                for (IndexFinderThread<E> thread:threads) {
                    thread.interrupt();
                }
                return indexOfFoundValue;
            } else {
                for(IndexFinderThread<E> thread:threads) {
//                    System.out.println(thread.getName() + ", " + thread.getState());
                    if (thread.getState() == Thread.State.TERMINATED) {
//                        System.out.println(thread.getState());
                        allDead = true;
                    } else {
//                        System.out.println("fff");
                        allDead = false;
                        break;
                    }
                }
                if (allDead) {
                    return -1;
                }
            }

        }
    }

    private class IndexFinderThread<E> extends Thread {

        private int beginIndex;
        private int endIndex;
        /*private ArrayList<E> arrayList;*/
        private E value;

        public IndexFinderThread(int beginIndex, int endIndex, E value/*, ArrayList<E> list*/) {
            this.beginIndex = beginIndex;
            this.endIndex = endIndex;
            this.value = value;
            /*this.arrayList = list;*/
        }

        @Override
        public void run() {
            for(int i = beginIndex; i <= endIndex; i++) {
                if (!isInterrupted()) {
                    if(value.equals(arrayList.get(i))) {
                        isFound = true;
                        indexOfFoundValue = i;
                        return;
                    }
                } else {
                    return;
                }
            }
        }
    }

}
