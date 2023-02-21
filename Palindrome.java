import java.util.Scanner;

public class Palindrome {

	public static void main(String[] args) {
		String reverse ="";
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter int/String: ");
		String check = scan.next();
		
		for (int i = check.length()-1; i >=0; i--) {
			reverse= reverse+check.charAt(i);
		}
		if(reverse.equalsIgnoreCase(check)) {
			System.out.println(reverse+" :palindrome");
		}else {
			System.out.println("Not Palindrome");
		}
	}
}