package hw1;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Created by GFalcon on 22.05.15.
 Сравнить время выполнения операции у ArrayList и LinkedList
 - добавление в начало
 - добавление в конец
 - добавление в середину
 - получение элемента по индексу
 - удаление элемента из начала
 - поиск элемента по значению

 Класс задания: hw2.lab.ListsCompare
 Класс теста: hw2.lab.ListsCompareTest
 */
public class ListsCompare {
    public static void main(String[] args){
        ListsCompareTest test = new ListsCompareTest();

        test.addFirst();
        test.addLast();
        test.addMiddle();
        test.getElement();
        test.removeFirst();
        test.indexOf();
    }
}
class ListsCompareTest{
    private long timeStart;
    private long timeEnd;
    private int val;
    private ArrayList<Integer> alist = new ArrayList<>();
    private LinkedList<Integer> llist = new LinkedList<>();

    ListsCompareTest(){
        this(100000);
    }
    ListsCompareTest(int size){
        if (size > 0){
             for(int i = 0; i < size; i++){
                  alist.add(i);
                  llist.add(i);
              }
        }
    }

    public void addFirst(){
        val = (int)(alist.size()*Math.random());
        System.out.println("Add first element добавить");
        timeStart = System.nanoTime();
        alist.add(0,val);
        timeEnd = System.nanoTime();
        System.out.print("ArrayList: ");
        System.out.println(timeEnd-timeStart);
        timeStart = System.nanoTime();
        llist.addFirst(val);
        timeEnd = System.nanoTime();
        System.out.print("LinkedList: ");
        System.out.println(timeEnd-timeStart);
    }
    public void addLast(){
        val = (int)(alist.size()*Math.random());
        System.out.println("Insert last element");
        timeStart = System.nanoTime();
        alist.add(alist.size() - 1, val);
        timeEnd = System.nanoTime();
        System.out.print("ArrayList: ");
        System.out.println(timeEnd-timeStart);
        timeStart = System.nanoTime();
        llist.addLast(val);
        timeEnd = System.nanoTime();
        System.out.print("LinkedList: ");
        System.out.println(timeEnd-timeStart);
    }
    public void addMiddle(){
        val = (int)(alist.size()*Math.random());
        System.out.println("Insert in middle");
        timeStart = System.nanoTime();
        alist.add((alist.size()/2), val);
        timeEnd = System.nanoTime();
        System.out.print("ArrayList: ");
        System.out.println(timeEnd-timeStart);
        timeStart = System.nanoTime();
        llist.add((llist.size()/2), val);
        timeEnd = System.nanoTime();
        System.out.print("LinkedList: ");
        System.out.println(timeEnd-timeStart);
    }
    public void getElement(){
        val = (int)(alist.size() * Math.random()) - 1;
        if(val < 0){
            val = 0;
        }
        System.out.println("Get from index");
        timeStart = System.nanoTime();
        alist.get(val);
        timeEnd = System.nanoTime();
        System.out.print("ArrayList: ");
        System.out.println(timeEnd-timeStart);
        timeStart = System.nanoTime();
        llist.get(val);
        timeEnd = System.nanoTime();
        System.out.print("LinkedList: ");
        System.out.println(timeEnd-timeStart);
    }
    public void removeFirst(){
        System.out.println("Delete first element");
        timeStart = System.nanoTime();
        alist.remove(0);
        timeEnd = System.nanoTime();
        System.out.print("ArrayList: ");
        System.out.println(timeEnd-timeStart);
        timeStart = System.nanoTime();
        llist.removeFirst();
        timeEnd = System.nanoTime();
        System.out.print("LinkedList: ");
        System.out.println(timeEnd-timeStart);
    }
    public void indexOf(){
        val = (int)(alist.size() * Math.random());
        System.out.println("Find index element");
        timeStart = System.nanoTime();
        alist.indexOf(val);
        timeEnd = System.nanoTime();
        System.out.print("ArrayList: ");
        System.out.println(timeEnd-timeStart);
        timeStart = System.nanoTime();
        llist.indexOf(val);
        timeEnd = System.nanoTime();
        System.out.print("LinkedList: ");
        System.out.println(timeStart-timeEnd);
    }

}