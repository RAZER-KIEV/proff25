package session2.session2_arrayList;

import java.util.Iterator;

/**
 * Created by oleg on 25.05.15.
 */
public class Main {
    public static void main(String[] args) {


        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < 12; i++){
            list.add((int)(Math.random() * 10));
        }
        System.out.println(list);
        System.out.println(list.size());
//        list.remove();
//        list.remove();
//        list.add(3,6);
//        list.remove(3);
//        list.set(7,4);
//        list.add(45);
//        System.out.println(list);
//        list.set(12,13);
//        System.out.println();
        Iterator<Integer> iter = list.iterator();
        while(iter.hasNext()){
            int n = iter.next();
            System.out.print(n + " ");
            if(n == 3 | n ==4){
                iter.remove();
            }
        }
        System.out.println(list);
    }
}
