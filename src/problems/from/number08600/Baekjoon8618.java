package problems.from.number08600;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon8618 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int caseCount = Integer.parseInt(br.readLine());
		while (caseCount-- > 0) {
			int numberCount = Integer.parseInt(br.readLine());
			int[] numbers = new int[numberCount];
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i=0; i<numberCount; i++) {
				numbers[i] = Integer.parseInt(st.nextToken());
			}
			
			int maxFront = 0;
			int maxRear = 0;
			int frontIndex = 0;
			int rearIndex = numberCount-1;
			int front = numbers[frontIndex];
			int rear = numbers[rearIndex];
			int length = 0;
			boolean flag = false;
			
			for (int i=0; i<numberCount; i++) {
				if (numbers[frontIndex] != front) {
					maxFront = length;
					flag = true;
				}
				if (numbers[rearIndex] != rear) {
					maxRear = length;
					flag = true;
				}
				
				length++;
				frontIndex++;
				rearIndex--;
			}
			
			String result = "BRAK";
			
			if (flag) {
				result = String.format("%d", Math.max(maxFront, maxRear));
			}
			System.out.println(result);
		}

	}

}
