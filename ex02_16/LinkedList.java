
public class LinkedList {
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
