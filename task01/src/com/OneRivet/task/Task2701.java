package com.OneRivet.task;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import java.util.HashMap;

public class Task2701 {

	public static void main(String[] args) {

//7th- Write a program to initialize an ArrayList in java
		ArrayList<String> arrayList = new ArrayList<String>();
		arrayList.add("Jitendra Singh");
		arrayList.add("Vishal Patel");
		arrayList.add("Abhishek Pandey");
		arrayList.add("Preet Patel");
		System.out.println("7th- Initialize an ArrayList in java: "+arrayList);

//1st- Write a program to traverse (or iterate) ArrayList
		System.out.println();
		System.out.println("1st- Itrate ArrayList: ");
		Iterator<String> iterator = arrayList.iterator();
		while (iterator.hasNext()) {
			System.out.println(iterator.next());
		}
		
//9th-Write a program to find the length of the ArrayList
		System.out.println();
		System.out.println("9th- Length of ArrayList: "+arrayList.size());
		
//2nd-Write a program to convert List to Array.
		System.out.println();
		System.out.println("2nd- After convert ArrayList into Array");
		String[] array = (String[]) arrayList.toArray(new String[arrayList.size()]);

		for (String string : array) {
			System.out.println(string);
		}

//3rd-Write a program to traverse(or iterate) HashSet
		System.out.println();
		System.out.println("3rd- Iterate HashSet");
		
		HashSet hashSet = new HashSet();
		hashSet.add("Ronak Patel");
		hashSet.add("JayKrishn");
		hashSet.add("Harsh Patel");
		Iterator iterator2 = hashSet.iterator();
		//forEach Through
		for (Object object : hashSet) {
			System.out.println(object);
		}
		//While loop through
		while (iterator2.hasNext()) {
			System.out.println(iterator2.next());
		}

//4th-Given an element write a program to check if element(value) exists in ArrayList
		System.out.println();
		System.out.println("4th- Element exists in ArrayList: " +arrayList.contains("Abhishek Pandey"));
		
//5th-Given an element write a program to check if element exists in HashSet
		System.out.println();
		System.out.println("5th- Element exists in HashSet: " +hashSet.contains("Ronak Patel"));
		
//6th- Write a program to initialize a HashMap in java
//10th-Write a program to add elements to the HashMap given the key and value data type is String
		System.out.println();
		HashMap<String, String> hashMap = new HashMap<String, String>();
		hashMap.put("Sonali", "Gupta");
		hashMap.put("Drashti", "Balsara");
		hashMap.put("Khyati", "Patel");
		hashMap.put("Gracy", "Patel");
		System.out.println("6th- Initialize a HashMap in java");
		System.out.println("10th- Add elements to the HashMap");
		System.out.println(hashMap);
		
		Set<Entry<String,String>> entrySet = hashMap.entrySet();
		Iterator itr = entrySet.iterator();
		
		while (itr.hasNext()) {
			System.out.println(itr.next());
			//hashMap.put("kamini", "patel");//throw concurrent modification exception
		}
	}

}
