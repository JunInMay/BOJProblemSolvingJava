package problems.from.number06500;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon6556Failed {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while (true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			
			int result = 0;
			if (n==0 || m==0) {
				result = 1;
			}
			if (n==0 && m==0) {
				break;
			}
			int[] top = new int[n+1];
			for (int i=0; i<n+1; i++) {
				top[i] = Integer.MIN_VALUE+1+i;
			}
			
			for (int i=0; i<m-1; i++) {
				int[] bottom = new int[n+1];
				bottom[0] = Integer.MIN_VALUE+1;
				for (int j=1; j<n+1; j++) {
					bottom[j] = bottom[j-1] + (top[j] + (Integer.MAX_VALUE+1));
				}
				top = bottom;
			}
			if (result != 1) {
				System.out.println(top[n] + Integer.MAX_VALUE+1);
			} else {
				System.out.println(result);
			}
		}
	}
}
