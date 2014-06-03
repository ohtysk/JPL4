
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;


public class LineSorter {
	private final SortedSet<String> set = new TreeSet<String>(new StringComparator());
	private final LineFilterReader lfr;

	LineSorter(String fileName) throws IOException {
		lfr = new LineFilterReader(new FileReader(new File(fileName)));
		int c;
		int len = 256;
		char[] cbuf = new char[len];
		while ((c = lfr.read(cbuf, 0, len)) != -1) {
			String str = new String(cbuf).substring(0, c - 1);
			set.add(str);
		}
	}
	public List<String> getList() {
		return new ArrayList(set);
	}
	
	class StringComparator implements Comparator<String> {
		@Override
		public int compare(String arg0, String arg1) {
			return arg0.compareTo(arg1);
		}	
	}
}