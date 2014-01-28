
public enum SIGNAL {
	RED(new Color("RED")),
	BLUE(new Color("BLUE")),
	YELLOW(new Color("YELLOW"));
	
	Color color;
	SIGNAL(Color color) {
		this.color = color;
	}
	
	public Color getColor() {
		return color;
	}		
}
