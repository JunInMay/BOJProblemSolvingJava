package problems.from.number03200;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;

public class Baekjoon3288 {
	static HashMap<Character, Integer> rotateMap = new HashMap<>();

	//Math.abs((i % 4))
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		rotateMap.put('U', 0);
		rotateMap.put('L', 1);
		rotateMap.put('D', 2);
		rotateMap.put('R', 3);
		
		int lineCount = Integer.parseInt(br.readLine());
		
		int[][] rotateCounts = new int[lineCount][];
		for (int i=0; i<lineCount; i++) {
			rotateCounts[i] = new int[i+1];
			String input = br.readLine();
			for (int j=0; j<input.length(); j++) {
				rotateCounts[i][j] = rotateMap.get(input.charAt(j));
			}
		}
		
		for (int i=1; i<lineCount; i++) {
			int now = lineCount - (i+1);
			for (int j=0; j<lineCount-i; j++) {
				int rotateCount = rotateCounts[now+1][j] + rotateCounts[now+1][j+1];
//				System.out.println(rotateCount);
				rotateCounts[now][j] = Math.abs((rotateCounts[now][j] + rotateCount) % 4);
			}
		}
		
		for (int[] rc : rotateCounts) {
			System.out.println(Arrays.toString(rc));
		}
		for (int i=0; i<lineCount; i++) {
			for (int j=0; j<i+1; j++) {
				while (rotateCounts[i][j] > 0) {
					System.out.println(String.format("%d %d", lineCount-(i), j+1));
					rotateCounts[i][j]--;
				}
			}
		}
		
	}

}

/*

3
D
DR
LLD

2
R
LD



*/