package problems.from.number10900;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon10994 {
	static void star(char[][] board, int size, int y, int x) {
		if (size == 1) {
			board[y][x] = '*';
			return;
		}
		int limitY = y + 1 + (size-1) * 4;
		int limitX = x + 1 + (size-1) * 4;
		
		char fill = ' ';
		for (int i=y; i<limitY; i++) {
			for (int j=x; j<limitX; j++) {
				if (i == y || i == limitY-1 || j == x || j == limitX-1) {
					fill = '*';
				} else {
					fill = ' ';
				}
				board[i][j] = fill;
			}
		}
		star(board, size-1, y+2, x+2);
	}
	

	public static void main(String[] args) throws IOException {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		
		int number = Integer.parseInt(br.readLine());
		char[][] board = new char[1 + (number-1) * 4][1 + (number-1) * 4];
		star(board, number, 0, 0);
		StringBuilder sb = new StringBuilder();
		
		for (int i=0; i<1 + (number-1) * 4; i++) {
			sb.append(board[i]);
			sb.append('\n');
		}
		System.out.print(sb);
		
	}
}
