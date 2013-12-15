
public class Vehicle {
	private double speed;
	private double direction;
	private String owner;
	private static int nextId = 0;
	private int id;
	
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
