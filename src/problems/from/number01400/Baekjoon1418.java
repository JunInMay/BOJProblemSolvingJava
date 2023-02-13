package problems.from.number01400;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon1418 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int number = Integer.parseInt(br.readLine());
		int standard = Integer.parseInt(br.readLine());
		
		boolean[] sieve = new boolean[100001];
		sieve[0] = true;
		sieve[1] = true;
		for (int i=2; i<=100000; i++) {
			if (sieve[i]) {
				continue;
			}
			for (int j=i+i; j<=100000; j+=i) {
				sieve[j] = true;
			}
		}
		
		int result = 1;
		for (int n=1; n<=number; n++) {
			int maxPrimeFactor = -1;
			for (int divisor=1; divisor<=Math.sqrt(n); divisor++) {
				if (n % divisor != 0) {
					continue;
				}
				int quotient = n/divisor;
				if (!sieve[quotient]) {
					maxPrimeFactor = Math.max(maxPrimeFactor, quotient);
				}
				if (!sieve[divisor]) {
					maxPrimeFactor = Math.max(maxPrimeFactor, divisor);
				}
			}
			if (maxPrimeFactor > 0 && maxPrimeFactor <= standard) {
				result++;
			}
		}
		System.out.println(result);
	}

}
