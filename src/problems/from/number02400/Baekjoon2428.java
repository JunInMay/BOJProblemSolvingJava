package problems.from.number02400;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Baekjoon2428 {
	static boolean isCheckable(int base, int target) {
		double standard = (double) base * 0.9;
		if (target >= standard) {
			return true;
		}
		
		return false;
	}
	
	static int binarySearch(Integer[] array, int startIndex, int endIndex) {
		int result = -1;
		int base = array[startIndex-1];
		while (startIndex <= endIndex) {
			int midIndex = (startIndex + endIndex) / 2;
			boolean checkable = isCheckable(base, array[midIndex]);
			if (checkable) {
				startIndex = midIndex + 1;
				result = midIndex;
			} else {
				endIndex = midIndex - 1;
			}
		}
		return result;
	}

	public static void main(String[] args) throws IOException {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		
		int solutionCount = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		Integer[] solutions = new Integer[solutionCount];
		for (int i=0; i<solutionCount; i++) {
			solutions[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(solutions, Collections.reverseOrder());
		
		Long result = 0L;
		for (int i=0; i<solutionCount-1; i++) {
			int checkPoint = binarySearch(solutions, i+1, solutionCount-1);
			result += Math.max(checkPoint - i, 0);
		}
		System.out.println(result);
	}
}

/*
5
100000 90000 91000 85000 70000

5
100000 90000 91000 85000 70000


*/