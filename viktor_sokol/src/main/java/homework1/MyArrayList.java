package homework1;

import java.util.Iterator;

/**
 * Created by Віктор on 5/24/2015.
 * <p>
 * Написать собственную реализацию динамического массива MyArrayList.
 * Сделать параметризацию списка, параметр E.
 * Реализовать в списке интерфейсы Iterable.
 * Реализовать следующие методы
 * - void add(E value)
 * - E get(int index)
 * - boolean set(int index, E value)
 * - boolean add(int index, E value)
 * - int indexOf(E value)
 * - int size()
 * - E remove(int index)
 * - Iterator<E> iterator()
 */
public class MyArrayList<E> implements Iterable<E> {

    private E[] elements;
    private int index;
    private int size;
    private static final int dEFAULT_CAPACITY = 16;

    //Конструктор за замовчанням
    public MyArrayList() {
        elements = (E[]) new Object[dEFAULT_CAPACITY];
    }

    //додавання значення в кынець
    public void add(E value) {
        if (index == elements.length) {
            growArray();
        }
        elements[index] = value;
        index++;
        size++;
    }

    //збыльшення масиву
    private void growArray() {
        E[] newArray = (E[]) new Integer[elements.length * 2];
        System.arraycopy(elements, 0, newArray, 0, index - 1);
        elements = newArray;
    }

    //отримати значення по індексу
    public E get(int index) {
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size " + index);
        }
        return (E) elements[index];
    }

    //перевірка індекса
    private void checkIndex(int index) {
        if (index < 0 || index >= this.index) {
            throw new IllegalArgumentException();
        }
    }

    // заміна значення по вказаному індексу
    public boolean set(int index, E value) {
        if (index > size || index < 0) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size " + size);
        }
        if (index < size) {
            E oldValue = elements[index];
            elements[index] = value;
            return true;
        }
        return false;
    }

    //метод повертає розмір масиву
    public int size() {
        boolean empty;
        if (empty = true) {
            System.out.println("0");
        } else {

        }
        return size;
    }

    // додавання значення по індексу із зміщенням всього масиву
    public boolean add(int index, E value) {
        if (index > size || index < 0) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size " + size);
        }
        System.arraycopy(elements, index, elements, index + 1, size - index);
        elements[index] = value;
        size++;
        return true;
    }

    // пошук індексу по значенню елемента
    public int indexOf(E value) {
        if (value == null) {
            for (int i = 0; i < size; i++) {
                if (elements[i] == null) {
                    return i;
                }
            }
        } else {
            for (int i = 0; i < size; i++) {
                if (value.equals(elements[i])) {
                    return i;
                }
            }
        }
        return -1;
    }

    //видалення по індексу
    public E remove(int index) {
        if (index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size " + size);
        }
        E oldValue = elements[index];
        int value = size - index - 1;
        if (value > 0) {
            System.arraycopy(elements, index + 1, elements, index, value);
        }
        elements[--size] = null;
        return oldValue;
    }

    // ітератор
    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            @Override
            public boolean hasNext() {
                if (size == elements.length) {
                    return false;
                }
                return true;
            }

            @Override
            public E next() {
                return null;
            }
        };
    }

    public class MyArrayListTest {

    }
}

