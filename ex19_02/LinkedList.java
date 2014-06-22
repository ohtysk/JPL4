/**
 * Linked List.
 * @author ohta
 * @version 1.1
 * @since 1.0
 */
public class LinkedList {
	/** List value */
	private Object value = null;
	/** Next list */
	private LinkedList next = null;

	/** Creates a new LinkedList with no value and no next LinkedList. */
	public LinkedList() {}
	
	/**
	 * Creates a new LinkedList with value and no next LinkedList.
	 * @param value The new value 
	 */
	public LinkedList(Object value) {
		this.value = value;
	}

	/**
	 * Creates a new LinkedList with value and next list. 
	 * @param value The new value
	 * @param next The next LinkedList
	 */
	public LinkedList(Object value, LinkedList next) {
		this.value = value;
		this.next = next;
	}

	/**
	 * Creates a new series of LinkedList with values.
	 * @param values The new values
	 */
	public LinkedList(Object... values) {
		int length = values.length;
		this.value = values[0];
		Object[] newValues = new Object[length - 1]; 
		System.arraycopy(values, 1, newValues, 0, length -1);
		if (length > 1) {
			this.next = new LinkedList(newValues);
		}
	}
	
	public static void main(String[] args) {
		LinkedList a = new LinkedList("hoge", "huga", "test");
		LinkedList b = new LinkedList("aaaa");
		LinkedList c = new LinkedList((Object[]) new String[] {"111", "222", null, "444"});
		System.out.println(a);
		System.out.println(a.length());
		System.out.println(b);
		System.out.println(b.length());
		System.out.println(c);
		System.out.println(c.length());
	}
	
	/**
	 * Returns a string of value of LinkedList.
	 */
	public String toString() {
		String desc =  (String)value;
		if (next != null) {
			desc += " : {" + next + "}";
		}
		return  desc;
	}
	
	/**
	 * Returns this value of LinkedList.
	 */
	public Object getValue() {
		return value;
	}
	
	/**
	 * Sets the value of LinkedList.
	 * @param value
	 */
	public void setValue(Object value) {
		this.value = value;
	}
	
	/**
	 * Returns the next LinkedList.
	 */
	public LinkedList getNext() {
		return next;
	}
	
	/**
	 * Returns a length of LinkedList.
	 */
	public int length() {
		if (next == null) {
			return 1;
		}
		return 1 + next.length();
	}
}
