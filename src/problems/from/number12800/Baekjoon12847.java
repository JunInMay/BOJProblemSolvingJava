package problems.from.number12800;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon12847 {

	public static void main(String[] args) throws IOException {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int paymentCount = Integer.parseInt(st.nextToken());
		int workday = Integer.parseInt(st.nextToken());
		long[] paymentSum = new long[paymentCount];
		
		st = new StringTokenizer(br.readLine());
		long result = 0;
		for (int i=0; i<paymentCount; i++) {
			long before = 0;
			if (i != 0) {
				before = paymentSum[i-1];
			}
			paymentSum[i] = before + Integer.parseInt(st.nextToken());
			
			long now = paymentSum[i];
			long next = 0;
			int nextIndex = i - workday;
			if (nextIndex >= 0) {
				next = paymentSum[nextIndex];
			}
			result = Math.max(result, now - next);
		}
		System.out.println(result);
	}
}

/*
5 0
10 20 30 20 10

5 2
1000 20 30 40 50

1 1
20
*/
