package homeTasks.week1;
import java.util.Iterator;

public class MyArrayList<E> implements Iterable<E> {
    private E[] list;
    private int length;
    private static int ite = 0;

    public MyArrayList() {
        length = 0;
        list = (E[]) new Object[0];
    }
    public MyArrayList(int l) {
        length = l;
        list = (E[]) new Object[l];
    }
    public void add(E value) {
        E[] templist = (E[]) new Object[length + 1];
        for (int i = 0; i < length; i++) {
            templist[i] = list[i];
        }
        templist[length] = value;
        list = templist;
        length++;
    }

    public E get(int index) {
        return list[index];
    }

    public boolean set(int index, E value) {
        if (index >= length || index < 0) return false;
        else {
            list[index] = value;
            return true;
        }
    }

    public boolean add(int index, E value) {
        if (index > length || index < 0) return false;
        else {
            E[] templist = (E[]) new Object[length + 1];
            for (int i = 0; i < index; i++) {
                templist[i] = list[i];
            }
            templist[index] = value;
            for (int i = index; i < length; i++) {
                templist[i + 1] = list[i];
            }
            list = templist;
            length++;
            return true;
        }
    }

    public int indexOf(E value) {
        for (int i = 0; i < length; i++)
            if (list[i] == value)
                return i;
        return -1;
    }

    public int size() {
        return length;
    }

    public E remove(int index) {
        E rez = list[index];
        E[] templist = (E[]) new Object[length - 1];
        if (index >= length || index < 0) return null;
        else {
            for (int i = 0; i < index; i++) {
                templist[i] = list[i];
            }
            for (int i = index; i < length - 1; i++) {
                templist[i] = list[i + 1];
            }
        }
        list = templist;
        length--;
        return rez;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            private int Ind = 0;

            @Override
            public boolean hasNext() {
                if (Ind <= list.length) return true;
                else return false;
            }

            @Override
            public E next() {
                E value = list[Ind];
                Ind++;
                return value;
            }
        };
    }
@Override
    public String toString() {
        return list.toString();
    }
    public static void main(String[] args) {
        MyArrayList<Integer> array = new MyArrayList<Integer>();
        array.add(5);
        array.add(10);
        array.add(15);
        array.add(20);
        array.add(25);
        array.add(30);
        array.add(5, 35);
        System.out.println(array.get(0)+" "+array.get(1)+" "+array.get(2)+" "+array.get(3)+" "+
                array.get(4)+" "+array.get(5)+" "+array.get(6));
    }
}