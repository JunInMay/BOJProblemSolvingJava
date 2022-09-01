package problems.from.number01500;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon1543 {

	public static void main(String[] args) throws IOException {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		
		String originalText = br.readLine();
		String indexText = br.readLine();
		
		int result = 0;
		for (int i=0; i<originalText.length()-(indexText.length()-1); i++) {
			boolean isMatch = true;
			int idx = 0;
			while (idx < indexText.length()) {
				if(originalText.charAt(i + idx) != indexText.charAt(idx)) {
					isMatch = false;
					break;
				}
				idx++;
			}
			
			if (isMatch) {
				result++;
				i += indexText.length() - 1;
			}
		}
		System.out.println(result);
	}
}
