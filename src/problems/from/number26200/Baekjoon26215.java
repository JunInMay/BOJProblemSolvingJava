package problems.from.number26200;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Baekjoon26215 {

	public static void main(String[] args) throws IOException {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		int houseCount = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		Integer[] list = new Integer[houseCount];
		for (int i=0; i<houseCount; i++) {
			list[i] = Integer.parseInt(st.nextToken());
		}
		
		int result = 0;
		while (true) {
			Arrays.sort(list, Collections.reverseOrder());
			int left = list[0];
			if (list.length < 2) {
				result += left;
				break;
			}
			int right = list[1];
			if (left != 0) {
				list[0] = Math.max(0, left-1);
			} else {
				break;
			}
			if (right != 0) {
				list[1] = Math.max(0, right-1);
			}
			result++;
		}
		if (result > 1440) {
			result = -1;
		}
		System.out.println(result);
	}

}

/*
5
9 8 7 6 6

*/