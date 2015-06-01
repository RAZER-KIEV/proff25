package week1_lesson2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * Created by HP on 19.05.2015.
 */
public class Task1 {
    public void filterPrime(List<Integer> list){
        Iterator<Integer> iter = list.iterator();
        while(iter.hasNext()){
           int temp =iter.next();
            if (isPrime(temp)) iter.remove();
        }
    }
    private boolean isPrime(int n){
        if(n==1){return false;}
        for (int i=2; i<n; i++){
            if(n%i==0) return true;
        }
        return false;
    }
    public static void main(String[] args) {
        Task1 module=new Task1();
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
        //list.add(5);
       // list.add(4);
       // list.add(3);
       // list.add(9);
        module.filterPrime(list);
        System.out.println(list.toString());
    }
}