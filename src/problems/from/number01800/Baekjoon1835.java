package problems.from.number01800;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class Baekjoon1835 {

	public static void main(String[] args) throws IOException {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		
		int cardCount = Integer.parseInt(br.readLine());
		ArrayDeque<Integer> deque = new ArrayDeque<>();
		int[] cards = new int[cardCount];
		
		for (int i=0; i<cardCount; i++) {
			deque.add(i);
		}
		for (int i=0; i<cardCount; i++) {
			for (int j=0; j<i+1; j++) {
				deque.add(deque.poll());
			}
			int index = deque.poll();
			cards[index] = i+1;
		}
		StringBuilder sb = new StringBuilder();
		for (int i=0; i<cardCount; i++) {
			sb.append(cards[i]);
			sb.append(' ');
		}
		System.out.println(sb.toString().strip());
	}
}
