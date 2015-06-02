package session2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Sveta on 5/19/2015.
 * написать метод, удал€ющий из списка все прост≥е числа
 */
public class Task1 {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 11, 12));
        delPrime(list);
        System.out.println(list);

    }
    public static void delPrime(List<Integer> list){
        Iterator iterator = list.iterator();
        while(iterator.hasNext()){
            int number = (int) iterator.next();
            if(isPrime(number)){
                iterator.remove();
            }
        }

    }
    public static boolean isPrime(int number){
        int k = 0;
        for (int i = 1; i <= number; i++) {
            if(number%i == 0){
                k = k+i;
            }

        }
        if(k == number + 1) {
            return true;
        }
        else {
            return false;
        }
    }
}
