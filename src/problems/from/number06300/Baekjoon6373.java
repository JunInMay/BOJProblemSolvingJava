package problems.from.number06300;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
0588235294117647
8823529411764705
8235294117647058
 */

public class Baekjoon6373 {
	static String multiply(String s, int multiple) {
		StringBuilder result = new StringBuilder();
		int carry = 0;
		for (int i=0; i<s.length(); i++) {
			int digit = Character.getNumericValue(s.charAt(s.length()-(1+i)));
			int calculatedResult = digit * multiple + carry;
			int nextDigit = calculatedResult % 10;
			carry = calculatedResult / 10;
			
			result.append(nextDigit);
		}
		result.reverse();
		
		return result.toString();
	}
	static boolean isCyclic(String original, String check) {
		boolean result = false;
		
		for (int i=0; i<check.length(); i++) {
			StringBuilder cycleChecker = new StringBuilder();
			for (int j=0; j<check.length(); j++) {
				cycleChecker.append(check.charAt((i + j) % check.length()));
			}
			if (cycleChecker.toString().equals(original)) {
				result = true;
				break;
			}
		}
		
		return result;
	}

	public static void main(String[] args) throws IOException {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		
		String input = "";
		while ((input = br.readLine()) != null) {
			boolean isCyclic = false;
			for (int multiple=1; multiple<=input.length(); multiple++) {
				isCyclic = isCyclic(input, multiply(input, multiple));
			}
			
			String notText = ""; 
			if (!isCyclic) {
				notText = "not ";
			}
			System.out.println(String.format("%s is %scyclic", input, notText));
		}
	}
}
