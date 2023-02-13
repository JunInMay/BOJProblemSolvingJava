package problems.from.number03000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon3036 {
	
	public static int getEucladian(int a, int b) {
		if (b != 0) {
			return getEucladian(b, a%b);
		}
		return a;
	}

	public static void main(String[] args) throws IOException {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		
		int ringCount = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int firstRing = Integer.parseInt(st.nextToken());
		while (st.hasMoreTokens()) {
			int nextRing = Integer.parseInt(st.nextToken());
			int GCD = getEucladian(firstRing, nextRing);
			System.out.printf("%d/%d\n",firstRing/GCD, nextRing/GCD);
		}
	}
}
