package problems.from.number09500;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Baekjoon_9519 {
	static StringBuilder front;
	static StringBuilder rear;
	
	public static int toInt(String s) {
		return Integer.parseInt(s);
	}
	
	public static void initialize() {
		front.setLength(0);
		rear.setLength(0);
	}

	public static void main(String[] args) throws IOException {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		HashMap<String, Integer> patterns = new HashMap<>();
		List<String> patternsIndex = new ArrayList<>();
		
		int times = toInt(br.readLine());
		int cycle = 0;
		String now = br.readLine();
		front = new StringBuilder();
		rear = new StringBuilder();
		
		for (int i=0; i<times; i++) {
			if (patterns.containsKey(now)) {
				cycle = i;
				break;
			} else {
				patterns.put(now, i);
				patternsIndex.add(now);
			}
			
			initialize();
			for (int j=0; j<now.length(); j++) {
				if (j%2 == 0) {
					front.append(now.charAt(j));
				} else {
					rear.append(now.charAt(j));
				}
			}
			now = front.append(rear.reverse()).toString();
		}
		
		if (cycle == 0) {
			System.out.println(now);
		} else {
			System.out.println(patternsIndex.get(times%cycle));
		}
	}
}
/*
1000000000
srama
*/
