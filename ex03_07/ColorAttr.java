
public class ColorAttr extends Attr {
	private ScreenColor myColor;
	
	public ColorAttr(String name, Object value) {
		super(name, value);
		decodeColor();
	}
	
	public ColorAttr(String name) {
		this(name, "transparent");
	}
	
	public ColorAttr(String name, ScreenColor value) {
		super(name, value.toString());
		myColor = value;
	}
	
	public Object setValue(Object newValue) {
		Object retVal = super.setValue(newValue);
		decodeColor();
		return retVal;
	}
	
	public ScreenColor serValue(ScreenColor newValue) {
		super.setValue(newValue.toString());
		ScreenColor oldValue = myColor;
		myColor = newValue;
		return oldValue;
	}
	
	public ScreenColor getColor() {
		return myColor;
	}
	
	protected void decodeColor() {
		if (getValue() == null)
			myColor = null;
		else
			myColor = new ScreenColor(getValue());
	}
	
	public int hashCode() {
		return getName().hashCode();
	}
	
	public boolean equals(Object obj) {

		return this.hashCode() == obj.hashCode();
	}
}
