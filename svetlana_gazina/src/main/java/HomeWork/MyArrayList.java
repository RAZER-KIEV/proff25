package HomeWork;

import java.util.Iterator;
import java.util.Objects;

/**
 * Created by Sveta on 5/21/2015.

 */
public class MyArrayList<E> implements Iterable {

    E[] list = (E[]) new Object[10];
    int size;
    int capacity = 10;
    int check;


    public void add(Object value) {
        checkElement(value);
        checkCapacity(size + 1);
        list[size + 1] = (E)value;
        size++;
        check++;


    }


    public Object get(int index) {
        checkIdx(index);
        return list[index];
    }



    public boolean set(int index, Object value) {
        checkIdx(index);
        checkElement(value);
        list[index] = (E)value;
        return true;
    }

    public boolean add(int index, Object value) {
        checkIdx(index);
        checkCapacity(size + 1);
        checkElement(value);
        check++;
        for (int i = size -1; i > index; i--) {
            list[i+1] = list[i];
        }
        list[index] = (E) value;
        size++;
        return true;
    }

    public int indexOf(Object value) {
        for (int i = 0; i < size; i++) {
            if (list[i] == value)
            {
                return i;
            }
        }
        return -1;
    }

    public int size() {
        return size;
    }

    public Object remove(int index) {
        E el = (E) get(index);
        checkIdx(index);
        check++;
        for (int i = index; i < size - 1; i++) {
            list[i] = list[i+1];
        }

        size--;
        return el;
    }

    @Override
    public Iterator iterator() {
        return new MyIterator();
    }

    private void checkCapacity(int i) {
        if(i > capacity) {
            E[] newList = (E[]) new Objects[(capacity*3)/2 +1];
            list = newList;
            capacity = (capacity*3)/2 +1;

        }
    }

    private void checkIdx(int index) {
        if(index < 0 || index > size){
            return;
        }

    }

    private void checkElement(Object value) { // !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
        {

        }
    }

    class MyIterator implements Iterator<E> {

        int CurrentIdx = 0;
        int idx = check;

        @Override
        public boolean hasNext() {
            check();
            return CurrentIdx < size;
        }

        @Override
        public E next() {
            check();
            E el = list[CurrentIdx + 1];
            CurrentIdx++;
            return el;

        }

        @Override
        public void remove() {
            check();
            idx++;
            MyArrayList.this.remove(CurrentIdx);

        }
        private void check(){
            if(idx != check){

                System.out.println("MyArrayList has been changed!");
                return;
            }
        }
    }


}
