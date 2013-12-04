
public class Point {
	public double x, y;

	public double distance(Point that) {
		double xdiff = x - that.x;
		double ydiff = y - that.y;
		return Math.sqrt(xdiff * xdiff + ydiff * ydiff);
	}
	
	public void clear() {
		this.x = 0.0;
		this.y = 0.0;
	}
	
	public void move(double x, double y) {
		this.x = x;
		this.y = y;
	}
	
	public void move(Point that) {
		this.x = that.x;
		this.y = that.y;
	}
	
	public void showString() {
		System.out.println("(" + this.x + ", " + this.y + ")");
	}
	public static void main(String[] args) {
		Point origin = new Point();
		origin.x = 5.5;
		origin.y = 34;		
		origin.showString();
		
		Point target = new Point();
		target.move(32.2, 223);
		target.showString();
		
		double dist = origin.distance(target);
		System.out.println("distance = " + dist);
		
		origin.move(target);
		origin.showString();
	}
}
