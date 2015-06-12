package hw2.myArrayList;
/**
 * Написать собственную реализацию динамического массива MyArrayList.
 Сделать параметризацию списка, параметр E.
 Реализовать в списке интерфейсы Iterable.
 Реализовать следующие методы
 - void add(E value)
 - E get(int index)
 - boolean set(int index, E value)
 - boolean add(int index, E value)
 - int indexOf(E value)
 - int size()
 - E remove(int index)
 - Iterator<E> iterator()

 Класс теста MyArrayListTest
 */


import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

@SuppressWarnings("unchecked")
public class MyArrayList<E> implements Iterable<E> {

	private static final int DEFAULT_SIZE = 10;
	private E[] arr;
	private int size;
	
	private int status;
	
	public MyArrayList() {
		arr = (E[]) new Object[DEFAULT_SIZE];
	}
	
	private E[] increaseArr(E[] arr) {
		E[] arrTmp = (E[])new Object[arr.length*3/2+1];
		for(int i=0; i<arr.length; i++) {
			arrTmp[i] = arr[i];
		}
		return arrTmp;
	}

	public boolean add(int idx, E element) {
		if (size == 0) {
			if (idx > size)
				throw new ArrayIndexOutOfBoundsException();
			if(size==arr.length) {
				E[] arrTmp = (E[])new Object[arr.length];
				for(int i=0; i<arr.length; i++) {
					arrTmp[i] = arr[i];
				}
				arr = (E[]) new Object[(arr.length*3/2)+1];
				for(int i=1; i<arrTmp.length+1; i++) {
					arr[i] = arrTmp[i];
				}
			arr[size] = element;
			size++;
			return true;
			}
		}
		if (idx == 0) {
			if (size == arr.length) {
				E[] arrTmp = (E[])new Object[arr.length];
				for(int i=0; i<arr.length; i++) {
					arrTmp[i] = arr[i];
				}
				arr = (E[]) new Object[(arr.length*3/2)+1];
				for(int i=0; i<arrTmp.length; i++) {
					arr[i+1] = arrTmp[i];
				}
			} else {
				for(int i=size-1; i >= 0; i--) {
					arr[i+1] = arr[i];
				}
			}
			arr[idx] = element;
			size++;
			return true;
		} else {
			if(idx>size+1) {
				throw new ArrayIndexOutOfBoundsException();
			}
			if (idx == size) {
				if (size == arr.length) {
					arr = increaseArr(arr);
					arr[idx] = element;
					size++;
				} else {
					arr[idx] = element;
					size++;
					return true;
				}
			} else {
				if (size == arr.length) {
					E[] arrTmp = (E[])new Object[arr.length];
					for(int i=0; i<arr.length; i++) {
						arrTmp[i] = arr[i];
					}
					arr = (E[]) new Object[(arr.length*3/2)+1];
					for(int i=0; i<idx; i++) {
						arr[i] = arrTmp[i];
					}
					for(int i = idx; i < arrTmp.length; i++) {
						arr[i+1] = arrTmp[i];
					}
				} else {
					for(int i=size-1; i>=idx; i--) {
						arr[i+1] = arr[i];
					}
				}
				arr[idx] = element;
				size++;
				return true;
			}
		}
		status++;
		return false;
	}

	public E get(int idx) {
		if(idx >= size) {
			throw new ArrayIndexOutOfBoundsException();
		} else 
			return arr[idx];
	}

	public boolean set(int idx, E element) {
		if(idx >= size) {
			throw new ArrayIndexOutOfBoundsException();
		} else {
			E res = arr[idx];
			arr[idx] = element;
			status++;
			return true;
		}
			
	}

	public E remove(int idx) {
		if(idx >= size) {
			throw new ArrayIndexOutOfBoundsException();
		} else {
			E res = arr[idx];
			for(int i=idx; i<size-1; i++) {
				arr[i] = arr[i+1];
			}
			size--;
			status++;
			return res;
		}
	}

	public int size() {
		return size;
	}

	public Iterator<E> iterator() {
		
		return new Iterator<E>() {
			int currentIdx;
			boolean canRemove;
			int iterStatus;
			int thisStatus = MyArrayList.this.status;
			
			@Override
			public boolean hasNext() {
				return currentIdx < size;
			}
			@Override
			public E next() {
				if(!hasNext()) {
					throw new NoSuchElementException();
				}
				check();
				canRemove = true;
				currentIdx++;
				return arr[currentIdx-1];
			}
			
			public void remove() {
				if(!canRemove)
					throw new IllegalStateException();
				check();
				MyArrayList.this.remove(currentIdx-1);
				currentIdx--;
				canRemove = false;
				iterStatus++;
			}
			private void check() {
				if(thisStatus - MyArrayList.this.status + iterStatus != 0)
					throw new ConcurrentModificationException();
			}
		};
	}

	public void add(E element) {
		add(size(), element);
	}

	public int indexOf(Object bbj) {

		if (bbj == null) {
			for (int i = 0; i < size(); i++) {
				if (get(i) == null) {
					return i;
				}
			}
		} else {
			for (int i = 0; i < size(); i++) {
				if (bbj.equals(get(i))) {
					return i;
				}
			}
		}

		return -1;
	}

	protected void checkIdx(int idx) {
		if (idx < 0 || idx >= size()) {
			throw new IndexOutOfBoundsException("index : " + idx + " size : "
					+ size());
		}
	}
}
class MyArrayListTest {
	public static void main(String[] args) {

	}
}
