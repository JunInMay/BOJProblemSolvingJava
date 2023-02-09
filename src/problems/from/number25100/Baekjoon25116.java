package problems.from.number25100;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Baekjoon25116 {

	public static void main(String[] args) throws IOException {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int stageCount = Integer.parseInt(st.nextToken());
		long requiredDifficulty = Long.parseLong(st.nextToken());
		long requiredStageCount = Long.parseLong(st.nextToken());
		
		long minLevel = 1;
		long maxLevel = stageCount;
		long requiredLevel = 0;
		while (minLevel <= maxLevel) {
			long midLevel = (minLevel + maxLevel) / 2;
			long now = midLevel*(midLevel+1)/2;
			System.out.println("now : " + now + " midL : " + midLevel);
			if (now < requiredStageCount) {
				minLevel = midLevel+1;
			} else {
				maxLevel = midLevel-1;
			}
		}
		requiredLevel = maxLevel;
		long leastLevel = requiredLevel-1;
		System.out.println("requiredLevel : " + requiredLevel);
		// 1 = 0
		// 2, 3 = 1
		// 4, 5, 6 = 2
		// 7, 8, 9, 10 = 3 ...
		
		// 부분합 구하기
		long[] stageDifficulties = new long[stageCount+1];
		long[] subtotals = new long[stageCount+1];
		st = new StringTokenizer(br.readLine());
		for (int i=0; i<stageCount; i++) {
			stageDifficulties[i+1] = Long.parseLong(st.nextToken());
			subtotals[i+1] = stageDifficulties[i+1] + subtotals[i];
		}
		
		ArrayList<Long> leastSubtotalParts = new ArrayList<>();
		// 몇개씩 묶이는지?
		int stageGroupMemberCount = (int)(stageCount - leastLevel);
		System.out.println("몇개씪 묶이나 ? : " + stageGroupMemberCount);
		// leastLevel 의 부분합 중 최소값 을 구하고 requiredStageDifficulty를 만족시키는 가수를 찾기
		for (int i=1; i<=requiredLevel; i++) {
			leastSubtotalParts.add(subtotals[i+stageGroupMemberCount-1]-subtotals[i-1]);
		}
		
		long result = (long) Math.ceil((double)(Math.max(0, requiredDifficulty - Collections.min(leastSubtotalParts)))/stageGroupMemberCount);
		System.out.println("최소 : " + result);
		
		ArrayList<Long> mainSubtotalParts = new ArrayList<>();
		stageGroupMemberCount = (int)(stageCount - requiredLevel);
		for (int i=1; i<=requiredLevel+1; i++) {
			mainSubtotalParts.add(subtotals[i+stageGroupMemberCount-1]-subtotals[i-1]);
		}
		System.out.println(mainSubtotalParts);
	}

}

/*
3 17 2
3 4 5

3 15 4
3 4 5

4 1 9
3 4 5 6

4 1 3
3 4 5 6

4 1 2

100000 1 5000050000

*/