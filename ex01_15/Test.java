
public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ImprovedSimpleLookup table = new ImprovedSimpleLookup();
		Object message;
		
		table.print();
		
		message = table.add("hoge", 1);
		System.out.println(message);
		table.print();
		
		message = table.add("hoge", 5);
		System.out.println(message);

		message = table.remove("hoge");
		System.out.println(message);
		
		message = table.add("hoge", 5);
		System.out.println(message);
		
		table.print();
		
		for (int i = 0; i < 50; i++) {
			message = table.add("kita" + i, i);
		}

		table.print();
		
	}

}
