package problems.from.number12700;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Baekjoon12761 {
	
	static int toInt(String s) {
		return Integer.parseInt(s);
	}
	
	static int[] getCandidates(int position, int A, int B) {
		int[] result = {
				position + A,
				position + B,
				position - A,
				position - B,
				position * A,
				position * B,
				position + 1,
				position - 1
		};
		
		return result;
	}

	public static void main(String[] args) throws IOException {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int A = toInt(st.nextToken());
		int B = toInt(st.nextToken());
		
		int start = toInt(st.nextToken());
		int goal = toInt(st.nextToken());
		
		boolean[] visited = new boolean[100001];
		
		ArrayDeque<Move> dq = new ArrayDeque<>();
		dq.offer(new Move(start, 0));
		
		while (!dq.isEmpty()) {
			Move now = dq.poll();
			int[] candidates = getCandidates(now.position, A, B);
			
			if (now.position == goal) {
				System.out.println(now.moveCount);
				break;
			}
			
			for (int candidate : candidates) {
				if (candidate < 0 || visited.length-1 < candidate) {
					continue;
				}
				if (!visited[candidate]) {
					visited[candidate] = true;
					dq.offer(new Move(candidate, now.moveCount+1));
				}
			}
		}
	}
}

class Move{
	int position;
	int moveCount;
	
	Move(int position, int moveCount){
		this.position = position;
		this.moveCount = moveCount;
	}
}
