package problems.from.number05100;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.StringTokenizer;

public class Baekjoon5107 {
	static boolean dfs(HashMap<String, String> map, HashMap<String, Boolean> visited, String key) {
		if (visited.getOrDefault(key, false)) {
			return true;
		}
		String target = map.getOrDefault(key, null);
		if (target == null) {
			return false;
		}
		visited.put(key, true);
		return dfs(map, visited, target);
	}

	public static void main(String[] args) throws IOException {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);

		int caseNumber = 1;
		while(true) {
			int count = Integer.parseInt(br.readLine());
			if (count == 0) {
				break;
			}
			HashMap<String, String> map = new HashMap<>();
			HashMap<String, Boolean> visited = new HashMap<>();
			for (int i=0; i<count; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				String from = st.nextToken();
				String to = st.nextToken();
				map.put(from, to);
				visited.put(from, false);
				visited.put(to, false);
			}
			
			int cycle = 0;
			for (Entry<String, String> e : map.entrySet()) {
				String key = e.getKey();
				if (visited.get(key)) {
					continue;
				}
				dfs(map, visited, key);
				cycle++;
			}
			System.out.println(String.format("%d %d", caseNumber, cycle));
			
			caseNumber++;
		}
	}

}

/*

2
Ahmed Tess
Tess Ahmed
0

3
A B
B C
C A
0







*/