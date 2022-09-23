package problems.from.number08700;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 * 메모리 초과 문제를 겪었던 문제임, 아래에 해결과정을 적음
 * 
 * Goal : int[]의 값을 1 2 3 4 5 6 -1 3 -2 4 ... 와 같이 출력하기, 최대 길이 : 1,000,000개
 * 
 * 1. Array를 for문을 돌면서 나온 배열 값을 String에 '+' 연산으로 이어 붙이기
 * -> 실패, String : immutable 객체, 불변 객체, 변화할 수 없는 객체이므로 + 연산을 할 때마다 String값이 새로 생성된다고 보면 됨
 * -> 100만개의 String을 생성함에 따라 메모리 초과 위험성 증대 -> 채점율 15%? 언저리에서 메모리 초과
 * 
 * 2. 1번 방법으로 String을 짜고 BufferedWriter 사용해서 출력
 * -> 실패, 어차피 100만개의 String을 만들기 때문에 실패
 * 
 * 3. Arrays.toString으로 for문을 돌지 않고 결과 String을 만든 후 replaceAll을 통해 정규표현식 작성해서 [1, 2, 3, ...]과 같이 되어있는 String 값을 1, 2, 3... 으로 정제
 * -> 실패, replaceAll도 결국 내부적으로 String을 새로 만듦 채점율 33% 언저리에서 메모리 초과
 * 	※ 궁금점 : replaceAll을 쓰면 immutable한 String을 반복적으로 만든다고? 그럼 replaceAll이란 메소드는 활용해도 되는 메소드인가? 아니면 더 적절한 정규표현식 엔진? 이라는게 존재하나?
 * 
 * 4. 로직에 필요한 Object 변수들(Array, Deque 등)을 while문 밖에서 선언
 * -> 실패, 의미 없는 시도라는 것을 알고는 있었지만 혹시 몰라 시도했으나 역시 실패. while문 밖에서 선언하나 안에서 선언하나 어차피 GC가 컨트롤한다.
 * 
 * 5. Array를 for문을 돌면서 나온 값들을 StringBuilder에 조합
 * -> 성공, 역시 String을 계속 새로 만드는 것이 문제였다.
 * -> 추가적으로 StringBuilder를 쓰기만 하면 BufferedWriter를 안써도 풀렸다.
 */

public class Baekjoon8774 {
	static int toInt(String s) {
		return Integer.parseInt(s);
	}
	
	public static void main(String[] args) throws IOException {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		
		int casesCount = toInt(br.readLine().trim()); 
		int iterationCount = 0;
		while(iterationCount++ < casesCount) {
			int listSize = toInt(br.readLine().trim());
			StringTokenizer st = new StringTokenizer(br.readLine());
			ArrayDeque<HektorData> dataList = new ArrayDeque<>();
			int[] resultList = new int[listSize];
			Arrays.fill(resultList, -1);
			
			for (int i=0; i<listSize; i++) {
				int value = toInt(st.nextToken());
				
				while (!dataList.isEmpty() && dataList.getFirst().value < value) {
					HektorData topData = dataList.pop();
					resultList[topData.index] = i;
				}
				dataList.push(new HektorData(value, i));
			}
			
			StringBuilder sb = new StringBuilder();
			for (int number : resultList) {
				sb.append(number);
				sb.append(" ");
			}
			System.out.println(sb);
		}
	}
}

class HektorData {
	int value;
	int index;

	HektorData(int value, int index){
		this.value = value;
		this.index = index;
	}
}
/*
1
9
3 2 1 3 2 1 4 2 1
 */
