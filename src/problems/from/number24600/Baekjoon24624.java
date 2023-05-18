package problems.from.number24600;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;


/*
a^n + b^n = c^n 이 되게하는 n이 n>2일 경우엔 없다는데 왜 그런지 모르겠다.
 */
public class Baekjoon24624 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		BigInteger first = new BigInteger(br.readLine());
		BigInteger second = new BigInteger(br.readLine());
		BigInteger third = new BigInteger(br.readLine());
		
		int result = -1;
		if (third.compareTo(first) >= 0 && third.compareTo(second) >= 0) {
			int exponent = 1;
			while (true) {
				first = first.pow(exponent);
				second = second.pow(exponent);
				third = third.pow(exponent);
				
				BigInteger sum = first.add(second);
				if (sum.compareTo(third) == 0) {
					result = exponent;
					break;
				} else if (sum.compareTo(third) == -1) {
					break;
				}
				exponent += 1;
				if (exponent == 3) {
					break;
				}
			}
		}
		System.out.println(result);
	}
}
