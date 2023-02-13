package problems.from.number11500;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class Baekjoon11502 {

	public static void main(String[] args) throws IOException {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		
		boolean[] sieve = new boolean[1001];
//		Arrays.fill(sieve, true);
		for (int i=2; i<sieve.length; i++) {
			for (int j=i+i; j<sieve.length; j+=i) {
				sieve[j] = true;
			}
		}
		ArrayList<Integer> primeNumbers = new ArrayList<>();
		for (int i=2; i<sieve.length; i++) {
			if (!sieve[i]) {
				primeNumbers.add(i);
			}
		}
		
		int caseCount = Integer.parseInt(br.readLine());
		
		while(caseCount-- > 0) {
			int goal = Integer.parseInt(br.readLine());
			
			boolean flag = false;
			for (int a : primeNumbers) {
				int sum = a;
				if (flag) {
					break;
				}
				for (int b : primeNumbers) {
					if (flag) {
						break;
					}
					sum += b;
					for (int c : primeNumbers) {
						sum += c;
						if (flag) {
							break;
						}
						if (sum == goal) {
							String result = String.format("%d %d %d", a, b, c);
							flag = true;
							System.out.println(result);
						}
						sum -= c;
					}
					sum -= b;
				}
			}
		}
	}
}
