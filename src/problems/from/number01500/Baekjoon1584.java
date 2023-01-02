package problems.from.number01500;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baekjoon1584 {
	static final int size = 501;
	static int[] dY = {-1, 1, 0, 0};
	static int[] dX = {0, 0, -1, 1};
	
	static void drawGraph(BufferedReader br, Character[][] board, int inputCount, char fill) throws IOException {
		while (inputCount-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			
			int startX = Math.min(x1, x2);
			int startY = Math.min(y1, y2);
			int endX = Math.max(x1, x2);
			int endY = Math.max(y1, y2);
			
			for (int y=startY; y<=endY; y++) {
				for (int x=startX; x<=endX; x++) {
					board[y][x] = fill;
				}
			}
			
		}
	}
	static <T> void intializeGraph(T[][] board, T fill){
		for (int i=0; i<board.length; i++) {
			for (int j=0; j<board.length; j++) {
				board[i][j] = fill;
			}
		}
	}

	public static void main(String[] args) throws IOException {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);

		Character[][] board = new Character[size][size];
		intializeGraph(board, '.');
		Integer[][] costs = new Integer[size][size];
		intializeGraph(costs, Integer.MAX_VALUE);
		boolean[][] visited = new boolean[size][size];
		int dangerCount = Integer.parseInt(br.readLine());
		drawGraph(br, board, dangerCount, 'd');
		
		int deadlyCount = Integer.parseInt(br.readLine());
		drawGraph(br, board, deadlyCount, 'f');
		
		ArrayDeque<Node> deque = new ArrayDeque<>();
		deque.add(new Node(0, 0, 0));
		while (!deque.isEmpty()) {
			Node now = deque.poll();
			
			for (int i=0; i<4; i++) {
				int nextY = now.y + dY[i];
				int nextX = now.x + dX[i];
				
				if (nextY < 0 || nextY >= size || nextX < 0 || nextX >= size) {
					continue;
				}
				if (board[nextY][nextX] == 'f') {
					continue;
				}
				int presentPrice = costs[nextY][nextX];
				
				int cost = 0;
				if (board[nextY][nextX] == 'd') {
					cost = 1;
				}
				int futurePrice = now.distance + cost;
				if (futurePrice < presentPrice) {
					costs[nextY][nextX] = futurePrice;
				} else {
					continue;
				}
				if (cost == 0) {
					deque.addFirst(new Node(nextY, nextX, futurePrice));
				} else {
					deque.add(new Node(nextY, nextX, futurePrice));
				}
				visited[nextY][nextX] = true;
			}
		}
//		for (Integer[] line : costs) {
//			System.out.println(Arrays.toString(line));
//		}
		int result = costs[size-1][size-1];
		if (result == Integer.MAX_VALUE) {
			result = -1;
		}
		System.out.println(result);
	}

}

class Node {
	int y;
	int x;
	int distance;
	Node (int y, int x, int d) {
		this.y = y;
		this.x = x;
		distance = d;
	}
}

/*

1
0 0 10 8
1
2 2 3 3

1
500 0 0 500
1
0 0 0 0

2
0 0 250 250
250 250 500 500
2
0 251 249 500
251 0 500 249



*/