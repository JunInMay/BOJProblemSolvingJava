package problems.from.number18000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * 그냥...
 * (a의 개수 +1) * (b의 개수 +1) ... (z의 개수 +1) 해서 구하면 되는데..
 * 어렵게 머리 굴렸다... 풀렸을땐 뿌듯했는데...
 * 난 수학을 못하나보다.. 돌겠다...
 */
public class Baekjoon18007 {
	static int result = 0;
	
	public static void main(String[] args) throws IOException {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		char[] input = br.readLine().toCharArray();
		long[][] alphabetDP = new long[26][26];
		
		int result = 0;
		for (int i=0; i<input.length; i++) {
			char alphabet = input[i];
			int alphabetIndex = alphabet-97;
			alphabetDP[alphabetIndex][0]++;
			result++;
		}
		
		for (int i=1; i<26; i++) {
			for (int j=0; j<26; j++) {
				long target = alphabetDP[j][0];
				for (int k=j+1; k<26; k++) {
					alphabetDP[j][i] += alphabetDP[k][i-1] * target;
					alphabetDP[j][i] %= 11092019;
				}
				result += alphabetDP[j][i];
				result %= 11092019;
			}
		}
		System.out.println(result+1);
	}
}
