package problems.from.number01800;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baekjoon1895 {

	public static void main(String[] args) throws IOException {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int rowCount = Integer.parseInt(st.nextToken());
		int colCount = Integer.parseInt(st.nextToken());
		int[][] board = new int[rowCount][colCount];
		for (int i=0; i<rowCount; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j=0; j<colCount; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int standard = Integer.parseInt(br.readLine());
		
		int[] filter = new int[9];
		int result = 0;
		for (int i=0; i<rowCount-2; i++) {
			for (int j=0; j<colCount-2; j++) {
				int filterIndex = 0;
				for (int dY=0; dY<3; dY++) {
					for (int dX=0; dX<3; dX++) {
						filter[filterIndex] = board[i+dY][j+dX];
						filterIndex++;
					}
				}
				Arrays.sort(filter);
				int number = filter[4];
				if (number >=standard) {
					result++;
				}
			}
		}
		System.out.println(result);
	}
}


/*
6 5
49 36 73 62 21
27 88 14 11 12
99 18 36 91 21
45 96 72 12 10
12 48 49 75 56
12 15 48 86 78
40



*/