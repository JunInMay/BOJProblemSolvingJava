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

			long result = 0;
			for (int i = 1; i <= pointCount - 1; i++) {
				for (int j = 0; j <= pointCount - i - 1; j++) {

					int size = i * i + j * j; // i, j 각각의 점으로부터 그려지는 정사각형의 크기
					if (size >= leastSize) {
						/*
						 * 정사각형이 되는 점 두개 i, j를 구했다면, 그 정사각형이 차지하는 너비는 i + j이다.
						 * 가로, 세로에 각각 N - (i + j) 만큼 정사각형을 그릴 수 있다.
						 */
						result += (pointCount - (i + j)) * (pointCount - (i + j));
					}
				}
			}
			System.out.println(result);
		}
	}
}
