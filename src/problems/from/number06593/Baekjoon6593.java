package problems.from.number06593;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Baekjoon6593 {
	static int toInt(String s) {
		return Integer.parseInt(s);
	}
	
	// 높낮이, 상하좌우 -> 6방향
	static int[] floorDX = {-1, 1, 0, 0, 0, 0};
	static int[] rowDX = {0, 0, -1, 1, 0, 0};
	static int[] colDX = {0, 0, 0, 0, -1, 1};
	
	static boolean isValid(int checkValue, int maxValue) {
		if (checkValue < 0 || maxValue <= checkValue) {
			return false;
		}
		return true;
	}
	
	public static void main(String[] args) throws IOException {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		
		while (true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int floorCount = toInt(st.nextToken());
			int rowCount = toInt(st.nextToken());
			int colCount = toInt(st.nextToken());
			
			if (floorCount == 0) {
				break;
			}
			
			char[][][] building = new char[floorCount][rowCount][colCount];
			boolean[][][] visited = new boolean[floorCount][rowCount][colCount];
			Move startPoint = null;
			
			for (int i=0; i<floorCount; i++) {
				for (int j=0; j<rowCount; j++) {
					char[] row = br.readLine().toCharArray();
					for (int k=0; k<colCount; k++) {
						building[i][j][k] = row[k];
						if (row[k] == 'S') {
							startPoint = new Move(i, j, k, 0);
							visited[i][j][k] = true;
						}
					}
				}
				br.readLine();
			}
			
			ArrayDeque<Move> queue = new ArrayDeque<>();
			queue.add(startPoint);
			int resultMoveCount = 0;
			while (!queue.isEmpty()) {
				Move now = queue.poll();
				int nowFloor = now.floor;
				int nowRow = now.row;
				int nowCol = now.col;
				int nowMoveCount = now.moveCount;
				
				if (building[nowFloor][nowRow][nowCol] == 'E') {
					resultMoveCount = nowMoveCount;
					break;
				}
				
				for (int i=0; i<6; i++) {
					int nextFloor = nowFloor + floorDX[i];
					int nextRow = nowRow + rowDX[i];
					int nextCol = nowCol + colDX[i];
					
					if (!isValid(nextFloor, floorCount) || !isValid(nextRow, rowCount) || !isValid(nextCol, colCount)) {
						continue;
					} else if (visited[nextFloor][nextRow][nextCol]) {
						continue;
					} else if (building[nextFloor][nextRow][nextCol] == '#') {
						continue;
					}
					
					queue.add(new Move(nextFloor, nextRow, nextCol, nowMoveCount+1));
					visited[nextFloor][nextRow][nextCol] = true;
				}
			}
			
			if (resultMoveCount > 0) {
				System.out.println(String.format("Escaped in %d minute(s).", resultMoveCount));
			} else {
				System.out.println("Trapped!");
			}
		}
	}
}
class Move {
	int floor;
	int row;
	int col;
	int moveCount;
	
	public Move(int floor, int row, int col, int moveCount) {
		this.floor = floor;
		this.row = row;
		this.col = col;
		this.moveCount = moveCount;
	}
}


/*
3 4 5
S....
.###.
.##..
###.#

#####
#####
##.##
##...

#####
#####
#.###
####E

0 0 0

 * */
