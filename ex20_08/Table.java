import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.LineNumberReader;
import java.io.StreamTokenizer;
import java.util.ArrayList;
import java.util.List;


public class Table {
	public static void make(File in, File out) throws IOException {
		FileReader fr = new FileReader(in);	
		LineNumberReader lnr = new LineNumberReader(fr);
		lnr.setLineNumber(1);
		int lastLine = 0;
		int c;
		List<Integer> numbers = new ArrayList<Integer>();
		while ((c = lnr.read()) != -1) {
			if (c == '\n' || c == '\r') continue;
			int line = lnr.getLineNumber();
			if (line != lastLine) {
				if (c == '%' && lnr.read() == '%') {
					numbers.add(line);
				}
			}
			lastLine = line;
		}
		FileWriter fw = new FileWriter(out);
		for (Integer i : numbers)
			fw.write(i + "\n");
		fw.close();
	}
	public static void show(File in, File table) throws IOException {
		FileReader fr = new FileReader(in);
		LineNumberReader lnr = new LineNumberReader(fr);
		lnr.setLineNumber(1);
		int c;
		List<Integer> numbers = new ArrayList<Integer>();
		FileReader tfr = new FileReader(table);
		StreamTokenizer st = new StreamTokenizer(tfr);
		while(st.nextToken() != StreamTokenizer.TT_EOF)
			if (st.ttype == StreamTokenizer.TT_NUMBER)
				numbers.add((int)st.nval);
		
		int index = (int)Math.floor(Math.random() * numbers.size());
		int min = numbers.get(index);
		int max = numbers.size() == index + 1 ? Integer.MAX_VALUE : numbers.get(index + 1);
		int last = 0;
		while ((c = lnr.read()) != -1) {
			int line = lnr.getLineNumber();
			if (min <= last && line < max) {
				System.out.print((char)c);
			}
			last = line;
		}
	}
}
