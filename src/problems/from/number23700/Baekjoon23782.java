package problems.from.number23700;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

public class Baekjoon23782 {
	static int toInt(String s) {
		return Integer.parseInt(s);
	}
	static long toLong(String s) {
		return Long.parseLong(s);
	}
	
	public static void main(String[] args) throws IOException {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		
		int iteration = toInt(br.readLine());
		for (int i=0; i<iteration; i++) {
			long number = toLong(br.readLine());
			
			HashSet<Long> factorsSet = new HashSet<>();
			for (long j=1; j<=Math.sqrt(number); j++) {
				if (number % j == 0) {
					factorsSet.add(j);
					factorsSet.add(number / j);
				}
			}
			
			ArrayList<Long> factors = new ArrayList<>(factorsSet);
			Collections.sort(factors);
			
			long coverableNumber = 0;
			String result = "No";
			// factor는 중복 없는 오름차순으로 들어옴
			for (long factor : factors) {
				// 현재 합으로 표현할 수 있는 수의 범위 +1 이내에 있는 인수일 경우 범위에 추가, 그렇지 않으면 범위가 이어지지 않으므로 NO 
				if (coverableNumber + 1 >= factor) {
					coverableNumber += factor;
				} else {
					break;
				}
				
				// 합으로 표현할 수 있는 수의 범위가 n-1 이상이라면 YES
				if (coverableNumber >= number-1) {
					result = "Yes";
					break;
				}
			}
			
			System.out.println(result);
		}
	}
}