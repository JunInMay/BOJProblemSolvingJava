package problems.from.number15900;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


// 우선순위 큐로 풀면 더 빠른데.. ㅠㅠ
public class Baekjoon_15903 {
	static long[] cards;
	
	public static int toInt(String s) {
		return Integer.parseInt(s);
	}
	
	public static void main(String[] args) throws IOException {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = toInt(st.nextToken());
		int M = toInt(st.nextToken());
		
		cards = new long[N];
		st = new StringTokenizer(br.readLine());
		for (int i=0; i<N; i++) {
			cards[i] = toInt(st.nextToken());
		}
		
		for (int i=0; i<M; i++) {
			Arrays.sort(cards);
			long cardSum = cards[0] + cards[1];
			
			cards[0] = cardSum;
			cards[1] = cardSum;
		}
//		System.out.println(Arrays.toString(cards));
		System.out.println(Arrays.stream(cards).sum());

	}

}
/*
4 1
4 2 3 1 
4 2
4 2 3 1 
4 3
4 2 3 1
3 2
3 2 6
3 3
3 2 6
 *
 */