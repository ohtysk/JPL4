import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;


public class LineNumber {
	public static void main(String[] args) throws IOException {
		for (String arg : args) {
			System.out.println("command :" + arg);
			Process child = Runtime.getRuntime().exec(arg);
			InputStream isOut = child.getInputStream();
			InputStreamReader r = new InputStreamReader(isOut);
			BufferedReader in = new BufferedReader(r);

			String line;
			int i = 0;
			while ((line = in.readLine()) != null) {
				System.out.println(i++ + " : " + line);
			}
		}
	}
}
