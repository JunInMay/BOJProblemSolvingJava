package test;

import java.util.Arrays;

public class Test {

	public static void main(String[] args) {
		
		String testText1 = "qe-dd ae";
		System.out.println(Arrays.toString(testText1.split("-")));
		System.out.println(Arrays.toString(testText1.split("-| ")));
		
		
	}
	

}
