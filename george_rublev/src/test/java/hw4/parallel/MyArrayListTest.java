package hw4.parallel;

import org.junit.Before;
import org.junit.Test;

/*

- существующего элемента
- не существующего элемента
- не существующего элемента в пустом массиве
- не существующего элемента в массиве с одним элементом
- существующего элемента в массиве с одним элементом
- элемента со значением null

 */

public class MyArrayListTest {
    MyArrayList<Integer> module;

    @Before
    public void setUp() {
        module = new MyArrayList<Integer>();
        for(int i=1000;i>0;i--){
            module.add(i);
        }

    }

    @Test
    public void testEqualsLegal() {

int index;

        System.out.println("Поиск существуещего элемента");
        index = module.parallelIndexOf(101);
        System.out.println(index);
        module.findedIdex=-1;
        System.out.println("Поиск не существуещего элемента");
        index = module.parallelIndexOf(10000);
        System.out.println(index);
        module.findedIdex=-1;
        System.out.println("не существующего элемента в пустом массиве");
        index = module.parallelIndexOf(10000);
        System.out.println(index);
        module.findedIdex=-1;
        System.out.println("не существующего элемента в массиве с одним элементом");
        index = module.parallelIndexOf(10000);
        System.out.println(index);
        module.findedIdex=-1;
        System.out.println("существующего элемента в массиве с одним элементом");
        index = module.parallelIndexOf(1);
        System.out.println(index);
        module.findedIdex=-1;
        System.out.println("элемента со значением null");
        index = module.parallelIndexOf(null);
        System.out.println(index);

    }
}
