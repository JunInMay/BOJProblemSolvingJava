package problems.from.number07700;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Baekjoon7785 {

	public static void main(String[] args) throws IOException {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		
		int caseCount = Integer.parseInt(br.readLine());
		HashMap<String, Boolean> company = new HashMap<>();
		
		while (caseCount-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String name = st.nextToken();
			String action = st.nextToken();
			
			if (action.charAt(0) == 'e') {
				company.put(name, true);
			} else {
				company.put(name, false);
			}
		}
		
		ArrayList<String> keyList = new ArrayList<>(company.keySet());
		Collections.sort(keyList, Comparator.reverseOrder());
		StringBuilder sb = new StringBuilder();
		for (String key : keyList) {
			if (company.getOrDefault(key, false)) {
				sb.append(key);
				sb.append('\n');
			}
		}
		System.out.print(sb);
	}
}
