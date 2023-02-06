package problems.from.number23600;

import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Baekjoon23631Failed {
	static long sumSequence(int diff, int index) {
		return index * (diff * (index + 1)) / 2;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int caseCount = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		while (caseCount-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int goal = Integer.parseInt(st.nextToken()) - 1;
			int commonDifference = Integer.parseInt(st.nextToken());
			
			int maxSequenceIndex = (int) Math.sqrt(20000000);
			if (goal <= commonDifference) {
				maxSequenceIndex = 2;
			}
			int minSequenceIndex = 0;
			
			while (maxSequenceIndex - minSequenceIndex > 1) {
				int midSequenceIndex = (maxSequenceIndex + minSequenceIndex) / 2;
				long sequenceSum = sumSequence(commonDifference, midSequenceIndex);
				
				if (goal < sequenceSum) {
					maxSequenceIndex = midSequenceIndex;
				} else {
					minSequenceIndex = midSequenceIndex;
				}
			}
			long numberLeft = (goal - sumSequence(commonDifference, minSequenceIndex)) * -1;
			int start = commonDifference * ((minSequenceIndex+1)/2);
			if (minSequenceIndex % 2 != 1) {
				start *= -1;
				numberLeft *= -1;
			}
			String direction = "R";
			if (maxSequenceIndex % 2 == 0) {
				direction = "L";
			}
			sb.append(String.format("%d %s", start + numberLeft, direction));
			sb.append('\n');
		}
		System.out.println(sb);

	}

}
