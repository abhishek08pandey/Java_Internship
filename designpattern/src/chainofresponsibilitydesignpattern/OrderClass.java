package chainofresponsibilitydesignpattern;

import java.util.Scanner;

public class OrderClass {

	public static void main(String[] args) {
		order();
	}
	
	public static void order() {
		
		Scanner scan = new Scanner(System.in);
		System.out.println("\n***************\nMenu:\n Milk , coffee, Water\n***************\n");
		String order = scan.next();
		
		Iteam o1 = new Coffee();
		
		o1.orderIteam(order);
	}
}
