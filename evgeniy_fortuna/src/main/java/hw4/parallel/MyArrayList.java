package hw4.parallel;

import java.util.Iterator;

/**
 * Реализовать в классе MyArrayList метод
 public int parallelIndexOf(E e), выполняющий линейный многопоточный поиск в списке.
 В тестах проверить поиск:
 - существующего элемента
 - не существующего элемента
 - не существующего элемента в пустом массиве
 - не существующего элемента в массиве с одним элементом
 - существующего элемента в массиве с одним элементом
 - элемента со значением null

 Класс задания:
 hw4.parallel.MyArrayList

 Класс теста:
 hw4.parallel.MyArrayListTest
 */
public class MyArrayList<E> implements  Iterable<E>  {

    private final static int defaultSize = 9;
    private Object [] index;
    private int i = 0;

    public MyArrayList() {
        index = (E[]) new Object[defaultSize ];
    }
    public MyArrayList(int capacity) {
        index = (E[]) new Object[capacity];
    }


    public void add(E value) {
        index[this.i++] = value;
    }

    public E get(int index) {
        return (E) this.index[index];
    }

    public boolean set(int index, E value) {
        this.index[index] = value;
        return true;
    }

    public boolean add(int index, E value) {
        Object[] tekMass = this.index;
        int mass = this.index.length + 1;
        this.index = (E[]) new Object[mass];

        for(int bCols = 0; bCols < this.index.length; bCols++) {
            if(bCols < index) {
                this.index[bCols ] = tekMass[bCols ];
            } else if(bCols == index) {
                this.index[bCols] = value;
                this.index[index+1] = tekMass[bCols];
            } else {
                if((index+1) != bCols) {
                    this.index[bCols] = tekMass[bCols-1];
                }
            }
        }
        this.i++;
        return true;
    }

    public int parallelIndexOf(E e) {
        int size = this.i; Object[] bb = this.index;
        Thread th = new Thread(){
            @Override
            public void run() {
                for(int the = 0; the < size; the++)
                    if (bb[the] == e) {
                        System.out.println("Element yes");
                    } else if(bb[the] != e) {
                        System.out.println("Element not found");
                    } else if(bb[the] == null && bb[the] == e) {
                        System.out.println("Element null");
                    } else if(bb[the].toString().charAt(0) != e.toString().charAt(0)) {
                        System.out.println("не существующего элемента в массиве с одним элементом");
                    } else if(bb[the].toString().charAt(0) == e.toString().charAt(0)) {
                        System.out.println("существующего элемента в массиве с одним элементом");
                    } else if(bb[the] == null && e == null) {
                        System.out.println("элемента со значением null");
                    }
            }
        };

        return 0;
    }

    public int indexOf(E value) {
        for (int the = 0; the < this.i; the++) {
            if(this.index[the] == value) {
                return the;
            }
        }
        return -1;
    }

    public int size() {
        return this.i;
    }

    public E remove(int index) {
        Object[] massTek = this.index;
        massTek[index] = null;
        this.i--;
        this.index = (E[]) new Object[this.i];
        for(int bCols = 0; bCols < massTek.length; bCols++) {
            if(bCols < this.index.length) {
                if(massTek[bCols] == null) {
                    this.index[bCols] = massTek[bCols+1];
                } else {
                    this.index[bCols] = massTek[bCols];
                }

            }
        }
        return null;
    }

    public Iterator<E> iterator() {
        return new ArrayIterator();
    }

    class ArrayIterator implements Iterator<E> {
        int pos;

        @Override
        public boolean hasNext() {
            return pos < i;
        }

        @Override
        public E next() {
            return (E) index[pos++];
        }
    }

    public String toString() {
        if(this.i == 0) {
            return "[]";
        }
        int mm = 0;
        StringBuilder bd = new StringBuilder("[ ");
        for(int cols = 0; cols < this.i; cols++) {
            if(cols == this.i - 1) {
                bd.append(mm + ". ");
                bd.append(this.index[cols]);
                bd.append(" ]");
                return bd.toString();
            }
            bd.append(mm + ". ");
            bd.append(this.index[cols] + ", ");
            mm++;
        }
        return "";
    }
}

