package problems.from.number03200;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon3254 {
	// 상하좌우대각선시계방향으로 총 8방향
	static int[] dx = {0, 0, -1, 1, 1, 1, -1, -1};
	static int[] dy = {1, -1, 0, 0, 1, -1, -1, 1};
	
	static boolean dfs(int[][] board, int y, int x, int direction, int count) {
		if (direction == -1) {
			count = 1;
			for (int i=0; i<8; i++) {
				int nextX = x + dx[i];
				int nextY = y + dy[i];
				if (nextX < 0 || nextY < 0 || nextX > 6 || nextY > 5) {
					continue;
				}
				boolean result = dfs(board, nextY, nextX, i, count++);
				if (result) {
					return result;
				}
			}
			
		} else {
			
		}
		
		return false;
	}
	
	public static void main(String[] args) throws IOException {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		
		int[][] board = new int[6][7];
		int[] lastIndex = new int[7];
		for (int i=0; i<21; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			// 상근, 정인
			int skNumber = Integer.parseInt(st.nextToken());
			
			
			
			int jiNumber = Integer.parseInt(st.nextToken());
		}
	}
}
