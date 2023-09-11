package problems.from.number09200;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon9291 {
	
	static boolean check(int[][] board) {
		
		for (int i = 0; i < 9; i++) {
			boolean[] colCheck = new boolean[10];
			boolean[] rowCheck = new boolean[10];
			boolean[] squareCheck = new boolean[10];
			for (int j = 0; j < 9; j++) {
				int colNumber = board[j][i];
				int rowNumber = board[i][j];
				int squareNumber = board[3 * (i / 3) + j / 3][3 * (i % 3) + j % 3];
				
				if (colCheck[colNumber] || rowCheck[rowNumber] || squareCheck[squareNumber]) {
					return false;
				}
				
				colCheck[colNumber] = true;
				rowCheck[rowNumber] = true;
				squareCheck[squareNumber] = true;
			}
		}
		
		return true;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int caseCount = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int caseIndex = 1; caseIndex <= caseCount; caseIndex++) {
			String result = "CORRECT";
			
			int[][] board = new int[9][9];
			for (int i = 0; i < 9; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < 9; j++) {
					board[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			if (!check(board)) {
				result = "INCORRECT";
			}
			
			sb.append(String.format("Case %d: %s\n", caseIndex, result));
			if (caseIndex != caseCount) {
				br.readLine();
			}
		}
		
		System.out.print(sb);
	}

}
