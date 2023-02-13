package problems.from.number24900;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Baekjoon24988 {
	static HashMap<Integer, ArrayList<Integer>> map;
	static boolean[] visited;
	static char[] owners;
	
	static void dfs(int now) {
		ArrayList<Integer> connectedRoads = map.get(now);
		owners[now] = 'B';
		
		for (int destination : connectedRoads) {
			if (!visited[destination] && owners[destination] != 'A') {
				visited[destination] = true;
				dfs(destination);
			}
		}
	}

	public static void main(String[] args) throws IOException {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int fieldCount = Integer.parseInt(st.nextToken());
		int roadCount = Integer.parseInt(st.nextToken());
		
		map = new HashMap<>();
		
		while (roadCount-- > 0) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken()) - 1;
			int to = Integer.parseInt(st.nextToken()) - 1;
			map.putIfAbsent(from, new ArrayList<>());
			map.putIfAbsent(to, new ArrayList<>());
			ArrayList<Integer> fromDestinations = map.get(from);
			ArrayList<Integer> toDestinations = map.get(to);
			fromDestinations.add(to);
			toDestinations.add(from);
		}
		
		visited = new boolean[fieldCount];
		owners = new char[fieldCount];
		visited[fieldCount-1] = true;
		visited[fieldCount-2] = true;
		owners[fieldCount-1] = 'A';
		owners[fieldCount-2] = 'B';
		dfs(fieldCount-2);
		
		StringBuilder sb = new StringBuilder();
		for (char owner : owners) {
			if (owner != 'B') {
				sb.append('A');
			} else {
				sb.append(owner);
			}
		}
		System.out.println(sb);
	}
}
