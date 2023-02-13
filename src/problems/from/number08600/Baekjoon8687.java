package problems.from.number08600;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baekjoon8687 {
	
	static int[] dY = {-1, 1, 0};
	static int[] dX = {0, 0, 1};
	
	static class Node {
		int y;
		int x;
		Node (int y, int x) {
			this.y = y;
			this.x = x;
		}
		
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int height = Integer.parseInt(st.nextToken());
		int width = Integer.parseInt(st.nextToken());
		
		Integer[][] board = new Integer[height][width];
		for (int i=0; i<height; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j=0; j<width; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int result = Integer.MAX_VALUE;
		Integer[][] costs = new Integer[height][width];
		for (int i=0; i<height; i++) {
			for (int j=0; j<width; j++) {
				costs[i][j] = Integer.MAX_VALUE;
			}
		}
		
		ArrayDeque<Node> deque = new ArrayDeque<>();
		for (int y=0; y<height; y++) {
			if (board[y][0] == 1) {
				continue;
			}
			costs[y][0] = 0;
			deque.add(new Node(y, 0));
		}
		while (!deque.isEmpty()) {
			Node now = deque.poll();
			if (now.x == width-1) {
				break;
			}
			
			for (int i=0; i<3; i++) {
				int nextY = now.y + dY[i];
				int nextX = now.x + dX[i];
				
				if (nextY < 0 || nextY >= height || nextX < 0 || nextX >= width) {
					continue;
				}
				if (board[nextY][nextX] == 1) {
					continue;
				}
				
				int cost = 0;
				if (nextY != now.y) {
					cost = 1;
				}
				
				int nextCost = costs[now.y][now.x] + cost;
				if (costs[nextY][nextX] <= nextCost) {
					continue;
				}
				costs[nextY][nextX] = nextCost;
				
				if (cost == 0) {
					deque.addFirst(new Node(nextY, nextX));
				} else {
					deque.add(new Node(nextY, nextX));
				}
			}
		}
		for (int i=0; i<height; i++) {
			result = Math.min(result, costs[i][width-1]);
		}
		printBoard(costs);
		
		if (result == Integer.MAX_VALUE) {
			System.out.println("NIE");
		} else {
			System.out.println(result);
		}
		
	}
	
	static <T> void printBoard(T[][] array) {
		System.out.println("#####-----#####");
		for (int i=0; i<array.length; i++) {
			System.out.println(Arrays.toString(array[i]));
		}
		System.out.println("===============");
	}
	
}

/*
4 5
0 0 0 1 0
0 1 0 1 0
1 1 0 0 0
0 0 1 0 1

4 5
0 0 0 1 0
1 1 1 1 1
1 1 1 1 1
1 1 1 1 1

4 5
0 0 0 1 0
1 1 0 1 0
1 1 0 0 0
0 0 0 0 1

4 5
0 0 0 1 0
1 1 0 0 0
1 1 0 1 0
0 0 0 1 1




*/