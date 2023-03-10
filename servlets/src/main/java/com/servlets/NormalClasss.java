package com.servlets;

public class NormalClasss {

	public static void main(String[] args) {

		int[] array1 = { 5, 1, 22, 25, 6, -1, 8, 10 };
		int[] array2 = { 1,10, 6, -1 };
		int i = 0, j = 0;

		while (i < array1.length && j < array2.length) {
			if (array1[i] == array2[j]) {
				j++;
			}
			i++;
		}
		if (j == array2.length) {
			System.out.println("true");
		} else {
			System.out.println("false");
		}
	}
}
