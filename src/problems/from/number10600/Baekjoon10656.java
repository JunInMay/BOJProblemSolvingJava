package problems.from.number10600;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon10656 {
	static char[][] board;
	static boolean verifyVertical(int y, int x) {
		if (board[y][x] == '.') {
			if ((y-1) < 0 || board[y-1][x] == '#') {
				for (int i=1; i<=2; i++) {
					if ((y+i) >= board.length || board[y+i][x] == '#') {
						return false;
					}
				}
				return true;
			}
		}
		return false;
	}
	
	static boolean verifyHorizontal(int y, int x) {
		if (board[y][x] == '.') {
			if ((x-1) < 0 || board[y][x-1] == '#') {
				for (int i=1; i<=2; i++) {
					if ((x+i) >= board[y].length || board[y][x+i] == '#') {
						return false;
					}
				}
				return true;
			}
		}
		return false;
	}

	public static void main(String[] args) throws IOException {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		StringTokenizer st = new StringTokenizer(br.readLine());
		int rowCount = Integer.parseInt(st.nextToken());
		int colCount = Integer.parseInt(st.nextToken());
		
		board = new char[rowCount][colCount];
		for (int i=0; i<rowCount; i++) {
			String input = br.readLine();
			for (int j=0; j<colCount; j++) {
				board[i][j] = input.charAt(j);
			}
		}
		
		// verification per each point
		int result = 0;
		StringBuilder points = new StringBuilder();
		for (int i=0; i<rowCount; i++) {
			for (int j=0; j<colCount; j++) {
				if (verifyVertical(i, j) || verifyHorizontal(i, j)) {
					result++;
					points.append(i+1).append(' ').append(j+1).append('\n');
				}
			}
		}
		System.out.println(result);
		System.out.println(points);
	}
}
