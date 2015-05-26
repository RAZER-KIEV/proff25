package hw1;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Created by IEvgen Boldyr on 25.05.15.
 * Project: prof25
 */

public class ArrayListVsLinkedList {

    /* Сравнить производительность ArrayList и LinkedList:
     * -добавить в начало 10 тис эл
     * -добавить в конец
     * -добавить в середину
     * -получение элемента по индексу
     * -удаление элемента из начала
     * -поиск элемента по значению
     */

    public static void main(String[] args) {
        ArrayList<Integer> array = new ArrayList<Integer>();
        long arrayTimeResult = 0;
        LinkedList<Integer> linked = new LinkedList<Integer>();
        long linkedTimeResult = 0;
        long start = 0;

        System.out.print("Заполнение листов (10_000_000 эл.) - ");
        start = System.currentTimeMillis();
        for (int i = 0; i < 10_000_000; i++) {
            array.add(new Integer((int) (Math.random() * 100000)));
        }
        arrayTimeResult = System.currentTimeMillis() - start;

        start = System.currentTimeMillis();
        for (int i = 0; i < 10_000_000; i++) {
            linked.add(new Integer((int) (Math.random() * 100000)));
        }
        linkedTimeResult = System.currentTimeMillis() - start;
        choseWinner(arrayTimeResult, linkedTimeResult);

        System.out.print("Добавление в начало - ");
        start = System.currentTimeMillis();
        array.add(0, new Integer((int) (Math.random() * 100)));
        arrayTimeResult = System.currentTimeMillis() - start;

        start = System.currentTimeMillis();
        linked.add(0, new Integer((int) (Math.random() * 100)));
        linkedTimeResult = System.currentTimeMillis() - start;
        choseWinner(arrayTimeResult, linkedTimeResult);

        System.out.print("Добавление в конец - ");
        start = System.currentTimeMillis();
        array.add(array.size() - 1, new Integer((int) (Math.random() * 100)));
        arrayTimeResult = System.currentTimeMillis() - start;

        start = System.currentTimeMillis();
        linked.add(linked.size() - 1, new Integer((int) (Math.random() * 100)));
        linkedTimeResult = System.currentTimeMillis() - start;
        choseWinner(arrayTimeResult, linkedTimeResult);

        System.out.print("Добавление в середину - ");
        start = System.currentTimeMillis();
        array.add(array.size() / 2, new Integer((int) (Math.random() * 100)));
        arrayTimeResult = System.currentTimeMillis() - start;

        start = System.currentTimeMillis();
        linked.add(linked.size() / 2, new Integer((int) (Math.random() * 100)));
        linkedTimeResult = System.currentTimeMillis() - start;
        choseWinner(arrayTimeResult, linkedTimeResult);

        System.out.print("Получение элементов по индексу - ");
        start = System.currentTimeMillis();
        array.get(array.size() / 2);
        arrayTimeResult = System.currentTimeMillis() - start;

        start = System.currentTimeMillis();
        linked.get(linked.size() / 2);
        linkedTimeResult = System.currentTimeMillis() - start;
        choseWinner(arrayTimeResult, linkedTimeResult);

        System.out.print("Удаление элемента из начала - ");
        start = System.currentTimeMillis();
        array.remove(0);
        arrayTimeResult = System.currentTimeMillis() - start;

        start = System.currentTimeMillis();
        linked.remove(0);
        linkedTimeResult = System.currentTimeMillis() - start;
        choseWinner(arrayTimeResult, linkedTimeResult);

        System.out.print("Поиск элемента по значению - ");
        start = System.currentTimeMillis();
        array.indexOf(56789);
        arrayTimeResult = System.currentTimeMillis() - start;

        start = System.currentTimeMillis();
        linked.indexOf(98765);
        linkedTimeResult = System.currentTimeMillis() - start;
        choseWinner(arrayTimeResult, linkedTimeResult);
    }

    private static void choseWinner(Long arrayTimeResult, Long linkedTimeResult) {
        if (arrayTimeResult < linkedTimeResult) {
            System.out.println("ArrayList - Win!");
        } else {
            System.out.println("LinkedList - Win!");
        }
    }
}
