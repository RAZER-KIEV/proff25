package HomeWork;

/**
 * Created by Sveta on 5/21/2015.
 * * Created by Sveta on 5/21/2015.
 *

 Реализовать следующие методы
 - void add(E value)
 - E get(int index)
 - boolean set(int index, E value)
 - boolean add(int index, E value)
 - int indexOf(E value)
 - int size()
 - E remove(int index)

 */
public interface MyList<E> {
    public void add(E value);
    public E get(int index);
    public boolean set(int index, E value);
    public boolean add(int index, E value);
    public int indexOf(E value);
    public int size();
    public E remove(int index);

}
