package problems.from.number02700;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;
import java.io.IOException;

public class Baekjoon2776 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int caseCount = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		while (caseCount-- > 0) {
			int correctNumberCount = Integer.parseInt(br.readLine());	
			StringTokenizer st = new StringTokenizer(br.readLine());
			HashSet<Integer> correctNumbers = new HashSet<Integer>(); 
			while (correctNumberCount-- > 0) {
				correctNumbers.add(Integer.parseInt(st.nextToken()));
			}
			
			int submitNumberCount = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			while (submitNumberCount-- > 0) {
				if (correctNumbers.contains(Integer.parseInt(st.nextToken()))) {
					sb.append(1);
				} else {
					sb.append(0);
				}
				sb.append('\n');
			}
		}
		System.out.print(sb);
	}

}
