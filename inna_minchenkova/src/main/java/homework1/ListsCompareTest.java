package homework1;

import javax.xml.bind.SchemaOutputResolver;
import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Created by Jax on 29.05.2015.
 */
public class ListsCompareTest {
    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        LinkedList<Integer> linkedList = new LinkedList<>();
        ListsCompare test = new ListsCompare();
        test.run(arrayList);
        test.run(linkedList);
        System.out.println("ArrayList size : " + arrayList.size());
        System.out.println("LinkedList size : " + linkedList.size());

        System.out.println("Добавление елементов в начало ArrayList");

        System.out.println("Добавление елементов в начало LinkedList");
        test.addToFirst(linkedList);

        System.out.println("ArrayList size : " + arrayList.size());
        System.out.println("LinkedList size : "+ linkedList.size());

        System.out.println("Добавление елементов по индекус ArrayList");
        test.addToIndex(arrayList, 25);

        System.out.println("Добавление елементов по индексу LinkedList");
        test.addToIndex(linkedList, 25);

        System.out.println("Добавление елементов в конец ArrayList");
        test.addToLast(arrayList);

        System.out.println("Добавление елементов в конец LinkedList");
        test.addToLast(linkedList);

        System.out.println("Удаление из начала ArrayList");
        test.remove(arrayList);
        System.out.println("Удаление из начала LinkedList");
        test.remove(linkedList);

        System.out.println("Поиск елемента по значению в ArrayList");
        System.out.println("[ "+ arrayList.indexOf(1000)+" ]");
        System.out.println("Поиск елемента по значению в LinkedList");
        System.out.println("[ " +linkedList.indexOf(1000)+" ]");

        System.out.println("Размер Arraylist");
        System.out.println(arrayList.size());
        System.out.println("Размер Linkedlist");
        System.out.println(linkedList.size());
    }
}

