package hw4.parallel;
/**
 * Created by rrudych on 04.06.15.
 */
public class MyArrayList<E> {


    private static final int DEFAULT_SIZE = 10;
    private E[] arr;
    private int size;

    private int resultIdx = -1;
    private volatile boolean hasFound;

    public MyArrayList() {
        arr = (E[]) new Object[DEFAULT_SIZE];
    }

    private E[] increaseArr(E[] arr) {
        E[] arrTmp = (E[])new Object[arr.length*3/2+1];
        for(int i=0; i<arr.length; i++) {
            arrTmp[i] = arr[i];
        }
        return arrTmp;
    }

    public boolean add(int idx, E element) {
        if (size == 0) {
            if (idx > size)
                throw new ArrayIndexOutOfBoundsException();
            if(size==arr.length) {
                E[] arrTmp = (E[])new Object[arr.length];
                for(int i=0; i<arr.length; i++) {
                    arrTmp[i] = arr[i];
                }
                arr = (E[]) new Object[(arr.length*3/2)+1];
                for(int i=1; i<arrTmp.length+1; i++) {
                    arr[i] = arrTmp[i];
                }
                arr[size] = element;
                size++;
                return true;
            }
        }
        if (idx == 0) {
            if (size == arr.length) {
                E[] arrTmp = (E[])new Object[arr.length];
                for(int i=0; i<arr.length; i++) {
                    arrTmp[i] = arr[i];
                }
                arr = (E[]) new Object[(arr.length*3/2)+1];
                for(int i=0; i<arrTmp.length; i++) {
                    arr[i+1] = arrTmp[i];
                }
            } else {
                for(int i=size-1; i >= 0; i--) {
                    arr[i+1] = arr[i];
                }
            }
            arr[idx] = element;
            size++;
            return true;
        } else {
            if(idx>size+1) {
                throw new ArrayIndexOutOfBoundsException();
            }
            if (idx == size) {
                if (size == arr.length) {
                    arr = increaseArr(arr);
                    arr[idx] = element;
                    size++;
                } else {
                    arr[idx] = element;
                    size++;
                    return true;
                }
            } else {
                if (size == arr.length) {
                    E[] arrTmp = (E[])new Object[arr.length];
                    for(int i=0; i<arr.length; i++) {
                        arrTmp[i] = arr[i];
                    }
                    arr = (E[]) new Object[(arr.length*3/2)+1];
                    for(int i=0; i<idx; i++) {
                        arr[i] = arrTmp[i];
                    }
                    for(int i = idx; i < arrTmp.length; i++) {
                        arr[i+1] = arrTmp[i];
                    }
                } else {
                    for(int i=size-1; i>=idx; i--) {
                        arr[i+1] = arr[i];
                    }
                }
                arr[idx] = element;
                size++;
                return true;
            }
        }
        return false;
    }

    public void add(E element) {
        add(size(), element);
    }

    public E get(int idx) {
        if(idx >= size) {
            throw new ArrayIndexOutOfBoundsException();
        } else
            return arr[idx];
    }

    public int size() {
        return size;
    }

    public int indexOf(E bbj) {

        if (bbj == null) {
            for (int i = 0; i < size(); i++) {
                if (get(i) == null) {
                    return i;
                }
            }
        } else {
            for (int i = 0; i < size(); i++) {
                if (bbj.equals(get(i))) {
                    return i;
                }
            }
        }

        return -1;
    }

    public int parallelIndexOf(E el) {

        class ThreadFinder extends Thread {

            int fromIdx;
            int toIdx;

            public ThreadFinder(int from, int to) {
                this.fromIdx = from;
                this.toIdx = to;
                this.start();
            }
            public void run() {
                if (el == null) {
                    for (int i = fromIdx; i < toIdx; i++) {
                        if(!hasFound) {
                            if (get(i) == null) {
                                resultIdx = i;
                                hasFound = true;
                                break;
                            }
                        } else break;
                    }
                } else {
                    for (int i = fromIdx; i < toIdx; i++) {
                        if(!hasFound) {
                            if (el.equals(arr[i])) {
                                resultIdx = i;
                                hasFound = true;
                                break;
                            }
                        } else {
                            break;
                        }
                    }
                }
            }
        }

        if(size <10) {
            if (el == null) {
                for (int i = 0; i < size; i++) {
                    if (get(i) == null) {
                        return i;
                    }
                }
            } else {
                for (int i = 0; i < size; i++) {
                    if (el.equals(get(i))) {
                        return i;
                    }
                }
            }
        } else {
            Thread thread1 = new ThreadFinder(0, size/3);
            Thread thread2 = new ThreadFinder(size/3, (size*2)/3);
            Thread thread3 = new ThreadFinder((size*2)/3, size);
            try {
                thread1.join();
                thread2.join();
                thread3.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return resultIdx;
    }
}