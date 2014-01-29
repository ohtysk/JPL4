


public class PassengerVehicle extends Vehicle {
	private final int seatNumber;
	private int currentNumberPassenger = 0;
	
	PassengerVehicle(int seatNumber)  {
		this.seatNumber = seatNumber;
	}

	PassengerVehicle(String firstOwner, int seatNumber)  {
		super(firstOwner);
		this.seatNumber = seatNumber;
	}

	public final int getCurrentNumberPassenger() {
		return currentNumberPassenger;
	}
	public final int getSeatNumber() {
		return seatNumber;
	}
	
	public static void main(String argv[]) {
		PassengerVehicle pv1 = new PassengerVehicle(5);
		PassengerVehicle pv2 = new PassengerVehicle("watashidesu", 6);
		PassengerVehicle pv3 = new PassengerVehicle(5);
		
		System.out.println(pv1);
		System.out.println(pv2);
		System.out.println(pv3);
	}
	
	public String toString() {
		return super.toString() + "maxseat=" + seatNumber + ":currentNumber=" + currentNumberPassenger;
	}
}
