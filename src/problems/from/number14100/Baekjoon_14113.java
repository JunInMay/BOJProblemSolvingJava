package problems.from.number14100;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon_14113 {
	
	public static int toInt(String s) {
		return Integer.parseInt(s);
	}

	public static void main(String[] args) throws IOException {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int A = toInt(st.nextToken());
		int B = toInt(st.nextToken());
		int C = toInt(st.nextToken());
		int D = toInt(st.nextToken());
		int E = toInt(st.nextToken());
		
		int result = 0;
		
		result += A;
		
		result += B;
		E -= Math.min(B, E);
		
		int CwithD = Math.min(C, D);
		result += CwithD;
		C -= CwithD;
		D -= CwithD;
		
		int C1withE2 = Math.min(C, E/2);
		result += C1withE2;
		C -= C1withE2;
		E -= C1withE2*2;
		
		int C1withE1 = Math.min(C, E);
		result += C1withE1;
		C -= C1withE1;
		E -= C1withE1;
		
		result += C;
		
		int D2withE1 = Math.min(D/2, E);
		result += D2withE1;
		D -= D2withE1*2;
		E -= D2withE1;
		
		result += D/2;
		D = D%2;
		
		result += D;
		E -= Math.min(D*3, E);
		
		result += E/5;
		E = E%5;
		
		if (E > 0) {
			result ++;
		}
		
		System.out.println(result);
		
	}

}
