public class Number {
	int value;
	boolean even;
	
	public void setValue(int value) {
		this.value = value;
		this.even = value % 2 == 0;
	}
	
	public String toString() {
		String mark;
		if (even)
			mark = " *";
		else
			mark = "";
		return value + mark; 
	}
}
