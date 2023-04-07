package abstractdesignpattern;

public class Burger implements Food{

	@Override
	public void food(String name) {
		System.out.print("It's "+ name+"Burger order...");
		
		
	}

}
