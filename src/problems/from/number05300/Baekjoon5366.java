package problems.from.number05300;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;

public class Baekjoon5366 {

	public static void main(String[] args) throws IOException {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		
		ArrayList<String> nameOrder = new ArrayList<>();
		HashMap<String, Integer> killCount = new HashMap<>();
		
		int sum = 0;
		while (true) {
			String input = br.readLine();
			if (input.equals("0")) {
				break;
			}
			if (!killCount.containsKey(input)) {
				killCount.put(input, 1);
				nameOrder.add(input);
			} else {
				killCount.put(input, killCount.get(input)+1);
			}
			sum++;
		}
		
		for (String key : nameOrder) {
			System.out.printf("%s: %d\n", key, killCount.get(key));
		}
		System.out.printf("%s: %d\n", "Grand Total", sum);
	}

}
