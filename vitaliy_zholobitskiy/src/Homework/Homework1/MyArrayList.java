package Homework.Homework1;



import java.util.Iterator;
import java.util.List;
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
    MyArrayList() {
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

    // �������� �������
    private void checkIndex(int index) {
        if (index < 0 || index >= this.count) {
            throw new IllegalArgumentException();
        }
    }
}
