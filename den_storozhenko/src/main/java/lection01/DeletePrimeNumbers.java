package lection01;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * Created by storo_000 on 19.05.2015.
 */
public class DeletePrimeNumbers {

    private static boolean isPrime(int k){
        if (k<=1) return false;
        for (int i=2;i<=Math.sqrt(k);i++){
            if (k%i==0) return false;
        }
        return true;
    }

    public void deletePrime(List<Integer> list){
        Iterator<Integer> iterator = list.iterator();
        while(iterator.hasNext()){
            if (isPrime(iterator.next()))
                iterator.remove();
        }
    }

    public static void main(String[] args) {
        DeletePrimeNumbers deletePrimeNumbers = new DeletePrimeNumbers();
        ArrayList<Integer> list=new ArrayList<>(Arrays.asList(-51,-4,0,1,2,3,4,5,6,7,8,9,10));
        deletePrimeNumbers.deletePrime(list);
        System.out.println(list);
    }
}

//Написать метод, удаляющий из списка все простые числа
