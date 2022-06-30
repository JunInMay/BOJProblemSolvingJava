package problems.from.number19800;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baekjoon_19844 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] inputText = br.readLine().split("-| ");
		String[] checkStringsArray = {
				"c", "j", "n", "m",
				"t", "s", "l", "d", "qu"};
		String[] vowelsArray = {
				"a", "e", "i", "o", "u", "h"
		};
		ArrayList<String> checkStringsVerification = new ArrayList<>(Arrays.asList(checkStringsArray));
		ArrayList<String> vowelsVerification = new ArrayList<>(Arrays.asList(vowelsArray));
		
		int count = 0;
		for (String word : inputText) {
			int apostropheIndex = word.indexOf("'");
			count++;
			
			if (apostropheIndex < 0) {
				continue;
			}
			StringTokenizer st = new StringTokenizer(word, "'");
			if (checkStringsVerification.contains(st.nextToken())) {
				if (!st.hasMoreTokens()) {
					continue;
				}
				if (vowelsVerification.contains(Character.toString(st.nextToken().charAt(0)))) {
					count++;
				}
			}
		}
		System.out.println(count);
	}
// qu'es't'a-ce qu'il mange aujourd'hui
}

