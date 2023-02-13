package problems.from.number02000;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Baekjoon2078 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int left = Integer.parseInt(st.nextToken());
		int right = Integer.parseInt(st.nextToken());
		int movesLeft = 0;
		int movesRight = 0;
		/* Solution 1 with subtraction */
		/*
		while (left != right) {
			if (left > right) {
				left -= right;
				movesLeft++;
			} else {
				right -= left;
				movesRight++;
			}
		}
		*/
		/* Solution 2 with division */
		while (left != 0 && right != 0) {
			if (left > right) {
				movesLeft += left / right;
				left %= right;
			} else {
				movesRight += right / left;
				right %= left;
			}
			if (left == 0) {
				movesLeft--;
			} else if (right == 0){
				movesRight--;
			}
		}
		System.out.printf("%d %d", movesLeft, movesRight);
	}
}
