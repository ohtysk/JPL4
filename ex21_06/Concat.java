import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.SequenceInputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.List;


public class Concat {
	public static void main(String[] args) throws IOException {
		InputStream in;
		if (args.length == 0) {
			in = System.in;
		} else {
			Enumeration<InputStream> files = new ConcatEnumeration(args);
			in = new SequenceInputStream(files);
		}
		int ch;
		while ((ch = in.read()) != -1) {
			System.out.write(ch);
		}
	}
	
	static class ConcatEnumeration implements Enumeration<InputStream> {
		private final String[] files;
		private final int size;
		private int index = 0;

		ConcatEnumeration(String[] files) {
			this.files = files;
			size = files.length;
		}
		
		@Override
		public boolean hasMoreElements() {
			return index < size;
		}
		
		@Override
		public InputStream nextElement() {
			if (!hasMoreElements()) return null;
			
			InputStream fileIn = null;
			InputStream bufIn = null;
			try {
				fileIn = new FileInputStream(files[index++]);
				bufIn = new BufferedInputStream(fileIn);				
			} catch (IOException e) {}
			return bufIn;
		}		
	}
}
