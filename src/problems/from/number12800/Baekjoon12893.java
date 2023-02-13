package problems.from.number12800;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Baekjoon12893 {

	public static void main(String[] args) throws IOException {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int vertexCount = Integer.parseInt(st.nextToken());
		int edgeCount = Integer.parseInt(st.nextToken());
		
		HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
		while (edgeCount-- > 0) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			
			map.putIfAbsent(from, new ArrayList<>());
			map.putIfAbsent(to, new ArrayList<>());
			map.get(from).add(to);
			map.get(to).add(from);
		}
		
		int[] visited = new int[vertexCount+1];
		int result = 1;
		for (int start=1; start<=vertexCount; start++) {
			if (visited[start] != 0) {
				continue;
			}
			visited[start] = 1;
			ArrayDeque<Integer> deque = new ArrayDeque<>();
			boolean isPossible = true;
			deque.add(start);
			while (!deque.isEmpty()) {
				int now = deque.poll();
				int nextValue = visited[now] * -1;
				for (int to : map.getOrDefault(now, new ArrayList<>())) {
					if (visited[to] != 0 && visited[to] != nextValue) {
						isPossible = false;
						break;
					} else if (visited[to] == nextValue){
						continue;
					}
					visited[to] = nextValue;
					deque.add(to);
				}
			}
			if (!isPossible) {
				result = 0;
				break;
			}
		}
		System.out.println(result);
	}

}

/*


3 2
1 2
2 3




*/
