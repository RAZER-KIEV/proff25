package hw4.parallel;

/**
 * Created by bosyi on 07.06.15.
 */
public class MyArrayListStarter {
    public static void main(String[] args) {
        MyArrayList<Integer> arrayList = new MyArrayList<>();
        for (int i = 0; i < 10000; i++) {
            arrayList.add(i);
        }
//        System.out.println(arrayList.parallelIndexOf(55));
//        System.out.println(arrayList.parallelIndexOf(-111));
        System.out.println(arrayList.parallelIndexOf(5001));
    }
}
