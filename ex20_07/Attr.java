import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;


public class Attr {
	private final String name;
	private Object value = null;
	private final static int NULL    = 0;
	private final static int BOOLEAN = 1;
	private final static int INT     = 2;
	private final static int DOUBLE  = 3;
	private final static int STRING  = 4;
	
	public Attr(String name) {
		this.name = name;
	}
	
	public Attr(String name, Object value) {
		this.name = name;
		this.value = value;
	}

	public Attr(String name, File file) throws IOException {
		this.name = name;
		this.value = readValue(file);
	}

	public String getName() {
		return name;
	}
	
	public Object getValue() {
		return value;
	}
	
	public Object setValue(Object newValue) {
		Object oldVal = value;
		value = newValue;
		return oldVal;
	}
	
	public String toString() {
		return name + "='" + value + "'";
	}
	
	public void writeValue(File file) throws IOException {
		OutputStream fout = new FileOutputStream(file);
		DataOutputStream out = new DataOutputStream(fout);
		if (value == null) {
			out.writeInt(NULL);
		} else if (value instanceof Boolean) {
			out.writeInt(BOOLEAN);
			out.writeInt(-1);
			out.writeBoolean((boolean)value);
		} else if (value instanceof Boolean[]) {
			out.writeInt(BOOLEAN);
			out.writeInt(((Boolean[]) value).length);
			for (Boolean b : (Boolean[])value)
				out.writeBoolean((boolean)b);
		} else if (value instanceof boolean[]) {
			out.writeInt(BOOLEAN);
			out.writeInt(((boolean[]) value).length);
			for (boolean b : (boolean[])value)
				out.writeBoolean(b);
		} else if (value instanceof Integer) {
			out.writeInt(INT);
			out.writeInt(-1);
			out.writeInt((int)value);
		} else if (value instanceof Integer[]) {
			out.writeInt(INT);
			out.writeInt(((Integer[])value).length);
			for (Integer i : (Integer[])value)
				out.writeInt(i);
		} else if (value instanceof int[]) {
			out.writeInt(INT);
			out.writeInt(((int[])value).length);
			for (int i : (int[])value)
				out.writeInt(i);
		} else if (value instanceof Double) {
			out.writeInt(DOUBLE);
			out.writeInt(-1);
			out.writeDouble((double)value);
		} else if (value instanceof Double[]) {
			out.writeInt(DOUBLE);
			out.writeInt(((Double[])value).length);
			for (Double d : (Double[])value)
				out.writeDouble(d);
		} else if (value instanceof double[]) {
			out.writeInt(DOUBLE);
			out.writeInt(((double[])value).length);
			for (double d : (double[])value)
				out.writeDouble(d);
		} else if (value instanceof String) {
			out.writeInt(STRING);
			out.writeInt(((String)value).length());
			out.writeChars((String)value);			
		}
		out.close();
	}
	
	private Object readValue(File file) throws IOException {
		InputStream fin = new FileInputStream(file);
		DataInputStream in = new DataInputStream(fin);
		int type = in.readInt();
		if (type == NULL) return null;
		int length = in.readInt();
		switch(type) {
		case BOOLEAN:
			if (length == -1) {
				return in.readBoolean();
			}
			Boolean[] bs = new Boolean[length];
			for (int i = 0; i < length; i++)
				bs[i] = in.readBoolean();
			return bs;			
		case INT:
			if (length == -1) {
				return in.readInt();
			}
			Integer[] is = new Integer[length];
			for (int i = 0; i < length; i++)
				is[i] = in.readInt();
			return is;
		case DOUBLE:
			if (length == -1) {
				return in.readDouble();
			}
			Double[] ds = new Double[length];
			for (int i = 0; i < length; i++)
				ds[i] = in.readDouble();
			return ds;
		case STRING:
			char[] cs = new char[length];
			for (int i = 0; i < length; i++) {
				cs[i] = in.readChar();
			}
			return String.valueOf(cs);
		default:
			break;
		}
		return null;
	}
}
