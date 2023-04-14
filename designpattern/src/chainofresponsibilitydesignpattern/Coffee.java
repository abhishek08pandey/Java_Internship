package chainofresponsibilitydesignpattern;

public class Coffee implements Iteam {

//	protected Iteam iteam;
//
//	Coffee(Iteam iteam) {
//		this.iteam = iteam;
//	}

	@Override
	public void orderIteam(String order) {
		coffeeOrder(order);

	}

	public static void coffeeOrder(String order) {
		if (order.equalsIgnoreCase("coffee")) {
			System.out.println("It is Coffee order");
			OrderClass.order();
		} else {
			Milk.milkOrder(order);
		}

	}

}
