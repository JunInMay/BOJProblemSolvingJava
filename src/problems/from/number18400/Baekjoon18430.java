package problems.from.number18400;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 *
 * 입력값이 5x5로 매우 적어 백트래킹 + dfs로 부메랑 만드는 모든 경우의 수를 구해서 가장 best한 부메랑 값들의 합을 출력함 
 */
public class Baekjoon18430 {
	static int[][] board;
	static boolean[][] visited;
	static int rowCount;
	static int colCount;
	static int[] dY = {-1, -1, 1, 1};
	static int[] dX = {-1, 1, 1, -1};
	static int maxValue = 0;
	
	static void dfs(int y, int x, int now) {
		for (int i=0; i<4; i++) {
			int aY = y+dY[i];
			int aX = x;
			int bY = y;
			int bX = x+dX[i];
			if (aY < 0 || aY >= rowCount || aX < 0 || aX >= colCount
					|| bY < 0 || bY >= rowCount || bX < 0 || bX >= colCount) {
				continue;
			}
			if (visited[aY][aX] || visited[bY][bX]) {
				continue;
			}
			int boomerang = now + (board[y][x] * 2) + board[aY][aX] + board[bY][bX];
			maxValue = Math.max(maxValue, boomerang);
			
			visited[aY][aX] = true;
			visited[bY][bX] = true;
			for (int r=y; r<rowCount; r++) {
				for (int c=(y == r) ? x : 0; c<colCount; c++) {
					if (visited[r][c]) {
						continue;
					}
					visited[r][c] = true;
					dfs(r, c, boomerang);
					visited[r][c] = false;
				}
			}
			visited[aY][aX] = false;
			visited[bY][bX] = false;
		}
	}

	public static void main(String[] args) throws IOException {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		rowCount = Integer.parseInt(st.nextToken());
		colCount = Integer.parseInt(st.nextToken());
		board = new int[rowCount][colCount];
		visited = new boolean[rowCount][colCount];
		
		for (int i=0; i<rowCount; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j=0; j<colCount; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for (int i=0; i<rowCount; i++) {
			for (int j=0; j<colCount; j++) {
				visited[i][j] = true;
				dfs(i, j, 0);
				visited[i][j] = false;
			}
		}
		System.out.println(maxValue);
	}

}

/*

2 3
7 5 4
3 2 9

2 3
4 3 1
1 1 1

2 3
1 1 1
1 3 4

5 5
3 4 5 6 7
7 6 5 4 3
10 11 12 13 45
77 66 55 44 22
1 3 1 2 4

*/