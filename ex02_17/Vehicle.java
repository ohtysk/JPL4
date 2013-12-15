
public class Vehicle {
	private double speed;
	private double direction;
	private String firstOwner;
	private static int nextId = 0;
	private final int id;
	public static final int TURN_LEFT = 1;
	public static final int TURN_RIGHT = 2;
	
	public static void main(String[] args) {
		System.out.printf("maxid = %d%n", getMaxId());
		for (int i = 10; i < 15; i++) {
			Vehicle a = new Vehicle("first owner " + i);
			a.setSpeed(i * 0.5);
			a.setDirection(i * 1.5);
			System.out.printf("%d, %s%n", i, a);
			a.turn(- i * 2.5);
			System.out.printf("%d, %s%n", i, a);
			a.turn(TURN_RIGHT);
			System.out.printf("%d, %s%n", i, a);
		}
		System.out.printf("maxid = %d%n", getMaxId());
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
	
	public static int getMaxId() {
		return nextId - 1;
	}
	
	public String toString() {
		return this.id + " (" + this.firstOwner + ", " + this.speed + ", " + this.direction + ")";
	}
	
	public void changeSpeed(double speed) {
		this.speed = speed;
	}
	
	public void stop() {
		this.speed = 0;
	}
	
	public void turn(double degree) {
		this.direction += degree;
	}
	
	public void turn(int direction) {
		if (direction == TURN_LEFT) {
			this.direction += -90;
		} else if (direction == TURN_RIGHT) {
			this.direction += 90;
		} else {
			turn((double)direction);
		}
	}
}
