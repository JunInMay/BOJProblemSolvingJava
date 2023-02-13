package problems.from.number25400;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Baekjoon25426 {

	public static void main(String[] args) throws IOException {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		int caseCount = Integer.parseInt(br.readLine());
		
		BigInteger result = new BigInteger("0");
		ArrayList<Integer> aList = new ArrayList<>();
		for (int i=0; i<caseCount; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			result = result.add(new BigInteger(st.nextToken()));
			
			aList.add(a);
		}
		
		Collections.sort(aList, Collections.reverseOrder());
		for (int a : aList) {
			result = result.add(new BigInteger(Long.toString(((long) a * caseCount--))));
		}
		System.out.println(result);
	}
}
/*
5
2 4
5 1
3 2
1 10
0 0

3
5 3
4 2
3 1

10
1 1
1 2
1 3
1 4
1 5
1 6
1 7
1 8
1 9
1 10

3
1 0
1 0
1 0

40
1000000000 1000000000
1000000000 1000000000
1000000000 1000000000
1000000000 1000000000
1000000000 1000000000
1000000000 1000000000
1000000000 1000000000
1000000000 1000000000
1000000000 1000000000
1000000000 1000000000
1000000000 1000000000
1000000000 1000000000
1000000000 1000000000
1000000000 1000000000
1000000000 1000000000
1000000000 1000000000
1000000000 1000000000
1000000000 1000000000
1000000000 1000000000
1000000000 1000000000
1000000000 1000000000
1000000000 1000000000
1000000000 1000000000
1000000000 1000000000
1000000000 1000000000
1000000000 1000000000
1000000000 1000000000
1000000000 1000000000
1000000000 1000000000
1000000000 1000000000
1000000000 1000000000
1000000000 1000000000
1000000000 1000000000
1000000000 1000000000
1000000000 1000000000
1000000000 1000000000
1000000000 1000000000
1000000000 1000000000
1000000000 1000000000
1000000000 1000000000


*/