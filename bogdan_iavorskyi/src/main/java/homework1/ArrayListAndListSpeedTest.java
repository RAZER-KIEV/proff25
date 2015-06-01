package homework1;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by bosyi on 25.05.15.
 */
public class ArrayListAndListSpeedTest {

    private int numberOfTries;
    private int numberOfAgainTries;
    private int numberOfElementsInArray;

    public static void main(String[] args) {

        ArrayListAndListSpeedTest task = new ArrayListAndListSpeedTest(10000,20,5);
        task.work();

    }

    public ArrayListAndListSpeedTest(int numberOfElementsInArray, int numberOfTries, int numberOfAgainTries) {
        this.numberOfTries = numberOfTries;
        this.numberOfAgainTries = numberOfAgainTries;
        this.numberOfElementsInArray = numberOfElementsInArray;
    }

    public void work() {
        List<Integer> arrayList = new ArrayList<>(/*numberOfElementsInArray*/);
        List<Integer> linkedList = new LinkedList<>();
        List[] lists = {arrayList, linkedList};
        for (int i = 0; i < numberOfElementsInArray; i++) {
            int number = (int)(Math.random()*10);
            lists[0].add(number);
            lists[1].add(number);
        }

        long[][] table = new long[6][2];
        String[] tableHead = {"addFirst","addLast","addMiddle","get","removeFirst","indexOf"};

        for (int i = 0; i < numberOfAgainTries; i++) {

                table[0][0]+=addFirst(lists[0]);
                table[0][1]+=addFirst(lists[1]);
                table[1][0]+=addLast(lists[0]);
                table[1][1]+=addLast(lists[1]);
                table[2][0]+=addMiddle(lists[0]);
                table[2][1]+=addMiddle(lists[1]);
                table[3][0]+=get(lists[0]);
                table[3][1]+=get(lists[1]);
                table[4][0]+=removeFirst(lists[0]);
                table[4][1]+=removeFirst(lists[1]);
                table[5][0]+=indexOf(lists[0]);
                table[5][1]+=indexOf(lists[1]);

        }

        for (int i = 0; i < table.length; i++) {
            for (int j = 0; j < table[i].length; j++) {
                table[i][j] = table[i][j] / numberOfAgainTries;
            }
        }

        printResult(tableHead,table, 40);

    }

    private long addFirst(List<Integer> list) {
        long totalTime = 0;
        long time;
        int number = (int)(Math.random()*10);
        for (int i = 0; i < numberOfTries; i++) {
            time = System.nanoTime();
            list.add(0, number);
            totalTime+=System.nanoTime() - time;
        }
        return totalTime/numberOfTries;
    }

    private long addLast(List<Integer> list) {
        long totalTime = 0;
        long time;
        int number = (int)(Math.random()*10);
        for (int i = 0; i < numberOfTries; i++) {
            time = System.nanoTime();
            list.add(number);
            totalTime+=System.nanoTime() - time;
        }
        return totalTime/numberOfTries;
    }

    private long addMiddle(List<Integer> list) {
        int index = numberOfElementsInArray/2;
        long totalTime = 0;
        long time;
        int number = (int)(Math.random()*10);
        for (int i = 0; i < numberOfTries; i++) {
            time = System.nanoTime();
            list.add(index, number);
            totalTime+=System.nanoTime() - time;
        }
        return totalTime/numberOfTries;
    }

    private long get(List<Integer> list) {
        long totalTime = 0;
        long time;
        int index = numberOfElementsInArray/3;
        for (int i = 0; i < numberOfTries; i++) {
            time = System.nanoTime();
            list.get(index);
            totalTime+=System.nanoTime() - time;
        }
        return totalTime/numberOfTries;
    }

    private long removeFirst(List<Integer> list) {
        long totalTime = 0;
        long time;
        for (int i = 0; i < numberOfTries; i++) {
            time = System.nanoTime();
            list.remove(0);
            totalTime+=System.nanoTime() - time;
        }
        return totalTime/numberOfTries;
    }

    private long indexOf(List<Integer> list) {
        long totalTime = 0;
        long time;
        for (int i = 0; i < numberOfTries; i++) {
            time = System.nanoTime();
            list.indexOf(-1);
            totalTime+=System.nanoTime() - time;
        }
        return totalTime/numberOfTries;
    }

    private void printResult(String[] head, long[][] table, int numberOfAsteriskes) {
        long maxValue = 0;
        for (int i = 0; i < table.length; i++) {
            for (int j = 0; j < table[i].length; j++) {
                if (table[i][j] > maxValue) {
                    maxValue = table[i][j];
                }
            }
        }
        int newNumber;
        String newLine = "";
        for (int i = 0; i < table.length; i++) {
            for (int j = 0; j < table[i].length; j++) {
                newNumber = (int)(table[i][j]*numberOfAsteriskes/maxValue);
                for (int k = 0; k < newNumber; k++) {
                    newLine+="*";
                }
                System.out.printf("%12s%12s%45s | %10d\n", j==0?"ArrayList":"LinkedList", head[i],newLine,table[i][j]);
                newLine = "";
            }
            System.out.println();
        }

    }
}
