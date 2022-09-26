package problems.from.number25200;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon_25212 {
	static double[] cakes;
	static int result;
	
	public static double toDouble(String s) {
		return Double.parseDouble(s);		
	}
	public static int toInt(String s) {
		return Integer.parseInt(s);
	}
	
	public static void main(String[] args) throws IOException {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		result = 0;
		
		int cakeCount = toInt(br.readLine());
		cakes = new double[cakeCount];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i=0; i<cakeCount; i++) {
			double cake = 1d/toDouble(st.nextToken());
			cakes[i] = cake;
		}
		goNext(0d, 0);
		System.out.println(result);
	}
	
	public static void goNext(double now, int index) {
		
		for (int i=index; i<cakes.length; i++) {
			now += cakes[i];
			if (now < 99d/100) {
				goNext(now, i+1);
			} else if (99d/100 <= now && now <= 101d/100) {
				result++;
			}
			now -= cakes[i];
		}	
	}
}
/*
10
2 2 2 2 2 2 2 2 2 2
*/