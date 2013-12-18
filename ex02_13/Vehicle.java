
public class Vehicle {
	private double speed;
	private double direction;
	private final String firstOwner;
	private static int nextId = 0;
	private final int id;
	
	public static void main(String[] args) {
		System.out.printf("maxid = %d%n", getMaxId());
		for (int i = 10; i < 15; i++) {
			Vehicle a = new Vehicle("first owner " + i);
			a.setSpeed(i * 0.5);
			a.setDirection(i * 1.5);
			System.out.printf("%d, %s%n", i, a);
		}
		System.out.printf("maxid = %d%n", getMaxId());
	}
	
	public Vehicle(String firstOwner) {
		id = nextId;
		nextId++;
		this.firstOwner = firstOwner;
	}
	
	public void setSpeed(double speed) {
		this.speed = speed;
	}
	
	public double getSpeed() {
		return speed;
	}
	
	public void setDirection(double direction) {
		this.direction = direction;
	}
	
	public double getDirection() {
		return direction;
	}
	
	public String getFirstOwner() {
		return firstOwner;
	}
	
	public int getId() {
		return id;
	}
	
	public static int getMaxId() {
		return nextId - 1;
	}
	
	public String toString() {
		return this.id + " (" + this.firstOwner + ", " + this.speed + ", " + this.direction + ")";
	}
}
