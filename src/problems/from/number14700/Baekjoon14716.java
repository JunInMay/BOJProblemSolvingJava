package problems.from.number14700;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Baekjoon14716 {
	static int[] dY = {-1, 1, 0, 0, -1, 1, 1, -1};
	static int[] dX = {0, 0, -1, 1, 1, 1, -1, -1};
	
	static class Node {
		int y, x;
		Node (int y, int x){
			this.y = y;
			this.x = x;
		}
	}

	public static void main(String[] args) throws IOException {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int height = Integer.parseInt(st.nextToken());
		int width = Integer.parseInt(st.nextToken());
		int[][] board = new int[height][width];
		for (int i=0; i<height; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j=0; j<width; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		boolean[][] visited = new boolean[height][width];
		int count = 0;
		for (int y=0; y<height; y++) {
			for (int x=0; x<width; x++) {
				if (!visited[y][x] && board[y][x] == 1) {
					Node start = new Node(y, x);
					visited[y][x] = true;
					ArrayDeque<Node> deque = new ArrayDeque<>();  
					deque.add(start);
					count += 1;
					
					while(!deque.isEmpty()) {
						Node now = deque.poll();
						
						for (int i=0; i<8; i++) {
							int nextY = now.y + dY[i];
							int nextX = now.x + dX[i];
							
							if (nextY < 0 || nextY >= height || nextX < 0 || nextX >= width) {
								continue;
							}
							if (board[nextY][nextX] == 0 || visited[nextY][nextX]) {
								continue;
							}
							
							visited[nextY][nextX] = true;
							deque.add(new Node(nextY, nextX));
						}
					}
				}
			}
		}
		
		System.out.println(count);
		
		

	}

}


/*

4 4
0 0 0 0 
0 1 0 1 
0 1 0 1 
0 1 0 1 

8 13
0 0 0 0 0 0 0 0 0 0 0 0 0
0 1 0 0 0 1 0 1 1 1 1 1 0
0 1 1 0 0 1 0 0 0 1 0 0 0
0 1 0 1 0 1 0 0 0 1 0 0 0
0 1 0 1 0 1 0 0 0 1 0 0 0
0 1 0 0 1 1 0 0 0 1 0 0 0
0 1 0 0 0 1 0 0 0 1 0 0 0
0 0 0 0 0 0 0 0 0 0 0 0 0

8 7
0 0 0 0 0 0 0 
0 1 0 0 0 1 0 
0 1 1 0 0 1 0 
0 1 0 1 0 1 0 
0 1 0 1 0 1 0 
0 1 0 0 1 1 0 
0 1 0 0 0 1 0 
0 0 0 0 0 0 0 

*/