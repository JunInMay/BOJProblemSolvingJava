package problems.from.number18000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon18097 {

	public static void main(String[] args) throws IOException {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		
		int cityCount = Integer.parseInt(br.readLine());
		
		if (cityCount <= 2) {
			cityCount--;
		}
		System.out.println(cityCount);
	}
}
