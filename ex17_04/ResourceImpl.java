
public class ResourceImpl implements Resource {
	Object key;
	boolean needsRelease = false;
	
	ResourceImpl(Object key) {
		this.key = key;
		// �O�������[�X�̐ݒ�
		needsRelease = true;
	}
	
	@Override
	public void use(Object key, Object... args) {
		if (this.key != key)
			throw new IllegalArgumentException("woring key");
		
		// �����[�X�̎g�p
	}

	@Override
	public synchronized void release() {
		if (needsRelease) {
			needsRelease = false;
			// �����[�X�̊J��
		}
	}

}
