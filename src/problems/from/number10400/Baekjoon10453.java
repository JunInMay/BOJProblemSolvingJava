package problems.from.number10400;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon10453 {
	
	public static void main(String[] args) throws IOException {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);

		int caseCount = Integer.parseInt(br.readLine());
		
		for (int caseIdx=0; caseIdx<caseCount; caseIdx++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			char[] asIsText = st.nextToken().toCharArray();
			char[] toBeText = st.nextToken().toCharArray();
			int size = asIsText.length;
			int[] bPositions = new int[size/2];
			int bIndex = 0;
			
			for (int i=0; i<size; i++) {
				if (toBeText[i] == 'b') {
					bPositions[bIndex] = i;
					bIndex++;
				}
			}
			
			int result = 0;
			bIndex = 0;
			for (int i=0; i<size; i++) {
				if (asIsText[i] == 'b') {
					result += Math.abs(i - bPositions[bIndex]);
					bIndex++;
				}
			}
			System.out.println(result);
		}
	}
}
