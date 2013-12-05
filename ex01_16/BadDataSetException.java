
public class BadDataSetException extends Exception {
	public Exception e = null;
	public double [] data = null;
	
	BadDataSetException(Exception e) {
		this.e = e;
	}
	
	BadDataSetException(Exception e, double[] data) {
		this.e = e;
		this.data = data.clone();
	}
	
}
