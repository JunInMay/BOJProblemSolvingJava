package problems.from.number06100;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baekjoon6159 {
	static int toInt(String s) {
		return Integer.parseInt(s);
	}
	
	public static void main(String[] args) throws IOException {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		StringTokenizer st = new StringTokenizer(br.readLine());

		int cowCount = toInt(st.nextToken());
		int costumeCapacity = toInt(st.nextToken());
		
		int[] cows = new int[cowCount];
		for (int i=0; i<cowCount; i++) {
			cows[i] = toInt(br.readLine());
		}
		
		Arrays.sort(cows);
		int frontIndex = 0;
		int rearIndex = cows.length - 1;
		int result = 0;
		while (true) {
			if (frontIndex == rearIndex) {
				break;
			}
			int front = cows[frontIndex];
			int rear = cows[rearIndex];
			int sum = front + rear;
			if (sum <= costumeCapacity) {
				result += rearIndex - frontIndex;
				frontIndex++;
			} else {
				rearIndex--;
			}
		}
		System.out.println(result);
	}
}
