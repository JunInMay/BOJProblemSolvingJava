package problems.from.number04300;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon4309 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int caseCount = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (;caseCount > 0; caseCount--) {
			String input = br.readLine();
			char[] chars = input.toCharArray();
			int length = chars.length;
			
			int extra = 0;
			int count = 0;
			boolean isImpossible = false;;
			for (int i = 0; i < length / 2; i++) {
				int j;
				for (j = length - i - (extra == 0 ? 1 : 0); j > i && chars[i] != chars[j]; j--) {};
				
				if (i == j) {
					if (extra != 0 || length % 2 == 1) {
						isImpossible = true;
						break;
					}
					
					extra = length / 2 - i;
					continue;
				}
				
				for (;j < length - i - (extra == 0 ? 1 : 0); j++) {
					char temp = chars[j];
					chars[j] = chars[j+1];
					chars[j+1] = temp;
					count++;
				}
			}

			String result = "Impossible";
			if (!isImpossible) {
				result = count + extra + "";
			}
			sb.append(result).append('\n');
		}
		System.out.print(sb);
	}
}
