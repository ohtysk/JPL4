
public class LinkedList implements LinkedListInterface {
	private Object value = null;
	private LinkedListInterface next = null;

	@Override
	public void setValue(Object value) {
		// TODO Auto-generated method stub
		this.value = value;
	}

	@Override
	public Object getValue() {
		// TODO Auto-generated method stub
		return value;
	}

	@Override
	public void setNext(LinkedListInterface next) {
		// TODO Auto-generated method stub
		this.next = next;
	}

	@Override
	public LinkedListInterface getNext() {
		// TODO Auto-generated method stub
		return next;
	}
}
