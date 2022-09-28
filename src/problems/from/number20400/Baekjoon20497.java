package problems.from.number20400;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class Baekjoon20497 {
	// 상하좌우
	static int[] dy = {-1, 1, 0, 0};
	static int[] dx = {0, 0, -1, 1};
	static int size;
	
	static int toInt(String s) {
		return Integer.parseInt(s);
	}
	/*
	 * 인덱스가 범위(0 <= index < static int size) 내에 존재하는지 확인  
	 */
	static boolean isInRange(int number) {
		if (number < 0 || size <= number) {
			return false;
		}
		return true;
	}
	/*
	 * 주방 격자의 섬의 개수를 확인(격자를 모두 탐색할때 몇번의 bfs/dfs를 돌아야 하는지 개수를 확인)
	 */
	static int countIsland(char[][] kitchen) {
		int result = 0;
		boolean[][] checked = new boolean[size][size];
		for (int i=0; i<size; i++) {
			for (int j=0; j<size; j++) {
				if (kitchen[i][j] == '@') {
					checked[i][j] = true;
				}
			}
		}
		for (int i=0; i<size; i++) {
			for (int j=0; j<size; j++) {
				if (!checked[i][j]) {
					Coordinate start = new Coordinate(i, j);
					boolean visited[][] = new boolean[size][];
					for (int k=0; k<size; k++) {
						visited[k] = checked[k].clone();
					}
					
					ArrayDeque<Coordinate> queue = new ArrayDeque<>();
					queue.add(start);
					visited[start.y][start.x] = true;
					while (!queue.isEmpty()) {
						Coordinate now = queue.poll();
						
						for (int k=0; k<4; k++) {
							int nextY = now.y + dy[k];
							int nextX = now.x + dx[k];
							if (!isInRange(nextY) || !isInRange(nextX)) {
								continue;
							}
							if (visited[nextY][nextX]) {
								continue;
							}
							
							visited[nextY][nextX] = true;
							queue.add(new Coordinate(nextY, nextX));
						}
					}
					result++;
					for (int k=0; k<size; k++) {
						checked[k] = visited[k].clone();
					}
				}
			}
		}
		
		return result;
	}
	
	public static void main(String[] args) throws IOException {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		
		size = toInt(br.readLine());
		
		char[][] kitchen = new char[size][size];
		
		for (int i=0; i<size; i++) {
			char[] row = br.readLine().toCharArray();
			for (int j=0; j<size; j++) {
				if (row[j] == 'S') {
					kitchen[i][j] = '@';
				} else {
					kitchen[i][j] = row[j];
				}
			}
		}
		// 격자를 막기 전 섬의 개수 확인
		int islandCount = countIsland(kitchen);
		
		int result = 0;
		for (int i=0; i<size; i++) {
			for (int j=0; j<size; j++) {
				if (kitchen[i][j] == '.') {
					kitchen[i][j] = '@';
					int nowIslandCount = countIsland(kitchen);
					// 기존 섬의 개수보다 섬의 개수가 늘었다면, 공간이 분리된 것
					if (islandCount < nowIslandCount) {
						result++;
					}
					kitchen[i][j] = '.';
				}
			}
		}
		System.out.println(result);
	}
}
class Coordinate {
	int y;
	int x;
	Coordinate(int y, int x){
		this.y = y;
		this.x = x;
	}
}

/*
4
@@@@
@@.@
@..@
@@@@

11
@..........
.@.........
..@........
...@.......
....@......
.....@.....
......@....
.......@...
........@..
.........@.
...........

11
...........
...........
...........
...........
...........
...........
...........
...........
...........
...........
...........
 * 
 * 
 */
