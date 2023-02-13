package problems.from.number12100;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon12175 {

	public static void main(String[] args) throws IOException {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		int caseCount = Integer.parseInt(br.readLine());
		
		for (int caseIdx=1; caseIdx<=caseCount; caseIdx++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int K = Integer.parseInt(st.nextToken());
			int V = Integer.parseInt(st.nextToken());
			
			int result = 0;
			for (int i=0; i<=K; i++) {
				int redMin = Math.max(0, i-V);
				int redMax = Math.min(K, i+V);
				for (int j=redMin; j<=redMax; j++) {
					int greenMin = Math.max(redMin, j-V);
					int greenMax = Math.min(redMax, j+V);
//					System.out.println("#####case : " + i + " , " + j + " ##########");
//					System.out.println("min : " + greenMin);
//					System.out.println("max : " + greenMax);
					result += greenMax - greenMin + 1;
				}
			}
			System.out.printf("Case #%d: %d\n", caseIdx, result);
		}
	}
}

/*

4
1 1
1 0
255 0
0 0

1
7 2

1
255 255

*/
