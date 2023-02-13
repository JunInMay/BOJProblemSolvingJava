package problems.from.number10800;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Baekjoon10826 {
	static int toInt(String s) {
		return Integer.parseInt(s);
	}
	
	public static void main(String[] args) throws IOException {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		
		int number = toInt(br.readLine());
		BigInteger[] fibonacci = new BigInteger[10001];
		fibonacci[0] = new BigInteger("0");
		fibonacci[1] = new BigInteger("1");
		
		for (int i=2; i<10001; i++) {
			fibonacci[i] = fibonacci[i-1].add(fibonacci[i-2]);
		}
		
		System.out.println(fibonacci[number]);
		
	}
}
