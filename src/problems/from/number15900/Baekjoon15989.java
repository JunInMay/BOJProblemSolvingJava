package problems.from.number15900;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Baekjoon15989 {

	public static void main(String[] args) throws IOException {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		
		int[][] memo = new int[10001][3];
		memo[0][0] = 1;
		for (int i=1; i<=10000; i++) {
			for (int j=1; j<=3; j++) {
				int before = i-j;
				if (before < 0) {
					continue;
				}
				for (int k=0; k<j; k++) {
					memo[i][j-1] += memo[before][k];
				}
			}
		}
		int caseCount = Integer.parseInt(br.readLine());
		while (caseCount-- > 0) {
			int input = Integer.parseInt(br.readLine());
			System.out.println(Arrays.stream(memo[input]).sum());
		}
	}
}
