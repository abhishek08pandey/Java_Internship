package abstractdesignpattern;

public class Pizza implements Food {

	@Override
	public void food(String name) {
		System.out.println("It's "+ name+"Pizza order...");

	}

}
