package problems.from.number18700;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon18787 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int length = Integer.parseInt(br.readLine());
		
		String desired = br.readLine();
		String accepted = br.readLine();
		boolean sameBefore = true;
		int result = 0;
		for (int i=0; i<length; i++) {
			char now = accepted.charAt(i);
			char correct = desired.charAt(i);
			if (now != correct) {
				if (sameBefore) {
					result += 1;
					sameBefore = false;
				}
			} else {
				if (!sameBefore) {
					sameBefore = true;
				}
			}
		}
		System.out.println(result);
	}

}
