
@SuppressWarnings("serial")
public class ObjectNotFoundException extends Exception {
	private final Object value;
	private final LinkedList<?> list;

	public ObjectNotFoundException(Object value, LinkedList<?> list) {
		super();
		this.value = value;
		this.list = list;
		System.out.println(this);
	}
	
	public Object getObject() {
		return value;
	}

	public Object getList() {
		return list;
	}

	public String toString() {
		return "Not found " + value +  " in " + list;
	}
}
