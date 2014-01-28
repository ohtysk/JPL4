package ex03_01;

public class PssengerVehicle extends Vehicle {
	private final int seatNumber;
	private int currentNumberPassenger = 0;
	
	PssengerVehicle(int seatNumber)  {
		this.seatNumber = seatNumber;
	}

	PssengerVehicle(String firstOwner, int seatNumber)  {
		super(firstOwner);
		this.seatNumber = seatNumber;
	}

	public int getCurrentNumberPassenger() {
		return currentNumberPassenger;
	}
	public int getSeatNumber() {
		return seatNumber;
	}
	
	public static void main(String argv[]) {
		PssengerVehicle pv1 = new PssengerVehicle(5);
		PssengerVehicle pv2 = new PssengerVehicle("watashidesu", 6);
		PssengerVehicle pv3 = new PssengerVehicle(5);
		
		System.out.println(pv1);
		System.out.println(pv2);
		System.out.println(pv3);
	}
	
	public String toString() {
		return super.toString() + "maxseat=" + seatNumber + ":currentNumber=" + currentNumberPassenger;
	}
}
