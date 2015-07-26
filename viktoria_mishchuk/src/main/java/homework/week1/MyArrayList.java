package homework.week1;

/**
 * Created by viktoria on 20.05.15.
 */
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class MyArrayList<E>  implements Iterable{

    private E[] list;
    private int size = 0;
    private boolean isMod;

    public MyArrayList() {

        list = (E[]) new Object[10];
    }

    public void add(E element) {
        isMod = true;
        if (size < list.length-1) {
            list[size++] = element;
        } else if (size >= list.length) {
            newArray(size * 2);
            list[size++] = element;
        }
    }

    public boolean add(int index, E element) {
        isMod = true;
        if (index < size && size  < list.length-1) {
            System.arraycopy(list, index, list, index + 1, size - index);
            list[index] = element;
            size++;
            return  true;
        } else if (index == size && size >= list.length-1) {
            newArray(size * 2);
            System.arraycopy(list, index, list, index + 1, size - index);
            list[index] = element;
            size++;
            return true;
        } else {
            throw new IndexOutOfBoundsException();
        }
    }

    public E get(int index) {
        if (size >= 0 && index < size) {
            return list[index];
        } else {
            throw new IndexOutOfBoundsException();
        }
    }

    public E getFirst() {
        return list[0];
    }

    public E getLast() {
        return list[size];
    }

    public boolean set(int index, E element) {
        if (size >= 0 && index < size) {
            list[index] = element;
            return true;
        } else  {
            throw new IndexOutOfBoundsException();
        }
    }

    public E remove(int index) {
        isMod = true;
        if (index >= 0 && index < size) {
            E tmp = list[index];
            System.arraycopy(list, index + 1, list, index, size - index - 1);
            size--;
            return  tmp;
        } else  {
            throw new IndexOutOfBoundsException();
        }
    }

    @Override
    public String toString() {
        String str = new String("[");
        for (int i = 0; i < size; i++) {
            if (i < (size - 1)) {
                str += get(i) + ", ";
            } else {
                str += get(i) + "]";
            }
        }
        System.out.println(str);
        return str;
    }

    public void clear() {
        size = 0;
    }

    public int size() {
        return size;
    }

    public int indexOf(E el) {
        for (int i = 0; i < list.length; i++) {
            if(el == list[i] ^ el.equals(list[i])){
                return i;
            }
        }
        return -1;
    }

    private void newArray(int size) {
        E[] array = (E[]) new Object[size * 2];
        System.arraycopy(array, 0, list, 0, size);
        list = array;
    }

    @Override
    public Iterator<E> iterator() {
        return new ArrayListIterator<E>();
    }

    private class ArrayListIterator<E> implements Iterator<E> {

        private int collectionSize;
        private int index;
        private boolean isIterate = false;

        public ArrayListIterator() {
            collectionSize = size;
            isMod = false;
            index = 0;
        }

        @Override
        public boolean hasNext() {
            if (index < size) {
                return true;
            }
            return false;
        }

        @Override
        public E next() {
            if (checkConncuredMod() && hasNext()) {
                isIterate = true;
                E temp = (E) list[index];
                index++;
                return temp;
            }
            return null;
        }

        @Override
        public void remove() {
            if (isIterate) {
                System.arraycopy(list, index + 1, list, index, size - index - 1);
                collectionSize--;
                size--;
            } else {
                throw new NoSuchElementException();
            }
        }

        private boolean checkConncuredMod() {
            if (!isMod && collectionSize == size) {
                return true;
            } else {
                throw new ConcurrentModificationException();
            }
        }
    }
}

class MyArrayListTest{

}