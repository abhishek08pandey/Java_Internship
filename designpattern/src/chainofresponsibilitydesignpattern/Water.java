package chainofresponsibilitydesignpattern;

public class Water implements Iteam {

//	protected Iteam iteam;
//
//	Water(Iteam iteam) {
//		this.iteam = iteam;
//	}

	@Override
	public void orderIteam(String order) {
		waterOrder(order);

	}

	public static void waterOrder(String order) {
		if (order.equalsIgnoreCase("Water")) {
			System.out.println("It is Water order");
			OrderClass.order();
		} else {
			OrderClass.order();
		}
	}
}
