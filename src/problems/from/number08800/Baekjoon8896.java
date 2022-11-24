package problems.from.number08800;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Baekjoon8896 {
	
	static int getResult(boolean[] rsp) {
		boolean isRock = rsp[0];
		boolean isScissor = rsp[1];
		boolean isPaper = rsp[2];
		// 묵찌빠중 하나가 이긴 경우
		if (isRock && isScissor && !isPaper) {
			return 1;
		}
		if (isScissor && isPaper && !isRock) {
			return 2;
		}
		if (isPaper && isRock && !isScissor) {
			return 3;
		}
			
		return 0;
	}

	public static void main(String[] args) throws IOException {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);

		int caseCount = Integer.parseInt(br.readLine());
		HashMap<Character, Integer> rspMapping = new HashMap<>();
		rspMapping.put('R', 1);
		rspMapping.put('S', 2);
		rspMapping.put('P', 3);
		
		while (caseCount-- > 0) {
			int robotCount = Integer.parseInt(br.readLine());
			char[][] robots = new char[robotCount][];
			boolean[] eliminated = new boolean[robotCount];
			for (int i=0; i<robotCount; i++) {
				robots[i] = br.readLine().toCharArray();
			}
			int roundCount = robots[0].length;
			
			for (int i=0; i<roundCount; i++) {
				boolean[] rspExistence = new boolean[3];
				for (int j=0; j<robotCount; j++) {
					if (eliminated[j]) {
						continue;
					}
					char rsp = robots[j][i];
					rspExistence[rspMapping.get(rsp)-1] = true;
				}
				
				// 가위바위보 게임 결과 받기 0 무승부 1 묵승 2 찌승 3 빠승
				int rspGameResult = getResult(rspExistence);
				if (rspGameResult == 0) {
					continue;
				}
				for (int j=0; j<robotCount; j++) {
					int rspSubmitNumber = rspMapping.get(robots[j][i]);
					if (rspSubmitNumber == rspGameResult) {
						continue;
					} else {
						eliminated[j] = true;
					}
				}
			}
			int index = -1;
			for (int j=0; j<robotCount; j++) {
				if (!eliminated[j]) {
					if (index != -1) {
						index = 0;
						break;
					}
					index = j+1;
				}
			}
			System.out.println(index);
		}
	}
}
