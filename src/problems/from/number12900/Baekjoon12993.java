package problems.from.number12900;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Deque;
import java.util.ArrayDeque;

public class Baekjoon12993 {
	
	public static void main(String[] args) throws IOException {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int goalX = Integer.parseInt(st.nextToken());
		int goalY = Integer.parseInt(st.nextToken());
		
		Deque<Node> queue = new ArrayDeque<>();
		queue.add(new Node(0, 0, 1));
		boolean resultFound = false;
		while (!queue.isEmpty()) {
			Node now = queue.poll();
			if (now.y > 1000000000 || now.x > 1000000000) {
				continue;
			}
			if (now.y == goalY && now.x == goalX) {
				resultFound = true;
			}
			Node increasedY = new Node(now.y + now.increase, now.x, now.increase * 3);
			Node increasedX = new Node(now.y, now.x + now.increase, now.increase * 3);
			queue.add(increasedY);
			queue.add(increasedX);
		}
		if (resultFound) {
			System.out.println(1);
		} else {
			System.out.println(0);
		}
	}
	
	static class Node {
		int y;
		int x;
		int increase;
		Node(int y, int x, int increase) {
			this.y = y;
			this.x = x;
			this.increase = increase;
		}
	}
}