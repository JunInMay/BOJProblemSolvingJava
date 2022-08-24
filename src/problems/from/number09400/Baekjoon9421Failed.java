package problems.from.number09400;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Baekjoon9421Failed {
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
		} else if (number == 1) {
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
		
		for (int i=0; i<487; i++) {
			digitSquareNumbers[i] = getDigitSquareNumber(i);
		}
		
		for (int i=0; i<487; i++) {
			boolean[] visited = new boolean[487];
			isHappyNumbers[i] = dfs(i, visited);
		}
		
		boolean[] sieve = new boolean[limitNumber+1];
		Arrays.fill(sieve, 2, limitNumber+1, true);
		for (int i=3; i<=limitNumber; i++) {
			for (int j=2; j<=Math.sqrt(i); j++) {
				if ((double)i%j == 0) {
					sieve[i] = false;
					break;
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
