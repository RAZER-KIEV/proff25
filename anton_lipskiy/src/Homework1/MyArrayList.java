package Homework1;

/**
 * Created by Anton Lipskiy on 25.05.2015.
 */
public class MyArrayList<T> {

    private int size = 0;
    private T[]  arr = (T[]) new Object[10];

    public void add(T val){

        if (arr.length-1==size){
            extendArr();
        }

        arr[size] = val;

        size++;
    }



    public void add(T val, int pos){

        if (arr.length-1==size){
            extendArr();
        }

        T[] tempArray = (T[]) new Object[arr.length];

        System.arraycopy(arr, 0, tempArray, 0, pos-1);

        tempArray[pos-1]=val;

        System.arraycopy(arr, pos-1, tempArray, pos, arr.length-pos);

        arr = tempArray;

        size++;
    }





    private void extendArr(){

        //T[] tempArray = (T[]) new Object[arr.length*(2/3+1)];
        System.arraycopy(arr, 0, arr, 0, arr.length); //так можно заменить нижестоящий цикл

//		for (int i=0; i<arr.length; i++){
//			tempArray[i] = arr[i];
//		}
        //arr = tempArray;
    }



    //@Override
    public boolean isEmpty(){

        return size == 0;

    }



    @Override
    public String toString(){

       if (size==0) {
            return("[]");
        }

        StringBuilder sb = new StringBuilder("[");

        if (size==0) {
            return "[]";
        }

        for (int i = 0; i < size; i++) {
            if (i < size-1) {
                sb.append(arr[i]).append(",");
            } else {
                sb.append(arr[i]).append("]");
            }
        }

        return sb.toString();
    }

}//MyArrayList