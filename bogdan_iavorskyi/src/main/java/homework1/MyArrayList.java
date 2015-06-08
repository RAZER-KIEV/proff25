package homework1;

import java.util.*;

/**
 * Created by bosyi on 05.06.15.
 */
public class MyArrayList<E> implements Iterable<E> {

    private static final int DEFAULT_CAPACITY = 10;

    private static final double EXTEND_RATE = 1.25;

    private int size;

    private int modCount = 0;

    // length of this array will be capacity
    private Object[] elementData;

    public MyArrayList() {
        this(DEFAULT_CAPACITY);
    }

    public MyArrayList(int capacity) {
        if (capacity < 0) {
            throw new IllegalArgumentException("Capacity: " + capacity);
        }
        elementData = new Object[capacity];
        size = 0;
    }

    public MyArrayList(Collection<? extends E> c) {
        elementData = c.toArray();
        size = elementData.length;
    }

    public void add(E value) {
        if (size >= elementData.length) {
            extendElementData();
        }
        elementData[size] = value;
        size++;
        modCount++;
    }

    public E get(int index) {
        return (E) elementData[index];
    }

    public boolean add(int index, E value) {
        if (index < 0 || index > size) {
            return false;
        }
        Object[] newElementData = new Object[elementData.length + 1];
        System.arraycopy(elementData, 0, newElementData, 0, index);
        System.arraycopy(elementData, index, newElementData, index + 1, elementData.length - index);
        newElementData[index] = value;
        elementData = newElementData;
        size++;
        modCount++;
        return true;
    }

    public boolean set(int index, E value) {
        if (index < 0 || index >= size) {
            return false;
        }
        elementData[index] = value;
        return true;
    }

    public E remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("" + index);
        }
        E returnValue = (E) elementData[index];
        Object[] newElementData = new Object[elementData.length - 1];
        System.arraycopy(elementData, 0, newElementData, 0, index);
        System.arraycopy(elementData, index + 1, newElementData, index, size - index - 1);
        size--;
        modCount++;
        elementData = newElementData;
        return returnValue;
    }

    public int indexOf(E value) {
        for (int i = 0; i < size; i++) {
            if(elementData[i].equals(value)) {
                return i;
            }
        }
        return -1;
    }

    public int size() {
        return size;
    }

    @Override
    public String toString() {
        String stringRepresentationOfElementData = "";
        if (size >= 1) {
            stringRepresentationOfElementData = elementData[0].toString();
            for (int i = 1; i < size; i++) {
                stringRepresentationOfElementData += ", " + elementData[i].toString();
            }
        }
        return "MyArrayList = [" + stringRepresentationOfElementData + ']';
    }

    private void extendElementData() {
        int newCapacity;
        if (elementData.length < DEFAULT_CAPACITY) {
            newCapacity = DEFAULT_CAPACITY;
        } else {
            newCapacity = (int) (elementData.length * EXTEND_RATE);
        }
        elementData = Arrays.copyOf(elementData, newCapacity);
    }

    @Override
    public Iterator<E> iterator() {
        return new Itr();
    }

    private class Itr implements java.util.Iterator<E> {
        int pointer = 0;
        int iteratorModCount = modCount;

        @Override
        public boolean hasNext() {
            return pointer != size;
        }

        @Override
        public E next() {
            checkForComodification();
            if (pointer >= size) {
                throw new NoSuchElementException();
            }
            return (E) elementData[pointer++];
        }

        private void checkForComodification() {
            if (modCount != iteratorModCount) {
                throw new ConcurrentModificationException();
            }
        }
    }

}
