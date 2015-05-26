package lection01.homework;

import java.util.*;

/**
 * Created by storo_000 on 24.05.2015.
 */
class MyArrayList<E> implements Iterator<E>, Iterable<E> {
    private Object [] data;
    private static final int DEFAULT_SIZE = 10;
    private int currIndex;
    private int currSize;
    private int reservedSize;

    MyArrayList(int size){
        if (size>=0) {
            this.reservedSize = size;
            data = new Object[size];
            currIndex = 0;
            currSize = 0;
        }
        else
            throw new IllegalArgumentException();
    }

    MyArrayList(){
        reservedSize = DEFAULT_SIZE;
        data = new Object[DEFAULT_SIZE];
        currIndex = 0;
        currSize = 0;
    }

    public int size(){
        return currSize;
    }

    public void add(E value){
        if (currSize==reservedSize)
            grow();
        data[currSize++]=value;
    }

    public  E get(int index){
        checkIndex(index);
        return (E)data[index];
    }

    public boolean set(int index, E value){
        try{
            checkIndex(index);
        }
        catch (IllegalArgumentException e) {
            return false;
        }
        data[index] = value;
        return true;
    }


    public  boolean add(int index, E value){
        try{
            checkIndex(index);
        }
        catch (IllegalArgumentException e) {
            return false;
        }
        if (currSize==reservedSize){
            grow();
        }
        int numMoved = currSize - index - 1;
        System.arraycopy(data, index, data, index+1, numMoved);
        currSize++;
        data[index] = value;
        return true;
    }

    public int indexOf(E value){
        if (value==null){
            for (int i=0;i<currSize;i++)
                if (data[i] == null)
                    return i;
            return -1;
        }
        for (int i=0;i<currSize;i++)
            if (data[i].equals(value))
                return i;
        return -1;
    }

    public E remove(int index){
        checkIndex(index);
        E object = (E)data[index];

        int numMoved = currSize - index + 1;
        if (numMoved>0)
            System.arraycopy(data, index+1, data, index, numMoved);
        currSize--;
        return object;
    }

    private  void checkIndex(int index){
        if (index<0 || index>=currSize)
            throw new IllegalArgumentException();
    }

    private void grow(){
        Object [] newData = new Object[reservedSize<<1];
        System.arraycopy(data,0,newData,0,currSize);
        data = newData;
        reservedSize<<=1;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            private int index = 0;
            @Override
            public boolean hasNext() {
                return (index<currSize);
            }

            @Override
            public E next() {
                return (E)(data[index++]);
            }
        };
    }

    @Override
    public boolean hasNext() {
        return (currIndex<currSize);
    }

    @Override
    public E next() {
        if (currIndex>=currSize)
            throw new NoSuchElementException();
        return (E)data[currIndex++];
    }
}
