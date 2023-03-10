package com.OneRivet.task;

import java.util.Scanner;


public class Armstrong{
public static void main(String[] args){

        Scanner scan = new Scanner(System.in);

	System.out.println("Enter Number: ");
	int num= scan.nextInt();
	int number=num;
	int number2=num;

System.out.println(num);
System.out.println(number);

	int zero=0;int count=0;
	int lastDigit, multiple=1;

	while(number > 0){
	number=number/10;
	count++;

	}
System.out.println(count);
while(number2>0){

lastDigit=number2%10;

for(int i = 1; i<=count; i++){

multiple=multiple*lastDigit;

}System.out.println(multiple);

zero=zero+multiple;
number2=number2/10;

}
System.out.println(zero);
if(number==zero){
	System.out.println("Armstrong Number");
}else{
	System.out.println("Not a Armstrong Number");
}
}
}
