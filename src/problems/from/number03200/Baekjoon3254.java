package problems.from.number03200;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baekjoon3254 {
	// 상하좌우대각선시계방향으로 총 8방향
	static int[] dx = {0, 0, -1, 1, 1, 1, -1, -1};
	static int[] dy = {1, -1, 0, 0, 1, -1, -1, 1};
	
	static void print(int[][] board) {
		for (int i=0; i<board.length; i++) {
			System.out.println(Arrays.toString(board[i]));
		}
	}
	static boolean dfs(int[][] board, int y, int x, int direction, int count, int target) {
		if (count == 4) {
			return true;
		}
		boolean result = false;
		if (direction == -1) {
			// 방향이 정해지지 않았을 경우 8방향으로 dfs친다.
			count = 1;
			target = board[y][x];
			
			for (int i=0; i<8; i++) {
				int nextX = x + dx[i];
				int nextY = y + dy[i];
				if (nextX < 0 || nextY < 0 || nextX > 6 || nextY > 5) {
					continue;
				}
				if (board[nextY][nextX] == target) {
					result = dfs(board, nextY, nextX, i, count+1, target);
				}
				if (result) {
					return result;
				}
			}
		} else {
			// 방향이 정해질 경우
			int nextX = x + dx[direction];
			int nextY = y + dy[direction];
			if (nextX < 0 || nextY < 0 || nextX > 6 || nextY > 5) {
				return false;
			}
			if (board[nextY][nextX] == target) {
				result = dfs(board, nextY, nextX, direction, count+1, target);
			}
			if (result) {
				return result;
			}
		}
		
		return false;
	}
	
	static boolean discernWinner(int[][] board, int index) {
		boolean result = false;
		for (int y=0; y<6; y++) {
			for (int x=0; x<7; x++) {
				if (board[y][x] != 0) {
					result = dfs(board, y, x, -1, 0, 1);
				}
				if (result == true) {
					String winner = "ji";
					if (board[y][x] == 1) {
						winner = "sk";
					}
					System.out.println(String.format("%s %d", winner, index+1));
					return result;
				}
			}
		}
		return result;
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
			board[lastIndex[skNumber-1]++][skNumber-1] = 1;
			if (discernWinner(board, i)) {
				return;
			}
				
			int jiNumber = Integer.parseInt(st.nextToken());
			board[lastIndex[jiNumber-1]++][jiNumber-1] = -1;
			if (discernWinner(board, i)) {
				return;
			}
		}
		System.out.println("ss");
	}
}
