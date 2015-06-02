package session2;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by rr on 19.05.2015.
 */
public class Task1 {

    public static void main(String[] args) {
        ArrayList<Integer> ls = new ArrayList<>();
        for(int i = 0; i<100; i++) {
            ls.add(i);
        }
        System.out.println(ls);
        System.out.println();
        Task1 ts = new Task1();
        ts.filterPrime(ls);
        System.out.println(ls);
    }

    public void filterPrime(List<Integer> list) {
        Iterator<Integer> iter = list.iterator();
        while(iter.hasNext()) {
            int i = iter.next();
            if(isPrime(i)) {
                iter.remove();
            }
        }
    }

    private boolean isPrime(int number) {
        if(number == 1)
            return true;
        if(number == 0)
            return false;
        for(int i = 2; i<number; i++) {
            if(number%i == 0)
                return false;
        }
        return true;
    }
}
