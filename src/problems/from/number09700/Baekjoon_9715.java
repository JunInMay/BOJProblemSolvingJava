package problems.from.number09700;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon_9715 {
	static int[][] board;
	static InputStreamReader isr;
	static BufferedReader br;
	static StringTokenizer st;
	
	public static int toInt(String s) {
		return Integer.parseInt(s);
	}
	
	public static int[][] initializeBoard(int rows, int cols) throws IOException{
		int[][] result = new int[rows][cols];
		for (int i = 0; i < rows; i++) {
			String[] inputText = br.readLine().split("");
			for (int j = 0; j < cols; j++) {
				result[i][j] = toInt(inputText[j]);
			}
		}
		
		return result;
	}
	
	public static int sideScan(int[] line) {
		int count = 0;
		int before = 0;
		int now = 0;
		for (int i = 0; i < line.length; i++) {
			now = line[i];
			if (now > before) {
				count += now-before;
			} else if (now < before) {
				count += before-now;
			}
			before = now;
		}
		count += now;
		
		return count;
	}
	
	public static int boardScan(int rows, int cols) {
		int count = 0;
		for (int r = 0; r < rows; r++) {
			for (int c = 0; c < cols; c++) {
				if (board[r][c] > 0) {
					count++;
				}
			}
		}
		
		return count;
	}
	
	public static int getResult(int rows, int cols) {
		int result = 0;
		
		for (int r = 0; r < rows; r++) {
			int[] horizontalLine = board[r];
			result += sideScan(horizontalLine);
		}
		for (int c = 0; c < cols; c++) {
			int[] verticalLine = new int[rows];
			for (int r = 0; r < rows; r++) {
				verticalLine[r] = board[r][c];
			}
			result += sideScan(verticalLine);
		}
		result += boardScan(rows, cols) * 2;
		
		return result;
	}

	public static void main(String[] args) throws IOException {
		isr = new InputStreamReader(System.in);
		br = new BufferedReader(isr);

		int caseCount = toInt(br.readLine());
		int rowCount, colCount;
		for (int i = 0; i < caseCount; i++) {
			st = new StringTokenizer(br.readLine());
			rowCount = toInt(st.nextToken());
			colCount = toInt(st.nextToken());
			board = initializeBoard(rowCount, colCount);
			System.out.println(getResult(rowCount, colCount));
		}
	}
}
/*
 *
4
1 2
113
1
*/