package problems.from.number09800;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Baekjoon9863 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringBuilder sb = new StringBuilder();
		while (true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int totalCallers = Integer.parseInt(st.nextToken());
			int positionsToSkip = Integer.parseInt(st.nextToken());
			int pickedCaller = Integer.parseInt(st.nextToken());
			
			if (totalCallers == 0) {
				break;
			}
			
			ArrayDeque<Caller> deque = new ArrayDeque<Caller>();
			
			for (int i = 1; i <= totalCallers; i++) {
				deque.add(new Caller(i));
			}
			
			int skippedCount = 0;
			int rotation = 1;
			int result = 0;
			while (true) {
				Caller now = deque.pop();
				skippedCount += 1;
				
				if (skippedCount == positionsToSkip) {
					if (rotation == pickedCaller) {
						result = now.order;
						break;
					}
					skippedCount = 0;
					rotation += 1;
				} else {
					deque.add(now);
				}
			}
			
			sb.append(result).append('\n');
		}
		System.out.println(sb);

	}

}

class Caller {
	int order;
	
	Caller (int o) {
		order = o;
	}
}