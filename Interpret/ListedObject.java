
public class ListedObject {
	private static int nextIndex = 0;
	private final Object object;
	private final int index;
	
	ListedObject(Object object) {
		index = nextIndex++;
		this.object = object;
	}
	
	public String toString() {
		return "#" + index + " " + object;
	}
	
	public Object getOject() {
		return object;
	}
	
	public int getIndex() {
		return index;
	}
}
