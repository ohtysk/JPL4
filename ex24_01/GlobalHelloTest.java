import static org.junit.Assert.*;

import java.util.Locale;
import java.util.ResourceBundle;

import org.junit.Test;


public class GlobalHelloTest {
	@Test // 該当リソースなし
	public void testChina() {
		Locale.setDefault(Locale.CHINA);
		ResourceBundle res = ResourceBundle.getBundle("GlobalRes");
		String msg = res.getString(GlobalRes.GOODBYE);
		assertEquals("Ciao", msg);
		msg = res.getString(GlobalRes.HELLO);
		assertEquals("Ciao", msg);
	}

	@Test // ResourceBundle のサブクラス
	public void testFrance() {
		Locale.setDefault(Locale.FRANCE);
		ResourceBundle res = ResourceBundle.getBundle("GlobalRes");
		String msg = res.getString(GlobalRes.GOODBYE);
		assertEquals("Salue", msg);
		msg = res.getString(GlobalRes.HELLO);
		assertEquals("Bonjour", msg);
	}
	@Test // properties ファイル
	public void testJapan() {
		ResourceBundle res = ResourceBundle.getBundle("GlobalRes", Locale.JAPAN);
		String msg = res.getString(GlobalRes.GOODBYE);
		assertEquals("sayonara", msg);
		msg = res.getString(GlobalRes.HELLO);
		assertEquals("konnitiha", msg);
	}

	@Test // ListResourceBundle のサブクラス
	public void testEnglish() {
		ResourceBundle res = ResourceBundle.getBundle("GlobalRes", Locale.ENGLISH);
		String msg = res.getString(GlobalRes.GOODBYE);
		assertEquals("Goodbye", msg);
		msg = res.getString(GlobalRes.HELLO);
		assertEquals("Hello", msg);
	}
	@Test // ListResourceBundle　のサブクラス
	public void testEnglishAu() {
		ResourceBundle res = ResourceBundle.getBundle("GlobalRes", new Locale("en", "AU", ""));
		String msg = res.getString(GlobalRes.GOODBYE);
		assertEquals("Goodbye", msg);
		msg = res.getString(GlobalRes.HELLO);
		assertEquals("G'day", msg);
	}

}
