
public class GasTank extends EnergySource {
	private final double maxGas;
	private double currentGas;
	
	GasTank(double maxGas, double currentGas) {
		this.maxGas = maxGas;
		this.currentGas = currentGas;
	}
	
	public boolean empty() {
		if (currentGas > 0) {
			return false;
		} else {
			return true;
		}
	}

	public double getMaxGas() {
		return maxGas;
	}
}
