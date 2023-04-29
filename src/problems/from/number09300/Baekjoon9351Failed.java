package problems.from.number09300;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Baekjoon9351Failed {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int caseCount = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		for (int caseNumber=1; caseNumber<=caseCount; caseNumber++) {
			String input = br.readLine();
			int size = input.length();
			
			int maxPalindromeSize = 1;
			ArrayList<Integer> startIndexes = new ArrayList<>();
			ArrayList<Integer> endIndexes = new ArrayList<>();
			for (int i=0; i<size; i++) {
				for (int j=0; j<size-i; j++) {
					int end = size-j;
					int range = (end - i) / 2;
					int tempPalindromeSize = 0 + (end - i) % 2;
					boolean isPalindrome = true;
					for (int r=0; r<range; r++) {
						int front = i + r;
						int rear = end - 1 - r;
						if (input.charAt(front) != input.charAt(rear)) {
							isPalindrome = false;
							break;
						}
						tempPalindromeSize += 2;
					}
					if (isPalindrome && tempPalindromeSize > maxPalindromeSize) {
						maxPalindromeSize = tempPalindromeSize;
					}
				}
			}
			
			int maxPalindromeCount = 0;
			for (int i=0; i<size; i++) {
				for (int j=0; j<size-i; j++) {
					int end = size-j;
					int range = (end - i) / 2;
					int tempPalindromeSize = 0 + (end - i) % 2;
					for (int r=0; r<range; r++) {
						int front = i + r;
						int rear = end - 1 - r;
						if (input.charAt(front) != input.charAt(rear)) {
							break;
						}
						tempPalindromeSize += 2;
					}
					if (tempPalindromeSize == maxPalindromeSize) {
						startIndexes.add(i);
						endIndexes.add(end);
						maxPalindromeCount += 1;
					}
				}
			}
			sb.append(String.format("Case #%d:\n", caseNumber));
			if (maxPalindromeSize > 1) {
				for (int i=0; i<maxPalindromeCount; i++) {
					int start = startIndexes.get(maxPalindromeCount-1-i);
					int end = endIndexes.get(maxPalindromeCount-1-i);
					for (int j=start; j<end; j++) {
						sb.append(input.charAt(j));
					}
					sb.append('\n');
				}
			}
		}
		System.out.print(sb);
	}

}
/*



2
abcbadcvcd
abcbadcvcdabcba









*/