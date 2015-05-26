package session02;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Created by lukashevich.e on 20.05.2015.
 *  Написать собственную реализацию динамического массива MyArrayList. Сделать параметризацию списка, параметр E.
 Реализовать в списке интерфейсы Iterable. Реализовать следующие методы:
 - void add(E value)+
 - E get(int index)+
 - void set(int index, E value)+
 - void add(int index, E value)+
 - int indexOf(E value)+
 - int size()+
 - E remove(int index)+
 - Iterator<E> iterator()+
 */

public class MyArrayList<E> implements Iterable<E>{

    public final static int DAFAULT_CAPACITY = 10;
    private E[] arr;
    private int size;

    MyArrayList() {
        this(DAFAULT_CAPACITY);
    }

    MyArrayList(int size) {
        arr = (E[]) new Object[size];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    private void checkIdx(int idx) {
        if (idx < 0 || idx >= size) {
            throw new ArrayIndexOutOfBoundsException(idx);
        }
    }

    public void add(E el) {
        if (size < arr.length) {
            arr[size] = el;
            size++;
        } else if (size == arr.length) {
            E[] tmp = (E[]) new Object[arr.length * 3 / 2 + 1];
            System.arraycopy(arr, 0, tmp, 0, arr.length);
            arr = tmp;
            arr[size] = el;
            size++;
        }
    }

    public void add(int idx, E el) {
        checkIdx(idx);
        if (idx == size) {
            add(el);
        } else {
            if (size == arr.length) {
                E[] tmp = (E[]) new Object[arr.length * 3 / 2 + 1];
                System.arraycopy(arr, 0, tmp, 0, arr.length);
                tmp[idx] = el;
                System.arraycopy(arr, idx, tmp, idx + 1, size - idx);
                arr = tmp;
                size++;
            } else {
                System.arraycopy(arr, 0, arr, 0, idx);
                System.arraycopy(arr, idx, arr, idx + 1, size - idx);
                arr[idx] = el;
                size++;
            }
        }
    }

    public void set(int idx, E el) {
        checkIdx(idx);
        arr[idx] = el;
    }

    public E get(int idx) {
        checkIdx(idx);
        return arr[idx];
    }

    public E remove(int idx) {
        checkIdx(idx);
        E res = arr[idx];
        System.arraycopy(arr, idx + 1, arr, idx, size - idx+1);
        size--;
        return res;
    }

    public int indexOf(E el) {
        if (!isEmpty()) {
            for (int i = 0; i < size; i++) {
                if (arr[i].equals(el)) {
                    return i;
                }
            }
        }
        return -1;
    }

    public boolean contains(E el) {
        if (!isEmpty()) {
            for (int i = 0; i < size; i++) {
                if (arr[i].equals(el)) {
                    return true;
                }
            }
        }
        return false;
    }

    public int size() {
        return size;
    }

    @Override
    public String toString() {
        if (size == 0) {
            return "[]";
        }
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < size - 1; i++) {
            sb.append(arr[i]).append(", ");
        }
        sb.append(arr[size - 1]).append("]");
        return sb.toString();
    }

    @Override
    public int hashCode() {
        int hash = 37;
        for (int i = 0; i < size; i++){
            hash = hash*17 + arr[i].hashCode();
        }
        hash = hash*17 + size;
        return hash;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {

            int pos;
            int hCode = MyArrayList.this.hashCode();
            boolean parser;

            private void checkHashCode() {
                int newHCode = MyArrayList.this.hashCode();
                if (newHCode != hCode) {
                    throw new ConcurrentModificationException();
                }
            }

            @Override
            public boolean hasNext() {
                checkHashCode();
                return pos < size;
            }

            @Override
            public E next() {
                checkHashCode();
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                parser = true;
                return arr[pos++];
            }

            @Override
            public void remove(){
                checkHashCode();
                if (!parser) {
                    throw new IllegalStateException();
                } else {
                    checkIdx(pos - 1);
                    System.arraycopy(arr, pos, arr, pos - 1, size - pos);
                    size--;
                    pos--;
                    hCode = MyArrayList.this.hashCode();
                    parser = false;
                }
            }
        };
    }

    public static void main (String[] args) {
        MyArrayList<Integer> mal = new MyArrayList<>(20);
        for (int i = 0; i < 20; i++){
            mal.add((int)(Math.random()*100));
        }
        System.out.println(mal);
        System.out.println(mal.get(5));
        mal.set(5, 555);
        mal.add(12, 999);
        System.out.println(mal);
        System.out.println(mal.size());
        System.out.println(mal.indexOf(999));
        System.out.println(mal.remove(12));

        System.out.println(mal);
        System.out.println(mal.remove(13));
        System.out.println(mal.size());
        System.out.println(mal);

        Iterator<Integer> iter = mal.iterator();
        while (iter.hasNext()) {
            int el = iter.next();
            if (el % 2 == 0) {
                iter.remove();
            }
        }
        System.out.println(mal);
    }
}