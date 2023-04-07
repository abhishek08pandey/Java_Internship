package abstractdesignpattern;

import java.util.Scanner;

public class MainClass {

	public static void main(String[] args) {
		foodOrder();
	}

	public static void foodOrder() {

		int x = 4;
		while (x > 0) {

			Scanner scan = new Scanner(System.in);

			System.out.println("\n**********\nPlease Order\n 1: Veg\n 2: NonVeg\n**********");
			int typeFood = scan.nextInt();

			if (typeFood == 1) {
				
				System.out.println("**********\nSelect food:\n 1: Pizza, 2: Soup, 3: Burger\n**********");
				int food = scan.nextInt();
				
				AbstractFoodFactory vegFactory = MainFactory.getFactory(true);

				if (food == 1) {
					Food vegFood = vegFactory.getFood("pizza");
					vegFood.food("Veg ");
				} else if (food == 2) {
					Food vegFood = vegFactory.getFood("Soup");
					vegFood.food("Veg ");
				} else if (food == 3) {
					Food vegFood = vegFactory.getFood("Burger");
					vegFood.food("Veg ");
				} else {
					System.out.println("Please Enter valid input if you want eat delicious food");
					foodOrder();
				}

			} else if (typeFood == 2) {

				System.out.println("**********\nSelect food:\n 1: Pizza, 2: Soup, 3: Burger\n**********");
				int food = scan.nextInt();
				
				AbstractFoodFactory NonVegFactory = MainFactory.getFactory(false);

				if (food == 1) {
					Food nonVegFood = NonVegFactory.getFood("pizza");
					nonVegFood.food("NonVeg ");
				} else if (food == 2) {
					Food nonVegFood = NonVegFactory.getFood("Soup");
					nonVegFood.food("NonVeg ");
				} else if (food == 3) {
					Food nonVegFood = NonVegFactory.getFood("Burger");
					nonVegFood.food("NonVeg ");
				} else {
					System.out.println("Please Enter valid input if you want eat delicious food");
					foodOrder();
				}
			} else {
				foodOrder();
			}
		}
	}
}
