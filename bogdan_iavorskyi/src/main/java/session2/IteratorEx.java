package session2;

import java.util.*;

/**
 * Created by bosyi on 19.05.15.
 */
public class IteratorEx {
    public static void main(String[] args) {
        IteratorEx task = new IteratorEx();
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(1,2,3,4,5,6,7,8,9,10));
        task.filterPrime(list);
        System.out.println(list.toString());
    }

    public void filterPrime(List<Integer> list) {
        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()) {
            if (isPrime(iterator.next())) {
                iterator.remove();
            }
        }
    }

    public boolean isPrime(int number) {
        if (number <= 1) {
            return false;
        }
        for (int i = 2; i < Math.sqrt(number)+1; i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
}
