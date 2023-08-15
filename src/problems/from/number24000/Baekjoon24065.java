package problems.from.number24000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon24065 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int caseCount = Integer.parseInt(br.readLine());

		while (caseCount --> 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int pointCount = Integer.parseInt(st.nextToken());
			int leastSize = Integer.parseInt(st.nextToken());
			double leastRoot = Math.sqrt(leastSize);

			long result = 0;
			for (int i = 1; i <= pointCount - 1; i++) {
				for (int j = 0; j <= pointCount - i - 1; j++) {
					double root = Math.sqrt(i * i + j * j);
					if (root >= leastRoot) {
						result += (pointCount - (i + j)) * (pointCount - (i + j));
					}
				}
			}
			System.out.println(result);
		}
	}
}
