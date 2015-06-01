package HomeWork;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Created by Sveta on 5/21/2015.
 *Сравнить время выполнения операции у ArrayList и LinkedList
 - добавление в начало
 - добавление в конец
 - добавление в середину
 - получение элемента по индексу
 - удаление элемента из начала
 - поиск элемента по значению

 Класс задания: hw2.lab.ListsCompare
 Класс теста: hw2.lab.ListsCompareTest
 *
 */
public class ListsCompare {
    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        LinkedList<Integer> linkedList = new LinkedList<>();

        for (int i = 0; i < 10_000; i++) {
            arrayList.add((int)Math.random()*100);
            linkedList.add((int)Math.random()*100);
        }

        // add first
        long timeOfStart = System.nanoTime();
        arrayList.add(0,5);
        long addTimeA = System.nanoTime() - timeOfStart;

        timeOfStart = System.nanoTime();
        linkedList.add(0, 5);
        long addTimeL = System.nanoTime() - timeOfStart;

        System.out.print("AddFirst:        ");
        printResult(addTimeA, addTimeL);

        //add last
        timeOfStart = System.nanoTime();
        arrayList.add(5);
        addTimeA = System.nanoTime() - timeOfStart;

        timeOfStart = System.nanoTime();
        linkedList.add(5);
        addTimeL = System.nanoTime() - timeOfStart;

        System.out.print("AddLast:         ");
        printResult(addTimeA, addTimeL);

        //add in the middle
        timeOfStart = System.nanoTime();
        arrayList.add(5000, 5);
        addTimeA = System.nanoTime() - timeOfStart;

        timeOfStart = System.nanoTime();
        linkedList.add(5000, 5);
        addTimeL = System.nanoTime() - timeOfStart;

        System.out.print("AddInTheMiddle:  ");
        printResult(addTimeA, addTimeL);

        //add by index1

        timeOfStart = System.nanoTime();
        arrayList.add(100, 5);
        addTimeA = System.nanoTime() - timeOfStart;

        timeOfStart = System.nanoTime();
        linkedList.add(100, 5);
        addTimeL = System.nanoTime() - timeOfStart;

        System.out.print("AddByIndex1:     ");
        printResult(addTimeA, addTimeL);

        //get by index
        timeOfStart = System.nanoTime();
        arrayList.get(98);
        addTimeA = System.nanoTime() - timeOfStart;

        timeOfStart = System.nanoTime();
        linkedList.get(98);
        addTimeL = System.nanoTime() - timeOfStart;

        System.out.print("AddByIndex2:     ");
        printResult(addTimeA, addTimeL);

        //delete first
        timeOfStart = System.nanoTime();
        arrayList.remove(0);
        addTimeA = System.nanoTime() - timeOfStart;

        timeOfStart = System.nanoTime();
        linkedList.remove(0);
        addTimeL = System.nanoTime() - timeOfStart;

        System.out.print("DeleteFirst:     ");
        printResult(addTimeA, addTimeL);

        //find by index1
        timeOfStart = System.nanoTime();
        arrayList.get(5);
        addTimeA = System.nanoTime() - timeOfStart;

        timeOfStart = System.nanoTime();
        linkedList.get(5);
        addTimeL = System.nanoTime() - timeOfStart;

        System.out.print("FindByIndex1:    ");
        printResult(addTimeA, addTimeL);

        //find by index2
        timeOfStart = System.nanoTime();
        arrayList.get(1500);
        addTimeA = System.nanoTime() - timeOfStart;

        timeOfStart = System.nanoTime();
        linkedList.get(1500);
        addTimeL = System.nanoTime() - timeOfStart;

        System.out.print("FindByIndex2:    ");
        printResult(addTimeA, addTimeL);

        //find by value
        timeOfStart = System.nanoTime();
        arrayList.indexOf(300);
        addTimeA = System.nanoTime() - timeOfStart;

        timeOfStart = System.nanoTime();
        linkedList.indexOf(300);
        addTimeL = System.nanoTime() - timeOfStart;

        System.out.print("FindByValue:     ");
        printResult(addTimeA, addTimeL);
    }

    public static void printResult(long arrayTime, long linkedTime){
        if(arrayTime < linkedTime){
            System.out.println("Arraylist: " + arrayTime + ";  LinkedList: " + linkedTime);
        }
        if(arrayTime > linkedTime){
            System.out.println("LinkedList: " + linkedTime + ";  Arraylist: " + arrayTime);
        }
        if(arrayTime == linkedTime){
            System.out.println("The same time: " + linkedTime);
        }



    }



}
