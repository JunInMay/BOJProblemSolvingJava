package problems.from.number09600;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Baekjoon9657 {
	
	static int toInt(String s) {
		return Integer.parseInt(s);
	}

	public static void main(String[] args) throws IOException {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		
		int number = toInt(br.readLine());
		Boolean[] initialGameResult = {true, false, true, true};
		List<Boolean> temporaryList = Arrays.asList(initialGameResult);
		ArrayList<Boolean> gameResults = new ArrayList<>(temporaryList);
		System.out.println(false || false);
		for (int i=4; i<number+1; i++) {
			Boolean nextResult = !(gameResults.get(i-1)) || !(gameResults.get(i-3)) || !(gameResults.get(i-4));
			if (i == 7) {
				System.out.println((gameResults.get(i-1)));
				System.out.println((gameResults.get(i-3)));
				System.out.println((gameResults.get(i-4)));
			}
			System.out.println((i+1)+ " : " + nextResult);
			gameResults.add(!nextResult);
		}
		String winner = "CY";
		if (gameResults.get(number-1)) {
			winner = "SK";
		}
		System.out.println(winner);
	}
}
