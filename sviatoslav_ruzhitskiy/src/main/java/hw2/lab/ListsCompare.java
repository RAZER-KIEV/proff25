package hw2.lab;


import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Created by ПК on 21.05.2015.
 */
class ListsCompareTest {

    long lStart;
    long lfinish;
    //long lDelta;
    ArrayList<Integer> arrayList = new ArrayList<>(10000);
    LinkedList<Integer> linkedList = new LinkedList<>();

    public void testArrayListAddOnBiggin(){

        System.out.println("test ArrayList Add On Biggin(): ");
        long lStart = System.nanoTime();
        fillArrayListfromBigin();
        long lfinish = System.nanoTime();
        double lDelta = (lfinish - lStart)/1000000;
        System.out.println("Time for execute test <ArrayList Add On Biggin()>, ms : " + lDelta);
        //System.out.println(arrayList);

    }

    public void testLinkedListAddOnBiggin(){
        System.out.println("test LinkedList Add On Biggin(): ");

        lStart = System.nanoTime();
        fillLinkedListfromBigin();
        lfinish = System.nanoTime();
        double lDelta = (lfinish - lStart)/1000000;
        System.out.println("Time for execute test <LinkedList Add On Biggin()>, ms : " + lDelta);
        //System.out.println(linkedList);
    }


    public void testArrayListAddOnMiddle() {
        System.out.println("test ArrayList Add On Middle(): ");

        lStart = System.nanoTime();
        for (int i = 0; i < 10000; i++) {
            Integer intobj = (int) (Math.random() * 10000);

            arrayList.add(5000, intobj);
        }
        lfinish = System.nanoTime();
        double lDelta = (lfinish - lStart) / 1000000;
        System.out.println("Time for execute test <ArrayList Add On Middle()> , ms : " + lDelta);
        //System.out.println(linkedList);
    }

    public void testLinkedListAddOnMiddle(){
        System.out.println("test LinkedList Add On Middle(): ");
        lStart = System.nanoTime();
        for (int i = 0; i < 10000; i++) {
            Integer intobj = (int) (Math.random() * 10000);

            linkedList.add(5000, intobj);
        }
        lfinish = System.nanoTime();
        double lDelta = (lfinish - lStart)/1000000;
        System.out.println("Time for execute test <LinkedList Add On Middle()> , ms : " + lDelta);
        //System.out.println(linkedList);

    }

    public void testLinkedListAddOnEnd(){
        System.out.println("test LinkedList Add On End(): ");
        lStart = System.nanoTime();
        for (int i = 0; i < 10000; i++) {
            Integer intobj = (int) (Math.random() * 10000);

            linkedList.add(10000, intobj);
        }
        lfinish = System.nanoTime();
        double lDelta = (lfinish - lStart)/1000000;
        System.out.println("Time for execute test <LinkedList Add On End()>, ms : " + lDelta);
        //System.out.println(linkedList);

    }
    public void testArrayListAddOnEnd(){
        System.out.println("test ArrayList Add On End(): ");
        lStart = System.nanoTime();
        for (int i = 0; i < 10000; i++) {
            Integer intobj = (int) (Math.random() * 10000);

            arrayList.add(5000, intobj);
        }
        lfinish = System.nanoTime();
        double lDelta = (lfinish - lStart) / 1000000;
        System.out.println("Time for execute test <ArrayList Add On End()> , ms : " + lDelta);
        //System.out.println(linkedList);

    }
    public void testArrayListGetByIndex(){
        System.out.println("test ArrayList Get By Index: ");

        for (int i = 0; i < 10000; i++) {
            Integer intobj = (int) (Math.random() * 10000);

            arrayList.add(0, intobj);
        }
        lStart = System.nanoTime();
        arrayList.get(5000);
        lfinish = System.nanoTime();
        double lDelta = (lfinish - lStart) ;
        System.out.println("Time for execute test <ArrayList Get By Index()> , ns : " + lDelta);


    }

    public void testLinkedListGetByIndex(){
        System.out.println("test LinkedList Get By Index: ");
        for (int i = 0; i < 10000; i++) {
            Integer intobj = (int) (Math.random() * 10000);

            linkedList.add(0, intobj);
        }
        lStart = System.nanoTime();
        linkedList.get(5000);
        lfinish = System.nanoTime();
        double lDelta = (lfinish - lStart) ;
        System.out.println("Time for execute test <LinkedList Get By Index()> , ns : " + lDelta);



    }
    public void testArrayListDeleteFromBiggin(){
        System.out.println("test ArrayList Delete From Biggin: ");
        fillArrayListfromBigin();

        lStart = System.nanoTime();
        arrayList.remove(0);
        lfinish = System.nanoTime();
        double lDelta = (lfinish - lStart) ;
        System.out.println("Time for execute test <ArrayList Delete From Biggin> , ns : " + lDelta);




    }
    public void testLinkedListDeleteFromBiggin(){
        System.out.println("test LinkedList Delete From Biggin: ");
        fillLinkedListfromBigin();

        lStart = System.nanoTime();
        linkedList.remove(0);
        lfinish = System.nanoTime();
        double lDelta = (lfinish - lStart) ;
        System.out.println("Time for execute test <LinkedList Delete From Biggin> , ns : " + lDelta);

    }
    public void testArrayListSearchByValue(){
        System.out.println("test ArrayList Search By Value: ");
        fillArrayListfromBigin();
        int i = arrayList.get(5000);
        lStart = System.nanoTime();
        arrayList.indexOf(i);
        lfinish = System.nanoTime();
        double lDelta = (lfinish - lStart) ;
        System.out.println("Time for execute test <ArrayList Search By Value> , ns : " + lDelta);




    }
    public void testLinkedListSearchByValue(){
        System.out.println("test LinkedList Search By Value: ");
        fillLinkedListfromBigin();
        int i = arrayList.get(5000);
        lStart = System.nanoTime();
        linkedList.indexOf(i);
        lfinish = System.nanoTime();
        double lDelta = (lfinish - lStart) ;
        System.out.println("Time for execute test <ArrayList Search By Value> , ns : " + lDelta);


    }
    private void fillArrayListfromBigin() {
        for (int i = 0; i < 10000; i++) {
            Integer intobj = (int) (Math.random() * 10000);
            arrayList.add(0, intobj);

        }

    }
    private void fillLinkedListfromBigin() {
        for (int i = 0; i < 10000; i++) {
            Integer intobj = (int) (Math.random() * 10000);
            linkedList.add(0, intobj);
        }

    }
}
public class ListsCompare {
    public static void main(String[] args) {
        ListsCompareTest tests = new ListsCompareTest();

        tests.testArrayListAddOnBiggin();
        tests.testLinkedListAddOnBiggin();

        tests.testArrayListAddOnMiddle();
        tests.testLinkedListAddOnMiddle();

        tests.testArrayListAddOnEnd();
        tests.testLinkedListAddOnEnd();

        tests.testArrayListGetByIndex();
        tests.testLinkedListGetByIndex();

        tests.testArrayListDeleteFromBiggin();
        tests.testLinkedListDeleteFromBiggin();

        tests.testArrayListSearchByValue();
        tests.testLinkedListSearchByValue();

    }
}
