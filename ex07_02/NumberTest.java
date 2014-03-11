
public class NumberTest {
	byte byteVar;
	short shortVar;
	int intVar;
	long longVar;
	float floatVar;
	double doubleVar;
	
	public NumberTest() {
		// TODO Auto-generated constructor stub
	}
	
	public static void main(String[] args) {
		NumberTest test = new NumberTest();

		//test.byteVar = 0f; //Type mismatch: cannot convert from double to byte
		//test.byteVar = 1.8e-1;//Type mismatch: cannot convert from double to byte

		//test.shortVar = 1.5;//Type mismatch: cannot convert from double to short
		//test.shortVar = 1.5f;//Type mismatch: cannot convert from float to short
		
		//test.intVar = -1.0;//Type mismatch: cannot convert from double to int
		//test.intVar = 1.0f;//Type mismatch: cannot convert from float to int
		
		//test.longVar = 5e10;//Type mismatch: cannot convert from double to long
		//test.longVar = 0x5p10;//Type mismatch: cannot convert from double to long
		
		test.floatVar = 0x33;
		System.out.println(test.floatVar);
		test.floatVar = 9223372036854775807L;
		System.out.println(test.floatVar);
		//test.floatVar = 9223372036854775807;//The literal 9223372036854775807 of type int is out of range 
		test.floatVar = -9223372036854775808L;
		System.out.println(test.floatVar);
		//test.floatVar = -8.0;//Type mismatch: cannot convert from double to float

		test.doubleVar = 0x33;
		System.out.println(test.doubleVar);
		test.doubleVar = 9223372036854775807L;
		System.out.println(test.doubleVar);
		//test.doubleVar = 9223372036854775807;//The literal 9223372036854775807 of type int is out of range 
		test.doubleVar = -9223372036854775808L;
		System.out.println(test.doubleVar);
		
	}

}
