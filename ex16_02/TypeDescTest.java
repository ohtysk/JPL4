import static org.junit.Assert.*;

import org.junit.Test;


public class TypeDescTest extends java.lang.ClassLoader implements Runnable {

	@Test
	public void test() {
		String[] args = { "java.util.HashMap", "TypeDescTest$Inner" , "TypeDescTest$Inner$Inner2"};
		TypeDesc.main(args);
	}

	public class Inner extends java.lang.annotation.AnnotationFormatError implements Cloneable {
		public Inner(String message) {
			super(message);
			// TODO Auto-generated constructor stub
		}

		public class Inner2 {
			
		}
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}
}
