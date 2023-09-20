package problems.from.number08600;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon8670 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int elementCount = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int maxElement = 0;
		int result = 0;
		for (int i = 1; i <= elementCount; i++) {
			int element = Integer.parseInt(st.nextToken());
			
			if (element > maxElement) {
				maxElement = element;
			}
			
			if (maxElement == i) {
				result += 1;
			}
		}
		
		System.out.println(result);
	}

}
