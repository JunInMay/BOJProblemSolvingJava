package problems.from.number06900;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon6919 {
	
	static long GCD (long left, long right) {
		while (true) {
			if (left % right == 0) {
				break;
			}
			long temp = left % right;
			left = right;
			right = temp;
		}
		
		return right;
	}
	
	public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		long numerator = Long.parseLong(br.readLine());
		long denominator = Long.parseLong(br.readLine());
		
		long quotient = numerator / denominator;
		numerator %= denominator;
		long gcd = GCD(numerator, denominator);
		
		numerator /= gcd;
		denominator /= gcd;
		
		String result = "";
		if (quotient != 0) {
			result = String.valueOf(quotient);
		}
		String fraction = "";
		if (numerator != 0) {
			fraction = String.format("%d/%d", numerator, denominator);
		}
		
		if (quotient != 0 && numerator != 0) {
			result += " ";
		}
		
		if (quotient == 0 && numerator == 0) {
			result = "0";
		}
		
		System.out.println(String.format("%s%s", result, fraction));
	}
	
}
