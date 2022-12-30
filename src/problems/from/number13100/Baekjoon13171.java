package problems.from.number13100;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon13171 {
	static long divisor = (long) 1E9+7;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		long A = Long.parseLong(br.readLine());
		long X = Long.parseLong(br.readLine());
		
		long[] multiplies = new long[64];
		multiplies[0] = A;
		for (int i=1; i<64; i++) {
			multiplies[i] = (multiplies[i-1] * multiplies[i-1]) % divisor; 
		}
		
		long result = 1;
		int index = 0;
		while (true) {
			result *= Math.max(1, (X % 2) * multiplies[index]);
			result %= divisor;
			X = X/2;
			if (X == 0) {
				break;
			}
			index++;
		}
		System.out.println(result);
		
	}
	
}
/*

1000000000000000000
1000000000000000000

*/