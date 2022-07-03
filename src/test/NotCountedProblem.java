package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class NotCountedProblem {

	public static void main(String[] args) throws IOException {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		int bytes = Integer.parseInt(br.readLine());
		String longs = "";
		
		for (int i = 0; i < bytes; i+=4) {
			longs += "long ";
		}
		System.out.println(longs + "int");
		
	}

}
