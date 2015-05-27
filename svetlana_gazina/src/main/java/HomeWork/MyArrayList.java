package HomeWork;

import java.util.Iterator;
import java.util.Objects;

/**
 Написать собственную реализацию динамического массива MyArrayList.
 Сделать параметризацию списка, параметр E.
 Реализовать в списке интерфейсы Iterable.
 Реализовать следующие методы
 - void add(E value)
 - E get(int index)
 - boolean set(int index, E value)
 - boolean add(int index, E value)
 - int indexOf(E value)
 - int size()
 - E remove(int index)
 - Iterator<E> iterator()

 Класс теста MyArrayListTest

 */
public class MyArrayList<E> implements Iterable {

    E[] list = (E[]) new Object[10];
    int size = 0;
    int capacity = 10;
    int check;


    public void add(E value) {
        checkCapacity(size + 1);
        size++;
        list[size-1] = value;

        check++;
    }


    public E get(int index) {
        checkIdx(index);
        return list[index];
    }

    public boolean set(int index, E value) {
        checkIdx(index);
        checkElement(value);
        list[index] = value;
        return true;
    }

    public boolean add(int index, E value) {
        checkIdx(index);
        checkCapacity(size + 1);
        check++;
        for (int i = size -1; i > index; i--) {
            list[i+1] = list[i];
        }
        list[index] = value;
        size++;
        return true;
    }

    public int indexOf(E value) {
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

    public E remove(int index) {
        E el = get(index);
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

    private void checkElement(E value) { // !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
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

class MyArrayListTest {
    public static void main(String[] args) {
        MyArrayList<Integer> myList = new MyArrayList<>();
        for (int i = 0; i < 10; i++) {
            myList.add(i);
        }
        System.out.println("Size must be 10: " + myList.size);
        System.out.println("5 el must be 5: " + myList.get(5));
        System.out.println("7 must be 7-th: " + myList.indexOf(7));

        myList.set(5, 13);
        System.out.println("5 el must be 13: " + myList.get(5));


        myList.remove(5);
        System.out.println("Size must be 9: " + myList.size);
        System.out.println("5 el must be 6: " + myList.get(5));

    }
}
