import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Type;


public class Declaration {
	public final int a = 2;
	public static void main(String[] args) throws ClassNotFoundException {
		Declaration.show(Class.forName("java.lang.Double"));
	}
	
	static void show(Class<?> c) {
		String className = c.getName();
		System.out.print("class " + className);
		Type superClass = c.getGenericSuperclass();
		if (superClass.getClass() != Object.class) {
			System.out.print(" extends " + superClass.toString().replace("class ", ""));
		}
		Type[] interfaces = c.getGenericInterfaces();
		if (interfaces.length > 0) {
			System.out.print(" implements");
			for (Type i: interfaces)
				System.out.print(" " + i);
		}
		
		System.out.println(" {");
		
		Field[] feilds = c.getDeclaredFields();
		showMembers(feilds, className, 4, ";");
		
		Constructor[] constructors = c.getDeclaredConstructors();
		showMembers(constructors, className, 4, " {}");

		Method[] methods = c.getDeclaredMethods();
		showMembers(methods, className, 4, " {}");

		System.out.println("}");
	}
	
	private static void showMembers(Member[] ms, String className, int indent, String surfix) {
		for (Member m : ms) {
			for (int i = 0; i < indent; i++)
				System.out.print(" ");
			System.out.println(shorten(m.toString(), className) + surfix);
		}
	}
	
	private static String shorten(String str, String className) {
		return str.replace(className + ".", "");
	}
}
