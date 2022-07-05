package problems.from.number04600;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon_4676 {
	static String[] vowels = {
			"a", "e", "i", "o", "u", "y"
	};
	static int[] haikuRules = {5, 7, 5};

	public static void main(String[] args) throws IOException {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);

		String[] input = null;
		String first, second, third;
		
		while (true) {
			input = br.readLine().split("/");
			first = input[0];
			second = input[1];
			third = input[2];
			String result = "Y";
			
			if (first.equals("e") && second.equals("o") && third.equals("i")) {
				break;
			} else {
				for (int i = 0; i < 3; i ++) {
					if (countSyllables(input[i]) == haikuRules[i]) {
						continue;
					} else {
						result = Integer.toString(i+1);
						break;
					}
				}
			}
			System.out.println(result);
		}
	}

	private static int countSyllables(String string) {
		String[] serializedString = string.split("");
		int count = 0;
		boolean isVowelRightBefore = false;
		for (String s : serializedString) {
			boolean haveVowel = false;
			for (int i = 0; i < vowels.length; i++) {
				if (s.equals(vowels[i])) {
					haveVowel = true;
					break;
				}
			}
			if (haveVowel) {
				if (!isVowelRightBefore) {
					count++;
				}
				isVowelRightBefore = true;
			} else {
				isVowelRightBefore = false;
			}
		}
		
		return count;
	}

}
