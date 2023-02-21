import java.util.Scanner;

public class PrimeNumber{

	public static void main(String[] args){

		int stop = 0;
		int num;
		
		 
		Scanner scan = new Scanner(System.in);
		System.out.println("enter number: ");
		num = scan.nextInt();
		
		int number = num/2;

		if(num==0 || num==1){
			System.out.println(num+" :is not Prime Number");
		}else{

			for(int i = 2; i<=number; i++){
			
				if(num % i==0){
				 System.out.println(num + " :is not prime number");
				stop  = 1;
				break;
				}
			}
				if(stop==0){
				System.out.println(num+ " : is prime number");
				}
		}
	}
}