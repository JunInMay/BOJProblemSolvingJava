package problems.from.number13100;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon13116 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int caseCount = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		while (caseCount-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int left = Integer.parseInt(st.nextToken());
			int right = Integer.parseInt(st.nextToken());
			
			while (left != right) {
				if (left > right) {
					left /= 2;
				} else {
					right /= 2;
				}
			}
			sb.append(left*10);
			sb.append('\n');
		}
		System.out.print(sb);
	}
}
