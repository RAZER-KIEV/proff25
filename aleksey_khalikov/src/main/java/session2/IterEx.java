package session2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * Created by GFalcon on 19.05.15.
 */
public class IterEx {
    public static void main(String[] args) {
        IterEx module = new IterEx();
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9));
        module.filterPrimes(list);
        System.out.println(list);
    }
    public void filterPrimes(List<Integer> list){
        Iterator<Integer> iter = list.iterator(); // получаем итератор
        while (iter.hasNext()){ // проверяем, есть элемент следующий или нет
            Integer a = iter.next();
            int b = (int) a;
            if(isPrime(b)) iter.remove();
        }
    }
    private boolean isPrime(int number){
        for (int i = 2; i < number; i++){
            int temp = (number / i) * i;
            if (temp == number) return false;
        }
        return true;
    }
}
