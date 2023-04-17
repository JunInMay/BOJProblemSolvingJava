package problems.from.number04900;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon4992 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while (true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int size = Integer.parseInt(st.nextToken());
			int operationCount = Integer.parseInt(st.nextToken());
			if (size == 0 && operationCount == 0) {
				break;
			}
			
			Hanafuda hanafuda = new Hanafuda();
			for (int i=1; i<=size; i++) {
				hanafuda.stack(new Node(i));
			}
			for (int i=0; i<operationCount; i++) {
				st = new StringTokenizer(br.readLine());
				int from = Integer.parseInt(st.nextToken());
				int amount = Integer.parseInt(st.nextToken());
				hanafuda.cut(from, amount);
				System.out.println(hanafuda.print());
			}
			System.out.println(hanafuda.top.value);
		}
		
	}

}

class Hanafuda {
	int size;
	Node top;
	Node bottom;
	
	void stack(Node n) {
		if (size == 0) {
			top = n;
			bottom = n;
		} else {
			n.next = top;
			top.before = n;
			top = n;
		}
		size += 1;
	}
	
	void cut(int from, int amount) {
		Node initialTop = top;
		Node fromTop = top;
		for (int i=1; i<from; i++) {
			fromTop = fromTop.next;
		}
		Node topBottom = fromTop.before;
		Node toBottom = fromTop;
		for (int i=1; i<amount; i++) {
			toBottom = toBottom.next;
		}
		Node bottomTop = toBottom.next;
		
		top = fromTop;
		fromTop.before = null;
		if (from > 1) {
			toBottom.next = initialTop;
			initialTop.before = toBottom;
		}
		if (topBottom != null) {
			topBottom.next = bottomTop;
			if (bottomTop != null) {
				bottomTop.before = topBottom;
			}
		}
	}
	
	String print() {
		StringBuilder sb = new StringBuilder();
		Node now = top;
		for (int i=0; i<size; i++) {
			sb.append(now.value);
			sb.append(' ');
			now = now.next;
		}
		return sb.toString();
	}
}

class Node {
	Node next = null;
	Node before = null;
	int value;
	
	Node (int v) {
		value = v;
	}
}


/*

5 3
1 3
1 3
1 3

1 1
1 1
1 1

*/