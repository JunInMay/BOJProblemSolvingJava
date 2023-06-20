package problems.from.number05900;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * 풀이를 보고 풀었으나 계속 틀렸습니다가 나온다.
 * 이상하게 내 풀이가 아니라 USACO 대회에서 제공한 솔루션으로도 백준에선 틀렸습니다가 나온다.
 * 너무 이상해서 질문까지 올리게 되었다.
 * https://www.acmicpc.net/board/view/119997
 * 위 링크는 내가 올린 질문글이다.
 * 뭔가 이상하다.
 * 맞았는데, 백준에서 잘못된 데이터를 추가해서 틀렸다고 나오는 것 같다.
 */

public class Baekjoon5964Failed {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int parenthesesLength = Integer.parseInt(br.readLine());
		
		long[] values = new long[parenthesesLength/2 + 1];
		long result = 0;
		int parenthesisLevel = 0;
		for (int i=0; i<parenthesesLength; i++) {
			int now = Integer.parseInt(br.readLine());
			
			if (now == 0) {
				parenthesisLevel++;
			} else {
				if (values[parenthesisLevel] == 0) {
					values[parenthesisLevel - 1] += 1;
				} else {
					values[parenthesisLevel - 1] += values[parenthesisLevel] * 2;
				}
				values[parenthesisLevel - 1] %= 12345678910L;
				values[parenthesisLevel] = 0;
				parenthesisLevel--;
			}
		}
		
		result = values[0];
		System.out.println(result);
	}

}

/*

10
0
0
0
1
0
0
1
1
1
1







8
0
0
1
1
0
0
1
1

10
0
0
0
1
0
1
1
0
1
1

*/