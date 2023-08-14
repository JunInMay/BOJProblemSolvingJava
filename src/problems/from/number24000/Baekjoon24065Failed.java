package problems.from.number24000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon24065Failed {
	static int result;
	static int rows;
	static int cols;
	
	static int cutOff(int rows, int cols, int leastSize) {
		int remaining = rows;
		
		for (int i=1; i<=cols; i++) {
			int rowRequired = (int) Math.ceil((double) leastSize / i);
			if (rowRequired <= rows) {
				result += ((cols / i) * (rows / rowRequired));
				remaining = rows % rowRequired;
				break;
			}
		}
		
		return remaining;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int caseCount = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		while (caseCount --> 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int fieldSize = Integer.parseInt(st.nextToken()) - 1;
			int leastSize = Integer.parseInt(st.nextToken());
			
			result = 0;
			rows = fieldSize;
			cols = fieldSize;
			
			int remainingRows = rows;
			int remainingCols = cols;
			
			remainingRows = cutOff(remainingRows, remainingCols, leastSize);
			remainingCols = cutOff(remainingRows, remainingCols, leastSize);
			cutOff(remainingRows, remainingCols, leastSize);
			
			sb.append(result).append('\n');
		}
		System.out.print(sb);
	}
}
