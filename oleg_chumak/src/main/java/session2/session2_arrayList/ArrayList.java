package session2.session2_arrayList;

import java.util.Arrays;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Created by oleg on 25.05.15.
 */
    public class ArrayList<E> implements Iterable<E> {
        //    java.hw6.notes.util.ArrayList;
        private int size;
        private int counter;
        private E[] work;
        private static final int DEFAULE_CAPACIEY = 10;

//        java.hw6.notes.util.ArrayList
        public ArrayList(int capacity) {
            work = (E[]) new Object[capacity];
        }


        public ArrayList() {
            this(DEFAULE_CAPACIEY);
        }


        public int size() {
            return size;
        }

        public boolean isEmpty() {
            return size == 0;
        }

        public void add(E value) {
            add(size, value);
        }

        public boolean add(int index, E value) {
            if (index == size) {
                lenCheck(index);
                work[index] = value;
                size++;
                counter++;
            } else {
                indexCheck(index);
                for (int i = size; i > index; i--) {
                    work[i] = work[i - 1];
                }
                work[index] = value;
                counter++;
                size++;
            }
            return true;
        }

        public E remove(int index) {
            E tmp;
            if (index == size - 1) {
                tmp = work[index];
                work[index] = null;
                size--;
                return tmp;
            } else {
                indexCheck(index);
                tmp = work[index];
                for (int i = index; i < size - 1; i++) {
                    work[i] = work[i + 1];
                    work[size] = null;
                }
            }
            size--;
            counter++;
            return tmp;
        }


        public boolean set(int index, E value) {
            indexCheck(index);
            work[index] = value;
            return true;
        }

        public E remove() {
            return remove(size - 1);
        }

        public void clear() {
            for (int i = size - 1; i >= 0; i--) {
                remove(i);
            }
        }

        public E get(int index) {
            indexCheck(index);
            return work[index];
        }

        public int indexOf(E value) {
            if (value == null) {
                for (int i = 0; i < size; i++) {
                    if (work[i] == null) {
                        return i;
                    }
                }
            } else if (value != null) {
                for (int i = 0; i < size; i++) {
                    if (work[i] == value) {
                        return i;
                    }
                }
            }
            return -1;
        }

        public int lastIndexOf(E value) {
            if (value == null) {
                for (int i = size - 1; i >= 0; i--) {
                    if (work[i] == null) {
                        return i;
                    }
                }
            } else if (value != null) {
                for (int i = size - 1; i >= 0; i--) {
                    if (work[i] == value) {
                        return i;
                    }
                }
            }
            return -1;
        }


        public boolean contains(E value) {
            return indexOf(value) >= 0;
        }

        private void indexCheck(int index) {
            if (index > size - 1 | index < 0) throw new ArrayIndexOutOfBoundsException();
        }

        private void lenCheck(int index) {
            if (size == work.length) enlarge();
        }

        private void enlarge() {
            E[] tmp = (E[]) new Object[(int) (size * 1.6)];
            for (int i = 0; i < size; i++) {
                tmp[i] = work[i];
            }
            work = tmp;
        }

        public E[] toArray() {
            return Arrays.copyOf(work, size);
        }

        @Override
        public String toString() {

            StringBuilder sb = new StringBuilder("[");
            if (size != 0) {
                for (int i = 0; i < size; i++) {
                    sb.append(" " + work[i] + ",");
                }
                sb.deleteCharAt(sb.length() - 1);
                sb.append(" ]");
                return sb.toString();
            } else return "[ empty ]";

        }


        @Override
        public Iterator<E> iterator() {
            return new Iterator<E>() {

                private int current;
                private int localCounter = counter;
                private boolean wasNexted = false;

                @Override
                public boolean hasNext() {
                    return current < size();
                }

                @Override
                public E next() {
                    if (!hasNext()) {
                        throw new NoSuchElementException();
                    } else {
                        E tmp = work[current];
                        current++;
                        wasNexted = true;
                        return tmp;
                    }
                }

                @Override
                 public void remove(){
                    if (wasNexted == false){
                        throw new IllegalStateException();
                    }
                    else{
                        if (localCounter != counter){
                            throw new ConcurrentModificationException();
                        }
                        else ArrayList.this.remove(current - 1);
                        current--;
                        localCounter++;
                        wasNexted = false;
                    }
                }
            };
        }
}

class MyArrayListEest{

}