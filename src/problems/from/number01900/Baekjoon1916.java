package problems.from.number01900;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Baekjoon1916 {
	static int[] costs;
	static boolean[] visited;
	static HashMap<Integer, ArrayList<Node>> graph;
	
	static void dijkstra(int start, int goal) {
		// 시작점에서 시작점으로 가는 비용은 0이다.
		costs[start] = 0;
		visited[start] = true;
		
		// 시작점 초기화
		for (Node n : graph.getOrDefault(start, new ArrayList<Node>())) {
			costs[n.destination] = Math.min(costs[n.destination], n.cost);
		}
		
		/* [2를 뺀 이유]
		 * 1. 자기 자신을 최단거리 탐색의 대상에 넣지는 않음
		 * 2. 최종 노드를 최단거리 탐색의 대상에 넣지 않음(어차피 최종 노드는 최단거리임 = 최종 노드에서 다른 노드로 가는 거리가 최단거리인지 판별할 필요가 없음)
		 */
		for (int iteration=0; iteration<costs.length-2; iteration++) {
			/* [i가 1부터 시작하는 이유]
			 * 문제에서 도시 번호를 1부터 시작함.
			 * 0부터 하도록 해도 되지만 입력값에 -1을 해줘야하는 것이 번거로워서 그냥 메모리 공간을 하나 더 잡았음
			 */
			
			// 매 루프마다 최소비용의 노드를 구한다.
			int minCost = Integer.MAX_VALUE;
			int minIndex = -1;
			for (int i=1; i<costs.length; i++) {
				if (costs[i] < minCost && !visited[i]) {
					minCost = costs[i];
					minIndex = i;
				}
			}
			
			ArrayList<Node> list = graph.getOrDefault(minIndex, new ArrayList<Node>());
			if (minIndex == -1) {
				continue;
			}
			visited[minIndex] = true;
			for (Node node : list) {
				if (!visited[node.destination]) {
					int candidateCost = minCost + node.cost;
					costs[node.destination] = Math.min(costs[node.destination], candidateCost);
				}
			}
		}
	}

	public static void main(String[] args) throws IOException {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		
		int cityCount = Integer.parseInt(br.readLine());
		int busCount = Integer.parseInt(br.readLine());
		graph = new HashMap<>();
		
		// 그래프 초기화
		for (int i=0; i<busCount; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			Node now = new Node(to, cost);
			ArrayList<Node> list = graph.getOrDefault(from, new ArrayList<>());
			list.add(now);
			graph.put(from, list);
		}

		StringTokenizer st = new StringTokenizer(br.readLine());
		int from = Integer.parseInt(st.nextToken());
		int to = Integer.parseInt(st.nextToken());
		visited = new boolean[cityCount+1];
		costs = new int[cityCount+1];
		Arrays.fill(costs, Integer.MAX_VALUE);
		
		dijkstra(from, to);
		System.out.println(costs[to]);
		
	}

}

class Node {
	int destination;
	int cost;
	
	Node (int d, int c){
		destination = d;
		cost = c;
	}
}


/*

2
4
1 2 3
1 2 2
1 2 4
1 2 1
1 2 3
1 2

5
4
1 2 2
2 3 1
3 4 4
3 4 5
1 4


*/