import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;
import java.util.ArrayList;
import java.util.List;


public class ShowAnnotation {
	static List<AnnotatedElement> history = new ArrayList<AnnotatedElement>();
	
	public static void show(String name) {
		try {
			Class<?> cls = Class.forName(name);
			showAnnotatedElement(cls);
			showAnnotatedElements(cls.getFields());
			showAnnotatedElements(cls.getDeclaredFields());
			showAnnotatedElements(cls.getConstructors());
			showAnnotatedElements(cls.getDeclaredConstructors());
			showAnnotatedElements(cls.getMethods());
			showAnnotatedElements(cls.getDeclaredMethods());			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	private static void showAnnotatedElements(AnnotatedElement[] elements) {
		for (AnnotatedElement element : elements) {
			if (history.contains(element))
				continue;
			history.add(element);
			showAnnotatedElement(element);
		}
	}
	
	private static void showAnnotatedElement(AnnotatedElement element) {
		Annotation[] annotations = element.getAnnotations();
		if (annotations.length > 0)
			System.out.println(element.toString());
		for (Annotation annotaiton : annotations) {
			System.out.println(" " + annotaiton.toString());
		}
	}
}
