package problems.from.number14700;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon14717 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int first = Integer.parseInt(st.nextToken());
		int second = Integer.parseInt(st.nextToken());
		int[] count = new int[11];
		count[first] += 1;
		count[second] += 1;
		
		int power = first == second ? first + 10 : (first + second) % 10;
		int setCase = 0;
		int winCase = 0;
		for (int i=1; i<=10; i++) {
			for (int j=1; j<=10; j++) {
				count[i] += 1;
				count[j] += 1;
				if (count[i] > 2 || count[j] > 2) {
					count[i] -= 1;
					count[j] -= 1;
					continue;
				}
				count[i] -= 1;
				count[j] -= 1;
				
				int unitCase = i == j ? 2 : (2 - count[i]) * (2 - count[j]);
				
				setCase += unitCase;
				int opponentPower = i == j ? i + 10 : (i + j) % 10;
				if (power > opponentPower) {
					winCase += unitCase;
				}
				
			}
		}
		
		System.out.println(String.format("%.3f",(double)winCase / setCase));
	}

}
