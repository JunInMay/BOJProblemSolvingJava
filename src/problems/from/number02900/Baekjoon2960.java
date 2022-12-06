package problems.from.number02900;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Baekjoon2960 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int numberLimit = Integer.parseInt(st.nextToken());
		int goal = Integer.parseInt(st.nextToken());
		
		boolean[] sieve = new boolean[numberLimit+1];
		int count = 0;
		int result = -1;
		for (int i=2; i<sieve.length; i++) {
			for (int j=i; j<sieve.length; j+=i) {
				if (sieve[j]) {
					continue;
				}
				count++;
				sieve[j] = true;
				if (count == goal) {
					result = j;
					System.out.println(result);
					return;
				}
			}
		}
	}
}
