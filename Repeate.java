public class Repeate{
	
public static void main(String[] args){

	String string = "asarrrgagul";
	
	for(int i = 0; i<string.length()-1; i++){		//s 
		for(int j=i; j< string.length()-1; j++){	//s


			if(string.charAt(i)==string.charAt(j+1)){//ss

			System.out.println(string.charAt(i));
			break;
			}
		}
	}
}
}