import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;


public class ArrayBunchList<E> extends AbstractList<E> {
	private List<E> array = new ArrayList<E>(); 
	private final int size;
	
	public ArrayBunchList(E[][] arrays) {
		int s = 0;
		for (E[] a : arrays) {
			s += a.length;
			array.addAll(Arrays.asList(a));
		}			
		size = s;
	}
	
	@Override
	public int size() {
		return size;
	}

	@Override
	public E get(int index) {
		return array.get(index);
	}

	@Override
	public E set(int index, E value) {
		return array.set(index, value);
	}

	@Override
	public ListIterator<E> iterator() {
		return new ABIterator();
	}
	
	public class ABIterator implements ListIterator<E> {
		private int nextPos = 0;
		private int prevPos = -1;
		private int current;
		private boolean settable = false; 

		@Override
		public boolean hasNext() {
			return nextPos < size();
		}
		@Override
		public int nextIndex() {
			return nextPos;
		}
		@Override
		public E next() {
			if (!hasNext())
				throw new NoSuchElementException();
			current = nextPos;
			E ret = array.get(nextPos++);
			prevPos++;
			settable = true;
			return ret;
		}

		@Override
		public boolean hasPrevious() {
			return -1 < prevPos;
		}

		@Override
		public int previousIndex() {
			return prevPos;
		}

		@Override
		public E previous() {
			if (!hasPrevious())
				throw new NoSuchElementException();
			current = prevPos;
			E ret = array.get(prevPos--);
			nextPos--;
			settable = true;
			return ret;
		}

		@Override
		public void set(E value) {
			if (settable) {
				array.set(current, value);
				settable = false;
			} else {
				throw new IllegalStateException();
			}
		}
		
		@Override
		public void remove() {
			throw new UnsupportedOperationException();
		}

		@Override
		public void add(E arg0) {
			throw new UnsupportedOperationException();			
		}

	}

}
