package homework3;

/**
 * Created by jax on 05.06.15.
 */
public class MyArrayListTest {
    public static void main(String[] args) {
        MyArrayList<Integer>list = new MyArrayList<>();
        for(int i=0;i<10;i++){
            list.add(i);
        }
        System.out.println(list);
    }
}
