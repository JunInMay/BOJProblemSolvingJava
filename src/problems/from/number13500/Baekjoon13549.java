package problems.from.number13500;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Baekjoon13549 {

	public static void main(String[] args) throws IOException {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int now = Integer.parseInt(st.nextToken());
		int goal = Integer.parseInt(st.nextToken());
		
		ArrayDeque<Node> deque = new ArrayDeque<>();
		HashMap<Integer, Integer> costs = new HashMap<>();
		costs.put(now, 0);
		deque.add(new Node(now, 0));
		while (!deque.isEmpty()) {
			Node node = deque.poll();
			if (node.position == goal) {
				System.out.println(node.seconds);
				break;
			}
			
			for (int i=0; i<3; i++) {
				int next = node.position;
				int cost = 0;
				
				if (i == 0) {
					next += 1;
					cost = 1;
				} else if (i == 1) {
					next += -1;
					cost = 1;
				} else {
					next *= 2;
				}
				
				if (next < 0 || next > 100000) {
					continue;
				}
				if (!costs.containsKey(next) || costs.get(next) > node.seconds + cost) {
					costs.put(next, node.seconds + cost);
				} else {
					continue;
				}
				
				Node nextNode = new Node(next, node.seconds + cost);
				if (cost == 0) {
					deque.addFirst(nextNode);
				} else {
					deque.add(nextNode);
				}
			}
		}
	}
}

class Node {
	int position;
	int seconds;
	
	Node(int p, int s) {
		position = p;
		seconds = s;
	}
}

/*

5 17

*/