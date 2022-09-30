package problems.from.number05600;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

/*
 * 문자열 입력은 255자, 최대 소수는 100000, 그런데 100000은 소수가 아니므로 99999까지(5자리)만 판별해도 됨
 * 각 255자에서 시작해서 5자씩 읽고 판별하므로 5*O(N) = O(N)
 */
public class Baekjoon5636 {
	static int toInt(String s) {
		return Integer.parseInt(s);
	}
	static int toInt(char c) {
		return Character.getNumericValue(c);
	}
	
	public static void main(String[] args) throws IOException {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		OutputStreamWriter osw = new OutputStreamWriter(System.out);
		BufferedWriter bw = new BufferedWriter(osw);
		
		// 아리스토테네스의 체 사용
		boolean[] sieve = new boolean[100000];
		Arrays.fill(sieve, true);
		sieve[0] = false;
		sieve[1] = false;
		
		for (int i=2; i<sieve.length; i++) {
			if (sieve[i] == false) {
				continue;
			}
			for (int j=i+i; j<sieve.length; j+=i) {
				sieve[j] = false;
			}
		}
		
		while (true) {
			String numberString = br.readLine();
			if (numberString.equals("0")) {
				break;
			}
			
			char[] numberCharArray = numberString.toCharArray();
			
			int result = 0;
			for (int i=0; i<numberCharArray.length; i++) {
				int discrimination = 0; 
				for (int j=0; j<5; j++) {
					if (i+j>=numberCharArray.length) {
						break;
					}
					discrimination *= 10;
					discrimination += toInt(numberCharArray[i+j]);
					
					if (sieve[discrimination]) {
						result = Math.max(result, discrimination);
					}
				}
			}
			bw.write(result+"\n");
		}
		bw.flush();
		bw.close();
	}
}