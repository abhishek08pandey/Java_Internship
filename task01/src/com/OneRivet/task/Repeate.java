package com.OneRivet.task;
import java.util.Set;
import java.util.HashSet;
public class Repeate {

	public static void main(String[] args){

		String string = "12152352dddd";
		int count=0;
		
		Set set = new HashSet();
		
		for(int i = 0; i<string.length()-1; i++){		//s 
			for(int j=i+1; j< string.length()-1; j++){	//s

				 if(string.charAt(i)==string.charAt(j)){
					 set.add(string.charAt(i));
					 count++;
				}}
		}System.out.println(set);
		System.out.println(set);
		nextRepeated();
	}
	
	public static void nextRepeated() {
		
		String str = "leeeeapplllle";
		char[] c = str.toCharArray();
		char ch = ' ';
		int f=0;
		
		for (int i = 0; i < c.length-1; i++) {
			for (int j = i+1; j < c.length-1; j++) {
				if(c[i]==c[j]) {
					f=1;
					ch=c[j];
					
					c[i]='_';
				}
			}if(f==1 & c[i]!='_'){
				System.out.println(ch);
				f=0;
			}
		}
		count();
	}
	
	public static void count() {
		 StringBuilder c = new StringBuilder("aaaaaaa");
		int count=0;
//		String str = "grr____rddddacypatel";
//		char[] c = str.toCharArray();
		
		int len= c.length();
		
		for (int i = 0; i < c.length(); i++) {
			for (int j = i+1; j < c.length()-1; j++) {
				if(c.charAt(i)==c.charAt(j))
				{
//					System.out.println(c[j]);
					count++;
//					c.replace(j,'_');
					
					//c = c.deleteCharAt(j);
					c= c.replace(j, j, " ");
					System.out.println(c.charAt(j));
				}
			}
			if(count>=1)
			{
//				System.out.println(c.charAt(i));
//				System.out.println(count+1);
			}
			count=0;
			
		}
	}
}
