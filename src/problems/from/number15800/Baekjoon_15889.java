package problems.from.number15800;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon_15889 {
	public static int toInt(String s) {
		return Integer.parseInt(s);
	}

	public static void main(String[] args) throws IOException {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		
		int soldiers = toInt(br.readLine());
		int soldiersPosition[] = new int[soldiers];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i=0; i<soldiers; i++) {
			soldiersPosition[i] = toInt(st.nextToken());
		}
		
		int maxRange = 0;
		boolean isCompletable = true;
		if (soldiers > 1) {
			st = new StringTokenizer(br.readLine());
			for (int i=0; i<soldiers-1; i++) {
				if (maxRange < soldiersPosition[i]) {
					break;
				}
				
				int possibleRange = soldiersPosition[i] + toInt(st.nextToken());
				if (maxRange < possibleRange) {
					maxRange = possibleRange;
				}
			}
		}
		
		if (soldiersPosition[soldiers-1] <= maxRange) {
			System.out.println("권병장님, 중대장님이 찾으십니다");
		} else {
			System.out.println("엄마 나 전역 늦어질 것 같아");
		}
	}
}
/*
5
0 3 8 15 100
3 5 7 100

5
0 3 3 3 100
3 5 6 10

1
0

2
0 100
100
*/
