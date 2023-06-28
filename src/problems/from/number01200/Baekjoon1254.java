package problems.from.number01200;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon1254 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String input = br.readLine();
		
		for (int start=0; start<input.length(); start++) {
			boolean isPalindrome = true;
			for (int i=0; i<input.length()-start; i++) {
				char left = input.charAt(start + i);
				char right = input.charAt(input.length() - (1+i));
				if (left != right) {
					isPalindrome = false;
				}
			}
			if (isPalindrome) {
				System.out.println(input.length() + start);
				break;
			}
		}
	}

}
