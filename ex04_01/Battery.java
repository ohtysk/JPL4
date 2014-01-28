
public class Battery implements EnergySource {
	private final double maxEnergy;
	private double currentEnergy;
	
	Battery(double maxEnergy, double currentEnergy) {
		this.maxEnergy = maxEnergy;
		this.currentEnergy = currentEnergy;
	}
	
	public boolean empty() {
		if (currentEnergy > 0) {
			return false;
		} else {
			return true;
		}
	}

	public double getMaxEnergy() {
		return maxEnergy;
	}
}
