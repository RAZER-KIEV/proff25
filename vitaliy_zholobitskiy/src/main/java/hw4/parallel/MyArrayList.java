package hw4.parallel;




import java.util.Iterator;
import java.util.NoSuchElementException;



/**
 * Created by just1ce on 24.05.2015.
 */
class MyArrayList<E> implements Iterable<E>,
        Iterator<E> {
    private E[] data;      //array of elements
    private int index = 0; //current index
    private int count = 0; //current count of elements
    private int length;    //lenght array of elements

    MyArrayList(int lenght){
        this.data = (E[]) new Object[lenght];
        this.length=lenght;
    }
    public MyArrayList() {
        this.data = (E[]) new Object[20];
        this.length=20;
    }
    @Override
    public Iterator iterator() {
        Iterator<E> it = new Iterator<E>() {

            private int currentIndex = 0;

            @Override
            public boolean hasNext() {
                return currentIndex < count && data[currentIndex] != null;
            }

            @Override
            public E next() {
                return data[currentIndex++];
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
        return it;
    }

    @Override
    public boolean hasNext() {
        return index<this.count;
    }

    @Override
    public E next() {
        if(index == this.count)
            throw new NoSuchElementException();
        index++;
        return data[index-1];
    }
    public void add(E value){
        if (count == data.length-1){
            growArray();
        }
        data[count]= value;
        count++;
    }

    public int parallelIndexOf(E el){
        final boolean[] isFound = new boolean[1];
        isFound[0]=false;
        class ListWalker implements Runnable {
            private int start = 0;
            private int end = 0;
            private Integer result;
            public ListWalker(int start, int end){
                this.start = start;
                this.end = end;
            }

            public Integer getResult(){
                return result;
            }

            @Override
            public void run() {
                for (int i = start; i < end; i++) {
                    if(isFound[0]==true)
                        return;
                    if (el.equals(get(i))){
                        result = i;
                        isFound[0] = true;
                        return;
                    }
                }
            }
        }
        ListWalker listWalker1 = new ListWalker(0,count/2);
        ListWalker listWalker2 = new ListWalker(count/2,count);
        Thread firstThread = new Thread(listWalker1);
        Thread secondThread = new Thread(listWalker2);
        firstThread.start();
        secondThread.start();

        try {
            firstThread.join();
            secondThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if (listWalker1.getResult() != null) {
            return listWalker1.getResult();
        } else
        if (listWalker2.getResult() != null) {
            return listWalker2.getResult();
        } else {
            return -1;
        }
    }
    public E get(int i){
        checkIndex(i);
        return data[i];
    }
    public boolean set(int index, E value){
        checkIndex(index);
        if(index>length) return false;
        data[index]= value;
        return true;
    }
    public boolean add(int index, E value){
        if (count == data.length-1){
            growArray();
        }
        for(int i=count-1;i>=index;i--){
            data[i+1]=data[i];
        }
        data[index]= value;
        count++;
        return true;
    }
    public int size(){
        return count;
    }
    public E remove(int index){
        checkIndex(index);
        for(int i=index;i<count-1;i++){
            data[i]=data[i+1];
        }
        count--;
        return data[index];
    }
    public int indexOf(E value){
        checkIndex(index);
        int ind=0;
        for(int i=0;i<=count;i++)
        {
            if(data[i].hashCode()==value.hashCode()) {
                ind = i;
                break;
            }
        }
        return ind;
    }
    private void growArray(){

        E[] newArray = (E[])new Object[data.length * 2];
        System.arraycopy(data, 0, newArray, 0, count);
        length=data.length * 2;
        data = newArray;
    }


    private void checkIndex(int index) {
        if (index < 0 || index >= this.count) {
            throw new IllegalArgumentException();
        }
    }
}
