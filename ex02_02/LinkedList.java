
public class LinkedList {
	public Object value = null;
	public LinkedList next = null;
	
	public static void main(String[] args) {
		LinkedList a = new LinkedList();
		a.value = "hoge";
		LinkedList b = new LinkedList();
		b.value = "huga";
		a.next = b;
		System.out.println(a);
		System.out.println(b);
	}
	
	public String toString() {
		if (next == null) {
			return "value: " + value;
		}
		return  "value: " + value + " *";
	}
}
