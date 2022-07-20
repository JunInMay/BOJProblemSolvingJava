package problems.from.number15900;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon_15991 {
	
	public static int toInt(String s) {
		return Integer.parseInt(s);
	}
	
	public static void main(String[] args) throws IOException {
		
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		
		int cases = toInt(br.readLine());
		int[] memoization = new int[100001];
		int modNumber = 1000000009;
		memoization[0] = 0;
		memoization[1] = 1;
		memoization[2] = 2;
		memoization[3] = 4;
		
		for (int i=4; i<100001; i++) {
			for (int j=1; j<4; j++) {
				memoization[i] += memoization[i-j];
			}
		}
		
		for (int i=0; i<cases; i++) {
			int number = toInt(br.readLine());
			int temp = 0;
			for (int j=0; j<4; j++) {
				if ((number-j)%2 == 0) {
					temp += memoization[(number-j)/2];
					temp %= modNumber;
				}
			}
			System.out.println(temp % modNumber);
		}
	}
}
/*
3
4
7
100
*/
