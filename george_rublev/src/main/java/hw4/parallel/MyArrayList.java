package hw4.parallel;


 import java.util.Iterator;



public class MyArrayList<E> implements Iterable<E> {

    E[] arr;
    int length;
    final static int dEFAULT_SIZE = 10;
    int mutable;
    int findedIdex =-1;

    public MyArrayList(){
        arr = (E[])new Object[dEFAULT_SIZE];
    }

    public MyArrayList(int size){
        arr = (E[]) new Object[size];
    }


    public int parallelIndexOf(E e){

        if(length<4){
            if(length == 0){
                return findedIdex;
            }
            if(length==1){
                if(arr[0].equals(e))findedIdex=0;
            }

            FindIndex findIndex = new FindIndex(e,0,length);
        }else{
            int s1=0,s2=0,s3=0,s4=0,e1=0,e2=0,e3=0,e4=0;

            e1=length/4;
            s2=++e1;
            e2=(length/4)*2;
            s3=++e2;
            e3=(length/4)*3;
            s4=++e3;
            e4=length;


            FindIndex findIndex0 = new FindIndex(e,s1,e2);
            FindIndex findIndex1 = new FindIndex(e,s2,e2);
            FindIndex findIndex2 = new FindIndex(e,s3,e3);
            FindIndex findIndex3 = new FindIndex(e,s4,e4);

            Thread fi0 = new Thread(findIndex0);
            Thread fi1 = new Thread(findIndex1);
            Thread fi2 = new Thread(findIndex2);
            Thread fi3 = new Thread(findIndex3);

            fi0.start();
            fi1.start();
            fi2.start();
            fi3.start();

            while (fi0.isAlive() || fi1.isAlive() || fi2.isAlive() || fi3.isAlive()){

            }
           fi0.stop();
            fi1.stop();
            fi2.stop();
            fi3.stop();

        }

        return findedIdex;
    }

    class FindIndex extends Thread{

        E value;
        int start;
        int end;
        public  FindIndex(E value,int start,int end){
            this.value=value;
            this.start=start;
            this.end=end;
        }

        @Override
        public void run() {

            for(int i=start;i<end;i++){
                if(arr[i].equals(value)){
                    findedIdex=i;
                    return;
                };
            }



        }
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

}


