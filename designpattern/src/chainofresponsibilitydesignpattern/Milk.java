package chainofresponsibilitydesignpattern;

public class Milk implements Iteam {

//	protected Iteam iteam;
//
//	Milk(Iteam iteam) {
//		this.iteam = iteam;
//	}

	@Override
	public void orderIteam(String order) {
		milkOrder(order);

	}

	public static void milkOrder(String order) {
		if (order.equalsIgnoreCase("Milk")) {
			System.out.println("It is Milk order");
			OrderClass.order();
		} else {
			Water.waterOrder(order);
		}

	}

}
