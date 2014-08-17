import java.util.ArrayList;
import java.util.EmptyStackException;


public class ArrayStack<E> {
	private ArrayList<E> list = new ArrayList<E>();
	
	public boolean empty() {
		return list.isEmpty();
	}
	
	E peek() {
		if (empty()) throw new EmptyStackException();
		return list.get(list.size() - 1);
	}
	
	E pop() {
		if (empty()) throw new EmptyStackException();
		return list.remove(list.size() - 1);
	}
	
	E push(E item) {
		list.add(item);
		return item;
	}
	
	int search(E item) {
		for (int i = 0; i < list.size(); i++) {
			if (list.get(list.size() - i - 1).equals(item))
				return i + 1;
		}
		return -1;
	}
}
