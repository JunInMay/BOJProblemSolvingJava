package problems.from.number16500;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon16507 {
	static int toInt(String s) {
		return Integer.parseInt(s);
	}
	
	public static void main(String[] args) throws IOException {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int height = toInt(st.nextToken());
		int width = toInt(st.nextToken());
		int rectangleCases = toInt(st.nextToken());
		
		int[][] rectangles = new int[height+1][width+1]; // 1,1 부터 꼭지점까지의 직사각형 case들
		int[][] board = new int[height+1][width+1];
		for (int i=1; i<=height; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j=1; j<=width; j++) {
				board[i][j] = toInt(st.nextToken());
			}
		}
		
		for (int i=1; i<=height; i++) {
			for (int j=1; j<=width; j++) {
				int upRectangle = rectangles[i-1][j];
				int leftRectangle = rectangles[i][j-1];
				int diagonalRectangle = rectangles[i-1][j-1];
				int now = board[i][j];
				/** 1,1 에서 y, x 까지의 직사각형을 구하는 방법
				 * 1. 1,1 ~ y-1, x 까지의 직사각형을 구한다. (upRectangle)
				 * 2. 1,1 ~ y, x-1 까지의 직사각형을 구한다. (leftRectangle)
				 * 3. 중복해서 더해져있는 영역인 1,1 ~ y-1, x-1을 구한다. (diagonalRectangle)
				 * 4. 1과 2를 더한 것에서 3을 뺀다.
				 * 5. 1, 2를 더하고, y, x 좌표의 값(now)을 더한다.
				 */
				rectangles[i][j] = upRectangle + leftRectangle - diagonalRectangle + now;
			}
		}
		
		for (int i=0; i<rectangleCases; i++) {
			st = new StringTokenizer(br.readLine());
			int startY = toInt(st.nextToken());
			int startX = toInt(st.nextToken());
			int endY = toInt(st.nextToken());
			int endX = toInt(st.nextToken());
			int yCount = endY - startY + 1;
			int xCount = endX - startX + 1;
			int count = yCount * xCount;
			
			/** 1,1 에서 y,x까지의 직사각형을 모두 구했을 때, 임의의 지점 sY, sX ~ eY, eX까지의 직사각형을 구하는 법
			 * 임의의 직사각형은 1,1에서 y,x까지의 직사각형에서 각각 모서리의 바깥 영역을 빼서 구할 수 있다.
			 * 각각 모서리의 바깥 영역을 구하고, 그 값을 1,1 ~ y,x 에서 빼주면 된다.
			 * 직사각형 모서리 우측과 하단의 영역은 diagonalCrust
			 * 직사각형 모서리 상단의 영역은 upRectangle
			 * 직사각형 모서리 좌측의 영역은 leftRectangle
			 * 그런데 upRectangle과 leftRectangle에서 중복해서 빼는 부분이 있다.
			 * 중복해서 빼는 부분은 overlappedRectangle
			 * 따라서 직사각형 영역은 base - diagonalCrust - upRectangle - leftRectangle + overlappedRectangle
			 */
			int base = rectangles[height][width];
			int diagonalCrust = base - rectangles[endY][endX];
			int upRectangle = rectangles[startY-1][endX];
			int leftRectangle = rectangles[endY][startX-1];
			int overlappedRectangle = rectangles[startY-1][startX-1];
			int average = (int)(base - diagonalCrust - upRectangle - leftRectangle + overlappedRectangle) / count;
			System.out.println(average);
		}
	}
}
/*
1 1 1
1
1 1 1 1

*/