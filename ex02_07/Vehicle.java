
public class Vehicle {
	private double speed;
	private double direction;
	private String firstOwner;
	private static int nextId = 0;
	private final int id;
	
	public static void main(String[] args) {
		for (int i = 10; i < 15; i++) {
			Vehicle a = new Vehicle("first owner " + i);
			a.setSpeed(i * 0.5);
			a.setDirection(i * 1.5);
			System.out.printf("%d, %d, %f, %f, %s%n", i, a.getId(), a.getSpeed(), a.getDirection(), a.getFirstOwner());
		}
	}
	public Vehicle() {
		id = nextId;
		nextId++;
	}
	
	public Vehicle(String firstOwner) {
		this();
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
	
	public void setFirstOwner(String firstOwner) {
		this.firstOwner = firstOwner;
	}
	
	public String getFirstOwner() {
		return firstOwner;
	}
	
	public int getId() {
		return id;
	}
}
