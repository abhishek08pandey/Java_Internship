package com.onerivet.stream;

import java.util.*;
import java.util.stream.Stream;

public class A {

	public static void main(String[] args) {
		
// Stream.of()		
		Stream<Integer> num = Stream.of(1,2,3,4,5,6,7,8,9,4);
		
		num.forEach(n->{System.out.println(n);});
// Stream.of(array)		
		Stream<Integer> num1 = Stream.of(new Integer [] {4,5,5,6,6,78,5,6,5,5,6});
		
		num1.forEach(n->{System.out.println(n);});
		
		
		String  str= new String("abhishek");

		List<String > list = new ArrayList<String>();
		list.add("abhishek");
		list.add("ajay");
		
		List<String > list1 = new ArrayList<String>();
		list1.add("abhishek");
		list1.add("sjay");
		
// Both return type in boolean form		
		list.stream().anyMatch(t->t.startsWith("s"));
		list.stream().allMatch(t->t.endsWith("k"));			


		list.stream().forEach(p->{System.out.println(p);});
		
	}
	
	
	public static void test1(int jh) {
	
		
		
		
	
	}			
}
