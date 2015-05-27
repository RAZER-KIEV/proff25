package hw2.lab;

/**
 * Created by RAZER on 27.05.2015.
 */
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
