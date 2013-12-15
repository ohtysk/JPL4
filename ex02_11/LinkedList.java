
public class LinkedList {
	public Object value = null;
	public LinkedList next = null;

	public LinkedList() {}
	
	public LinkedList(Object value) {
		this.value = value;
	}
	
	public LinkedList(Object value, LinkedList next) {
		this(value);
		this.next = next;
	}
	
	public static void main(String[] args) {
		LinkedList a = new LinkedList("hoge");
		LinkedList b = new LinkedList("huga", a);
		System.out.println(a);
		System.out.println(b);
	}
	
	public String toString() {
		String desc =  "(" + value + ")";
		if (next != null) {
			desc += " next (" + next.value + ")";
		}
		return  desc;
	}
}
