package problems.from.number10400;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon10469 {
	
	static int[] dY = {-1, 1, 0, 0, -1, -1, 1, 1};
	static int[] dX = {0, 0, -1, 1, -1, 1, 1, -1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		boolean[][] board = new boolean[8][8];
		int queenCount = 0;
		
		for (int i = 0; i < 8; i++) {
			char[] line = br.readLine().toCharArray();
			
			for (int j = 0; j < 8; j++) {
				if (line[j] == '*') {
					board[i][j] = true;
					queenCount += 1;
				}
			}
		}
		
		String result = "valid";
		if (queenCount == 8) {
			for (int i = 0; i < 8; i++) {
				for (int j = 0; j < 8; j++) {
					if (board[i][j]) {
						for (int k = 0; k < 8; k++) {
							for (int level = 1; level < 8; level++) {
								int nextY = i + dY[k] * level;
								int nextX = j + dX[k] * level;
								
								if (nextX < 0 || nextX >= board.length || nextY < 0 || nextY >= board.length) {
									break;
								}
								
								if (board[nextY][nextX]) {
									result = "invalid";
									break;
								}
							}
						}
					}
				}
			}
		} else {
			result = "invalid";
		}
		
		System.out.println(result);
	}

}
/*
*.......
..*.....
....*...
......*.
.*......
.......*
.....*..
...*....


*.......
........
........
........
........
........
........
.......*

........
........
.......*
........
....*...
..*.....
........
........

*/