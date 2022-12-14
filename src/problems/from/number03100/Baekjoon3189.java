package problems.from.number03100;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Baekjoon3189 {
	
	static boolean isSuffixOf(int base, int suffix) {
		int divisor = Math.max(10, (int) Math.pow(10, (int) Math.log10(suffix*10)));
		if (base % divisor == suffix % divisor) {
			return true;
		}
		return false;
	}

	public static void main(String[] args) throws IOException {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		StringTokenizer st = new StringTokenizer(br.readLine());
		int multiplicand = Integer.parseInt(st.nextToken());
		int multiplier = Integer.parseInt(st.nextToken());
		int suffix = Integer.parseInt(st.nextToken());
		
		HashMap<Integer, Boolean> isExist = new HashMap<>();
		int multipliedResult = multiplicand;
		int result = 0;
		while(true) {
			multipliedResult = (multipliedResult * multiplier) % 1000000;
			result++;
			if (isSuffixOf(multipliedResult, suffix)) {
				// 맞음
				System.out.println(result);
				break;
			}
			if (isExist.getOrDefault(multipliedResult, false)) {
				// 틀림
				System.out.println("NIKAD");
				break;
			}
			isExist.put(multipliedResult, true);
		}
	}

}

/*
2 3 4
3

1 2 3
NIKAD

5 3 215
5

*/