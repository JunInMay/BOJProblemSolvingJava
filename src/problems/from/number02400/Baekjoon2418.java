package problems.from.number02400;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baekjoon2418 {
	// 상하좌우 좌상 우상 우하 좌하
	static int[] dY = {-1, 1, 0, 0, -1, -1, 1, 1};
	static int[] dX = {0, 0, -1, 1, -1, 1, 1, -1};
	static long[][][] dp;
	static char[][] board;
	static String goal;
	static int stringLength;
	static int rowCount;
	static int colCount;
	
	static void dfs(int y, int x, int count) {
		if (count == stringLength-1) {
			dp[y][x][count] = 1;
			return;
		}
		long value = 0;
		for (int i=0; i<8; i++) {
			int nextY = y + dY[i];
			int nextX = x + dX[i];
			if (nextY < 0 || nextY >= rowCount || nextX < 0 || nextX >= colCount) {
				continue;
			}
			if (board[nextY][nextX] != goal.charAt(count+1)) {
				continue;
			}
			if (dp[nextY][nextX][count+1] != -1) {
				value += dp[nextY][nextX][count+1];
			} else {
				dfs(nextY, nextX, count+1);
				value += dp[nextY][nextX][count+1];
			}
		}
		dp[y][x][count] = value;
	}

	public static void main(String[] args) throws IOException {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		rowCount = Integer.parseInt(st.nextToken());
		colCount = Integer.parseInt(st.nextToken());
		stringLength = Integer.parseInt(st.nextToken());
		
		board = new char[rowCount][colCount];
		dp = new long[rowCount][colCount][stringLength];
		
		for (int i=0; i<rowCount; i++) {
			String input = br.readLine();
			for (int j=0; j<colCount; j++) {
				board[i][j] = input.charAt(j);
				Arrays.fill(dp[i][j], -1);
			}
		}
		goal = br.readLine();
		
		long result = 0;
		for (int i=0; i<rowCount; i++) {
			for (int j=0; j<colCount; j++) {
				if (board[i][j] == goal.charAt(0)) {
					dfs(i, j, 0);
					if (dp[i][j][0] != -1) {
						result += dp[i][j][0];
					}
				}
			}
		}
		System.out.println(result);

	}

}

/*

3 4 3
TARZ
ZZZZ
ZZZZ
TAR

2 3 2
AAA
AAA
AA


*/