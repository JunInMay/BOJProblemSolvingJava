package problems.from.number17200;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon17287 {

	public static void main(String[] args) throws IOException {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		
		String input = br.readLine();
		int result = 0;
		int point = 0;
		for (int i=0; i<input.length(); i++) {
			char now = input.charAt(i);
			if (now >= 48 && now <= 57) {
				result = Math.max(result, point);
				continue;
			}
			
			switch (now) {
			case '(':
				point += 1;
				break;
			case '{':
				point += 2;
				break;
			case '[':
				point += 3;
				break;
			case ')':
				point -= 1;
				break;
			case '}':
				point -= 2;
				break;
			case ']':
				point -= 3;
				break;
			}
				
		}
		System.out.println(result);

	}
}
