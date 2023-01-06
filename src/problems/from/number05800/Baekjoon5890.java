package problems.from.number05800;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baekjoon5890 {
	static int fieldSize = 1001;
	static int[] dY = {-1, 1, 0, 0};
	static int[] dX = {0, 0, -1, 1};
	
	static class Node {
		int y, x, cost;
		Node (int y, int x, int c){
			this.y = y;
			this.x = x;
			cost = c;
		}
	}

	public static void main(String[] args) throws IOException {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		StringTokenizer st = new StringTokenizer(br.readLine());

		int baleCount = Integer.parseInt(st.nextToken());
		int startY = Integer.parseInt(st.nextToken())-1;
		int startX = Integer.parseInt(st.nextToken())-1;

		int[][] board = new int[fieldSize][fieldSize];
		int[][] costs = new int[fieldSize][fieldSize];
		while (baleCount-- > 0) {
			st = new StringTokenizer(br.readLine());
			int baleY = Integer.parseInt(st.nextToken())-1;
			int baleX = Integer.parseInt(st.nextToken())-1;
			
			board[baleY][baleX] = 1;
		}
		
		for (int i=0; i<fieldSize; i++) {
			for (int j=0; j<fieldSize; j++) {
				costs[i][j] = Integer.MAX_VALUE;
			}
		}
		costs[startY][startX] = 0;
		
		ArrayDeque<Node> deque = new ArrayDeque<>();
		deque.add(new Node(startY, startX, 0));
		while (!deque.isEmpty()) {
			Node now = deque.poll();
			
			for (int i=0; i<4; i++) {
				int nextY = now.y + dY[i];
				int nextX = now.x + dX[i];
				
				if (nextY < 0 || nextY >= fieldSize || nextX < 0 || nextX >= fieldSize) {
					System.out.println(now.cost);
					return;
				}
				int cost = 0 + board[nextY][nextX];
				int nextCost = now.cost + cost;
				
				if (costs[nextY][nextX] <= nextCost) {
					continue;
				}
				
				costs[nextY][nextX] = nextCost;
				Node nextNode = new Node(nextY, nextX, nextCost);
				if (cost == 1) {
					deque.add(nextNode);
				} else {
					deque.addFirst(nextNode);
				}
			}
		}
	}

}

/*
7 6 3
6 2
5 2
4 3
2 1
7 3
5 4
6 4

10 3 3
1 2
1 3
1 4
1 5
2 2
3 2
3 4
4 2
4 3
4 4

7 2 3
1 1
1 2
1 3
1 4
1 5
2 1
2 5



*/