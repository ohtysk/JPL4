import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class ClassContents {
	static List<String> history = new ArrayList<String>();
	
	public static void main(String[] args) {
		for (String arg : args) {
			try {
				Class<?> c = Class.forName(arg);
				System.out.println(c);
				printMembersOnce(c.getDeclaredFields());
				printMembersOnce(c.getDeclaredConstructors());
				printMembersOnce(c.getDeclaredMethods());
				printMembersOnce(c.getFields());
				printMembersOnce(c.getConstructors());
				printMembersOnce(c.getMethods());
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		}
	}

	private static void printMembersOnce(Member[] mems) {
		for (Member m : mems) {
			if (m.getDeclaringClass() == Object.class)
				continue;
			String decl = m.toString();
			if (history.contains(decl))
				continue;
			history.add(decl);
			System.out.print(" ");
			System.out.println(strip(decl, "java.lang."));
			if (m instanceof Field) {
				showAnnotatedElement((Field)m);
			} else if (m instanceof Constructor) {
				showAnnotatedElement((Constructor)m);
			} else if (m instanceof Method) {
				showAnnotatedElement((Method)m);
			}
		}
	}

	private static String strip(String decl, String remove) {
		String[] spliteds = decl.split(remove);
		String joined = "";
		for (String splited : spliteds) {
			joined += splited;
		}
		return joined;
	}
	
	private static void showAnnotatedElements(AnnotatedElement[] elements) {
		for (AnnotatedElement element : elements) {
			showAnnotatedElement(element);
		}
	}
	
	private static void showAnnotatedElement(AnnotatedElement element) {
		Annotation[] annotations = element.getAnnotations();
		for (Annotation annotaiton : annotations) {
			System.out.println("  " + annotaiton.toString());
		}
	}

}
