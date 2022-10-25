package problems.from.number10900;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.Deque;
import java.util.ArrayDeque;

public class Baekjoon10917 {
	static int toInt(String s) {
		return Integer.parseInt(s);
	}
	
	public static void main(String[] args) throws IOException {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int lifeGoal = toInt(st.nextToken());
		int changeCount = toInt(st.nextToken());
		
		Map<Integer, List<Integer>> graph = new HashMap<>();
		for (int i=0; i<changeCount; i++) {
			st = new StringTokenizer(br.readLine());
			Integer tempStart = toInt(st.nextToken());
			Integer tempGoal = toInt(st.nextToken());
			if (!graph.containsKey(tempStart)) {
				graph.put(tempStart, new ArrayList<>());
			}
			graph.get(tempStart).add(tempGoal);
		}
		
		Deque<Node> dq = new ArrayDeque<>();
		boolean[] visited = new boolean[lifeGoal+1];
		dq.add(new Node(1, 0));
		visited[1] = true;
		int result = -1;
		while (!dq.isEmpty()) {
			Node now = dq.poll();
			if (now.value == lifeGoal) {
				result = now.times;
				break;
			}
			if (!graph.containsKey(now.value)) {
				continue;
			}
			
			for (Integer target : graph.get(now.value)) {
				if (visited[target]) {
					continue;
				}
				dq.add(new Node(target, now.times+1));
				visited[target] = true;
			}
		}
		
		System.out.println(result);
	}
}

class Node {
	int value;
	int times;
	
	Node (int value, int times) {
		this.value = value;
		this.times = times;
	}
}
