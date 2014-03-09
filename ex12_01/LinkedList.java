
public class LinkedList<T> {
	private T value = null;
	private LinkedList<T> next = null;

	public LinkedList() {}
	
	public LinkedList(T value) {
		this.value = value;
	}

	public LinkedList(T value, LinkedList<T> next) {
		this.value = value;
		this.next = next;
	}
	
	public LinkedList(T ... values) {
		int length = values.length;
		this.value = values[0];
		LinkedList<T> currentList = this;
		for (int i = 1; i < length; i++) {		
			LinkedList<T> nextList = new LinkedList<T>(values[i]);
			currentList.next = nextList;
			currentList = currentList.next;
		}
	}

	public LinkedList<T> find(T target) throws ObjectNotFoundException {
		for (LinkedList<T> list = this; list != null; list = list.next) {
			if (list.getValue().equals(target)) {
				return list;
			}
		}
		throw new ObjectNotFoundException((Object)target, this);			
	}
	
	public String toString() {
		String desc =  value.toString();
		if (next != null) {
			desc += " : " + next;
		}
		return  desc;
	}
	
	public Object getValue() {
		return value;
	}
	
	public void setValue(T value) {
		this.value = value;
	}
	
	public LinkedList<T> getNext() {
		return next;
	}
	
	public int length() {
		if (next == null) {
			return 1;
		}
		return 1 + next.length();
	}
}
