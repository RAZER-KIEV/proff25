package HomeWork3;



import java.util.ArrayList;

/**
 * Created by Sveta on 6/3/2015.
 * Реализовать в классе MyArrayList метод
 public int parallelIndexOf(E e), выполняющий линейный многопоточный поиск в списке.
 В тестах проверить поиск:
 - существующего элемента
 - не существующего элемента
 - не существующего элемента в пустом массиве
 - не существующего элемента в массиве с одним элементом
 - существующего элемента в массиве с одним элементом
 - элемента со значением null

 Класс задания:
 hw4.parallel.MyArrayList

 Класс теста:
 hw4.parallel.MyArrayListTest
 */
public class MyArrayList<E> extends ArrayList<E> {
    public int parallelIndexOf(E element)  {
        if(element == null) {
            return -1;
        }

        class MyRunnable implements Runnable {
            private boolean odd;
            private Integer result;
            private boolean found;

            public MyRunnable(boolean Odd){
                odd = Odd;
            }

            public Integer getResult(){
                return result;
            }

            @Override
            public void run() {
                int start = 0;
                if (!odd){
                    start = 1;
                }

                for (int i = start; i < size(); i+=2) {
                    if(found){
                        return;
                    }

                    if (element.equals(get(i))){
                        result = i;
                    }
                }
            }
        }

        MyRunnable myRunnable = new MyRunnable(false);
        MyRunnable myRunnable1 = new MyRunnable(true);
        Thread thread1 = new Thread(myRunnable);
        Thread thread2 = new Thread(myRunnable1);
        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        if (myRunnable.getResult() != null) {
            return myRunnable.getResult();
        } else
            if (myRunnable1.getResult() != null) {
                return myRunnable1.getResult();
        } else {
                return -1;
            }
    }
}
class MyArrayListTest {

public static void main(String[] args) {
    MyArrayList<Integer> list = new MyArrayList<>();
    MyArrayList<Integer> list1 = new MyArrayList<>();
    list.add(6);
    list.add(4);
    list.add(3);
    list.add(5);
    list.add(7);
    list.add(6);

    System.out.println("2: " + list.parallelIndexOf(3));
    System.out.println("-1: " + list.parallelIndexOf(67));
    System.out.println("-1: " + list1.parallelIndexOf(19));

    list1.add(15);
    System.out.println("-1: " + list1.parallelIndexOf(99));
    System.out.println("0: " + list1.parallelIndexOf(15));
    System.out.println("-1: " + list1.parallelIndexOf(null));

}


}