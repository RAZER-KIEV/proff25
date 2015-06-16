package hw4.parallel;
/*
 * В тестах проверить поиск:
 * - (+) существующего элемента
 * - (+) не существующего элемента
 * - (+) не существующего элемента в пустом массиве
 * - (+) не существующего элемента в массиве с одним элементом
 * - (+) существующего элемента в массиве с одним элементом
 * - (+) элемента со значением null
 *  - від себе додав перевірку на null якщо null є в масиві або якщо не має
 */

import org.junit.Before;
import org.junit.Test;

import java.util.Random;

import static org.junit.Assert.*;

public class MyArrayListTest {

    private MyArrayList<Integer> arrayList;
    private Random random;

    @Before
    public void setUp() {
        arrayList = new MyArrayList<>();
        random = new Random();
    }

    @Test
    public void parallelIndexOfLegal() {
        int maxIndex = random.nextInt(1000) + 100;
        int searchValue = random.nextInt(maxIndex);
        System.out.println("MaxIndex = " + maxIndex);
        System.out.println("Search value = " + searchValue);
        for (int i = 0; i < maxIndex; i++) {
            arrayList.add(i);

        }

        int actual = arrayList.parallelIndexOf(searchValue);
        int expected = searchValue;
        assertTrue("Error! Expected = " + expected + ", Actual = " + actual, actual == expected);
    }

    @Test
    public void parallelIndexOfIllegal() {
        int maxIndex = random.nextInt(1000) + 100;
        int searchValue = maxIndex;
        System.out.println("MaxIndex = " + maxIndex);
        System.out.println("Search value = " + searchValue);
        for (int i = 0; i < maxIndex; i++) {
            arrayList.add(i);

        }

        int actual = arrayList.parallelIndexOf(searchValue);
        int expected = -1;
        assertTrue("Error! Expected = " + expected + ", Actual = " + actual, actual == expected);
    }

    @Test
    public void parallelIndexOfIllegalInEmptyArray() {
        int actual = arrayList.parallelIndexOf(random.nextInt());
        int expected = -1;
        assertTrue("Error! Expected = " + expected + ", Actual = " + actual, actual == expected);
    }

    @Test
    public void parallelIndexOfIllegalInArrayWithOneValue() {
        arrayList.add(100);
        int actual = arrayList.parallelIndexOf(0);
        int expected = -1;
        assertTrue("Error! Expected = " + expected + ", Actual = " + actual, actual == expected);
    }

    @Test
    public void parallelIndexOfLegalInArrayWithOneValue() {
        int value = random.nextInt();
        arrayList.add(value);
        int actual = arrayList.parallelIndexOf(value);
        int expected = 0;
        assertTrue("Error! Expected = " + expected + ", Actual = " + actual, actual == expected);
    }

    @Test
    public void parallelIndexOfIllegalNull() {
        int maxIndex = random.nextInt(1000) + 100;
        for (int i = 0; i < maxIndex; i++) {
            arrayList.add(i);
        }

        int actual = arrayList.parallelIndexOf(null);
        int expected = -1;
        assertTrue("Error! Expected = " + expected + ", Actual = " + actual, actual == expected);
    }

    @Test
    public void parallelIndexOfLegalNull() {
        int maxIndex = random.nextInt(1000) + 100;
        for (int i = 0; i < maxIndex; i++) {
            arrayList.add(i);
        }
        arrayList.set(50, null);

        int actual = arrayList.parallelIndexOf(null);
        int expected = 50;
        assertTrue("Error! Expected = " + expected + ", Actual = " + actual, actual == expected);
    }

}
