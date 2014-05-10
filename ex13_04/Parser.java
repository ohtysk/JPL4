import java.util.ArrayList;


public class Parser {
	public ArrayList<Object> array = new ArrayList<Object>();
	
	public void parse(String input) throws Exception {
		String[] lines = input.split("\n");

		for (String line : lines) {
			String[] typeValue = line.split(" ");
			String typeString = typeValue[0];
			String valueString = typeValue[1];
			addArray(typeString, valueString);
		}
	}
	
	public void showArray() {
		for (Object object : array) {
			System.out.println(object.getClass().getName() + " " + object);
		}
	}
	
	private void addArray(String typeString, String valueString) throws Exception {
		switch (typeString) {
		case "Boolean":
			array.add(Boolean.valueOf(valueString));
			break;
		case "Character":
			array.add(valueString.toCharArray()[0]);
			break;
		case "String":
			array.add(valueString);
			break;
		case "Byte":
			array.add(Byte.valueOf(valueString));
			break;
		case "Short":
			array.add(Short.valueOf(valueString));
			break;
		case "Integer":
			array.add(Integer.valueOf(valueString));
			break;
		case "Long":
			array.add(Long.valueOf(valueString));
			break;
		case "Float":
			array.add(Float.valueOf(valueString));
			break;
		case "Double":
			array.add(Double.valueOf(valueString));
			break;
		default:
			throw new Exception();
		}		
	}
}
