package problems.from.number02200;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon2229 {
	static int toInt(String s) {
		return Integer.parseInt(s);
	}
	
	public static void main(String[] args) throws IOException {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		
		int studentCount = toInt(br.readLine());
		int[] students = new int[studentCount];
		StringTokenizer st = new StringTokenizer(br.readLine());

		for (int i=0; i<studentCount; i++) {
			students[i] = toInt(st.nextToken());
		}
		
		int[] rangeMax = new int[studentCount];
		
		// 0,1 ~ 0,1000 까지 기록
		for (int i=1; i<studentCount; i++) {
			
			// n,n -> 0,n까지 체크
			int max = students[i];
			int min = students[i];
			int now = max-min;
			for (int j=i; j>=0; j--) {
				max = Math.max(students[j], max);
				min = Math.min(students[j], min);
				now = max-min;
				
				if (j == 0) {
					rangeMax[i] = Math.max(rangeMax[i], now);
				} else {
					rangeMax[i] = Math.max(rangeMax[i], rangeMax[j-1] + now);
				}
			}
		}
		
		System.out.println(rangeMax[studentCount-1]);
	}
}


/*
10
2 5 7 1 3 4 8 6 9 3

*/