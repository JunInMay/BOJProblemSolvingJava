package problems.from.number12100;
/*
 * 브루트포스가 아닌, 그리디를 썼으나 실패
 * 1. 빈 방의 개수를 받고 빈 방의 개수만큼 빈방이 만들어질 때 까지 반복
 * 2. 각 방마다 만나는 벽을 4개부터 시작해서 1개까지 줄여나가며 인접한 벽을 가장 많이 줄일 수 있는 경우만을 골라서 빈 방으로 만듦
 * 최적의 해가 아닌듯 함
 * 
 * -after fail-
 * 이리저리 예시를 들어보니 (R*C)/2 < N일 경우 결과를 0으로 만들 수 있음
 * 따라서 대충 (R*C)/2 >= N일 때만 신경써줘도 됨 그 이후론 결과가 0이기 때문
 * 그 후 엑셀로 표를 그려봤는데, 2체크 ( 2번째 칸부터 체크 )일 경우 최적의 해가 나올 수도 있음을 깨달음 
 * 또 대부분 내가 생각했던 그리디로 결과가 최적이 나옴
 * 그러나 예시로 5 3 9 입력일 때 그리디로 최적의 결과가 나오지 않음
 * 5 3 9일 땐 2번째 칸 부터 체크를 치면 3이라는 결과가 나오고, 그리디론 4가 나옴
 * 따라서 2체크(왼쪽 상단부터 우측 하단까지 센다고 쳤을 때 2번째 칸, 즉 building[0][1] 부터 1칸씩 체크 무늬로 빈 공간을 채우는 방식)일 때 결과와
 * 그리디의 결과를 비교해서 더 최적의(값이 낮은) 결과를 답으로 삼음
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