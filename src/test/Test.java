package test;

import java.util.Arrays;

public class Test {

	public static void main(String[] args) {
		int n = 10000;
		int base = 4;
		long result = 0;
		
		
		for (int i = 0; i < n; i++) {
			int forPlus = 0;
			for (int j = 1; j < n; j++) {
				if (i+j+base+(i*2) > n) {
					forPlus = Math.max(j-i, 0);
				} else {
					forPlus = base + (i*2);
				}
				result += forPlus;
			}
		}
		//1312304
		//165922
		
		
		int a = 0;
		for (int i = 0; i <162444622; i++) {
			a++;
		}
		System.out.println("over");
	}
	

}
