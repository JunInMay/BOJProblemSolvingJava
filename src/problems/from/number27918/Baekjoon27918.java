package problems.from.number27918;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon27918 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int gameCount = Integer.parseInt(br.readLine());
		
		int dalguWin = 0;
		int phonixWin = 0;
				
		for (int i = 0; i < gameCount; i++) { 
			String gameResult = br.readLine();
			
			if (gameResult.equals("D")) {
				dalguWin += 1;
			} else {
				phonixWin += 1;
			}
			
			if (Math.abs(dalguWin - phonixWin) >= 2) {
				break;
			}
		}

		System.out.printf("%d:%d\n", dalguWin, phonixWin);
	}

}
