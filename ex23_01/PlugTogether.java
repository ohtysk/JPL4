import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;


public class PlugTogether {
	static void plugTogether(final InputStream is, final OutputStream os) {
		plugTogether(os, is);
	}
	
	static void plugTogether(final OutputStream os, final InputStream is) {
		new Thread() {
			public void run() {
				byte[] buf = new byte[256];
				int length = 0;
				try {
					while((length = is.read(buf)) != -1) {
						os.write(buf, 0, length);
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}.start();
	}
}
