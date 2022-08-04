package problems.from.number07700;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.stream.Stream;

public class Baekjoon_7795 {
	public static int toInt(String s) {
		return Integer.parseInt(s);
	}

	public static void main(String[] args) throws IOException {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		
		int cases = toInt(br.readLine());
		
		for (int i=0; i<cases; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int aCount = toInt(st.nextToken());
			int bCount = toInt(st.nextToken());
			
			int[] aArray = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			int[] bArray = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			
			Arrays.sort(aArray);
			Arrays.sort(bArray);
			
			int[] pairs = new int[aCount];
			
			int bIndex = 0;
			int count = 0;
			
			for (int aIndex=0; aIndex<aCount; aIndex++) {
				while (bIndex < bCount && bArray[bIndex] < aArray[aIndex]) {
					bIndex++;
					count++;
				}
				pairs[aIndex] = count;
			}
			System.out.println(Arrays.stream(pairs).sum());

		}
	}
}

/*
1
5 5
1 2 3 4 5
1 2 3 4 5

*/