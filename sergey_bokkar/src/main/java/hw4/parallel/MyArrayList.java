package hw4.parallel;

import java.util.ArrayList;

/**
 * Created by Well on 12.06.2015.
 * Реализовать в классе MyArrayList метод
 * public int parallelIndexOf(E e), выполняющий линейный многопоточный поиск в списке.
 */
public class MyArrayList<E> extends ArrayList {

    public int parallelIndexOf(E elem) {
        if (elem == null) {
            return -1;
        }

        class MyThread extends Thread {
            private Integer result;
            private boolean found;
            private int position;

            public MyThread(int position) throws InterruptedException {

                this.position = position;
            }

            public Integer getResult() {
                return result;
            }

            @Override
            public void run() {
                for (int i = position; i < size(); i += 2) {
                    if (found) {
                        return;
                    }

                    if (elem.equals(get(i))) {
                        result = i;
                        found = true;
                    }
                }
            }
        }
        MyThread thread1 = null;
        MyThread thread2 = null;
        try {
            thread1 = new MyThread(0);
            thread2 = new MyThread(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        thread1.start();
        thread2.start();

            try{
                thread1.join();
                thread2.join();
            }catch(InterruptedException exp){
                exp.printStackTrace();
            }

            if(thread1.getResult()!=null){
                return thread1.getResult();
            }else if(thread2.getResult()!=null){
                return thread2.getResult();
            }else{
                return -1;
            }
        }
    }


class MyArrayListTest {
}
