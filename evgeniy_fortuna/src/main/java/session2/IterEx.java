package session2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

// Удаление всех простых чисел

public class IterEx {
    public static void main(String[] args) {
        IterEx module = new IterEx();
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 11));
        module.filterPrimes(list);
        System.out.println(list);
    }

    public void filterPrimes(List<Integer> list){
        Iterator<Integer> iter = list.iterator();
        while (iter.hasNext()){
            int number = iter.next();
            if (isPrime(number)){
                iter.remove();
            }
        }
    }

    private boolean isPrime(int number){
        if (number == 1){
            return false;
        }
        for (int i = 2; i < number; i++) {
            if (number % i == 0){
                return false;
            }
        }
        return true;
    }
}
