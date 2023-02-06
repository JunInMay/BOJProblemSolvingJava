package problems.from.number09200;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Baekjoon9204 {
	static int[] dY = {-1, -1, 1, 1};
	static int[] dX = {-1, 1, 1, -1};
	static StringBuilder sb = new StringBuilder();
	
	static void makeNode(Node goal) {
		if (goal.before != null) {
			makeNode(goal.before);
		}
		sb.append(((char)(goal.x + 'A')));
		sb.append(" ");
		sb.append(goal.y + 1);
		sb.append(" ");
	}

	public static void main(String[] args) throws IOException {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		
		int caseCount = Integer.parseInt(br.readLine());
		
		while (caseCount-- > 0) {
			boolean[][] visited = new boolean[8][8];
			StringTokenizer st = new StringTokenizer(br.readLine());
			int startX = st.nextToken().charAt(0) - 'A';
			int startY = Integer.parseInt(st.nextToken()) - 1;
			int goalX = st.nextToken().charAt(0) - 'A';
			int goalY = Integer.parseInt(st.nextToken()) - 1;
			visited[startY][startX] = true;
			
			Node start = new Node(startY, startX);
			ArrayDeque<Node> deque = new ArrayDeque<>();
			deque.add(start);
			
			Node goal = null;
			while (!deque.isEmpty()) {
				Node now = deque.poll();
				if (now.y == goalY && now.x == goalX) {
					goal = now;
					break;
				}
				if (now.count == 2) {
					continue;
				}
				for (int i=0; i<4; i++) {
					for (int j=0; j<7; j++) {
						int nextY = now.y + dY[i] * j;
						int nextX = now.x + dX[i] * j;
						
						if (nextY < 0 || nextY >= 8 || nextX < 0 || nextX >= 8) {
							continue;
						}
						if (visited[nextY][nextX]) {
							continue;
						}
						Node next = new Node(nextY, nextX);
						next.before = now;
						next.count = now.count + 1;
						visited[nextY][nextX] = true;
						
						deque.add(next);
					}
				}
			}
			if (goal != null) {
				sb.append(goal.count);
				sb.append(' ');
				makeNode(goal);
			} else {
				sb.append("Impossible");
			}
			sb.append('\n');
		}
		System.out.println(sb);
	}
}

class Node {
	int y, x;
	int count = 0;
	Node before;
	
	Node (int y, int x){
		this.y = y;
		this.x = x;
	}
	
}

/*

1
F 1 E 8


*/