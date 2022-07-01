package problems.from.number06500;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Baekjoon_6571 {
	static BigInteger[] fibos = new BigInteger[10000];

	public static void main(String[] args) throws IOException {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		StringTokenizer st;
		BigInteger a;
		BigInteger b;
		fibos[0] = BigInteger.valueOf(1);
		fibos[1] = BigInteger.valueOf(1);
		fibo(2);
		int count;
		do {
			st = new StringTokenizer(br.readLine());
			a = new BigInteger(st.nextToken());
			b = new BigInteger(st.nextToken());
			count = 0;
			for (int i = 1; i < 10000; i++) {
				if (fibos[i].compareTo(a) >= 0 && fibos[i].compareTo(b) <= 0) {
					count++;
				}
			}
			if (!(a.equals(BigInteger.valueOf(0)) && b.equals(BigInteger.valueOf(0)))) {
				System.out.println(count);
			}
			
		} while(!(a.equals(BigInteger.valueOf(0)) && b.equals(BigInteger.valueOf(0))));
	}
	
	static void fibo(int index) {
		if (index < fibos.length) {
			fibos[index] = fibos[index-1].add(fibos[index-2]);
			fibo(index+1);
		}
	}
}
