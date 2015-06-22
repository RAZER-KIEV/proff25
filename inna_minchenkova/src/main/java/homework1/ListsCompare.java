package homework1;

import java.util.List;
import java.util.Random;

/**
 * Created by Jax on 28.05.2015.
 */
public class ListsCompare {
    public static final int LIST_SIZE = 100_000;
    public static final int LIST_REMOVE_SIZE = 10_000;
    public static final int ADD_SIZE = 10_000;
    public static final int RANDOM = 1000;
    Random random = new Random();

    public void run(List list){
        long start = System.currentTimeMillis();
        for(int i =0;i<LIST_SIZE;i++) {
            list.add(0, random.nextInt(RANDOM));
        }
        long finish = System.currentTimeMillis();
        long time = start-finish;
        System.out.println(time);
    }
    public void addToFirst(List list){
        long start = System.currentTimeMillis();
        for(int i =0;i<ADD_SIZE;i++){
            list.add(0,random.nextInt(RANDOM));
        }
        long finish = System.currentTimeMillis();
        long time = start-finish;
        System.out.println(time);
    }
    public void addToIndex(List list, int index){
        long start = System.currentTimeMillis();
        for(int i =0;i<ADD_SIZE;i++){
            list.add(index, random.nextInt(RANDOM));
        }
        long finish = System.currentTimeMillis();
        long time = start-finish;
        System.out.println(time);
    }
    public void addToLast(List list){
        long start = System.currentTimeMillis();
        for(int i=0;i<ADD_SIZE;i++){
            list.add(random.nextInt(RANDOM));
        }
        long finish = System.currentTimeMillis();
        long time = start-finish;
        System.out.println(time);
    }
    public void removeForIndex(List list,int index){
        long start = System.currentTimeMillis();
        for (int i =0;i<LIST_REMOVE_SIZE;i++){
            list.remove(index);
        }
        long finish = System.currentTimeMillis();
        long time = start-finish;
        System.out.println(time);
    }
    public void remove(List list){
        long start = System.currentTimeMillis();
        for (int i =0;i<LIST_REMOVE_SIZE;i++){
            list.remove(0);
        }
        long finish = System.currentTimeMillis();
        long time = start-finish;
        System.out.println(time);
    }
    public void getIndex(List list, int index){
        long start = System.currentTimeMillis();
        for (int i=0; i<LIST_SIZE;i++){
            list.get(index);
        }
        long finish = System.currentTimeMillis();
        long time = start-finish;
        System.out.println(time);
    }

}


