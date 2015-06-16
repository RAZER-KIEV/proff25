package hw2.lab;

import java.io.FileWriter;
import java.io.IOException;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

/**Speed tests of two lists(LinkedList, ArrayList). Results writes into the text file.
 * Tests: 1. Add first, 2. Add last, 3. Add middle, 4. Get element by index, 5. Delete first, 6. Find index by element(IndexOf).
 * Created by Роман on 25.05.2015.
 */
public class ListsCompare {

    public static void main(String[] args) throws IOException {

        ArrayList<Integer> aList = new ArrayList<>();
        LinkedList<Integer> lList = new LinkedList<>();
        int size = 1_000_000_0;
        System.out.println("Adding " + size + " elements");
        long t1 = System.currentTimeMillis();
        for(int i = 0; i <= size; i++) {
            aList.add(i);
        }
        long t2 = System.currentTimeMillis();
        System.out.println("ArrayList: " + (t2 - t1));
        t1 = System.currentTimeMillis();
        for(int i = 0; i <= size; i++) {
            lList.add(i);
        }
        t2 = System.currentTimeMillis();
        System.out.println("LinkedList: " + (t2 - t1));

        System.out.println();

        System.out.println("Add first:");
        t1 = System.currentTimeMillis();
        aList.add(0, -1);
        t2 = System.currentTimeMillis();
        System.out.println("ArrayList: " + (t2 - t1));
        t1 = System.currentTimeMillis();
        lList.add(0, -1);
        t2 = System.currentTimeMillis();
        System.out.println("LinkedList: " + (t2 - t1));

        System.out.println();

        System.out.println("Add last:");
        t1 = System.currentTimeMillis();
        aList.add(aList.size(), -2);
        t2 = System.currentTimeMillis();
        System.out.println("ArrayList: " + (t2 - t1));
        t1 = System.currentTimeMillis();
        lList.add(lList.size(), -2);
        t2 = System.currentTimeMillis();
        System.out.println("LinkedList: " + (t2 - t1));

        System.out.println();

        System.out.println("Add middle:");
        t1 = System.currentTimeMillis();
        aList.add(size / 2, -3);
        t2 = System.currentTimeMillis();
        System.out.println("ArrayList: " + (t2 - t1));
        t1 = System.currentTimeMillis();
        lList.add(size / 2, -3);
        t2 = System.currentTimeMillis();
        System.out.println("LinkedList: " + (t2 - t1));

        System.out.println();

        System.out.println("Get by index");
        t1 = System.currentTimeMillis();
        aList.get(size / 2);
        t2 = System.currentTimeMillis();
        System.out.println("ArrayList: " + (t2 - t1));
        t1 = System.currentTimeMillis();
        lList.get(size / 2);
        t2 = System.currentTimeMillis();
        System.out.println("LinkedList: " + (t2 - t1));

        System.out.println();

        System.out.println("Delete first");
        t1 = System.currentTimeMillis();
        aList.remove(0);
        t2 = System.currentTimeMillis();
        System.out.println("ArrayList: " + (t2 - t1));
        t1 = System.currentTimeMillis();
        lList.remove(0);
        t2 = System.currentTimeMillis();
        System.out.println("LinkedList: " + (t2 - t1));

        System.out.println();

        System.out.println("Index of");
        t1 = System.currentTimeMillis();
        aList.indexOf(size/2);
        t2 = System.currentTimeMillis();
        System.out.println("ArrayList: " + (t2 - t1));
        t1 = System.currentTimeMillis();
        lList.indexOf(size/2);
        t2 = System.currentTimeMillis();
        System.out.println("LinkedList: " + (t2 - t1));
    }


}

class ListsCompareTest {
    public static void main(String[] args) {

    }
}
