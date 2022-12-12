package problems.from.number02800;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baekjoon2840 {
	
	static String getBackward(char[] chars, int index) {
		int length = chars.length;
		int i = index;
		StringBuilder sb = new StringBuilder();
		do {
			sb.append(chars[i]);
			i = (i-1 % length + length) % length;
		} while(i != index);
		
		return sb.toString();
	}
	static boolean hasCharacter(char[] chars, char character) {
		for (int i=0; i<chars.length; i++) {
			if (chars[i] == character) {
				return true;
			}
		}
		return false;
	}

	public static void main(String[] args) throws IOException {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		StringTokenizer st = new StringTokenizer(br.readLine());
		int characterCount = Integer.parseInt(st.nextToken());
		int caseCount = Integer.parseInt(st.nextToken());
		
		char[] guess = new char[characterCount];
		Arrays.fill(guess, '?');
		int index = 0;
		String result = "!";
		boolean flag = false;
		while (caseCount-- > 0) {
			String input = br.readLine();
			st = new StringTokenizer(input);
			int moveCount = Integer.parseInt(st.nextToken());
			Character character = st.nextToken().charAt(0);
			index = (index + moveCount) % characterCount;
			if (guess[index] == '?' && !hasCharacter(guess, character)) {
				guess[index] = character;
			} else if (guess[index] == character) {
				continue;
			} else {
				flag = true;
				break;
			}
		}
		if (flag) {
			System.out.println(result);
		} else {
			System.out.println(getBackward(guess, index));
		}
	}
}


/*

5 6
1 A
2 B
5 B
1 C
2 A
2 B

3 3
1 A
2 B
36 C

25 25
44 D
92 Y
93 V
62 W
61 A
43 H
4 B
70 D
30 B
32 K
69 Z
20 H
45 F
95 X
45 N
100 N
6 Y
31 E
29 M
65 Y
35 M
89 X
83 N
5 I
3 P



expect : !


26 26
1 A
1 B
1 C
1 D
1 E
1 F
1 G
1 H
1 I
1 J
1 K
1 L
1 M
1 N
1 O
1 P
1 Q
1 R
1 S
1 T
1 U
1 V
1 W
1 X
1 Y
1 A

*/