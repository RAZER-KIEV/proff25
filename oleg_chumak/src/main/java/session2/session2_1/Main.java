package session2.session2_1;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * Created by oleg on 19.05.15.
 */
public class Main {
    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();

        for (int i = 1; i < 6; i++) {
            list.add(i);
        }
//        for (int i = 0; i < 10; i++){
//
//            System.out.println(isPrime(i)+ " " + i);
//        }
        System.out.println(list);
        filterPrimes(list);
        System.out.println(list);
    }

    private static boolean isPrime(int tmp) {
        if (tmp == 1 ) {
            return false;
        }
        else {
           for (int i = 2; i < tmp; i++) {
                if ((tmp % i) == 0) {
                    return false;
                }
            }
            return true;
        }
    }

    private static void filterPrimes(LinkedList list){
        Iterator<Integer> iter = list.iterator();
        while(iter.hasNext()) {
            Integer  integer = iter.next();
            if(isPrime(integer)){
                iter.remove();
            }
        }
    }
}


