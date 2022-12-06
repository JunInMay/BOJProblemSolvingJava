package problems.from.number22700;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Baekjoon22788 {
	static int getDigitalRoot(int number) {
		int result = 0;
		while (number != 0) {
			result += number % 10;
			number /= 10;
		}
		return result;
	}

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		boolean[] sieve = new boolean[1000000];
		sieve[0] = true;
		sieve[1] = true;
		for (int i=2; i<sieve.length; i++) {
			for (int j=i+i; j<sieve.length; j+=i) {
				sieve[j] = true;
			}
		}
		
		while(true) {
			StringBuilder sb = new StringBuilder();
			int number = Integer.parseInt(br.readLine());
			sb.append(String.format("%7d ", number));
			
			if (number == 0) {
				break;
			}
			
			if (!sieve[number]) {
				sb.append(String.format("%7d", number));
				System.out.println(sb);
				continue;
			}
			String result = "none";
			while(number > 10) {
				number = getDigitalRoot(number);
				if (!sieve[number]) {
					result = Integer.toString(number);
					break;
				}
			}
			sb.append(String.format("%7s", result));
			System.out.println(sb);
		}
	}
}
