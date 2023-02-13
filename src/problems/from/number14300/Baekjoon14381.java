package problems.from.number14300;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon14381 {
	
	static void check(boolean[] checked, int number) {
		while (number > 0) {
			checked[number % 10] = true;
			number /= 10;
		}
	}

	public static void main(String[] args) throws IOException {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		
		int caseCount = Integer.parseInt(br.readLine());
		for (int caseIndex=0; caseIndex<caseCount; caseIndex++) {
			int base = Integer.parseInt(br.readLine());
			int goal = base * 100;
			boolean checked[] = new boolean[10];
			int result = -1;
			for (int i=base; i<=goal; i+=base) {
				if (base == 0) {
					break;
				}
				check(checked, i);
				boolean flag = false;
				for (int j=0; j<10; j++) {
					if (checked[j] == false) {
						flag = true;
					}
				}
				if (flag == false) {
					result = i;
					break;
				}
			}
			String output = "INSOMNIA";
			if (result > 0) {
				output = Integer.toString(result);
			}
			System.out.printf("Case #%d: %s\n", caseIndex+1, output);
		}
	}
}
