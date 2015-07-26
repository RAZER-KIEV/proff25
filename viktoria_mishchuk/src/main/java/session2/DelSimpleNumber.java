package session2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by viktoria on 19.05.15.
 */
public class DelSimpleNumber {
    private int number;


    public static void main(String[] args) {
        DelSimpleNumber module = new DelSimpleNumber();
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
        module.filterPrimes(list);
        System.out.println(list);//[1,4]

    }

    private void filterPrimes(List<Integer> list) {
        for (int i = 0; i < list.size(); i++) {
            if (isPrime(list.get(i))) {
                list.remove(i);
            } else {
                System.out.println(list.get(i));
            }
        }
    }

    public boolean isPrime(int number){

        if (number % number == 0 && number % 1 == 0) {
            return true;
        } else {
            return false;
        }
    }
}

