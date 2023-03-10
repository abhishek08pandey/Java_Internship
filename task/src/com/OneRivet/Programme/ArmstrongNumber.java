package com.OneRivet.Programme;

public class ArmstrongNumber {

	public static void main(String[] args) {

		int n = 153;
		int count = 0, mul = 1, sum = 0,last;
		int num = n;

		while (num > 0) {
			num = num / 10;
			count++;
		}
	//	System.out.println(count);

		int num2 = n;

		while (num2 > 0) {
			last = num2 % 10;

			for (int i = 1; i <= count; i++) {
				mul = mul * last;
			}System.out.println(mul);
			
			sum=sum+mul;
			num2 = num2 / 10;
		}
		System.out.println("num2: " + sum);
		
	}
}
