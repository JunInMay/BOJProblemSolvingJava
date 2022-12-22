package problems.from.number16100;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
		
public class Baekjoon16114 {
	static String solution(int number, int minuses) {
		if (minuses % 2 != 0 && minuses != 1) {
			return "ERROR";
		}
		if (minuses == 1) {
			number *= -1;
		}
		int difference = minuses / 2;
		int count = 0;
		number -= difference;
		int temp = number;
		while (number > 0) {
			number -= difference;
			count++;
			if (number == temp) {
				return "INFINITE";
			}
			temp = number;
		}
		return String.valueOf(count);
		
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int number = Integer.parseInt(st.nextToken());
		int minuses = Integer.parseInt(st.nextToken());
		
		System.out.println(solution(number, minuses));
	}
}

/*
10 4
4

-5 5
ERROR

3 0
INFINITE


*/