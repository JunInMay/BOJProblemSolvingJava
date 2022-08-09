package problems.from.number01000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baekjoon1049 {
	
	public static int toInt(String s) {
		return Integer.parseInt(s);
	}
	
	public static void main(String[] args) throws IOException {		
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int deadStrings = toInt(st.nextToken());
		int brands = toInt(st.nextToken());
		
		int[] packages = new int[brands];
		int[] eachs = new int[brands];
		
		for (int i=0; i<brands; i++) {
			st = new StringTokenizer(br.readLine());
			packages[i] = toInt(st.nextToken());
			eachs[i] = toInt(st.nextToken());
		}
		
		Arrays.sort(packages);
		Arrays.sort(eachs);
		
		int quotient = Math.floorDiv(deadStrings, 6);
		deadStrings -= quotient * 6;
		
		int result = 0;
		result += Math.min(packages[0], eachs[0] * 6) * quotient;
		result += Math.min(packages[0], eachs[0] * deadStrings);
		
		System.out.println(result);
	}

}
