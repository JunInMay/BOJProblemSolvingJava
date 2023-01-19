package problems.from.number08800;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Baekjoon8816 {
	static int[] results = new int[500001];

	public static void main(String[] args) throws IOException {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		
		int caseCount = Integer.parseInt(br.readLine());
		
		results[1] = 1;
		for (int i=4; i<=1000000; i+=2) {
			results[i/2] = (results[(i-2)/2] * (i-1)) % 1000;
		}
		while (caseCount-- > 0) {
			int inputNumber = Integer.parseInt(br.readLine());
			System.out.println(results[inputNumber/2]);
		}
	}

}
