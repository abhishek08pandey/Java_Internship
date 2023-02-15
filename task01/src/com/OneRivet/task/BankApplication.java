package com.OneRivet.task;
import java.util.Scanner;

public class BankApplication {

	public static void main(String[] args) {
		try{
			
			BankApplication bankApplication = new BankApplication();
			
		 Scanner scan = new Scanner(System.in);
			System.out.println("Mode: ");
			String str = scan.next();
			
			if(str.contains("create account")) {
			}else {
				System.out.println("error");
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
}
