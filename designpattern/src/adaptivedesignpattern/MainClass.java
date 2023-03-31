package adaptivedesignpattern;

public class MainClass {

	public static void main(String[] args) {
		
	// when class1 used class 2 properties	
		Class1 class1 = new Class1();
		
		Interface2 interface2 = new Class2 ();
		
		Interface2 interface2Adapter = new AdapterClass1(class1);
		
		System.out.println("when class1 used class 2 properties	");
		
		interface2.test22();
		
		interface2Adapter.test22();// it use class1 functionality
		
	// when class1 used class 2 properties	
	
		Class2 class2 = new Class2();
		
		Interface1 interface1 = new Class1();
		
		Interface1 interface1Adapter = new AdapterClass2(class2);
		
		System.out.println("when class1 used class 2 properties	");
		
		interface1.test11();
		
		interface1Adapter.test11();// it use class2 functionality
	}
	
}
