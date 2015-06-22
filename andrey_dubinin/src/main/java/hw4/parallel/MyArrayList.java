package hw4.parallel;

import homework1.Iterable;

import java.util.Iterator;

/**
 * Created by jax on 25.05.15.
 */
public class MyArrayList<E> implements Iterable {
    public static final int DEFALT_CAPACITY = 10;
    private int size;
    private int index;
    private int el;
    private E[] element;

    public MyArrayList() {
        element = (E[]) new Object[DEFALT_CAPACITY];
    }

    @Override
    public void add(Object value) {
        if (index == element.length) {
            extendArray();
        }
        element[index] = (E) value;
        index++;
        size++;
    }

    @Override
    public Object get(int index) {
        return null;
    }

    @Override
    public boolean set(int index, Object value) {
        return false;
    }

    @Override
    public boolean add(int index, Object value) {
        return false;
    }

    @Override
    public int indexOf(Object o) {
        if (o == null) {
            for (int i = 0; i < size; i++)
                if (element[i] == null)
                    return i;
        } else {
            for (int i = 0; i < size; i++)
                if (o.equals(element[i]))
                    return i;
        }
        return -1;
    }

    public int parallelIndexof(E e) throws InterruptedException {
        if(size() ==0)
            return -1;

        class NewThread extends Thread{
            int from;
            int to;
            int result;

            NewThread (int from,int to){
                this.from=from;
                this.to = to;
            }
            public int getResult(){
                return result;
            }
            @Override
            public void run(){
                if(e ==null){
                    for(int i =from;i<to;i++){
                        if(element[i]==null){
                            result = i;
                            break;
                        }
                    }
                }else{
                    for (int i=from;i<to;i++)
                        if (element[i].equals(e)){
                            result = i;
                            break;
                        }
                }

            }

        }
        int i;
        for (i=0;i<size()/10;i++){
            NewThread thread = new NewThread(i*10,i*10+9);
            thread.start();
            thread.join();
            if(thread.getResult()>=0){
                return thread.getResult();
            }

        }
        NewThread thread = new NewThread(i*10,i*10+size()%10);
        thread.start();
        thread.join();
        if(thread.getResult()>=0){
            return thread.getResult();
        }

        return -1;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public E remove(int index) {
        checkIdx(index);
        element[index] = element[index-1];
        index--;
        size--;
        return null;
    }

    @Override
    public Iterator iterator() {
        return null;
    }

    private void extendArray() {
        E[] newArray = (E[]) new Integer[element.length * 2];
        System.arraycopy(element, 0, newArray, 0, index - 1);
        element = newArray;
    }
    private void checkIdx(int index){
        if(index<0 || index>=size){
            throw new ArrayIndexOutOfBoundsException(index);
        }
    }
    @Override
    public String toString(){
        if(size==0){
            return "[ ]";
        }
        for(int i=0;i<element.length;i++){
            System.out.println(element[i]);
        }
        return null;
    }

}
