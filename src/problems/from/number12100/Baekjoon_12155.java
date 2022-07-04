package problems.from.number12100;
/*
 * ���Ʈ������ �ƴ�, �׸��� ������ ����
 * 1. �� ���� ������ �ް� �� ���� ������ŭ ����� ������� �� ���� �ݺ�
 * 2. �� �渶�� ������ ���� 4������ �����ؼ� 1������ �ٿ������� ������ ���� ���� ���� ���� �� �ִ� ��츸�� ��� �� ������ ����
 * ������ �ذ� �ƴѵ� ��
 * 
 * -after fail-
 * �̸����� ���ø� ���� (R*C)/2 < N�� ��� ����� 0���� ���� �� ����
 * ���� ���� (R*C)/2 >= N�� ���� �Ű���൵ �� �� ���ķ� ����� 0�̱� ����
 * �� �� ������ ǥ�� �׷��ôµ�, 2üũ ( 2��° ĭ���� üũ )�� ��� ������ �ذ� ���� ���� ������ ������ 
 * �� ��κ� ���� �����ߴ� �׸���� ����� ������ ����
 * �׷��� ���÷� 5 3 9 �Է��� �� �׸���� ������ ����� ������ ����
 * 5 3 9�� �� 2��° ĭ ���� üũ�� ġ�� 3�̶�� ����� ������, �׸���� 4�� ����
 * ���� 2üũ(���� ��ܺ��� ���� �ϴܱ��� ���ٰ� ���� �� 2��° ĭ, �� building[0][1] ���� 1ĭ�� üũ ���̷� �� ������ ä��� ���)�� �� �����
 * �׸����� ����� ���ؼ� �� ������(���� ����) ����� ������ ����
 * -> Solved(but long code)
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baekjoon_12155 {
	static int remainingSpaces;
	static int R, C, N;
	static boolean[][] building;
	static int[] dCols = {0, 0, -1, 1};
	static int[] dRows = {-1, 1, 0, 0};
	
	
	static int toInt(String s) {
		return Integer.parseInt(s);
	}
	
	static void initializeBuilding(){
		building = new boolean[R][C];
		int row = building.length;
		int col = building[0].length;
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				building[i][j] = true;
			}
		}
	}
	
	static void fillWithGreedy(){
		for (int meetingWalls = 4; meetingWalls > 0; meetingWalls--) {
			for (int row = 0; row < R; row++) {
				for (int col = 0; col < C; col++) {
					if (remainingSpaces > 0) {
						if (checkWallCount(row, col) == meetingWalls && building[row][col]) {
							building[row][col] = false;
							remainingSpaces--;
						}
					}
				}
			}
		}
	}
	
	static void fillWithCheck(boolean skip) {
		for (int row = 0; row < R; row++) {
			for (int col = 0; col < C; col++) {
				if (remainingSpaces > 0) {
					if (!skip) {
						skip = true;
						continue;
					} else {
						building[row][col] = false;
						skip = false;
						remainingSpaces--;
					}
				}
			}
		}
	}
	
	static int countSharedWall() {
		int nextRow, nextCol;
		int sharedWallCount = 0;
		for (int row = 0; row < R; row++) {
			for (int col = 0; col < C; col++) {
				if (building[row][col]) {
					nextRow = row - 1;
					nextCol = col + 1;
					if (!(nextRow < 0 || R <= nextRow)) {
						if (building[nextRow][col]) {
							sharedWallCount++;
						}
					}
					if (!(nextCol < 0 || C <= nextCol)) {
						if (building[row][nextCol]) {
							sharedWallCount++;
						}
					}
				}
			}
		}
		return sharedWallCount;
	}
	
	static int checkWallCount(int row, int col) {
		int result = 0;
		int nextRow, nextCol;
		
		for (int i = 0; i < 4; i++) {
			nextRow = row + dRows[i];
			nextCol = col + dCols[i];
			if ((nextRow < 0 || R <= nextRow) || (nextCol < 0 || C <= nextCol)) {
				continue;
			}
			if (building[nextRow][nextCol]) {
				result++;
			}
		}
		
		return result;
	}

	public static void main(String[] args) throws IOException {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		int cases = toInt(br.readLine());
		
		for (int i = 0; i < cases; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int greedyResult = 0;
			int checkTwoResult = 0;
			R = toInt(st.nextToken());
			C = toInt(st.nextToken());
			N = toInt(st.nextToken());
			initializeBuilding();
			remainingSpaces = R*C - N;
			fillWithGreedy();
			greedyResult = countSharedWall();
			
			initializeBuilding();
			remainingSpaces = R*C - N;
			fillWithCheck(false);
			checkTwoResult = countSharedWall();
			
			System.out.println(String.format("Case #%d: %d", i+1, Math.min(greedyResult, checkTwoResult)));
		}
	}
}

/*
3
3 5 9
3 5 10
3 5 11

1
3 5 11

*/