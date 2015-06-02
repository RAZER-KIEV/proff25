package hw2;

import java.util.Iterator;

/**
 * Created by george on 28.05.15.
 */
public class MyArrayList<E> implements Iterable<E> {

    E[] arr;
    int length;
    final static int DEFAULT_SIZE = 10;
    int mutable;

    public MyArrayList(){
        arr = (E[])new Object[DEFAULT_SIZE];
    }

    public MyArrayList(int size){
        arr = (E[]) new Object[size];
    }

    private boolean isFull(){
        return length==arr.length;
    }

    private void makeNewSize(){
        E[] newarr = (E[])new Object[arr.length*3/2+1];
        System.arraycopy(arr,0,newarr,0,arr.length);
        arr = newarr;
    }

    private boolean checkIndex(int idx){
        return idx>=0 && idx<=length;
    }
    public void add(E value){
        add(length,value);
    }

    public boolean add(int idx, E value) {
        if(checkIndex(idx)){
            if (isFull()){
                makeNewSize();
            }
            if(idx==0){
                System.arraycopy(arr,0,arr,1,idx+1);
                arr[0]=value;
            } if (idx==this.length){
                arr[idx]=value;
            } else {
                System.arraycopy(arr,idx,arr,idx+1,length-idx);
                arr[idx]=value;
            }
            length++;
            mutable++;
            return true;
        } else {
            return false;
        }
    }

    public E get(int idx){
        if(idx>=0 && idx<length){
            return arr[idx];
        }else {
            return null;
        }
    }

    public  boolean set(int idx, E value){
        if(idx>=0 && idx<length) {
            arr[idx]=value;
            return true;
        } else {
            return false;
        }
    }
    public int indexOf(E val){
        Iterator<E> iter = this.iterator();
        int i=0;
        E result;
        while (iter.hasNext()){
            result = iter.next();
            if(result==val){
                return i;
            }
            i++;
        }
        return -1;
    }

    public E remove(int idx){
        if(idx>=0 && idx<length){
            E result = arr[idx];
            if(idx!=length-1) {
                System.arraycopy(arr, idx + 1, arr, idx, length - 1);
            }
            length--;
            mutable--;
            return result;
        }else {
            return null;
        }
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {

            int checkmutable = mutable;
            int curridx;
            boolean flag=false;

            private void isMutable() {
                if(mutable!=checkmutable){
                }
            }

            @Override
            public boolean hasNext() {
                isMutable();
                return curridx <length;
            }

            @Override
            public E next() {
                isMutable();
                if(curridx <length) {
                    E result = arr[curridx];
                    curridx++;
                    flag=true;
                    return result;
                } else {
                    throw new IndexOutOfBoundsException();
                }
            }

            @Override
            public void remove(){
                isMutable();
                if(flag==true){
                    if(curridx !=length-1){
                        System.arraycopy(arr,curridx,arr,curridx-1,length-curridx);
                    }
                    length--;
                    flag=false;
                } else {
                    throw new IndexOutOfBoundsException();
                }
            }
        };
    }

    public String toString() {
        Iterator<E> iter = this.iterator();
        StringBuilder sb = new StringBuilder("[");
        while (iter.hasNext()){
            sb.append(iter.next()).append(",");
        }
        sb.delete(sb.length()-1,sb.length());
        sb.append("]");
        return sb.toString();
    }

    public int size() {
        return length;
    }

    public void trimToSize(){
        if (length<arr.length){
            E[] newarr = (E[]) new Object[length];
            System.arraycopy(arr,0,newarr,0,length);
            arr=newarr;
        }
    }

    public static void main(String[] args) {
        MyArrayList<Integer> mal = new MyArrayList<Integer>();
        for(int i =0; i<100; i++){
            mal.add(i,i);
        }
MyArrayListTest.addTest(mal);
    }

}


class MyArrayListTest {

    MyArrayList<Integer> myArrayList = new MyArrayList<Integer>();

    static void addTest(MyArrayList myArrayList){
        System.out.println(myArrayList);
    }

}