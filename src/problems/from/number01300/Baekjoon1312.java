package problems.from.number01300;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.io.InputStreamReader;

public class Baekjoon1312 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int dividend = Integer.parseInt(st.nextToken());
		int divisor = Integer.parseInt(st.nextToken());
		int decimalPoint = Integer.parseInt(st.nextToken());
		
		int result = 0;
		for (int i=0; i<=decimalPoint; i++) {
			int quotient = dividend / divisor;
			int remainder = dividend % divisor;
			dividend = remainder * 10;
			result = quotient;
		}
		System.out.println(result);
	}
}
