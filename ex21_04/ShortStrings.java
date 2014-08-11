import java.util.ListIterator;
import java.util.NoSuchElementException;


public class ShortStrings implements ListIterator<String>{
	private ListIterator<String> strings;
	private String nextShort;
	private String prevShort;
	private int outerLastIndex;
	private int outerNextIndex = 0;
	private int outerPrevIndex = -1;
	private final int maxLen;
	private boolean removable = false;
	
	void show() {
		System.out.println("nextShort: " + nextShort);
		System.out.println("prevShort: " + prevShort);
		System.out.println("outerNextIndex: " + outerNextIndex);
		System.out.println("outerPrevIndex: " + outerPrevIndex);
		System.out.println("outerLastIndex: " + outerLastIndex);
		System.out.println("removable: " + removable);
		System.out.println();
	}
	
	ShortStrings(ListIterator<String> strings, int maxLen) {
		this.strings = strings;
		this.maxLen = maxLen;
	}
	
	@Override
	public void add(String e) {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean hasNext() {
		prevShort = null;
		if (nextShort != null)
			return true;
		while (strings.hasNext()) {
			nextShort = strings.next();
			if (nextShort.length() <= maxLen) {
				strings.previous();
				return true;
			}
		}
		nextShort = null;
		return false;
	}

	@Override
	public boolean hasPrevious() {
		nextShort = null;
		if (prevShort != null)
			return true;
		while (strings.hasPrevious()) {
			prevShort = strings.previous();
			if (prevShort.length() <= maxLen) {
				String a = strings.next();
				return true;
			}
		}
		prevShort = null;
		return false;
	}

	@Override
	public String next() {
		if (nextShort == null && !hasNext())
			throw new NoSuchElementException();
		strings.next();
		outerLastIndex = outerNextIndex;
		outerNextIndex++;
		outerPrevIndex++;
		String n = nextShort;		
		nextShort = null;
		prevShort = null;
		removable = true;
		return n;
	}

	@Override
	public int nextIndex() {
		return outerNextIndex;
	}

	@Override
	public String previous() {
		if (prevShort == null && !hasPrevious())
			throw new NoSuchElementException();
		strings.previous();
		outerLastIndex = outerPrevIndex;
		outerNextIndex--;
		outerPrevIndex--;
		String n = prevShort;	
		nextShort = null;
		prevShort = null;
		removable = true;
		return n;
	}

	@Override
	public int previousIndex() {
		return outerPrevIndex;
	}

	@Override
	public void remove() {
		if (!removable)
			throw new IllegalStateException();
		if (outerLastIndex == outerPrevIndex) {
			if (hasPrevious()) {
				String a = previous();
				strings.remove();
			}
		} else {
			if (hasNext()) {
				next();
				outerNextIndex--;
				outerPrevIndex--;
				strings.remove();
			}
		}
		removable = false;
	}

	@Override
	public void set(String e) {
		throw new UnsupportedOperationException();
	}

}
