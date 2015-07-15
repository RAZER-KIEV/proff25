package hw4.parallel;

import java.util.ArrayList;

/**
 * Created by ivan on 07.07.15.
 */
public class MyArrayList<E> extends ArrayList {

    private ArrayList list;

    public MyArrayList() {
        list = new ArrayList();
    }

    public MyArrayList(int size) {
        this.list = new ArrayList<E>(size);
    }

    public MyArrayList(ArrayList list) {
        this.list = list;
    }

    public ArrayList getList() {
        return list;
    }

    public void setList(ArrayList list) {
        this.list = list;
    }

    public int parallelIndexOf(E el) {

        if (el == null) {
            throw new NullPointerException();
        }

        long start = System.currentTimeMillis();
        Integer[] result = {-1};
        final boolean[] interrupted = {false};

        Thread main = new Thread() {
            @Override
            public void run() {
                for (int i = 0; i < list.size(); i += 1000) {
                    if (interrupted[0] == true) {
                        break;
                    }
                    int[] start = {i};
                    new Thread() {
                        @Override
                        public void run() {
                            for (int j = start[0]; j < start[0] + 1000; j++) {
                                if (interrupted[0] == true) {
                                    break;
                                }
                                if (list.get(j).equals(el)) {
                                    result[0] = j;
                                    interrupted[0] = true;
                                    break;
                                }
                            }
                        }
                    }.start();
                }
            }
        };
        main.run();
        System.out.println("Parallel search time: " + (System.currentTimeMillis() - start));
        return result[0];
    }

    private int linearSerarch(E el) {

        int result = -1;

        long start = System.currentTimeMillis();

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).equals(el)) {
                Thread.currentThread().interrupt();
                System.out.println("Linear search time: " + (System.currentTimeMillis() - start));
                return i;
            }
        }
        System.out.println("Linear search time: " + (System.currentTimeMillis() - start));
        return result;
    }


    public static void main(String[] args) {

    }
}
