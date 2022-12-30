package problems.from.number23800;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

/** 풀이
 * 로직을 땜빵하면서 푼거라 좀.. 별로일 수 있음
 * 
 * # 기본 개요
 * 첫 줄에 군만두를 주는 기준 값을(나머지로 나뉠 제수) 받음
 * 이후 둘째 줄에 짜장면과 짬뽕의 주문의 개수를 받고, 아직 정해지지 않은 주문 개수를 받음
 * 출력은 군만두 값을 최대로 하면서 볶음밥의 주문 수를 최대로 할 때의 "볶음밥의 수" 
 * 
 * # A. 아직 정해지지 않은 주문 처리
 * 짜장과 짬뽕은 이미 고정된 값이다. 이 상황에서 볶음밥의 주문 수를 최대로 해야 하므로 아직 정해지지 않은 주문은 모두 볶음밥이라고 처리해야한다.
 * 문제를 해결하기 위해 짜장과 짬뽕 주문은 볶음밥 주문을 쓰면서 짜장, 짬뽕 주문을 늘린다고 생각해야 한다는 말과 같다.  
 * 
 * # B. 우선 처리
 * 입력이 3 1 2 5일 때(실제론 두 줄씩 입력되지만 두 줄씩 입력하기 번거로우니 앞으로 첫 값을(여기선 3) 군만두를 주는 기준 값이라고 하자.) 
 * 군만두는 2개 받을 수 있다. 그런데 볶음밥은 1개가 남는다. 1, 2중 볶음밥은 어디로 가야할까? 2로 가야한다.
 * 여기서 2로 가야하는 이유는 그래야 볶음밥 주문을 최대한 덜 쓰면서 군만두 조건인 3을 제일 빠르게 달성할 수 있기 때문이다. greedy한 논리다.
 * 따라서 1, 2를 정렬하되, 군만두 조건에 제일 가까운 값을 우선하도록 정렬한다. -> 2, 1이 된다.
 * 
 * # C. 여분 처리
 * 기본적으로 짜장과 짬뽕에 줄 수 있는 볶음밥 주문은 군만두 조건에 일치하고 남는 볶음밥 주문이다.
 * 예를 들면 군만두 조건이 10, 볶음밥이 13개면 3개만 짜장, 짬뽕에 줄 수 있을 것이다.
 * 
 * # D. 희생 처리
 * 생각하지 못했던 땜빵 로직이다.
 * 10 6 7 10이나 10 6 7 11과 같은 상황에선 군만두를 최대 2개 받을 수 있다. 왜냐하면 6, 7을 10으로 만들어 10 10 3이 되면 군만두를 2개 받을 수 있기 때문이다.
 * 즉 C에서와 같이 볶음밥(여기선 10)의 여분(0)만 주는게 아니라 볶음밥을 통해 받는 군만두 1개를 희생해서 짬,짜,볶의 군만두를 최대로 만들어야 하는 상황도 존재한다는 것이다.
 * 그럼 어떨 때 볶음밥으로 만들 수 있는 군만두를 희생해야 할까?
 * 볶음밥으로 받을 수 있는 군만두 1개를 희생해서 짬, 짜의 군만두를 1개씩 총 2개 받을 수 있다면 이득이다.
 * 10 6 7 10에서 짬,짜가 군만두를 받기 위해 필요한 개수는 4, 3이고, 합치면 7이다.
 * 볶음밥이 10개이므로 7을 커버할 수 있다. 따라서 볶음밥 10에서 7을 빼줘서 나눠주면 된다.
 * 그런데 10 5 5 15는 어떨까? 똑같은 논리로 군만두를 받기 위해 필요한 주문 개수는 5, 5이고 합치면 10이다.
 * 볶음밥이 15개이므로 10을 커버할 수 있으니 볶음밥 15에서 10을 빼줘서 나눠주면 될까?
 * 그러면 볶음밥이 5가 되고, 최종적으로 10 10 5로 정답이 아니다.
 * 군만두도, 볶음밥도 최대가 되어야 하므로 정답은 10 5 10이 되어야 한다.
 * 즉 짬뽕, 짜장면의 부족한 개수 둘 중 어느 하나도 볶음밥의 여분보다 작지 않아야 한다.
 * 이를테면 10 5 4 14에서 짜장의 부족함인 5, 짬뽕의 부족함인 6을 더해 11이 14보다 작고
 * 볶음밥의 여분인 4로 짜장과 짬뽕의 부족함을 채울 수 없는 상태일 때만 볶음밥을 짬,짜에 나눠줄 수 있다. 
 * 
 * 예외가 참 많다. 볶음밥을 빼서 짜장, 짬뽕에 분배할 때 이득보는 조건을 알기 쉽게 식으로 나타내보려고 한다.
 * 3 1 1 4 와 같은 경우엔 볶음밥 4를 전부 짬,짜에 나눠야 한다.
 * 어떤 조건일 때 볶음밥을 짬, 짜에 각각 나누는 경우일지 생각해보자.
 * 짬뽕이 군만두를 받기 위해 부족한 양 : nJP,
 * 짜장이 군만두를 받기 위해 부족한 양 : nJZ 라고 하고 볶음밥을 k라고 하면
 * ##### 1. nJP + nJZ <= k여야 한다. #####
 * 왜냐면 일단 부족한 양을 볶음밥이 채워줄 수 있으려면 볶음밥이 부족한 양보다 더 많이 있어야 하기 때문이다. 자명하다.
 * 
 * 군만두 조건 : d라고 하면
 * ##### 2. nJP + nJZ <= d + k % d 여야 한다. #####
 * 볶음밥에서 군만두조건을 1개 포기하고 짜장, 짬뽕에 주문을 줌으로써 군만두 조건을 이득보려면
 * 무조건 볶음밥에서 군만두조건을 "1"개 포기하고, 짜장, 짬뽕에 군만두조건 각 1개씩 총 군만두조건이 2개 추가되어야 한다.
 * 반드시 볶음밥 k에서 군만두조건을 딱 "1"개만 포기해야 한다. 또 포기했을 때 주문의 개수가 nJP와 nJZ와 같거나 보다 커야한다.(만족한다는 뜻)
 * 즉 볶음밥 k에서 군만두조건을 1개만 포기할 때 빠지는 볶음밥 주문의 개수를 구해야 한다.
 * 예를 들어 5 2 2 11 일 때 k=11에서 6까지만 뺄 수 있다. 7 이상 빼면 군만두 조건을 2개만 포기하는게 되기 때문이다.
 * 따라서 k에서 군만두조건을 1개만 포기할 때 최대값은 d + k % d이고, nJP와 nJZC는 이것을 넘지 않아야 한다. 넘는다면 군만두조건을 이득보는게 아니게 되기 때문이다.
 * 
 * ##### 3. nJP > k % d && nJZ > k % d여야 한다. #####
 * 3 2 1 4 일 때, 볶음밥에서 군만두 조건을 1개 포기하고 짜장, 짬뽕에 군만두 조건을 2개 추가할 수 있다.
 * 얼핏 보면 이득처럼 보이기도 하지만, 애초에 볶음밥에서 여분의 개수가 1개  (4%3 = 1) 남아있고 그 1개를 짜장(2)에 추가해서 군만두 조건을 만들 수 있다.
 * 즉 잉여 볶음밥 주문으로 짜장, 짬뽕의 군만두 조건을 만족할 수 없어야 한다. 
 * 
 */
public class Baekjoon23814 {
	static long divisor;
	static long toLong(String s) {
		return Long.parseLong(s);
	}
	static long getNeed(long number) {
		if (number % divisor == 0) {
			return 0L;
		}
		return divisor - (number) % divisor;
	}

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		divisor = toLong(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		long n = toLong(st.nextToken());
		long m = toLong(st.nextToken());
		ArrayList<Long> menus = new ArrayList<>(Arrays.asList(
				n, m));
		Collections.sort(menus, new Comparator<Long>() {
			@Override
			public int compare(Long o1, Long o2) {
				if (o1 % divisor >= o2 % divisor) {
					return -1;
				}
				return 1;
			}
		});
		
		Long k = toLong(st.nextToken());
		Long needN = getNeed(n);
		Long needM = getNeed(m);
		Long surplus = k % divisor;
		if (needN + needM <= k && 
				needN + needM <= divisor + surplus &&
				needN > surplus && needM > surplus) {
			surplus = k;
		}
		k -= surplus;
		
		for (Long menu : menus) {
			Long need = getNeed(menu);
			if (need <= surplus) {
				surplus -= need;
			}
		}
		System.out.println(k + surplus);
	}

}

/*

3
5 5 20

3
1 1 10

2
1 1 3

2
1 1 4

2
11 11 4


10
8 9 2
A : 1

10
8 9 3
A : 0

10
5 5 1
A : 1

10
5 5 15
A : 10

10
3 3 15
A : 1

10
0 9 16
A : 15

10
8 9 10
A : 7

10
8 9 11
A : 10

10
8 9 7
A : 4

10
18 19 7
A : 4

1
1 1 1
A : 1

1
0 0 2
A : 2


10
17 16 5
A : 2

3
2 4 10
2079711786
1272148730 656515578 286341160

3
3 4 5
A : 3
3
3 4 6
A : 6
3
3 4 7
A : 7


1
1000000000000000000 1000000000000000000 1000000000000000000

7
10 11 3
A : 0

10
6 7 10
A : 3

10
6 7 3
A : 0

10
16 17 11
A : 4

2
0 0 2
A : 2

3
1 2 5
A : 4

*/