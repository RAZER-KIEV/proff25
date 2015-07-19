package hw4.parallel;

/**
 * Created by jax on 13.07.15.
 */

import java.util.ArrayList;

public class MyArrayList<E> extends ArrayList<E> {

    //    Реализовать в классе MyArrayList метод

    //    public int parallelIndexOf(E e), выполняющий линейный многопоточный поиск в списке.

    private int result;
    private boolean isInterrupted = false;

    public void setResult(int result) {
        this.result = result;
    }

    public boolean isInterrupted() {
        return isInterrupted;
    }

    public void setIsInterrupted(boolean isInterrupted) {
        this.isInterrupted = isInterrupted;
    }

    public synchronized  int parallelIndexOf(E e) throws InterruptedException {
        if(size() == 0){
            return -1;
        }
        else if(size() < 5){
            if(e == null){
                for(int i = 0; i < size(); i++){
                    if(get(i) == null){
                        return i;
                    }
                }
                return -1;
            }
            for(int i = 0; i < size(); i++){
                if(e.equals(get(i))){
                    return i;
                }
            }
            return -1;
        }
        else {Thread firstThread = new Thread(new MyThread(this, 0, size() / 4, e));
            Thread secondThread = new Thread(new MyThread(this, size() / 4 + 1, size() / 2, e));
            Thread thirdThread = new Thread(new MyThread(this, size() / 2 + 1, (size() * 3) / 4, e));
            Thread fourthThread = new Thread(new MyThread(this, (size() * 3) / 4 + 1, size() - 1, e));
            firstThread.start();
            secondThread.start();
            thirdThread.start();
            fourthThread.start();
            firstThread.join();
            secondThread.join();
            thirdThread.join();
            fourthThread.join();
            return result;
        }
    }
}

class MyThread<E> implements Runnable{
    private MyArrayList list;
    private int indexFrom;
    private int indexTo;
    private E element;
    public MyThread(MyArrayList list, int indexFrom, int indexTo, E element) {
        this.list = list;
        this.indexFrom = indexFrom;
        this.indexTo = indexTo;
        this.element = element;
    }

    @Override
    public void run() {
        if (element != null) {
            for(int i = indexFrom; i <= indexTo; i++){
                if (!list.isInterrupted()) {
                    if (element.equals(list.get(i))) {
                        list.setIsInterrupted(true);
                        list.setResult(i);
                    }
                }
                else  break;
            }
        }
        else {
            for(int i = indexFrom; i <= indexTo; i++){
                if (!list.isInterrupted()) {
                    if (list.get(i) == null) {
                        list.setIsInterrupted(true);
                        list.setResult(i);
                    }
                }
            }
        }
    }
}