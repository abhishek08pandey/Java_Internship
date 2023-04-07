package facadedesignpattern;

import java.util.Scanner;

public class MainClass {
	
	public static void main(String[] args) {
		selectSeasion();
	}
	
	public static void selectSeasion() {
		ClothesClass clothes = new ClothesClass();

		Scanner scan  = new Scanner(System.in);
		System.out.println("****************\n"
				+ "Enter Seasion number:\n 1: Summer \n 2: Winter \n 3: Monsoon\n 4: Exit \n******************");
		Integer seasion = scan.nextInt();
		
		switch (seasion) {
		case 1:
			clothes.Summer();
			break;

		case 2:
			clothes.Winter();
			break;
			
		case 3:
			clothes.Monsoon();
			break;
		
		default:
			
			break;
		}
	}

}
