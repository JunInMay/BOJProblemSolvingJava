package problems.from.number01200;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Baekjoon1261 {
	static int[] dY = {-1, 1, 0, 0};
	static int[] dX = {0, 0, -1, 1};
	
	static class Node {
		int y;
		int x;
		Node (int y, int x) {
			this.y = y;
			this.x = x;
		}
	}

	public static void main(String[] args) throws IOException {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int width = Integer.parseInt(st.nextToken());
		int height = Integer.parseInt(st.nextToken());
		
		char[][] board = new char[height][width];
		for (int i=0; i<height; i++) {
			board[i] = br.readLine().toCharArray();
		}
		int[][] costs = new int[height][width];
		for (int i=0; i<height; i++) {
			for (int j=0; j<width; j++) {
				costs[i][j] = Integer.MAX_VALUE;
			}
		}
		
		ArrayDeque<Node> deque = new ArrayDeque<>();
		deque.add(new Node(0, 0));
		costs[0][0] = 0;
		while (!deque.isEmpty()) {
			Node now = deque.poll();
			
			for (int i=0; i<4; i++) {
				int nextY = now.y + dY[i];
				int nextX = now.x + dX[i];
				
				if (nextY < 0 || nextY >= height || nextX < 0 || nextX >= width) {
					continue;
				}
				
				int cost = 0;
				if (board[nextY][nextX] == '1') {
					cost = 1;
				}
				
				int nextValue = costs[now.y][now.x] + cost;
				if (costs[nextY][nextX] <= nextValue) {
					continue;
				}
				
				costs[nextY][nextX] = nextValue;
				if (cost == 0) {
					deque.addFirst(new Node(nextY, nextX));
				} else {
					deque.add(new Node(nextY, nextX));
				}
			}
		}
		
		System.out.println(costs[height-1][width-1]);
	}

}



/*

4 2
0001
1000

6 6
001111
010000
001111
110001
011010
100010

*/