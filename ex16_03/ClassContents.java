import java.lang.reflect.Member;
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
}
