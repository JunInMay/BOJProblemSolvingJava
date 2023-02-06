package problems.from.number01300;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon1347 {
	// 하 좌 상 우
	static int[] dX = {0, -1, 0, 1};
	static int[] dY = {1, 0, -1, 0};

	public static void main(String[] args) throws IOException {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		
		int size = 101;
		char[][] board = new char[size][size];
		
		int inputSize = Integer.parseInt(br.readLine());
		char[] inputString = br.readLine().toCharArray();
		
		int mid = size/2;
		int nowY = mid;
		int nowX = mid;
		int minY = mid;
		int minX = mid;
		int maxY = mid;
		int maxX = mid;
		board[nowY][nowX] = '.';
		int direction = 0;
		for (int i=0; i<inputSize; i++) {
			char nowInput = inputString[i];
			
			switch (nowInput) {
			case 'L':
				direction = (direction-1+4)%4;
				break;
			case 'R':
				direction = (direction+1)%4;
				break;
			case 'F':
				nowY += dY[direction];
				nowX += dX[direction];
				board[nowY][nowX] = '.';
				break;
			}
			minY = Math.min(minY, nowY);
			minX = Math.min(minX, nowX);
			maxY = Math.max(maxY, nowY);
			maxX = Math.max(maxX, nowX);
		}
		StringBuilder sb = new StringBuilder();
		
		for (int y=minY; y<=maxY; y++) {
			for (int x=minX; x<=maxX; x++) {
				if (board[y][x] != '.') {
					sb.append('#');
				} else {
					sb.append('.');
				}
			}
			sb.append('\n');
		}
		System.out.println(sb);
	}

}
/*

50
FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFF


*/