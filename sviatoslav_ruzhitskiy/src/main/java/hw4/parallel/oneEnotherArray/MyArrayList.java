package hw4.parallel.oneEnotherArray;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by ПК on 04.06.2015.
 */
public class MyArrayList<E> extends ArrayList {
    public static int index= -1;
    ArrayList<E> arrayList;

    public MyArrayList() {
        arrayList = new ArrayList<E>();

    }

    public int parallelIndexOf(E e){

        ThreadGroup group = new ThreadGroup("SearchGroup");
        int _25 =(int) (arrayList.size()*0.25);
        int _50 =(int) (arrayList.size()*0.5);
        int _75 = (int) (arrayList.size()*0.75);
        // ThreadsMaker threadsMaker = new ThreadsMaker()
        new Thread(group, new ThreadsMaker(0,_25, arrayList,e));
        new Thread(group, new ThreadsMaker(_25,_50,arrayList,e));
        new Thread(group, new ThreadsMaker(_50,_75,arrayList,e));
        new Thread(group, new ThreadsMaker(_75,arrayList.size(),arrayList,e));
        return index;
    }

}
class ThreadsMaker<E> extends Thread{
   // MyArrayList arrlist = new MyArrayList<>();
   public ArrayList mass;
    int bigin;
    int end;
    Object value;
    ThreadsMaker thred;
    int index;
    // ThreadGroup group;
    static Thread thread;
    public <E> ThreadsMaker(int bigin,int end, ArrayList<E> arrayList, E value){
       //ArrayList<E> mass= new ArrayList<E>();
        this.bigin = bigin;
        this.end = end;
        this.mass = arrayList;
        this.value = value;
        //this.group = group;
        this.start();


    }



    public void run() throws NullPointerException{
        thred = (ThreadsMaker) Thread.currentThread();
        do {
            for (int i = bigin; i <= end; i++){
                   if (mass.get(i).equals(value)) {
                        index = i;
                        // pushI(index);
                        System.out.println("индекс найден потоком: " + thred.getName() + " index: " + i);
                        getThreadGroup().interrupt();

                    }
                }

        } while(thread.isInterrupted());

    }
    public void pushI(int index){
        MyArrayList.index = index;
        System.out.println("index pushed!" +index);


    }
}
class MyArrayListTest2 {
    public static void main(String[] args) {
        MyArrayList myArrayList = new MyArrayList();
        for (int i = 0; i < 1000; i++) {
            myArrayList.add(i, (Integer)i * 10);
        }

        int index = myArrayList.parallelIndexOf(7770);
        System.out.println(index);
    }
}