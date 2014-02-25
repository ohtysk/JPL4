
public class NewSortMetrics implements Cloneable{
	public long compareCnt;
	public long swapCnt;
	
	public void init() {
		swapCnt = compareCnt = 0;
	}
	
	public String toString() {
		return compareCnt + " compares " + swapCnt + " swaps";
	}
	
	public NewSortMetrics clone() {
		try {
			return (NewSortMetrics) super.clone();
		} catch (CloneNotSupportedException e) {
			throw new InternalError(e.toString());
		}
	}
}
