package session02;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Jeckgehor on 19.05.2015.
 */
public class SimpleNumber {
    public static void main (String[] args) {
        SimpleNumber module = new SimpleNumber();
        ArrayList<Integer> arrl = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17));
        System.out.println(arrl);
        module.filterPrime(arrl);
        System.out.println(arrl);
    }

    public void filterPrime(List<Integer> list) {
        Iterator<Integer> iter = list.iterator();
        while (iter.hasNext()) {
            int el = iter.next();
            if(isPrime(el)) {
                iter.remove();
            }
        }
    }

    public boolean isPrime(int el) {
        if (el == 1) {
            return false;
        }
        for(int i = 2; i < el; i++){
            if(el % i == 0){
                return false;
            }
        }
        return true;
    }
}