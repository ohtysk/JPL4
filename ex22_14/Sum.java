import java.util.StringTokenizer;


public class Sum {
	public static double fromString(String str) {
		StringTokenizer st = new StringTokenizer(str);
		double total = 0;
		while (st.hasMoreTokens()) {
			String s = st.nextToken();
			try {
				total += Double.parseDouble(s);
			} catch (Exception e) {}
		}
		return total;
	}
}
