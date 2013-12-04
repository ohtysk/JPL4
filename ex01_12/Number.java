public class Number {
	int value;
	boolean even;
	String string = null;
	
	public Number(int value) {
		this.setValue(value);
	}
	
	public Number(String string) {
		this.string = string;
	}
	
	public void setValue(int value) {
		this.value = value;
		this.even = value % 2 == 0;
	}
	
	public String toString() {
		if (string == null) {
			String mark;
			if (even)
				mark = " *";
			else
				mark = "";
		    string = value + mark;
		}
		return string;
	}
}
