package problems.from.number19800;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Baekjoon_19805 {
	
	public static int toInt(String s) {
		return Integer.parseInt(s);
	}
	
	public static void main(String[] args) throws IOException {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		
		int flowerKinds = toInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		Integer[] flowers = new Integer[flowerKinds];
		
		for (int i=0; i<flowerKinds; i++) {
			int flowerCount = toInt(st.nextToken());
			if (flowerCount % 2 == 0) {
				flowerCount -= 1;
			}
			flowers[i] = flowerCount;
		}
		
		Arrays.sort(flowers, Collections.reverseOrder());
		int result = 0;
		
		if (flowerKinds % 2 == 0) {
			flowerKinds -= 1;
		}
		for (int i=0; i<flowerKinds; i++) {
			result += flowers[i];
		}
		System.out.println(result);
	}
}
