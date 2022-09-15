package problems.from.number16600;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.StringTokenizer;

public class Baekjoon16652 {
	static int toInt(String s) {
		return Integer.parseInt(s);
	}

	public static void main(String[] args) throws IOException {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int expected = toInt(st.nextToken());
		int iteration = toInt(st.nextToken());
		
		Map<String, Integer> textTable = new HashMap<>();
		for (int i=0; i<iteration; i++) {
			String inputSubject = br.readLine();
			String[] splittedText = inputSubject.split(" ");
			String originalSubject = splittedText[splittedText.length-1];
			
			int value = splittedText.length;
			if (textTable.containsKey(originalSubject)) {
				value = Math.max(textTable.get(originalSubject), value);
			}
			textTable.put(originalSubject, value);
		}
		
		int minMailCount = 0;
		for (Entry<String, Integer> e : textTable.entrySet()) {
			minMailCount += e.getValue();
		}
		
		String result = "YES";
		if (minMailCount > expected) {
			result = "NO";
		}
		
		System.out.println(result);
		
	}
}
