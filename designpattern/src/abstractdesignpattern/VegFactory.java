package abstractdesignpattern;

public class VegFactory  extends AbstractFoodFactory{

	@Override
	public Food getFood(String name) {
	
		if(name.equalsIgnoreCase("pizza")){
			return new Pizza();
		}else if(name.equalsIgnoreCase("Soup")) {
			return new Soup();
		}else if(name.equalsIgnoreCase("Burger")) {
			return new Burger();
		}
		return null;
	}

}
