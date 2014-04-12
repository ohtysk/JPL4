import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.util.HashSet;


public class Interpret {
	String fieldStr = "hoge";
	
	public static void main(String[] args) {
		try{
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			String input;
			input = br.readLine();
			Object object = Class.forName(input).newInstance();
			while (true) {
				loop(object, br);
				System.out.println();
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	private static void loop(Object object, BufferedReader br) throws Exception {
		Field[] fields = printFields(object);
		String input = br.readLine();
		if (input.equals("exit")) throw new Exception();
		setField(object, fields, input);
	}
	
	private static void setField(Object object, Field[] fields, String input) throws Exception {
		String[] strs = input.split(" ");
		String name = strs[0];
		String valueString = strs[1];
		for (Field field : fields) {
			if (field.getName().equals(name)) {
				setField(object, field, valueString);
				return;
			}	
		}
	}

	private static void setField(Object object, Field field, String valueString) throws Exception {
		Class<?> cls = (Class<?>)field.getGenericType();
		field.setAccessible(true);
		Object value;
		if (cls.isPrimitive()) {
			Method method = ((Class<?>)(Object) cls).getMethod("valueOf", String.class);
			value = method.invoke(null, valueString);
		} else {
			try {
				Constructor constructor = cls.getConstructor(String.class);
				value = constructor.newInstance(valueString);
			} catch (Exception e) {
				value = valueString;
			}
		}
		System.out.println(cls.toString() + " " + value.getClass() + " " + value);
		if (Modifier.isStatic(field.getModifiers())) {
			field.set(null, value);
		} else {
			field.set(object, value);
		}
	}

	private static Field[] printFields(Object object) throws Exception {
		Object[] fieldObjects = uniqueMerge(object.getClass().getFields(), object.getClass().getDeclaredFields());
		Field[] fields = new Field[fieldObjects.length];
		for (int i = 0; i < fields.length; i++)
			fields[i] = (Field)fieldObjects[i];
		System.out.println(fields.length);
		for (Field field : fields)
			printField(object, field);
		return fields;
	}

	private static void printField(Object object, Field field) throws Exception {
		field.setAccessible(true);
		Object value = field.get(object);
		System.out.println(field + " = " + value);
	}
	
	private static Object[] uniqueMerge(Object[] as, Object[] bs) {
		HashSet<Object> merged = new HashSet<Object>();
		for (Object a : as)
			merged.add(a);
		
		for (Object b : bs)
			merged.add(b);
		return merged.toArray();
	}
}
