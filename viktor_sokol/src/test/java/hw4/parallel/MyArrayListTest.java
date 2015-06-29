package hw4.parallel;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.Assert.*;

/*Реализовать в классе MyArrayList метод
public int parallelIndexOf(E e), выполняющий линейный многопоточный поиск в списке.
        В тестах проверить поиск:
        - существующего элемента
        - не существующего элемента
        - не существующего элемента в пустом массиве
        - не существующего элемента в массиве с одним элементом
        - существующего элемента в массиве с одним элементом
        - элемента со значением null

        Класс задания:
        MyArrayList

        Класс теста:
        hw4.parallel.MyArrayListTest*/

/**
 * Created by Віктор on 6/7/2015.
 */


public class MyArrayListTest {
    @Test
    public void testParallelIndexOf1() throws Exception {
        String descriptionCase1 = "thread1----не существующего элемента";
        List<String> createMyList = new ArrayList<String>();
        createMyList.add("V");
        createMyList.add("I");
        createMyList.add("C");
        createMyList.add("T");
        createMyList.add("O");
        createMyList.add("R");
        String str1 = "D";

        MyArrayList list = new MyArrayList(createMyList, str1, descriptionCase1);
        int n = list.parallelIndexOf(str1);
        assertEquals(-1, n);
    }

    @Test
    public void testParallelIndexOf2() throws Exception {
        String descriptionCase2 = "thread2----существующего элемента";
        List<String> createMyList = new ArrayList<String>();
        createMyList.add("Vi");
        createMyList.add("In");
        createMyList.add("Co");
        createMyList.add("Tu");
        createMyList.add("Op");
        createMyList.add("Ri");
        String str1 = "Op";

        MyArrayList list = new MyArrayList(createMyList, str1, descriptionCase2);
        int n = list.parallelIndexOf(str1);
        assertEquals(4, n);
    }

    @Test
    public void testParallelIndexOf3() throws Exception {
        String descriptionCase3 = "thread3----элемента со значением null";
        List<String> createMyList = new ArrayList<String>();
        createMyList.add("Vi");
        createMyList.add("In");
        createMyList.add("Co");
        createMyList.add("Tu");
        createMyList.add("Op");
        createMyList.add("Ri");

        MyArrayList list = new MyArrayList(createMyList, null, descriptionCase3);
        int n = list.parallelIndexOf(null);
        assertEquals(-1, n);
    }

    @Test
    public void testParallelIndexOf4() throws Exception {
        String descriptionCase4 = "thread4----не существующего элемента в пустом массиве";
        List<String> createMyList = new ArrayList<String>();
        int value = 5;

        MyArrayList list = new MyArrayList(createMyList, value, descriptionCase4);
        int n = list.parallelIndexOf(value);
        assertEquals(-1, n);
    }

    @Test
    public void testParallelIndexOf5() throws Exception {

        String descriptionCase5 = "thread5----не существующего элемента в массиве с одним элементом";
        List<Boolean> createMyList = new ArrayList<Boolean>();
        createMyList.add(true);
        boolean value = false;

        MyArrayList list = new MyArrayList(createMyList, value, descriptionCase5);
        int n = list.parallelIndexOf(value);
        assertEquals(-1, n);
    }
}
