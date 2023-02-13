package problems.from.number02200;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Baekjoon2293 {

	public static void main(String[] args) throws IOException {
 		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		StringTokenizer st = new StringTokenizer(br.readLine());

		int coinCount = Integer.parseInt(st.nextToken());
		int goal = Integer.parseInt(st.nextToken());
		
		int[] cases = new int[goal+1];
		cases[0] = 1;
		ArrayList<Integer> coins = new ArrayList<>();
		while(coinCount-- > 0) {
			coins.add(Integer.parseInt(br.readLine()));
		}
		Collections.sort(coins);
		
		for (int coin : coins) {
			for (int i=0; i<=goal; i++) {
				int nextIndex = i - coin;
				if (nextIndex < 0) {
					continue;
				}
				
				cases[i] += cases[nextIndex];
			}
		}
		System.out.println(cases[goal]);
	}
}
