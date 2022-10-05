package problems.from.number01700;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Iterator;

public class Baekjoon1743 {
	static int[] dY = {-1, 1, 0, 0};
	static int[] dX = {0, 0, -1, 1};
	
	static int toInt(String s) {
		return Integer.parseInt(s);
	}

	public static void main(String[] args) throws IOException {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		String metaText = br.readLine();
		String[] splittedMetaText = metaText.split(" ");
		int rowSize = toInt(splittedMetaText[0]);
		int colSize = toInt(splittedMetaText[1]);
		int foodWasteCount = toInt(splittedMetaText[2]);
		
		boolean[][] corridor = new boolean[rowSize][colSize]; 
		
		for (int times=0; times<foodWasteCount; times++) {
			String inputCoordinate = br.readLine();
			String[] splittedCoordinate = inputCoordinate.split(" ");
			int y = toInt(splittedCoordinate[0]) - 1;
			int x = toInt(splittedCoordinate[1]) - 1;
			
			corridor[y][x] = true;
		}
		
		boolean[][] visited = new boolean[rowSize][colSize];
		int maxWaste = 0;
		for (int startY=0; startY<rowSize; startY++) {
			for (int startX=0; startX<colSize; startX++) {
				if (!visited[startY][startX] && corridor[startY][startX]) {
					int wasteSize = 0;
					ArrayDeque<Coordinate> queue = new ArrayDeque<>();
					queue.add(new Coordinate(startY, startX));
					while (!queue.isEmpty()) {
						Coordinate now = queue.poll();
						int nowY = now.y;
						int nowX = now.x;
						
						for (int directionIndex=0; directionIndex<4; directionIndex++) {
							int nextY = nowY + dY[directionIndex];
							int nextX = nowX + dX[directionIndex];
							
							if (nextY < 0 || rowSize <= nextY || nextX < 0 || colSize <= nextX) {
								continue;
							}
							if (visited[nextY][nextX]) {
								continue;
							}
							if (!corridor[nextY][nextX]) {
								continue;
							}
							
							queue.add(new Coordinate(nextY, nextX));
							visited[nextY][nextX] = true;
							wasteSize++;
						}
					}
					maxWaste = Math.max(maxWaste, wasteSize);
				}
			}
		}
		
		System.out.println(maxWaste);
	}
}

class Coordinate {
	int y;
	int x;
	Coordinate(int y, int x) {
		this.y = y;
		this.x = x;
	}
}