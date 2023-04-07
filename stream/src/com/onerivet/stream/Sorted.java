package com.onerivet.stream;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Sorted {

	public static void main(String[] args) {
		
		List<Integer> list =  Arrays.asList(2,12,33,41,6,2,1,2,54,7,5,1,2,3,4);
		List<String> languages = Arrays.asList("Java", "Scala", "C++", "Haskell", "Lisp");

		List<String> collect2 = languages.stream().map(x->x.toUpperCase()).collect(Collectors.toList());
		System.out.println(collect2);
		
		Set<Double> collect = list.stream().map(x->x+.3).collect(Collectors.toSet());
		System.out.println(collect);
		
		
// Remove Duplicate	
		Set<Integer> unique = list.stream().filter(x->x != ++x).collect(Collectors.toSet());
		System.out.println(unique);
		

// Remove Duplicate
		Set<Integer> removeDuplicate = list.stream().distinct().collect(Collectors.toSet());
		System.out.println(removeDuplicate);
		
		Set<Integer> set =new HashSet<>();
// Repeated value
		List<Integer> collect1 = list.stream().filter(e-> !set.add(e)).collect(Collectors.toList());
		System.out.println(collect1);
		
// Sorted
		List<Integer> sorted = list.stream().sorted().collect(Collectors.toList());
		System.out.println(sorted);
		
// Sorted in reverse 
		List<Integer> revrese = list.stream().sorted(Collections.reverseOrder()).collect(Collectors.toList());
		System.out.println(revrese);
	 
}
}
 