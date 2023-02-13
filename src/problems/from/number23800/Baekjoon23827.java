package problems.from.number23800;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Baekjoon23827 {
	static int divisor = (int) 1e9+7;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int numberCount = Integer.parseInt(br.readLine());
		int[] numberArray = new int[numberCount];
		int[] sumArray = new int[numberCount];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i=0; i<numberCount; i++) {
			int inputNumber = Integer.parseInt(st.nextToken());
			numberArray[i] = inputNumber;
			if (i == 0) {
				sumArray[i] = inputNumber;
			} else {
				sumArray[i] = (sumArray[i-1] + inputNumber) % divisor;
			}
		}
		
		long result = 0;
		for (int i=1; i<numberCount; i++) {
			result += ((long)numberArray[numberCount-i] * sumArray[numberCount-i-1]) % divisor;
			result %= divisor;
		}
		System.out.println(result);
	}
}


/*

6
500000 500000 500000 500000 500000 500000



*/