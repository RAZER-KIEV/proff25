package home1;

/**
 * Created by george on 24.05.15.
 */
public class homeArrayList {
    public static void main(String[] args) {
        hArrayList<Integer> hal = new hArrayList<Integer>();


    }
}

class hArrayList<T>{
    private T[] data;
    private boolean chenge = true;
    private int size = 0;
    private int maxSize = 16;

    hArrayList(){
        data = (T[]) new Object[maxSize];
        chenge = true;
    }
    hArrayList(int size){
        maxSize = size;
        data = (T[]) new Object[maxSize];
        chenge = false;

    }

    public boolean add(int data){

        return true;
    }

    private boolean checkAdd(){
        return true;
    }


}
