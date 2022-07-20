package problems.from.number15900;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.Arrays;

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
		int[] dx = {2, 4, 6};
		
		memoization[0] = 1;
		memoization[1] = 1;
		memoization[2] = 2;
		memoization[3] = 2;
		
		for (int i=4; i<100001; i++) {
			for (int j=0; j<dx.length; j++) {
				if (i-dx[j] >= 0) {
					memoization[i] = (memoization[i] + memoization[i-dx[j]]) % modNumber;
				}
			}
		}
		
		for (int i=0; i<cases; i++) {
			int number = toInt(br.readLine());
			System.out.println(memoization[number]);
			
		}
	}
}
/*
3
4
7
100

6
1
2
3
4
5
6
*/
