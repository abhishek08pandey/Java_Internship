package abstractdesignpattern;

public class Soup implements Food{

	@Override
	public void food(String name) {
		
		System.out.println("It's "+ name+"Soupe order...");
		
	}

}
