import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;


public class WeakValueMap<K, V> implements Map<K, V> {
	private HashMap<K, WeakReference<V>> map = new HashMap<K, WeakReference<V>>();
	private ReferenceQueue<V> queue;
	private Thread reaper;

	public WeakValueMap() {
		queue = new ReferenceQueue<V>();
		reaper = new ReaperThread();
		reaper.start();
	}
	
	@Override
	public synchronized void clear() {
		reaper.interrupt();
		map = new HashMap<K, WeakReference<V>>();
		queue = new ReferenceQueue<V>();
		reaper = new ReaperThread();
		reaper.start();	
	}

	@Override
	public synchronized boolean containsKey(Object key) {
		return map.containsKey(key);
	}

	@Override
	public synchronized boolean containsValue(Object value) {
		return map.containsValue(value);
	}

	@Override
	public synchronized Set<java.util.Map.Entry<K, V>> entrySet() {
		Set<Entry<K, WeakReference<V>>> set = map.entrySet();
		Set<Entry<K, V>> newSet = new TreeSet<Entry<K, V>>();
		for (Entry<K, WeakReference<V>> entry : set) {
			newSet.add(new AbstractMap.SimpleEntry<K, V>(entry.getKey(), entry.getValue().get()));
		}
		return newSet;
	}

	@Override
	public synchronized V get(Object key) {
		WeakReference<V> ref = map.get(key);
		return ref == null ? null : ref.get();
	}

	@Override
	public synchronized boolean isEmpty() {
		return map.isEmpty();
	}

	@Override
	public synchronized Set<K> keySet() {
		return map.keySet();
	}

	@Override
	public synchronized V put(K key, V value) {
		WeakReference<V> oldVal = map.put(key, new WeakReference<V>(value, queue));
		return oldVal == null ? null : oldVal.get();
	}

	@Override
	public synchronized void putAll(Map<? extends K, ? extends V> m) {
		for (Entry<? extends K, ? extends V> entry : m.entrySet()) {
			put(entry.getKey(), entry.getValue());
		}
	}

	@Override
	public synchronized V remove(Object key) {
		return map.remove(key).get();
	}

	@Override
	public synchronized int size() {
		return map.size();
	}

	@Override
	public synchronized Collection<V> values() {
		Collection<WeakReference<V>> refs = map.values();
		Collection<V> newValues = new ArrayList<V>();
		for (WeakReference<V> ref : refs) {
			newValues.add(ref.get());
		}
		return newValues;
	}

	class ReaperThread extends Thread {
		public void run() {
			System.out.println("thread start");
			while (true) {
				try {
					WeakReference<V> ref = (WeakReference<V>) queue.remove();
					synchronized(WeakValueMap.this) {
						Set<Entry<K, WeakReference<V>>> set = map.entrySet();
						List<K> keys = new ArrayList<K>();
						for (Entry<K, WeakReference<V>> entry : set) {
							if (entry.getValue() == ref) {
								keys.add(entry.getKey());
							}
						}
						for (K key : keys) {
							map.remove(key);
						}
					}
				}
				catch (InterruptedException e) {
					break;
				}
			}
		}
	}
}
