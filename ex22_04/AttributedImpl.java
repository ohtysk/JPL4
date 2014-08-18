import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Observable;


public class AttributedImpl extends Observable implements Attributed, Iterable<Attr>{
	private Map<String, Attr> map = new HashMap<String, Attr>();
	@Override
	public Iterator<Attr> iterator() {
		return map.values().iterator();
	}

	@Override
	public void add(Attr newAttr) {
		map.put(newAttr.getName(), newAttr);
		setChanged();
		notifyObservers(newAttr);
	}

	@Override
	public Attr find(String attrName) {
		return map.get(attrName);
	}

	@Override
	public Attr remove(String attrName) {
		Attr removed = map.remove(attrName);
		if (removed != null) {
			setChanged();
			notifyObservers(removed);
		}
		return removed; 
	}

	@Override
	public Iterator<Attr> attrs() {
		return iterator();
	}

}
