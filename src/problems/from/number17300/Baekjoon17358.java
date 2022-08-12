package problems.from.number17300;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon17358 {
	public static int divisor = (int) Math.pow(10, 9) + 7;
	
	public static int toInt(String s) {
		return Integer.parseInt(s);
	}

	public static void main(String[] args) throws IOException {
		
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		
		int number = toInt(br.readLine());
		
		int index = 2;
		long result = 1;
		while (index < number) {
			result = (result * ((index+2)-1)) % divisor;
			
			index += 2;
		}
		System.out.println(result);
	}
}
