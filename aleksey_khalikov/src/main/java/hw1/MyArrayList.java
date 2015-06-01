package hw1;

import java.util.Iterator;

/**
 * Created by GFalcon on 30.05.15.
 *  Написать собственную реализацию динамического массива MyArrayList.
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
 */
public class MyArrayList<E> implements Iterable<E>{
    private E[] myList = (E[])new Object[0];


    public void add(E value){
        E[] temp = (E[]) new Object[myList.length + 1];
        for (int i = 0; i < myList.length; i++) {
            temp[i] = myList[i];
        }
        temp[temp.length-1] = value;
        myList = temp;
    }

    public E get(int index){
        return myList[index];
    }

    public boolean set(int index, E value){
        if (index >= 0 && index < myList.length){
            myList[index] = value;
            return true;
        }
        return false;
    }

    public boolean add(int index, E value){
        if (index < 0) {
            return false;
        } else if (index > myList.length) {
            return false;
        } else {
                E[] temp = (E[]) new Object[myList.length + 1];
                for (int i = 0; i < index; i++){
                    temp[i] = myList[i];
                }
                temp[index] = value;
                for (int i = index + 1; i < temp.length; i++){
                    temp[i] = myList[i - 1];
                }
                myList = temp;
                return true;
        }

    }

    public int indexOf(E value){
        int index = -1;
        for (int i = 0; i < myList.length; i++){
            if (myList[i].equals(value)) index = i;
        }
        return index;
    }

    public int size(){
        return myList.length;
    }

    public E remove(int index){
        if ((index >= 0) && (index < myList.length)) {
            E value = myList[index];
            E[] temp = (E[])new Object[myList.length - 1];
            for (int i = 0; i < index; i++){
                temp[i] = myList[i];
            }
            for (int i = index; i < temp.length; i++){
                temp[i] = myList[i + 1];
            }
            myList = temp;
            return value;
        }
        return null;
    }


    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            private int curIndex = 0;
            @Override
            public boolean hasNext() {
                return curIndex <= myList.length;
            }

            @Override
            public E next() {
                E val = myList[curIndex];
                curIndex++;
                return val;
            }
        };
    }
}
class MyArrayListTest {

}
