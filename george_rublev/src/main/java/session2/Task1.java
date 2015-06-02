package session2;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * Created by george on 19.05.15.
 */
public class Task1 {
    public static void main(String[] args) {
        Task1 module = new Task1();
        ArrayList<Integer> list = new ArrayList<Integer>(Arrays.asList(1,2,3,4,5));
        module.filterPrime(list);
        System.out.println(list);
    }

    public void filterPrime (List<Integer> list){

        Iterator iter = list.iterator();
        while (iter.hasNext()){
            if(isPrime((Integer)iter.next())){
                iter.remove();
            }
        }
    }
    private boolean isPrime(int number){
        if(number == 1){
            return false;
        }
        for (int i = 2; i<number; i++){
            if(number % i == 0) return false;

        }
        return true;
    }

}

