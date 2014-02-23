
public class LinkedList implements Cloneable {
	private Object value = null;
	private LinkedList next = null;

	public LinkedList() {}
	
	public LinkedList(Object value) {
		this.value = value;
	}

	public LinkedList(Object value, LinkedList next) {
		this.value = value;
		this.next = next;
	}
	
	public LinkedList(Object... values) {
		int length = values.length;
		this.value = values[0];
		Object[] newValues = new Object[length - 1]; 
		System.arraycopy(values, 1, newValues, 0, length -1);
		if (length > 1) {
			this.next = new LinkedList(newValues);
		}
	}
	
	public LinkedList clone() {
		LinkedList dstList = new LinkedList();
		LinkedList dstTarget = dstList;
		LinkedList srcTarget = this;

		while (srcTarget.next != null) {
			dstTarget.setValue(srcTarget.getValue());
			dstTarget.next = new LinkedList();
			dstTarget = dstTarget.next;
			srcTarget = srcTarget.next;
		}
		dstTarget.setValue(srcTarget.getValue());
		
		return dstList;
	}
	
	public String toString() {
		String desc =  (String)value;
		if (next != null) {
			desc += " : {" + next + "}";
		}
		return  desc;
	}
	
	public Object getValue() {
		return value;
	}
	
	public void setValue(Object value) {
		this.value = value;
	}
	
	public LinkedList getNext() {
		return next;
	}
	
	public int length() {
		if (next == null) {
			return 1;
		}
		return 1 + next.length();
	}
}
