
abstract public class SortHarness {
	private Object[] values;
	private final SortMetrics curMetrics = new SortMetrics();
	
	public final SortMetrics sort(Object[] data) {
		values = data;
		curMetrics.init();
		doSort();
		return getMetrics();
	}
	
	public final SortMetrics getMetrics() {
		return curMetrics.clone();
	}
	
	protected final int getDataLength() {
		return values.length;
	}
	
	protected final Object probe(int i) {
		curMetrics.probeCnt++;
		return values[i];
	}
	
	protected final int compare(int i, int j) {
		curMetrics.compareCnt++;
		int code1 = values[i].hashCode();
		int code2 = values[j].hashCode();
		if (code1 == code2)
			return 0;
		else
			return (code1 < code2 ? -1 : 1);
	}
	
	protected final void swap(int i, int j) {
		curMetrics.swapCnt++;
		Object tmp = values[i];
		values[i] = values[j];
		values[j] = tmp;
	}
	
	protected abstract void doSort();
}
