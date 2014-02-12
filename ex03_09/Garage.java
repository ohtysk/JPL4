
public class Garage implements Cloneable {
	private final int capacity;
	private Vehicle[] vehicles;
	
	Garage(int capacity) {
		this.capacity = capacity;
		vehicles = new Vehicle[capacity];
	}
	
	public final int getCapacity() {
		return capacity;
	}
	
	public void insertVehicle(int id, Vehicle v) throws Exception {
		if (id < 0 || capacity <= id) {
			throw new Exception();
		}
		
		if (vehicles[id] != null) {
			throw new Exception();
		}
		
		vehicles[id] = v;
	}
	
	public void removeVehicle(int id) throws Exception {
		if (id < 0 || capacity <= id) {
			throw new Exception();
		}
		
		if (vehicles[id] == null) {
			throw new Exception();
		}
		
		vehicles[id] = null;
	}
	
	public Vehicle[] getVehicles() {
		return vehicles;
	}
	
	public Garage clone() throws CloneNotSupportedException {
		return (Garage)super.clone();
	}
	
	public static void main(String args[]) {
		try {
			Garage g1 = new Garage(10);
			for (int i = 0; i < 10; i++) {
				g1.insertVehicle(i, new Vehicle());
			}
			
			Garage g2 = g1.clone();
			Vehicle[] v1 = g1.getVehicles();
			Vehicle[] v2 = g2.getVehicles();
			for (int i = 0; i < 10; i++) {
				System.out.printf("%d %s\n", i, v1[i] == v2[i]);
			}
		} catch (Exception e){
		}
	}
}
