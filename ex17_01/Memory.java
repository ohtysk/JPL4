
public class Memory {
	static void showSummary() {
		Runtime rt = Runtime.getRuntime();
		long totalMB = rt.totalMemory() / 1024 / 1024;
		long freeMB = rt.freeMemory() / 1024 / 1024;
		long maxMB = rt.maxMemory() / 1024 / 1024;
		System.out.println("    summary: total=" + totalMB + "MB free=" + freeMB + "MB max=" + maxMB + "MB");
	}
	
	public static void main(String[] args) {
		Runtime rt = Runtime.getRuntime();
		System.out.println("start main");
		showSummary();
		
		int length = 500000000;
		long freeBefore = rt.freeMemory();
		Object[] object = new Object[length];
		for (int i = 0; i < length; i++) {
			object[i] = "hogeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee";
		}
		long freeAfter = rt.freeMemory();
		System.out.println("use memory");
		System.out.println("    free memory: before=" + freeBefore + "B after=" + freeAfter + "B diff=" + (freeBefore - freeAfter) + "B");
		showSummary();
		
		object = null;
		System.out.println("unuse memory");
		showSummary();
		
		rt.gc();
		System.out.println("gc");
		long freeAfter2 = rt.freeMemory();
		System.out.println("    free memory: before=" + freeAfter + "B after=" + freeAfter2 + "B diff=" + (freeAfter - freeAfter2) + "B");
		showSummary();
	}
}
