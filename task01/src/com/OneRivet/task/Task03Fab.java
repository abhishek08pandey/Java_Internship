package com.OneRivet.task;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

class User implements Comparable<User> {
	long id;
	String name;
	String technology;
	long salary;

	User(long id, String name, String technology, long salary) {
		this.id = id;
		this.name = name;
		this.technology = technology;
		this.salary = salary;
	}
	@Override
	public int compareTo(User user) {
		return user.name.compareTo(user.name);
	}
}
class SalaryComparator implements Comparator<User> {

	@Override
	public int compare(User o1, User o2) {
		if (o1.salary == o2.salary)
			return 0;
		else if (o1.salary > o2.salary)
			return 1;
		else
			return -1;
	}
}

public class Task03Fab {

	public static void main(String[] args) {

// Q1 Write a program to sort HashMap by keys ?
		Map<Integer, String> hash = new HashMap<>();
		hash.put(100, "Abhishek");
		hash.put(97, "Husain");
		hash.put(111, "Prince");
		hash.put(105, "Jay");
		hash.put(99, "Dev");
		
		System.out.println(hash.keySet()+"\n");
		
// Q2 Write a program to sort ArrayList using Comparable and Comparator?
		ArrayList<User> arrayList = new ArrayList<User>();
		arrayList.add(new User(10, "Abhishek", "JavaDeveloper", 10000));
		arrayList.add(new User(11, "Husain", "Devops", 8000));
		arrayList.add(new User(18, "Dharshi", "BusinessAnalyst", 6000));
		arrayList.add(new User(13, "Diya", "FrontEndDeveloper", 7000));

// Q2 Write a program to sort ArrayList using Comparable and Comparator?
		System.out.println(" Sorted name: ");
		Collections.sort(arrayList);
		for (User user : arrayList) {// Comparable
			System.out.println(user.name + " " + user.id);
		}
		System.out.println("\n  sorted salary: ");
		
		Collections.sort(arrayList, new SalaryComparator());
		for (User user : arrayList) {// Comparator
			System.out.println(user.salary + " " + user.name + " " + user.id);
		}
// Q3 Write a program to add element at particular index of ArrayList?
		System.out.println("\n Add Element at perticuler index number");
		arrayList.add(1, new User(19, "Dhruvin", "MobileAppDeveloper", 9000));
		for (User user : arrayList) {// Comparable
			System.out.println(user.name + " " + user.id + " " + user.technology + " " + user.salary);
		}
// Q5 How to synchronize an ArrayList in java?
		System.out.print("\n Synchronized ArrayList");
		List<String> list = Collections.synchronizedList(new ArrayList<String>());
		list.add("Dev");
		list.add("Prince");
		list.add("Jay");
		list.add("Husain");
		list.add("Abhi");
		System.out.println();
		synchronized (list) {
			Iterator iterator = list.iterator();
			while (iterator.hasNext()) {
				System.out.println(iterator.next());
			}
		}
		
		List<String> list2 = new ArrayList<String>();
		list2.add("Abhay");
		
//Q6 Write a program to convert LinkedList to ArrayList?
		System.out.println("\n Convert LinkedList to ArrayList");
		List<String> list1 = new LinkedList<String>(list2);
		list1.add("Dharshi");
		list1.add("Kamini");
		list1.add("Pratik");
		
		ListIterator<String> iterator1 = list1.listIterator();
		while(iterator1.hasNext()){
			System.out.println(iterator1.next());
		}
	}

//Q4 Write a program to sort HashMap by value? 


}
