package com.OneRivet.task;

import java.util.Scanner;

public class PrimeNumber {

	public static void main(String[] args) {
		int stop = 0;
		int firstNum;
		int lastNum;

		Scanner scan = new Scanner(System.in);
		System.out.println("Enter Fist number");
		firstNum = scan.nextInt();
		System.out.println("Enter Last number");
		lastNum = scan.nextInt();

		for (int i = firstNum; i <= lastNum; i++) {
			if(primeNumber(i)) {
				System.out.println(i);
			}
		}
	}
	
	public static boolean primeNumber(int firstNum) {
		
		if(firstNum<=1) {
			return false;
		}
		for (int i = 2; i <=firstNum/2; i++) {//2
			if(firstNum%i==0) {  //4
				return false;
			}
		}
		return true;
	}
}