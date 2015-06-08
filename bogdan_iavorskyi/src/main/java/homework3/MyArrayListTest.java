package homework3;

/**
 * Created by bosyi on 07.06.15.
 */
public class MyArrayListTest {
    public static void main(String[] args) {
        MyArrayList<Integer> listOfIntegers = new MyArrayList<>();
        for (int i = 0; i < 1000; i++) {
            listOfIntegers.add(i);
        }
        int resultOfSearch = listOfIntegers.parallelIndexOf(999);
        System.out.println(resultOfSearch);
    }

}
