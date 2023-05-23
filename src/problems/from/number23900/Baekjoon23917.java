package problems.from.number23900;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Baekjoon23917 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int caseCount = Integer.parseInt(br.readLine());

		StringBuilder sb = new StringBuilder();
		for (int n=1; n<=caseCount; n++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int people = Integer.parseInt(st.nextToken());
			int maxWithdrawal = Integer.parseInt(st.nextToken());
			
			st = new StringTokenizer(br.readLine());
			ArrayList<Node> list = new ArrayList<>();
			for (int i=0; i<people; i++) {
				Node now = new Node(i, Integer.parseInt(st.nextToken()));
				list.add(now);
			}
			
			Collections.sort(list, new Comparator<Node>() {
				@Override
				public int compare(Node o1, Node o2) {
					int time1 = o1.amount / maxWithdrawal + (o1.amount % maxWithdrawal == 0 ? -1 : 0);
					int time2 = o2.amount / maxWithdrawal + (o2.amount % maxWithdrawal == 0 ? -1 : 0);
					
					if (time1 == time2) {
						return o1.index - o2.index;
					}
					return time1 - time2;
				}
			});
			
			sb.append(String.format("Case #%d:", n));
			for (int i=0; i<people; i++) {
				sb.append(String.format(" %d", list.get(i).index+1));
			}
			sb.append('\n');
		}
		System.out.print(sb);
	}

}

class Node {
	int index;
	int amount;
	
	Node (int i, int a) {
		index = i;
		amount = a;
	}
}

/*


1
6 224891833
131897553 738140491 461220411 248168008 384578874 970051737


ans : 1 4 5 3 2 6

1
6 100
50 410 320 210 200 430


*/