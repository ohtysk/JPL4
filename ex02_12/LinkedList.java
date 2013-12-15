
public class LinkedList {
	public Object value = null;
	public LinkedList next = null;

	public LinkedList() {}
	
	public LinkedList(Object value) {
		this.value = value;
	}
	
	public LinkedList(Object... values) {
		int length = values.length;
		System.out.println(length);
		if (length > 0) {
			System.out.println(values[0]);
			this.value = values[0];
			Object[] newValues = new Object[length - 1]; 
			System.arraycopy(values, 1, newValues, 0, length -1);
			this.next = new LinkedList(newValues);
		}
	}
	
	public static void main(String[] args) {
		LinkedList a = new LinkedList("hoge", "huga", "test");
		System.out.println(a);
	}
	
	public String toString() {
		String desc =  (String)value;
		if (next != null) {
			desc += " : {" + next + "}";
		}
		return  desc;
	}
}
