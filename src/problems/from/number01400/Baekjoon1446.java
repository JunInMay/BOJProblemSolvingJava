package problems.from.number01400;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Baekjoon1446 {
	
	static class ShortcutNode {
		int to, cost;
		
		ShortcutNode (int t, int c){
			to = t;
			cost = c;
		}
	}
	
	static class Node implements Comparable<Node>{
		int position, cost;
		private Object o;
		
		Node (int p, int c){
			position = p;
			cost = c;
		}
		
		@Override
		public int compareTo(Node o) {
			return this.cost - o.cost;
		}
	}

	public static void main(String[] args) throws IOException {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int edgeCount = Integer.parseInt(st.nextToken());
		int goal = Integer.parseInt(st.nextToken());
		
		HashMap<Integer, ArrayList<ShortcutNode>> shortcuts = new HashMap<>();
		while (edgeCount-- > 0) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			
			shortcuts.putIfAbsent(from, new ArrayList<>());
			shortcuts.get(from).add(new ShortcutNode(to, cost));
		}
		
		int[] costs = new int[10001];
		boolean[] visited = new boolean[10001];
		for (int i=1; i<10001; i++) {
			costs[i] = i;
		}
		
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.add(new Node(0, 0));
		while (!pq.isEmpty()) {
			Node now = pq.poll();
			
			if (visited[now.position]) {
				continue;
			}
			
			for (ShortcutNode shortcut : shortcuts.getOrDefault(now.position, new ArrayList<>())) {
				int next = shortcut.to;
				int cost = now.cost + shortcut.cost;
				
				if (next > goal) {
					continue;
				}
				
				if (costs[next] > cost) {
					costs[next] = cost;
					pq.add(new Node(next, cost));
				}
			}
			if (now.position + 1 > goal) {
				continue;
			} else {
				if (costs[now.position+1] > now.cost+1) {
					costs[now.position+1] = now.cost+1;
				}
				pq.add(new Node(now.position+1, now.cost+1));
			}
		}
		System.out.println(costs[goal]);
	}

}
