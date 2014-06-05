import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.ref.WeakReference;


public class DataHandler {
	private WeakReference<File> lastFile;
	private WeakReference<byte[]> lastData;
	
	public byte[] readFile(File file) throws IOException {
		byte[] data;
		
		if (lastFile != null && lastFile.get() != null && file.equals(lastFile.get())) {
			data = lastData.get();
			if (data != null)
				return data;
		}
		
		data = readBytesFromFile(file);
		lastFile = new WeakReference<File>(file);
		lastData = new WeakReference<byte[]>(data);
		return data;
	}
	
	private byte[] readBytesFromFile(File file) throws IOException {
		FileInputStream fis = new FileInputStream(file);
		int length = fis.available();
		byte[] data = new byte[length];
		fis.read(data);
		return data;
	}
}
