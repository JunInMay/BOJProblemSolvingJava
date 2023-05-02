package problems.from.number24000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class Baekjoon24039 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int number = Integer.parseInt(br.readLine());
		
		boolean[] sieve = new boolean[200];
		Arrays.fill(sieve, true);
		sieve[0] = false;
		sieve[1] = false;
		
		ArrayList<Integer> primeNumbers = new ArrayList<>();
		for (int i=2; i<sieve.length; i++) {
			for (int j=i*2; j<sieve.length; j+=i) {
				sieve[j] = false;
			}
		}
		for (int i=0; i<sieve.length; i++) {
			if (sieve[i]) {
				primeNumbers.add(i);
			}
		}
		
		for (int i=0; i<primeNumbers.size()-1; i++) {
			int value = primeNumbers.get(i) * primeNumbers.get(i+1);
			if (value > number) {
				System.out.println(value);
				break;
			}
		}
	}

}
