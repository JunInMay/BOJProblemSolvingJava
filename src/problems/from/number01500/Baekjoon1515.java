package problems.from.number01500;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon1515 {

	public static void main(String[] args) throws IOException {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		
		char[] inputText = br.readLine().toCharArray();
		int idx = 0;
		int number = 1;
		int limit = 40000;
		
		while (number < limit) {
			char[] numberArray = String.valueOf(number).toCharArray();
			
			for (int i=0; i<numberArray.length; i++) {
				if (idx == inputText.length) {
					break;
				}
				
				if (inputText[idx] == numberArray[i]) {
					idx++;
					continue;
				}
			}
			
			if (idx == inputText.length) {
				break;
			}
			number++;
		}
		
		System.out.println(number);
	}
}
