package problems.from.number18300;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Baekjoon18352 {

	static class Node {
		int number, cost;

		Node(int n, int c) {
			number = n;
			cost = c;
		}
	}

	public static void main(String[] args) throws IOException {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int nodeCount = Integer.parseInt(st.nextToken());
		int lineCount = Integer.parseInt(st.nextToken());
		int goalDistance = Integer.parseInt(st.nextToken());
		int startNode = Integer.parseInt(st.nextToken());
		
		HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
		for (int i=0; i<lineCount; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			map.putIfAbsent(from, new ArrayList<>());
			map.get(from).add(to);
		}
		
		boolean[] visited = new boolean[nodeCount+1];
		int[] costs = new int[nodeCount+1];
		Arrays.fill(costs, Integer.MAX_VALUE);
		costs[startNode] = 0;
		/*
		 * 우선순위큐로 수정
		 */
		PriorityQueue<Node> pq = new PriorityQueue<>(new Comparator<Node>() {
			@Override
			public int compare(Node o1, Node o2) {
				// TODO Auto-generated method stub
				return o1.cost - o2.cost;
			}
			
		});
		for (int i=1; i<=nodeCount; i++) {
			Node node = new Node(i, Integer.MAX_VALUE);
			if (i == startNode) {
				node.cost = 0;
			}
			pq.add(node);
		}
		
		while(!pq.isEmpty()) {
			Node now = pq.poll();
			if (visited[now.number] || now.cost == Integer.MAX_VALUE) {
				continue;
			}
			
			for (Integer next : map.getOrDefault(now.number, new ArrayList<>())) {
				 if (costs[next] > now.cost + 1) {
					 costs[next] = now.cost + 1;
					 pq.add(new Node(next, now.cost+1));
				 }
			 }
			 visited[now.number] = true;
		}
		// O(n^2)
//		System.out.println(Arrays.toString(costs));
//		
//		for (int i=1; i<=nodeCount; i++) {
//			 int minIndex = -1;
//			 int minCost = Integer.MAX_VALUE;
//			 
//			 // 최소 값 찾기
//			 for (int j=1; j<=nodeCount; j++) {
//				 if (!visited[j] && costs[j] <= minCost) {
//					 minIndex = j;
//					 minCost = costs[j];
//				 }
//			 }
//			 if (minCost == Integer.MAX_VALUE) {
//				 continue;
//			 }
//			 
//			 for (Integer next : map.getOrDefault(minIndex, new ArrayList<>())) {
//				 if (costs[next] > minCost + 1) {
//					 costs[next] = minCost + 1;
//				 }
//			 }
//			 visited[minIndex] = true;
//		}
		boolean isExist = false;
		for (int i=1; i<=nodeCount; i++) {
			if (costs[i] == goalDistance) {
				System.out.println(i);
				isExist = true;
			}
		}
		if (!isExist) {
			System.out.println(-1);
		}
	}

}
