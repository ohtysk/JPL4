import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.ResourceBundle;


public class GlobalRes_fr extends ResourceBundle {
	private static List<String> keys = new ArrayList();
	static {
		keys.add(GlobalRes.HELLO);
		keys.add(GlobalRes.GOODBYE);
	}
	@Override
	public Enumeration<String> getKeys() {
		return (Enumeration<String>) keys;
	}

	@Override
	protected Object handleGetObject(String key) {
		switch (key) {
		case GlobalRes.HELLO:
			return "Bonjour";
		case GlobalRes.GOODBYE:
			return "Salue";
		default:
			return null;
		}
	}

}
