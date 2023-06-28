package problems.from.number19700;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Baekjoon19799Failed {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		float apple = Float.parseFloat(st.nextToken());
		int friendCount = Integer.parseInt(st.nextToken());
		
		ArrayDeque<Node> deque = new ArrayDeque<>();
		deque.add(new Node(apple, 0));
		
		TreeSet<Float> answerSet = new TreeSet<>();
		while (!deque.isEmpty()) {
			Node now = deque.poll();
			
			float[] nextNumbers = {
					now.value - 0.5f,
					now.value / 2
			};
			
			if (now.level == friendCount) {
				answerSet.add(now.value);
				continue;
			}
			for (int i=0; i<2; i++) {
				float nextValue = nextNumbers[i];
				
				if (nextValue % 1 != 0 && nextValue % 1 != 0.5) {
					continue;
				}
				if (nextValue < 0) {
					continue;
				}
				
				deque.add(new Node(nextValue, now.level+1));
			}
		}
		
		System.out.println(answerSet.size());
		int iteration = answerSet.size();
		StringBuilder sb = new StringBuilder();
		for (int i=0; i<iteration; i++) {
			sb.append(answerSet.pollFirst()).append(' ');
		}
		System.out.println(sb.toString().trim());
		
	}

}

class Node {
	float value;
	int level;

	Node(float v, int l) {
		value = v;
		level = l;
	}
}
