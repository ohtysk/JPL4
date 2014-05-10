
public class CountString {
	public static int count(String str, String target) {
		int index = 0;
		int total = 0;
		while (index < str.length()) {
			index = str.indexOf(target, index);
			if (index < 0) break;
			total++;
			index++;
		}
		return total;
	}

}
