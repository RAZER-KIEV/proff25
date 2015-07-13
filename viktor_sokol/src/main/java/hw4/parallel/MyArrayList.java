package hw4.parallel;

import java.util.List;

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
 * Created by Віктор on 6/4/2015.
 */


public class MyArrayList<T, E> implements Runnable {

    private List<T> receivedList;
    private E receivedObject;
    private String receivedDescription;

    public MyArrayList(){

    }


    public MyArrayList(List<T> sendedList, E sendedObject, String sendedDescription) {
        this.receivedList = sendedList; // з конструктора передаєм в клас
        this.receivedObject = sendedObject; // з конструктора передаєм в клас
        this.receivedDescription = sendedDescription;
    }

    public void run() {
        if (receivedList == null) {
            System.out.println("Object or List are not defined(null)" + " " + receivedDescription);
        } else if (parallelIndexOf(receivedObject) >= 0) {
            System.out.println("Object has index: " + parallelIndexOf(receivedObject) + " " + receivedDescription);
        } else if (parallelIndexOf(receivedObject) == -1) {
            System.out.println("There is no such object in the List" + " " + receivedDescription);
        }
    }

    public int parallelIndexOf(E e) {
        int index = -1;
        if (e != null) {
            for (int i = 0; i < receivedList.size(); i++) {
                if (e.equals(receivedList.get(i))) {
                    index = i;
                    break;
                }
            }
        }
        return index;
    }
}



