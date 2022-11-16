package problems.from.number09400;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Baekjoon9421 {
	static boolean[] isHappyNumbers;
	static int[] digitSquareNumbers;
	
	static int toInt(String s) {
		return Integer.parseInt(s);
	}
	
	static int getDigitSquareNumber(int number) {
		int digitSquareNumber = 0;
		while(number > 0) {
			digitSquareNumber += Math.pow((number % 10), 2);
			number /= 10;
		}
		
		return digitSquareNumber;
	}
	
	static boolean dfs(int number, boolean[] visited) {
		visited[number] = true;
		if (isHappyNumbers[number]) {
			return true;
		} else {
			if (visited[digitSquareNumbers[number]]) {
				return false;
			} else {
				return dfs(digitSquareNumbers[number], visited);
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int limitNumber = toInt(br.readLine());
		
		digitSquareNumbers = new int[487];
		isHappyNumbers = new boolean[487];
		isHappyNumbers[1] = true;
		
		for (int i=0; i<487; i++) {
			digitSquareNumbers[i] = getDigitSquareNumber(i);
		}
		
		for (int i=0; i<487; i++) {
			boolean[] visited = new boolean[487];
			isHappyNumbers[i] = dfs(i, visited);
		}
		
		boolean[] sieve = new boolean[limitNumber+1];
		Arrays.fill(sieve, 2, limitNumber+1, true);
		for (int i=2; i<=limitNumber; i++) {
			if (sieve[i]) {
				for (int j=i*2; j<=limitNumber; j+=i) {
					sieve[j] = false;
				}
			}
		}
		
		for (int i=0; i<=limitNumber; i++) {
			if (sieve[i]) {
				if (isHappyNumbers[getDigitSquareNumber(i)]) {
					bw.write(i+"\n");
					bw.flush();
				}
			}
		}
		bw.close();
	}
}
