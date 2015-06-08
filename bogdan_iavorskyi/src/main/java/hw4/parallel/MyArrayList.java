package hw4.parallel;

import java.util.ArrayList;

/*
 * Реализовать в классе MyArrayList метод
 * public int parallelIndexOf(E e), выполняющий линейный многопоточный поиск в списке.
 */

// MyArrayList is wrapper under java.util.ArrayList with extra int parallelIndexOf(E value) method
public class MyArrayList<E> {

    private ArrayList<E> dataArray;

    // constructor
    public MyArrayList() {
        dataArray = new ArrayList<>();
    }

    // delegate methods
    public void add(E value) {
        dataArray.add(value);
    }

    public E set(int index, E value) {
        return dataArray.set(index, value);
    }

    public int size() {
        return dataArray.size();
    }

    @Override
    public String toString() {
        return dataArray.toString();
    }

    // fields helpers for int parallelIndexOf(E value) method
    private E targetValue = null;
    private boolean isFound = false;
    private int indexOfTargetValue = -1;
    private int numberOfDeadThreadsLoosers = 0;

    // wanted parallelIndexOf method
    public int parallelIndexOf(E value) {
        int numberOfCores = Runtime.getRuntime().availableProcessors();
        int searchStep = (size() - 1) / numberOfCores;
        if (size() == 0) {
            return -1;
        } else if (size() <= numberOfCores) {
            return dataArray.indexOf(value);
        }
        targetValue = value;
        ArrayList<IndexOfThread> threads = new ArrayList<>(numberOfCores);

        // create and start threads
        for(int i = 0; i < numberOfCores; i++) {
            IndexOfThread thread;
            if(i == 0) {
                thread = this.new IndexOfThread(0, searchStep);
            } else if(numberOfCores - 1 == i) {
                thread = this.new IndexOfThread(searchStep * i + 1, size() - 1);
            } else {
                thread = this.new IndexOfThread(searchStep * i + 1, searchStep * i + searchStep);
            }
            threads.add(thread);
            thread.start();
        }

        // не розумію чому не працює
        while (!isFound && !checkForAllDead(threads)/*numberOfDeadThreadsLoosers != numberOfCores*/) {
            // waiting
        }
        if (isFound) {
            interruptThreads(threads);
        }
        int targetIndex = indexOfTargetValue;
        cleanUp();
        return targetIndex;
    }

    // methods helpers for int parallelIndexOf(E value) method
    private synchronized void incrementNumberOfDeadThreadsLoosers() {
        numberOfDeadThreadsLoosers++;
    }

    private void interruptThreads(ArrayList<IndexOfThread> threads) {
        for (IndexOfThread thread:threads) {
            thread.interrupt();
        }
    }

    private boolean checkForAllDead(ArrayList<IndexOfThread> threads) {
        for(IndexOfThread thread:threads) {
            if (thread.getState() != Thread.State.TERMINATED) {
                return false;
            }
        }
        return true;
    }

    private void cleanUp() {
        targetValue = null;
        isFound = false;
        numberOfDeadThreadsLoosers = 0;
        indexOfTargetValue = -1;
    }

    // inner class that extends Thread to search index of given value
    // non-static to simplify access to main class fields
    private class IndexOfThread extends Thread {

        int startPoint;
        int endPoint;
        E targetValue;

        public IndexOfThread(int start, int end) {
            startPoint = start;
            endPoint = end;
            targetValue = MyArrayList.this.targetValue;
        }

        @Override
        public void run() {
            if (targetValue != null) {
                for (int i = startPoint; i <= endPoint; i++) {
                    if (!isInterrupted()) {
                        if (dataArray.get(i).equals(targetValue)) {
                            System.out.println("Found by " + getName());
                            isFound = true;
                            indexOfTargetValue = i;
                            System.out.println(getName() + " dieing because found");
                            return;
                        }
                    } else {
                        System.out.println(getName() + " dieing because interrupted");
                        return;
                    }
                }
            } else {
                for (int i = startPoint; i <= endPoint; i++) {
                    if (!isInterrupted()) {
                        if (dataArray.get(i) == null) {
                            isFound = true;
                            indexOfTargetValue = i;
                            return;
                        }
                    } else {
                        return;
                    }
                }
            }
            System.out.println(getName() + " dieing in the end");
            incrementNumberOfDeadThreadsLoosers();
        }
    }

}
