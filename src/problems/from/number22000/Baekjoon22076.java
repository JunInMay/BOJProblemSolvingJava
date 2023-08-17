package problems.from.number22000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Map.Entry;
import java.util.StringTokenizer;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class Baekjoon22076 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int ballCount = Integer.parseInt(st.nextToken());
		int ballNeed = Integer.parseInt(st.nextToken());
		
		TreeMap<Integer, Integer> ballTable = new TreeMap<>();
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < ballCount; i++) {
			int now = Integer.parseInt(st.nextToken());
			ballTable.putIfAbsent(now, 0);
			ballTable.put(now, ballTable.get(now) + 1);
		}
		
		ArrayList<Integer> selectedBalls = new ArrayList<>();
		for (Entry<Integer, Integer> e : ballTable.entrySet()) {
			if (selectedBalls.size() < ballNeed) {
				selectedBalls.add(e.getKey());
				ballTable.put(e.getKey(), ballTable.get(e.getKey()) - 1);
			}
		}

		for (Entry<Integer, Integer> e : ballTable.entrySet()) {
			if (selectedBalls.size() < ballNeed) {
				for (int i = 0; i < Math.min(ballNeed - selectedBalls.size(), ballTable.get(e.getKey())); i++)
				selectedBalls.add(e.getKey());
				ballTable.put(e.getKey(), ballTable.get(e.getKey()) - 1);
			}
		}
		
		selectedBalls.sort(null);
		String result = String.join(" ", selectedBalls.stream().map(String::valueOf).collect(Collectors.toList()));
		System.out.println(result);
	}

}

/*

10 4
8 8 8 8 1 8 8 2 2 1








*/