
public class Vehicle {
	private double speed;
	private double direction;
	private String owner;
	private static int nextId = 0;
	private final int id;
	
	public static void main(String[] args) {
		for (int i = 10; i < 15; i++) {
			Vehicle a = new Vehicle();
			a.setSpeed(i * 0.5);
			a.setDirection(i * 1.5);
			a.setOwner("owner" + i);
			System.out.printf("%d, %d, %f, %f, %s%n", i, a.getId(), a.getSpeed(), a.getDirection(), a.getOwner());
		}
	}
	public Vehicle() {
		id = nextId;
		nextId++;
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
	
	public void setOwner(String owner) {
		this.owner = owner;
	}
	
	public String getOwner() {
		return owner;
	}
	
	public int getId() {
		return id;
	}
}
