package problems.from.number04300;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon4309 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int caseCount = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (;caseCount > 0; caseCount--) {
			String input = br.readLine();
			char[] chars = input.toCharArray();
			int length = chars.length;
			/*
				int extra
				1. 중심이 되는 문자의 위치가 중심에서 얼마나 떨어져 있는지
				2. 개수가 홀수인 문자가 존재하는지 여부를 의미하는 변수
				(문자들이 모두 짝수라면 중심이 되는 문자가 없을 수도 있음)
			*/
			int extra = 0;
			int count = 0;
			boolean isImpossible = false;;
			for (int i = 0; i < length / 2; i++) {
				int j; // 오른쪽에서부터 세어서 찾은 i번째 문자와 같은 문자의 index
				for (j = length - i - (extra == 0 ? 1 : 0); j > i && chars[i] != chars[j]; j--) {};
				
				// 중심이 발견 되었을 때
				if (i == j) {
					/*
					1. 이미 중심이 발견된 상태 (개수가 홀수인 문자가 2개 이상이라는 뜻)
					2. 문자열의 길이가 짝수 (짝이 없는 문자라는 뜻)
					위와 같은 경우엔 회문을 만들 수 없음.
					 */
					if (extra != 0 || length % 2 == 0) {
						isImpossible = true;
						break;
					}
					
					extra = length / 2 - i;
					continue;
				}
				
				for (;j < length - i - (extra == 0 ? 1 : 0); j++) {
					char temp = chars[j];
					chars[j] = chars[j+1];
					chars[j+1] = temp;
					count++;
				}
			}

			String result = "Impossible";
			if (!isImpossible) {
				result = count + extra + "";
			}
			sb.append(result).append('\n');
		}
		System.out.print(sb);
	}
}
