package session2;

import com.sun.deploy.panel.ITreeNode;

import java.util.*;

/**
 * Created by ivan on 19.05.15.
 */
public class methodDel {


    static void delPrimeNumber(List<Integer> list) {
        Iterator<Integer> iter = list.iterator();
        while (iter.hasNext()) {
            int number = iter.next();
                if(isPrime(number)){
                 iter.remove();
                }
        }
    }
    private static boolean isPrime(Integer num) {
         for(int i=2;i<=Math.sqrt(i)+1;i++){
             if (num%i==0){
                 return false;
             }
         }
        return true;
    }

    public static void main(String[] args) {
        ArrayList<Integer> aList = new ArrayList<Integer>();
        aList.add(2);
        aList.add(3);
        aList.add(4);
        aList.add(5);
        aList.add(6);
        aList.add(7);
        aList.add(8);
        aList.add(9);
        aList.add(10);
        aList.add(11);
        delPrimeNumber(aList);
        for (int i = 0; i < aList.size(); i++) {
            System.out.println(aList.get(i));
        }

    }
}
