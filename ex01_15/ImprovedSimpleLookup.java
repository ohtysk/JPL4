
public class ImprovedSimpleLookup implements ImprovedLookup {
	private final int INIT_LENGTH = 10; 
	private int tableLength = INIT_LENGTH;
	private int nextIndex = 0;
	private String[] names = new String[INIT_LENGTH];
	private Object[] values = new Object[INIT_LENGTH];

	private Integer findIndex(String name) {
		for (int i = 0; i < nextIndex; i++) {
			if (names[i].equals(name)) {
				return i;
			}
		}
		return null;
	}

	private void resizeTable(int length) {
		nextIndex = Math.min(nextIndex, length - 1);
		
		String[] tmpNames = names;
		names = new String[length];
		for (int i = 0; i < nextIndex; i++) {
			names[i] = tmpNames[i];
		}
		
		Object[] tmpValues = values;
		values = new Object[length];
		for (int i = 0; i < nextIndex; i++) {
			values[i] = tmpValues[i];
		}
		
		tableLength = length;
	}
	
	@Override
	public Object find(String name) {
		// TODO Auto-generated method stub
		for (int i = 0; i < nextIndex - 1; i++) {
			if (names[i].equals(name)) {
				return values[i];
			}
		}
		return null;
	}

	@Override
	public Object add(String name, Object value) {
		// TODO Auto-generated method stub
		if (nextIndex == tableLength) {
			// TODO make table long
			resizeTable(2 * tableLength);
		}
		
		for (int i = 0; i < nextIndex; i++) {
			if (names[i].equals(name)) {
				return null;
			}
		}
		names[nextIndex] = name;
		values[nextIndex] = value;
		nextIndex++;
		return value;
	}

	@Override
	public Object remove(String name) {
		// TODO Auto-generated method stub
		Integer target = findIndex(name);
		if (target != null) {
			for(int i = target; i < nextIndex - 1; i++) {
				names[i] = names[i + 1];
				values[i] = values[i + 1];
			}
			nextIndex--;
			return values[target];
		}
		return null;
	}

	public void print() {
		System.out.println("tableLength: " + tableLength);
		System.out.println("nextIndex: " + nextIndex);
		for (int i = 0; i < nextIndex; i++) {
			System.out.println(i + ": " + names[i] + ": " + values[i]);
		}
	}
}
