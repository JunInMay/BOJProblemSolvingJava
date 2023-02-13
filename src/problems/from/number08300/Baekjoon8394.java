package problems.from.number08300;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon8394 {

	public static void main(String[] args) throws IOException {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		
		int attendantCount = Integer.parseInt(br.readLine());
		if (attendantCount == 1) {
			System.out.println("0");
			return;
		}
		
		int[] before = {1, 1};
		for (int i=2; i<attendantCount; i++) {
			int notShakings = before[0] + before[1];
			int shakings = before[0];
			before[0] = notShakings % 10;
			before[1] = shakings % 10;
		}
		System.out.println((before[0] + before[1]) % 10);
	}
}
