package problems.from.number08600;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

/*
 * 메모리 초과 문제로 실패...
 * 대체 어떻게 하면 여기서 메모리를 줄일 수 있는 것일까?
 * Node 라는 객체를 안쓰고 싶은데, 방법이 있을까?
 * 
 */
public class Baekjoon8687Failed {
	// 우상하
	static int[] dY = {0, -1, 1};
	static int[] dX = {1, 0, 0};
	
//	static void initialize(boolean[][] visited, int[][] costs) {
//		for (int i=0; i<visited.length; i++) {
//			for (int j=0; j<visited[i].length; j++) {
//				costs[i][j] = Integer.MAX_VALUE;
//				visited[i][j] = false;
//			}
//		}
//	}
	static void initialize(boolean[][] visited) {
		for (int i=0; i<visited.length; i++) {
			for (int j=0; j<visited[i].length; j++) {
				visited[i][j] = false;
			}
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
//		int[][] costs = new int[height][width];
		int min = Integer.MAX_VALUE;
		for (int start=0; start<height; start++) {
			if (board[start][0] == 1) {
				continue;
			}
			
			initialize(visited);
			ArrayDeque<Node> deque = new ArrayDeque<>();
			deque.add(new Node(start, 0, 0));
//			costs[start][0] = 0;
			while (!deque.isEmpty()) {
				Node now = deque.poll();
				int nowY = now.y;
				int nowX = now.x;
				int nowCost = now.cost;
				visited[nowY][nowX] = true;
				if (nowX == width-1) {
					min = Math.min(min, nowCost);
				}
				
				for (int i=0; i<3; i++) {
					int nextY = nowY + dY[i];
					int nextX = nowX + dX[i];
					if (nextY < 0 || nextY >= height || nextX < 0 || nextX >= width) {
						continue;
					}
					if (visited[nextY][nextX] || board[nextY][nextX] == 1) {
						continue;
					}
					int cost = 1;
					if (i == 0) {
						cost = 0;
					}
//					if (costs[nowY][nowX] + cost < costs[nextY][nextX]) {
//						costs[nextY][nextX] = costs[nowY][nowX] + cost;
//					}
//					if (nowCost + cost <  ) {
//						
//					}
					
					if (cost == 1) {
						deque.add(new Node(nextY, nextX, nowCost + cost));
					} else {
						deque.addFirst(new Node(nextY, nextX, nowCost + cost));
					}
				}
			}
//			for (int[] cost : costs) {
//				min = Math.min(cost[width-1], min);
//			}
		}
		
		String result = Integer.toString(min);
		if (min == Integer.MAX_VALUE) {
			result = "NIE";
		}
		System.out.println(result);
		
	}
}

class Node {
	int y;
	int x;
	int cost;
	Node (int y, int x, int cost){
		this.y = y;
		this.x = x;
		this.cost = cost;
	}
}

/*


4 5
0 0 0 1 0
0 1 0 1 0
1 1 0 0 0
0 0 1 0 1

4 5
0 0 0 1 1
1 1 0 0 0
1 1 0 1 1
0 0 0 0 0

2 2
1 1
1 1

2 4
1 0 1 1
0 0 0 1

5 5
0 0 0 1 1
1 1 0 1 1
1 0 0 1 1
1 0 1 1 1
1 0 0 0 0

7 5
0 0 0 1 1
1 1 1 1 1
1 0 0 0 1
1 0 1 0 0
1 0 0 0 1
1 1 0 1 1
0 0 0 1 1

*/