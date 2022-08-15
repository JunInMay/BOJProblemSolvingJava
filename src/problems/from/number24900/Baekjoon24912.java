package problems.from.number24900;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baekjoon24912 {
	
	public static int toInt(String s) {
		return Integer.parseInt(s);
	}
	
	public static void main(String[] args) throws IOException {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		
		int cardCount = toInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] cards = new int[cardCount];
		for (int i=0; i<cardCount; i++) {
			cards[i] = toInt(st.nextToken());
		}
		
		boolean isColorable = true;
		for (int i=0; i<cardCount; i++) {
			int leftIdx = i-1;
			int rightIdx = i+1;
			
			if (cards[i] != 0) {
				// 이미 칠해져있는 경우 좌, 우측 판별하고 같은 색의 카드가 근처에 있다면 탐색 종료
				if ((!(leftIdx < 0) && cards[leftIdx] == cards[i]) || (!(rightIdx >= cardCount) && cards[rightIdx] == cards[i])) {
					isColorable = false;
					break;
				}
			} else {
				boolean[] candidates = new boolean[4];
				
				// 좌, 우측 판별
				if (!(leftIdx < 0)) {
					candidates[cards[leftIdx]] = true;
				}
				if (!(rightIdx >= cardCount)) {
					candidates[cards[rightIdx]] = true;
				}
				
				for (int j=1; j<candidates.length; j++) {
					if (!candidates[j]) {
						cards[i] = j;
						break;
					}
				}
			}
		}
		
		String result;
		if (isColorable) {
			result = String.join(" ", Arrays.stream(cards).mapToObj(String::valueOf).toArray(n -> new String[n]));
		} else {
			result = "-1";
		}
		System.out.println(result);
	}
}
