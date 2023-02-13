package problems.from.number17200;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon17296 {
	
	public static void main(String[] args) throws IOException {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		
		int stageCount = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		boolean pushed = false;
		int result = 0;
		for (int i=0; i<stageCount; i++) {
			double stageInput = Double.parseDouble(st.nextToken());
			if (!pushed && Math.ceil(stageInput) >= 1) {
				pushed = true;
				result += Math.ceil(stageInput);
			} else {
				result += Math.floor(stageInput);
			}
		}
		System.out.println(result);
	}
}

/*
2
1.5 0.5

 */
