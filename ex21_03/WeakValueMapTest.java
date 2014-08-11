import static org.junit.Assert.*;

import org.junit.Test;


public class WeakValueMapTest {
	@Test
	public void test() throws Exception {
		WeakValueMap<String, String> map = new WeakValueMap<String, String>();
		Thread.sleep(100);
		String beforekey = null;
		String beforevalue = null;
		for (int i = 0; i < 100000; i++) {
			String k = i + "";
			String v = i + "hoge";
			v += v;
			v += v;
			v += v;
			v += v;
			map.put(k, v);
			if (i == 123) {
				beforekey = k;
				beforevalue = v;
				System.out.println("before " + map.get(beforekey));
			}
		}
		String after = map.get(beforekey);
		System.out.println("after " + after);		
		assertEquals(beforevalue, after);
		after = map.get("1");
		assertEquals(null, after);
	}
}
