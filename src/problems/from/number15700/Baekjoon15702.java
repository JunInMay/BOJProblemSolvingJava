package problems.from.number15700;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon15702 {
	static int toInt(String s) {
		return Integer.parseInt(s);
	}
	
	public static void main(String[] args) throws IOException {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int questionsCount = toInt(st.nextToken());
		int testTakersCount = toInt(st.nextToken());
		
		int[] questionPoints = new int[questionsCount];
		
		st = new StringTokenizer(br.readLine());
		for (int i=0; i<questionsCount; i++) {
			questionPoints[i] = toInt(st.nextToken());
		}
		
		int maxTakerNumber = -1;
		int maxPoint = -1;
		for (int i=0; i<testTakersCount; i++) {
			st = new StringTokenizer(br.readLine());
			int takerNumber = toInt(st.nextToken());
			
			int point = 0;
			for (int j=0; j<questionsCount; j++) {
				char questionSolved = st.nextToken().charAt(0);
				if (questionSolved == 'O') {
					point += questionPoints[j];
				}
			}
			boolean condition = maxPoint < point || (maxPoint == point && takerNumber < maxTakerNumber);
			if (condition) {
				maxTakerNumber = takerNumber;
				maxPoint = point;
			} 
			
		}
		String result = String.format("%d %d", maxTakerNumber, maxPoint);
		System.out.println(result);
	}
}
