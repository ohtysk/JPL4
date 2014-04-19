import java.lang.reflect.Array;


public class ListedArray {
	private Object object;
	private final Object array;
	private final int arrayIndex;
	private final int elementIndex;

	ListedArray(Object object, int arrayIndex, int elementIndex, Object array) {
		this.object = object;
		this.arrayIndex = arrayIndex;
		this.elementIndex = elementIndex;
		this.array = array;
	}
	
	public void setObject(Object object) throws IllegalArgumentException, ArrayIndexOutOfBoundsException {
		if (object == null) System.out.println("object == null");
		if (array == null) System.out.println("array == null");
		if (array.getClass().isArray()) System.out.println("array is Array");
		System.out.println(object);
		Array.set(array, elementIndex, object);
		this.object = object;
	}
	
	public Object getObject() {
		return object;
	}

	public Object getArray() {
		return array;
	}
		
	public String toString() {
		String prefix = "#" + arrayIndex + "[" + elementIndex + "] "; 
		if (object == null) {
			return prefix + "null";
		}
		return prefix + object.toString();
	}
}
