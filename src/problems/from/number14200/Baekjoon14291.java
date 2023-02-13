package problems.from.number14200;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon14291 {
	static long countBlue(char[] pattern, long limit) {
		long result = 0;
		for (int i=0; i<limit; i++) {
			if (pattern[i] == 'B') {
				result++;
			}
		}
		return result;
	}

	public static void main(String[] args) throws IOException {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		int caseCount = Integer.parseInt(br.readLine());
		
		for (int i=0; i<caseCount; i++) {
			char[] pattern = br.readLine().toCharArray();
			long size = pattern.length;
			long patternBlueCount = countBlue(pattern, size);
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			long start = Long.parseLong(st.nextToken()) - 1;
			long end = Long.parseLong(st.nextToken());
			
			long topRepetition = end / size;
			long top = patternBlueCount * topRepetition + countBlue(pattern, end % size);
			long bottomRepetition = start / size;
			long bottom = patternBlueCount * bottomRepetition + countBlue(pattern, start % size);
			
//			System.out.println("top : " +top);
//			System.out.println("bot : " +bottom);
			System.out.println(String.format("Case #%d: %d", i+1, top-bottom));
		}
	}
}


/*
3
BBRB
4 8
BBRB
10 12
BR
1 1000000
 
 
*/