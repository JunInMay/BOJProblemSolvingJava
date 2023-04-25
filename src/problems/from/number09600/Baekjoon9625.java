package problems.from.number09600;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * BABBA
 * https://www.acmicpc.net/problem/9625
 * A는 B가 되고, B는 BA가 되는 문자열의 규칙성을 찾으면 됨
 * 문자열, A의 개수, B의 개수로 나열하면 순서는 아래와 같음
 * A 1 0
 * B 0 1
 * BA 1 1
 * BAB 1 2
 * BABBA 2 3
 * BABBABAB 3 5
 * BABBABABBABBA 5 8
 * 규칙성을 찾아보자면 n번째의 A의 개수는 n-1번째의 B의 개수이고, n번째의 B의 개수는 n-1번째의 A와 B의 개수의 합임을 알 수 있음
 */
public class Baekjoon9625 {

	public static void main(String[] args) throws IOException {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		
		int buttonTimes = Integer.parseInt(br.readLine());
		
		int a = 1;
		int b = 0;
		
		while (buttonTimes-- > 0) {
			int temp = a;
			a = b;
			b = temp + b;
		}
		System.out.println(String.format("%d %d", a, b));
	}

}
