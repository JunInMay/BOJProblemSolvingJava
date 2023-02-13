package problems.from.number10200;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Baekjoon10295 {
	// 상하좌우 우상 우하 좌하 좌상
	static int[] dY = {-1, 1, 0, 0, -1, 1, 1, -1};
	static int[] dX = {0, 0, -1, 1, 1, 1, -1, -1};
	
	static class Node {
		int y, x, cost;
		
		Node (int y, int x, int c) {
			this.y = y;
			this.x = x;
			cost = c;
		}
	}

	public static void main(String[] args) throws IOException {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		int cases = Integer.parseInt(br.readLine());
		
		while (cases-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int height = Integer.parseInt(st.nextToken());
			int width = Integer.parseInt(st.nextToken());
			
			char[][] board = new char[height][width];
			int highestHeight = 0;
			int highestY = -1;
			int highestX = -1;
			for (int i=0; i<height; i++) {
				char[] input = br.readLine().toCharArray();
				for (int j=0; j<width; j++) {
					board[i][j] = input[j];
					if (input[j] - 48 > highestHeight) {
						highestY = i;
						highestX = j;
						highestHeight = input[j] - 48;
					}
				}
			}
			
			st = new StringTokenizer(br.readLine());
			int startY = Integer.parseInt(st.nextToken());
			int startX = Integer.parseInt(st.nextToken());
			
			int[][] costs = new int[height][width];
			for (int i=0; i<height; i++) {
				for (int j=0; j<width; j++) {
					costs[i][j] = Integer.MAX_VALUE;
				}
			}
			costs[startY][startX] = 0;
			PriorityQueue<Node> pq = new PriorityQueue<>(new Comparator<Node>() {
				@Override
				public int compare(Node o1, Node o2) {
					return o1.cost - o2.cost;
				}				
			});
			pq.add(new Node(startY, startX, 0));
			
			while (!pq.isEmpty()) {
				Node now = pq.poll();
				for (int i=0; i<8; i++) {
					int nextY = now.y + dY[i];
					int nextX = now.x + dX[i];
					
					if (nextY < 0 || nextY >= height || nextX < 0 || nextX >= width) {
						continue;
					}
					if (board[nextY][nextX] == '#') {
						continue;
					}
					
					int heightDifference = Math.abs((board[now.y][now.x]-48) - (board[nextY][nextX]-48));
					int cost = (1+heightDifference) * (1+heightDifference);
					int nextCost = now.cost + cost;
					
					if (costs[nextY][nextX] <= nextCost) {
						continue;
					}
					costs[nextY][nextX] = nextCost;
					pq.add(new Node(nextY, nextX, nextCost));
				}
			}
			int result = costs[highestY][highestX];
			if (result == Integer.MAX_VALUE) {
				System.out.println("NO");
			} else {
				System.out.println(result);
			}
		}
	}

}

/*
1
5 5
11111
1####
12#4#
12###
12221
0 0



*/