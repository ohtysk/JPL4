import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Type;


public class Parser {
	private final Interpret interpret;
	Parser(Interpret interpret) {
		this.interpret = interpret;
	}
	
	public Object parse(String input, Field field) throws Exception {
		Type param = field.getGenericType();
		return parse(input, param);
	}
	
	public Object[] parse(String input, Method method) throws Exception {
		Type[] params = method.getGenericParameterTypes();
		return parse(input, params);
	}
	
	public Object[] parse(String input, Constructor constructor) throws Exception {
		Type[] params = constructor.getGenericParameterTypes();
		return parse(input, params);
	}
	
	public Object parse(String input, Type param) throws Exception {
		if (param == boolean.class || param == Boolean.class) {
			if (input.equals("true") || input.equals("True") || input.equals("t")) {
				return true;
			} else if (input.equals("false") || input.equals("False") || input.equals("f")) {
				return false;
			} 
			throw new Exception();//‰ðŽß‚Å‚«‚È‚¢
		} else if (param == byte.class || param == Byte.class) {
	    	return Byte.valueOf(input);
		} else if (param == char.class || param == Character.class){
			if (input.length() != 1) {
				throw new Exception();//char‚¶‚á‚È‚¢
			}
			return Character.valueOf(input.charAt(0));
		} else if (param == short.class || param == Short.class) {
	    	return Short.valueOf(input);			
	    } else if (param == int.class || param == Integer.class) {
			return Integer.valueOf(input);
		} else if (param == long.class || param == Long.class) {
	    	return Long.valueOf(input);
		} else if (param == float.class || param == Float.class) {
	    	return Float.valueOf(input);
		} else if (param == double.class || param == Double.class) {
	    	return Double.valueOf(input);
		} else if (param == String.class) {
			return input;
		} else {
			System.out.println(input);
			if (input.equals("null") || input.equals("")) return null;

			int sharpPosition = input.indexOf('#');
			if (sharpPosition != 0) throw new Exception();

			int bracketStart = input.indexOf('[');

			if (bracketStart == -1) {//object
				String numberString = input.substring(1);
				int index = Integer.parseInt(numberString);
				return interpret.getObjectFromList(index);
			} else {//element of array
				int bracketEnd = input.indexOf(']');
				if (bracketEnd == -1) throw new Exception();
				String arrayString = input.substring(1, bracketStart);
				int arrayIndex = Integer.parseInt(arrayString);
				String elementString = input.substring(bracketStart + 1, bracketEnd);
				int elementIndex = Integer.parseInt(elementString);
				System.out.println(arrayIndex + " " + elementIndex);
				return interpret.getArrayElementFromList(arrayIndex, elementIndex);
			}
		}
	}

	public Object[] parse(String input, Type[] params) throws Exception {
		System.out.println(input);
		if (params.length == 0) {
			if (input.equals("")) return null;
			throw new IllegalArgumentException();			
		}

		String[] splitedInput = input.split(",");
		if (splitedInput.length != params.length) {
			throw new IllegalArgumentException();
		}
		
		Object[] objects = new Object[splitedInput.length];
		for (int i = 0; i < splitedInput.length; i++) {
			System.out.println("splitedInput=" + splitedInput[i] + " type=" + params[i]);
			objects[i] = parse(splitedInput[i], params[i]);
		}
		return objects;
	}
}
