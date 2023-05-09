package problems.from.number08600;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class Baekjoon8633 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("cca".compareTo("ccc"));
		int caseCount = Integer.parseInt(br.readLine());
		String[] cases = new String[caseCount];
		
		for (int i=0; i<caseCount; i++) {
			cases[i] = br.readLine();
		}
		
		Arrays.sort(cases, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				int diff = o1.length() - o2.length();
				if (diff == 0) {
					return o1.compareTo(o2);
				}
				return diff;
			}
		});
		
		for (int i=0; i<caseCount; i++) {
			System.out.println(cases[i]);
		}
	}
}
 