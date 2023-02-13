package problems.from.number17800;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon17847 {
	// Diamond : 우상 우하 좌하 좌상
	static int[] dY = {-1, 1, 1, -1};
	static int[] dX = {1, 1, -1, -1};
	static boolean[][] visited;
	static char[][] board;
	static int midPoint;
	static int size;
	static StringBuilder sb;
	
	static void lineAppend(int startY, int startX, int dY, int dX, int iteration) {
		int nowY = startY;
		int nowX = startX;
		iteration = Math.max(1,  iteration);
		for (int i=0; i<iteration; i++) {
			if (visited[nowY][nowX]) {
				break;
			}
			visited[nowY][nowX] = true;
			sb.append(board[nowY][nowX]);
			
			nowY += dY;
			nowX += dX;
		}
	}

	static void seekDiamondDepth(int depth) {
		int startY = midPoint;
		int startX = depth;
		// 우상 우하 좌하 좌상 탐색
		for (int i=0; i<4; i++) {
			lineAppend(startY, startX, dY[i], dX[i], midPoint - depth);
			startY += dY[i] * (midPoint - depth);
			startX += dX[i] * (midPoint - depth);
		}
	}

	public static void main(String[] args) throws IOException {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		String inputString = br.readLine();
		size = (int) Math.sqrt((double) inputString.length());
		sb = new StringBuilder();
		visited = new boolean[size][size];
		board = new char[size][size];
		midPoint = size / 2;
		
		int stringIndex = 0 ;
		for (int i=0; i<size; i++) {
			for (int j=0; j<size; j++) {
				board[i][j] = inputString.charAt(stringIndex);
				stringIndex++;
			}
		}
		
		for (int i=0; i<midPoint+1; i++) {
			seekDiamondDepth(i);
		}
		System.out.println(sb.toString());
		
	}
}


/*
THEESEARENSRNTAEDNCACGEEWNHLTEKOITUALNCSLYRANODOM

WHAETHERENSRALLEENCAYGTELIHLKAKEITSARHCSEBIGMOACS

JOMHNPARTAILUUHLASERINWGO
 * */
