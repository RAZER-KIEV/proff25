package session2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * Created by viktoria on 19.05.15.
 */
public class IterEx {
    public static void main(String[] args) {
        IterEx module = new IterEx();
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
        module.filterPrimes(list);
        System.out.println(list);//[1,4]

    }

    private void filterPrimes(List<Integer> list) {
        Iterator<Integer> iter = list.iterator();
        while (iter.hasNext()){
            int number = iter.next();
            if(isPrime(number)){
                iter.remove();
            }
        }
    }

    public boolean isPrime(int number){

        if(number ==1 ){
            return false;
        }
        for (int i = 2; i < number; i++) {
            if (number % i == 0) {
                return false;
            }
        }
                return true;

        }
    }

