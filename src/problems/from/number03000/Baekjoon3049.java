package problems.from.number03000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon3049 {

	public static void main(String[] args) throws IOException {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		int vertex = Integer.parseInt(br.readLine());
		
		int line = 0;
		for (int i=0; i<vertex-2; i++) {
			int left = 1 + i;
			int right= vertex - 2 - left;
			line += left * right;
		}
		System.out.println(line * vertex / 4);
	}

}
