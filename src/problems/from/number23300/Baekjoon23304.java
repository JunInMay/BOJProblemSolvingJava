package problems.from.number23300;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon23304 {
	
	static boolean isPalindrome(char[] input, int start, int end) {
		boolean result = true;
		
		for (int i = 0; i < (end - start) / 2; i++) {
			if (input[start + i] != input[end - i - 1]) {
				result = false;
				break;
			}
		}
		
		return result;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		char[] input = br.readLine().toCharArray();
		int startIndex = 0;
		int endIndex = input.length;
		String result = "AKARAKA";
		
		while (true) {
			if (startIndex == endIndex) {
				break;
			}
			if (!isPalindrome(input, startIndex, endIndex)) {
				result = "IPSELENTI";
				break;
			}
			endIndex /= 2;
		}
		
		System.out.println(result);
	}

}
