public class Swapping{

	public static void main(String[] args){
	
		int x= 40;
		int y =20;
		int temp;
		
		//With temp variable
		System.out.println("With the use of Temporary variable");
		System.out.println("Before:  x: "+x+"  y: "+y);
		temp=x;
		x=y;
		y=temp;
		System.out.println("\nAfter:  x: "+x+"  y: "+y);

		//with + -
		System.out.println("With the use of + and -");
		System.out.println("Before:  x: "+x+"  y: "+y);
		x=x+y; // 60
		y=x-y; //60-20=40
		x=x-y;  //60-40 =20
		System.out.println("\nAfter:  x: "+x+"  y: "+y);
	

		//with / *
		System.out.println("With the use of / and * ");
		System.out.println("Before:  x: "+x+"  y: "+y);
		x=x/y; //40/20=x=2
		y=x*y;  //2*20 =y=40
		x=y/x;  //40*2 = 80
		System.out.println("After:  x: "+x+"  y: "+y);
















	}
}