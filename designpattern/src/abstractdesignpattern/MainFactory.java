package abstractdesignpattern;

public class MainFactory {

	public static AbstractFoodFactory getFactory(boolean order) {
		
		if(order) {
			return new VegFactory();
		}else{
			return new NonVegFoodFactory();
		}
	}
}
