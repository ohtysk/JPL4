
public class ResourceImpl implements Resource {
	Object key;
	boolean needsRelease = false;
	
	ResourceImpl(Object key) {
		this.key = key;
		// 外部リリースの設定
		needsRelease = true;
	}
	
	@Override
	public void use(Object key, Object... args) {
		if (this.key != key)
			throw new IllegalArgumentException("woring key");
		
		// リリースの使用
	}

	@Override
	public synchronized void release() {
		if (needsRelease) {
			needsRelease = false;
			// リリースの開放
		}
	}

}
