package problems.from.number12000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.StringTokenizer;

/*
 * 이분 그래프 문제(그래프의 연결된 노드들을 번갈아가며 Red와 Black으로 채울수 있는가를 판별하는 문제)
 */
public class Baekjoon12083 {
	static int toInt(String s) {
		return Integer.parseInt(s);
	}
	
	public static void main(String[] args) throws IOException {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		
		int caseCount = toInt(br.readLine());
		for (int iteration=0; iteration<caseCount; iteration++) {
			int pairsCount = toInt(br.readLine());
			
			// 그래프를 저장할 table과 해당 테이블에 입력된 문자열 방문 여부를 체크하는 checked 선언
			// checked의 상태는 3개로 핸들링됨 : 0 = 방문한 적 없음 1 = 방문했음, Red로 칠해짐 -1 = 방문했음, Black으로 칠해짐
			HashMap<String, ArrayList<String>> table = new HashMap<>();
			HashMap<String, Integer> checked = new HashMap<>();
			
			// 그래프 초기화
			for (int i=0; i<pairsCount; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				String left = st.nextToken();
				String right = st.nextToken();
				
				// 테이블에 값이 없을 경우 right가 추가된 리스트를 테이블에 추가함 
				// 테이블에 값이 있을 경우 해당 값이 가리키는 리스트에 right를 추가함
				if (!table.containsKey(left)) {
					ArrayList<String> list = new ArrayList<>();
					list.add(right);
					table.put(left, list);
				} else {
					table.get(left).add(right);
				}
				if (!table.containsKey(right)) {
					ArrayList<String> list = new ArrayList<>();
					list.add(left);
					table.put(right, list);
				} else {
					table.get(right).add(left);
				}
				// 방문한 적 없는 상태로 초기화 해야하므로 checked에 입력된 left, right 값을 넣음
				checked.put(left, 0);
				checked.put(right, 0);
			}
			
			// R, B로 색을 온전히 칠할 수 있는지 여부
			boolean isColorable = true;
			
			for (Entry<String, ArrayList<String>> e : table.entrySet()) {
				// 그래프에 섬(Island)이 존재할 수 있으므로, 그래프의 모든 노드들을 확인하면서 시작점을 찾음
				// 시작점이라고 함은 checked에서 0 값을(방문하지 않은 상태) 가지고 있는 노드를 말함
				if (checked.get(e.getKey()) == 0) {
					// 시작점을 찾을 경우 해당 시작점으로부터 BFS를 돎
					ArrayDeque<String> queue = new ArrayDeque<>();
					queue.add(e.getKey());
					checked.put(e.getKey(), 1); // 처음엔 R로 칠함
					
					while(!queue.isEmpty()) {
						String now = queue.poll();
						
						for (String candidate : table.get(now)) {
							// 다음 노드들을 확인하면서 아래와 같은 작업을 함
							// 방문하지 않은 노드일경우 직전 노드의 값에 -1을 곱한 값(1이면 -1, -1이면 1로 반대로 칠하게 됨)을 넣음
							// 방문한 노드이고, 색이 다를 경우 정상 케이스이므로 continue
							// 방문한 노드이고, 색이 같을 경우 비정상 케이스이므로 break
							if (checked.get(candidate) == 0) {
								checked.put(candidate, checked.get(now) * -1);
								queue.add(candidate);
							} else if (checked.get(candidate) != checked.get(now)){
								continue;
							} else {
								isColorable = false;
								break;
							}
						}
					}
				}
				if (!isColorable) {
					break;
				}
			}
			
			String result;
			if (isColorable) {
				result = "Yes";
			} else {
				result = "No";
			}
			System.out.println(String.format("Case #%d: %s", iteration+1, result));
		}
	}
}

/*
2
1
Dead_Bowie Fake_Thomas_Jefferson
3
Dead_Bowie Fake_Thomas_Jefferson
Fake_Thomas_Jefferson Fury_Leika
Fury_Leika Dead_Bowie

3
3
a b
b c
c a
4
a b
b c
c d
d e
7
x y
x z
a b
b y
c d
d e
e c
 
 
*/