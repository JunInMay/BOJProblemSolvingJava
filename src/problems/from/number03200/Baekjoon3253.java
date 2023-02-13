package problems.from.number03200;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 0-1 BFS 로 해결
 * 
 */
public class Baekjoon3253 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int nodeCount = Integer.parseInt(st.nextToken());
		int start = Integer.parseInt(st.nextToken());
		int goal = Integer.parseInt(st.nextToken());
		
		int[][] graph = new int[nodeCount+1][nodeCount+1];
		
		for (int i=1; i<=nodeCount; i++) {
			st = new StringTokenizer(br.readLine());
			int linkedRail = Integer.parseInt(st.nextToken());
			for (int j=0; j<linkedRail; j++) {
				int rail = Integer.parseInt(st.nextToken());
				int cost = 2;
				if (j == 0) {
					cost = 1;
				}
				graph[i][rail] = cost;
			}
		}
		
		ArrayDeque<Integer> deque = new ArrayDeque<>();
		boolean[] visited = new boolean[nodeCount+1];
		visited[start] = true;
		int[] costs = new int[nodeCount+1];
		Arrays.fill(costs, Integer.MAX_VALUE);
		costs[start] = 0;
		deque.add(start);
		while (!deque.isEmpty()) {
			int now = deque.poll();
			visited[now] = true;
			for (int i=1; i<=nodeCount; i++) {
				int target = graph[now][i];
				int cost = target-1;
				if (target == 0 || visited[i]) {
					continue;
				}
				if (costs[now] + cost < costs[i]) {
					costs[i] = costs[now] + cost;
				}
				if (cost == 0) {
					deque.addFirst(i);
				} else {
					deque.add(i);
				}
			}
		}
		
		int result = costs[goal];
		if (result == Integer.MAX_VALUE) {
			result = -1;
		}
		System.out.println(result);
	}

}

/*

3 2 1
2 2 3
2 3 1
2 1 2

*/