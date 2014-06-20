import java.util.ResourceBundle;


public class GlobalHello {
	public static void main(String[] args) {
		ResourceBundle res = ResourceBundle.getBundle("GlobalRes");
		String msg;
		if (args.length > 0) {
			msg = res.getString(GlobalRes.GOODBYE);
		} else {
			msg = res.getString(GlobalRes.HELLO);
		}
		System.out.println(msg);
	}
}
