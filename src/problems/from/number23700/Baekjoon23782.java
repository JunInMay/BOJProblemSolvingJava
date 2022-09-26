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
			// factor�� �ߺ� ���� ������������ ����
			for (long factor : factors) {
				// ���� ������ ǥ���� �� �ִ� ���� ���� +1 �̳��� �ִ� �μ��� ��� ������ �߰�, �׷��� ������ ������ �̾����� �����Ƿ� NO 
				if (coverableNumber + 1 >= factor) {
					coverableNumber += factor;
				} else {
					break;
				}
				
				// ������ ǥ���� �� �ִ� ���� ������ n-1 �̻��̶�� YES
				if (coverableNumber >= number-1) {
					result = "Yes";
					break;
				}
			}
			
			System.out.println(result);
		}
	}
}
