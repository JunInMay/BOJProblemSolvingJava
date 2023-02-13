package problems.from.number06100;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Baekjoon6146 {
	static int[] dY = {-1, 1, 0, 0};
	static int[] dX = {0, 0, -1, 1};
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int length = 1001; 
		int scale = 500;
		
		int goalX = Integer.parseInt(st.nextToken()) + scale;
		int goalY = Integer.parseInt(st.nextToken()) + scale;
		int puddleCount = Integer.parseInt(st.nextToken());
		
		char[][] board = new char[length][length];
		boolean[][] visited = new boolean[length][length];
		board[goalY][goalX] = 'g';
		
		while (puddleCount-- > 0) {
			st = new StringTokenizer(br.readLine());
			int puddleX = Integer.parseInt(st.nextToken()) + scale;
			int puddleY = Integer.parseInt(st.nextToken()) + scale;
			board[puddleY][puddleX] = 'p'; 
		}
		
		ArrayDeque<Node> deque = new ArrayDeque<>();
		deque.add(new Node(scale, scale, 0));
		visited[scale][scale] = true;
		while (!deque.isEmpty()) {
			Node now = deque.poll();
			if (board[now.y][now.x] == 'g') {
				System.out.println(now.moves);
				break;
			}
			for (int i=0; i<4; i++) {
				int nextY = now.y + dY[i];
				int nextX = now.x + dX[i];
				if (nextY < 0 || nextY >= length || nextX < 0 || nextX >= length) {
					continue;
				}
				if (visited[nextY][nextX] || board[nextY][nextX] == 'p') {
					continue;
				}
				
				visited[nextY][nextX] = true;
				deque.add(new Node(nextY, nextX, now.moves+1));
			}
		}
	}

}

class Node {
	int y;
	int x;
	int moves;
	
	Node(int y, int x, int moves){
		this.y = y;
		this.x = x;
		this.moves = moves;
	}
}
