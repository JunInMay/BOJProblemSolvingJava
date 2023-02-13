package problems.from.number02800;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.StringTokenizer;

/** 
 * @date 2022-11-21
 * @level 당시 Gold3
 * @Description
 * [구구절절한 사연(읽을 필요 없음)]
 * 처음에 문제를 읽고 겹쳐져있는 직사각형의 둘레에 있는 나무의 개수를 구하라는 문제인 줄 알았다.
 * 그래서 대충 30분동안 고민했는데 잘 모르겠어서 문제를 다시 읽어보니 각각의 직사각형의 변 위의 나무의 개수를 구하라는 문제였다.
 * 시간을 날려서 멘탈도 살짝 금이 갔다.
 * 문제 난이도는 Gold3으로 난이도가 있는 편이어서 어차피 풀 수 없는 문제라고 가정(밑밥?)을 한 뒤 문제 풀이에 임해서 더 침착할 수 있었던 것 같다.
 * 
 * [고민1]
 * 어쨌든 나무의 개수를 구하라고 했고, 제일 먼저 떠오른 생각은 배열에 나무의 여부를 true/false로 저장하고 직사각형의 선분을 따라 나무의 존재 여부를 체크 하는 것이다.
 * 그런데 이렇게 하면 메모리가 미친듯이 든다. 10^9^2 bit, 안 세어도 엄청난 메모리...
 * 
 * [고민2]
 * 아 배열로 하면 안되겠다. 나무가 심어질 영역(이차원 boolean 배열)을 저장하는 게 아니라 실제로 나무가 심어진 만큼만 메모리를 확보해야 한다고 생각했다.
 * 그럼 X, Y의 값에따라 나무의 위치를 저장하는 배열을 넣으면 되겠다는 결론에 겨우 다다랐다.
 * 
 * [고민3]
 * 근데 직사각형의 크기가 1, 10^9, 1, 10^9가 될 수 있다. 이만한 크기의 변을 전부 체크하면서 나무의 개수를 셀 순 없다...
 * 그럼.. 시작점과 종점만으로 개수를 계산하면 어떨까?
 * 
 * [풀이]
 * 이분탐색을 활용한다.
 * x=1인 지점에 나무가 y=1, 3, 5, 7, 9가 심어져 있다고 생각해보자.
 * 직사각형은 (1, 2), (2, 8) 이라고 생각해보자.
 * x=1인 지점에 탐색할 선분의 길이는 (1, 2) 부터 (1, 8) 이다.
 * 여기서 선분 위에 놓인 나무를 세려면 x=1인 지점에 나무가 y >= 2이고, 8 >= y인 나무들이다.
 * 그 나무를 전부 셀 수는 없으므로, 인덱스의 차를 이용해서 나무의 개수를 구한다.
 * 시작점이 y=2, 종점이 y=8 이므로 x=1인 지점의 나무들 중에 2의 위치를 이분 탐색으로 찾는다.
 * 2가 없다면, 적어도 2보단 높은 위치에 있는 나무들 중에서 가장 작은 나무를 찾는다.
 * 종점이 y=8이므로, x=1인 지점의 나무들중에 8의 위치를 이분 탐색으로 찾는다.
 * 나무들 중에 8이 없다면, 적어도 8보단 낮은 위치에 있는 나무들 중에서 가장 큰 나무를 찾는다.
 * 결국 3과 7을 찾을텐데, 각 인덱스는 1과 3이므로 인덱스 1부터 3까지의 나무의 개수를 구하면 (3-1)+1 = 3이다.
 * 선분위에 놓인 나무는 (1, 3), (1, 5), (1, 7) 3그루이다.
 * 
 * 이를 y축으로도 반복한다.
 * 그런데 모서리 부분은 중복 계산되므로 y축에서 x축으로 나열된 나무를 셀 때에는 x축의 범위를 좌우로 1칸씩 줄이면 된다.
 * 직사각형의 변은 4개이므로 x축 2번, y축 2번 총 4번 이분탐색하면 결과가 도출된다.
 * 
 * [시간복잡도]
 * 나무는 최대 300,000개가 입력으로 들어온다.
 * 나무를 x축 기준으로도 정렬하고, y축 기준으로도 정렬해야 하므로 총 600,000개를 정렬한다고 생각한다.
 * 나무를 정렬할 적엔 병합 정렬을 사용했다고 가정하고 O(N lg N)이 나온다.
 * 그 나무들에 대해서 이분 탐색을 진행하는데 이분 탐색의 시간 복잡도는 O(lg N)이다.
 * 시작점, 종점에 대해서 이분 탐색을 진행하는데 총 선분은 4개이므로 4*2(선분 4개 * 시작점, 종점) = 8, 즉 O(8 lg N)이다.
 * 결국 O(lg N)이다.
 * 그런데 이분 탐색을 산책로 개수에 비례해 반복해야 하므로 산책로 개수를 M이라 하면
 * O(M lg N) 이다.
 * 정렬 후에 이분 탐색을 반복 진행하므로 O(M lg N) 이라고 보면 될듯하다.
 */


public class Baekjoon2881 {
	static HashMap<Integer, ArrayList<Integer>> treesX;
	static HashMap<Integer, ArrayList<Integer>> treesY;
	
	// 직사각형의 둘레에 놓인 나무의 개수를 모두 세는 함수
	static int countTrees(int x1, int y1, int x2, int y2) {
		int result = 0;
		// 직사각형의 변은 4개이므로 4번 호출한다.
		result += getTreesLine(y1, y2, treesX.getOrDefault(x1, new ArrayList<>()));
		result += getTreesLine(y1, y2, treesX.getOrDefault(x2, new ArrayList<>()));
		result += getTreesLine(x1+1, x2-1, treesY.getOrDefault(y1, new ArrayList<>()));
		result += getTreesLine(x1+1, x2-1, treesY.getOrDefault(y2, new ArrayList<>()));
		
		return result;
	}
	// 직사각형의 한 선분에 놓인 나무의 개수를 모두 세는 함수
	static int getTreesLine(int start, int end, ArrayList<Integer> list) {
		int startIndex = binarySearch(start, end, start, list);
		int endIndex = binarySearch(start, end, end, list);
		
		if (startIndex == -1 || endIndex == -1) {
			return 0;
		}
		
		return endIndex - startIndex + 1;
	}
	// 선분의 범위에 포함되고, 목표값(goal)에 가장 근접한 나무의 인덱스를 찾는 함수(이분탐색)
	static int binarySearch(int rangeStart, int rangeEnd, int goal, ArrayList<Integer> list) {
		int index = -1;
		int start = 0;
		int end = list.size() - 1;
		while (start <= end) {
			int mid = (start + end) / 2;
			if (list.get(mid) < goal) {
				start = mid+1;
			} else if (list.get(mid) == goal) {
				return mid;
			} else {
				end = mid-1;
			}
			if (rangeStart <= list.get(mid) && list.get(mid) <= rangeEnd) {
				index = mid;
			}
		}
		return index;
	}

	public static void main(String[] args) throws IOException{
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		int treeCount = Integer.parseInt(br.readLine());
		treesX = new HashMap<>();
		treesY = new HashMap<>();
		
		StringTokenizer st;
		while (treeCount-- > 0) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			treesX.putIfAbsent(x, new ArrayList<>());
			treesY.putIfAbsent(y, new ArrayList<>());
			treesX.get(x).add(y);
			treesY.get(y).add(x);
		}
		
		// 이분탐색을 위해 각 리스트들은 정렬되어야 한다.
		for (Entry<Integer, ArrayList<Integer>> entry: treesX.entrySet()) {
			Collections.sort(entry.getValue());
		}
		for (Entry<Integer, ArrayList<Integer>> entry: treesY.entrySet()) {
			Collections.sort(entry.getValue());
		} 
		// 여기까지가 입력부.
		
		int walkwayCount = Integer.parseInt(br.readLine());
		while (walkwayCount-- > 0) {
			st = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			
			int result = 0;
			
			result = countTrees(x1, y1, x2, y2);
			System.out.println(result);
		}
	}
}


/*

4
1 1
1 2
2 1
2 2
1
1 1 2 2



*/