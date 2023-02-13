package problems.from.number01400;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baekjoon1405 {
	static int[] movePercentages = new int[4];
	static int moveCount; // 최대 14번 움직임
	static boolean[][] visited = new boolean[29][29]; // 14 + 중점(1) + 14 = 29
	static double[][] failPercentages = new double[29][29];
	// 동서남북
	static int[] dY = {0, 0, 1, -1};
	static int[] dX = {1, -1, 0, 0};
	
	
	static void dfs(int y, int x, double percentage, int count) {
		if (count == moveCount) {
			return;
		}
		for (int i=0; i<4; i++) {
			int nextY = y + dY[i];
			int nextX = x + dX[i];
			if (visited[nextY][nextX]) {
				failPercentages[nextY][nextX] += percentage * (movePercentages[i]/100d);
				continue;
			}
			visited[nextY][nextX] = true;
			dfs(nextY, nextX, percentage * (movePercentages[i]/100d), count+1);
			visited[nextY][nextX] = false;
		}
	}
	
	public static void main(String[] args) throws IOException {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		StringTokenizer st = new StringTokenizer(br.readLine());
		moveCount = Integer.parseInt(st.nextToken());
		
		for (int i=0; i<4; i++) {
			movePercentages[i] = Integer.parseInt(st.nextToken());
		}
		
		visited[14][14] = true;
		dfs(14, 14, 1, 0);
		
		double percentage = 0d;
		for (int i=0; i<29; i++) {
			for (int j=0; j<29; j++) {
				percentage += failPercentages[i][j];
			}
			System.out.println(Arrays.toString(failPercentages[i]));
		}
		System.out.println("p : " + percentage);
		System.out.println(new BigDecimal(1 - percentage));
		
	}

}
