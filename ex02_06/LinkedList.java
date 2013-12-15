
public class LinkedList {
	public Object value = null;
	public LinkedList next = null;
	
	public LinkedList(Object value) {
		this.value = value;
	}
	public static void main(String[] args) {
		final int VEHICLE_NUMBER = 10;
		LinkedList []vehicles = new LinkedList[VEHICLE_NUMBER];
		for (int i = 0; i < VEHICLE_NUMBER; i++) {
			Vehicle v = new Vehicle();
			v.setSpeed(i * 0.7);
			v.setDirection(i * 1.7);
			v.setOwner("owner" + i);
			vehicles[i] = new LinkedList(v);
			if (i > 0) {
				vehicles[i].next = vehicles[i - 1];
			}
		}
		LinkedList target = vehicles[VEHICLE_NUMBER - 1];
		while (target.next != null) {
			Vehicle v = (Vehicle)target.value;
			System.out.printf("%d, %f, %f, %s%n", v.getId(), v.getSpeed(), v.getDirection(), v.getOwner());
			target = target.next;
		}
	}
	
	public String toString() {
		if (next == null) {
			return "value: " + value;
		}
		return  "value: " + value + " *";
	}
}
