package problems.from.number17900;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon17910 {
	static int size;
	static int[] denominators;
	static long numerator;
	static long denominator = 1;
	
	static void constructFraction (int index) {
		if (index == size-1) {
			numerator = denominators[index];
		} else if (index == -1) {
			return;
		} else {
			int now = denominators[index];
			long temp = denominator;
			denominator = numerator;
			numerator = temp + now * denominator;
		}
		constructFraction(index-1);
	}
	
	static long GCD (long left, long right) {
		while (right != 0) {
			long temp = left % right;
			left = right;
			right = temp;
		}
		return left;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		size = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		denominators = new int[size];
		for (int i=0; i<size; i++) {
			denominators[i] = Integer.parseInt(st.nextToken()); 
		}
		
		constructFraction(size-1);
		long gcd = GCD(numerator, denominator);
		numerator = numerator / gcd;
		denominator = denominator / gcd;
		String result = String.format("%d/%d", numerator/gcd, denominator/gcd);
		if (denominator == 1) {
			result = String.format("%d", numerator);
		}
		System.out.println(result);
	}

}
