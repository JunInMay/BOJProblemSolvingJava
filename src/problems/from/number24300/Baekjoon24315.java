package problems.from.number24300;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon24315 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int a1 = Integer.parseInt(st.nextToken());
		int a0 = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		
		int c1 = Integer.parseInt(st.nextToken());
		int c2 = Integer.parseInt(st.nextToken());
		
		int n0 = Integer.parseInt(br.readLine());
		
		int result = 0;
		if (c1 <= a1 && a1 <= c2) {
			int nGap = a1 - c1;
			if (a0 > 0) {
				nGap = c2 - a1;
			}
			
			if (nGap * n0 >= Math.abs(a0)) {
				result = 1;
			}
		}
		System.out.println(result);
	}

}

/*

7 1
7 7
1


*/