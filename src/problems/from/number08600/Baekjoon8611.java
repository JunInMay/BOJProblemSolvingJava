package problems.from.number08600;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Baekjoon8611 {
	
	static boolean isPalindrome(String s) {
		boolean result = true;
		int length = s.length();
		
		for (int i=0; i<length/2; i++) {
			if (s.charAt(i) != s.charAt(length-(i+1))) {
				return false;
			}
		}
		
		
		return result;
	}

	public static void main(String[] args) throws IOException {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);

		BigInteger N = new BigInteger(br.readLine());
		boolean haveCase = false;
		
		for (int i=2; i<11; i++) {
			
			String palindrome = "";
			BigInteger divisor = new BigInteger(Integer.toString(i));
			BigInteger number = N;
			
			while (number.compareTo(BigInteger.ZERO) > 0) {
				BigInteger modValue = number.mod(divisor);
				number = number.divide(divisor);
				palindrome += modValue.toString();
				
			}
			if (isPalindrome(palindrome)) {
				System.out.println(String.format("%d %s", i, palindrome));
				haveCase = true;
			}
		}
		
		if (!haveCase) {
			System.out.println("NIE");
		}
		
	}

}
