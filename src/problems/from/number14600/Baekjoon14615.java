package problems.from.number14600;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Baekjoon14615 {
	static int cityCount;
	static boolean[][] visited;
	
	static boolean bfs(int start, HashMap<?, ArrayList<Integer>> board, int visitedIndex) {
		ArrayDeque<Integer> deque = new ArrayDeque<>();
		deque.add(start);
		while(!deque.isEmpty()) {
			int now = deque.poll();
			for (Integer candidate : board.get(now)) {
				if (visited[visitedIndex][candidate]) {
					continue;
				}
				visited[visitedIndex][candidate] = true;
				deque.add(candidate);
			}
		}
		return false;
	}
	
	public static void main(String[] args) throws IOException {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		cityCount = Integer.parseInt(st.nextToken());
		int tubeCount = Integer.parseInt(st.nextToken());
		
		HashMap<Integer, ArrayList<Integer>> CTP = new HashMap<>();
		HashMap<Integer, ArrayList<Integer>> reversedCTP = new HashMap<>();
		visited = new boolean[2][cityCount+1];
		
		for (int i=1; i<=cityCount; i++) {
			CTP.put(i, new ArrayList<Integer>());
			reversedCTP.put(i, new ArrayList<Integer>());
		}
		for (int i=0; i<tubeCount; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int goal = Integer.parseInt(st.nextToken());
			
			CTP.get(start).add(goal);
			reversedCTP.get(goal).add(start);
		}
		bfs(1, CTP, 0);
		bfs(cityCount, reversedCTP, 1);
		
		int caseCount = Integer.parseInt(br.readLine());
		String result = "";
		
		for (int i=0; i<caseCount; i++) {
			int bombIndex = Integer.parseInt(br.readLine());
			if (visited[0][bombIndex] && visited[1][bombIndex]) {
				result = "Defend the CTP";
			} else {
				result = "Destroyed the CTP";
			}
			bw.append(result);
			bw.append('\n');
		}
		bw.flush();
		bw.close();
	}
}
