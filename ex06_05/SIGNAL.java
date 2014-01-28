
public enum SIGNAL {
	RED(new Color("RED")) {
		public Color getColor() {
			return color;
		}
	} ,
	BLUE(new Color("BLUE")) {
		public Color getColor() {
			return color;
		}
	},
	YELLOW(new Color("YELLOW")) {
		public Color getColor() {
			return color;
		}
	};
	
	Color color;
	SIGNAL(Color color) {
		this.color = color;
	}
	
	public abstract Color getColor();		
}
