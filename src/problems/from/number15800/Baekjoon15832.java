package problems.from.number15800;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Baekjoon15832 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringBuilder sb = new StringBuilder();
		while (true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int trainees = Integer.parseInt(st.nextToken());
			int selection = Integer.parseInt(st.nextToken());
			
			if (trainees == 0) break;
			
			ArrayDeque<Integer> deque = new ArrayDeque<>();
			for (int i=1; i<=trainees; i++) {
				deque.add(i);
			}
			
			while (deque.size() > 1) {
				for (int i=0; i<selection-1; i++) {
					deque.add(deque.poll());
				}
				int deleted = deque.poll();
			}
			int selected = deque.poll();
			sb.append(selected).append('\n');
		}
		
		System.out.print(sb);
	}
}
