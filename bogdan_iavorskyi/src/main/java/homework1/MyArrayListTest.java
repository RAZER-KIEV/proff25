package homework1;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by bosyi on 05.06.15.
 */
public class MyArrayListTest {
    public static void main(String[] args) {
        MyArrayList<Integer> array = new MyArrayList<>();
        array.add(5);
        array.add(10);
        array.add(2,0);
        System.out.println(array.size());
        System.out.println(array);
        array.remove(0);
        System.out.println(array.size());
        System.out.println(array);
        System.out.println(array.indexOf(11));
        Iterator<Integer> iterator = array.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
//        testArrayList();
    }

    public static void testArrayList() {
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 0; i < 10; i++) {
            list.add(i);
        }
        Iterator<Integer> iterator = list.iterator();

        iterator.next();
        iterator.remove();
        iterator.remove();
    }
}
