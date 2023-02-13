package problems.from.number01400;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baekjoon1456 {
	static long toLong(String s) {
		return Long.parseLong(s);
	}

	public static void main(String[] args) throws IOException {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		
		// 10^7 limit
		int limit = (int) Math.pow(10, 7) + 1;
		
		boolean[] sieve = new boolean[limit];
		Arrays.fill(sieve, true);
		sieve[0] = false;
		sieve[1] = false;
		
		for (int i=2; i<limit; i++) {
			if (sieve[i]) {
				for (int j=i*2; j<limit; j+=i) {
					sieve[j] = false;
				}
			}
		}
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		long start = toLong(st.nextToken());
		long end = toLong(st.nextToken());
		
		int root = 2;
		int count = 0;
		while (true) {
			int startIndex = (int) Math.pow(start, (1.0/root));
			/*
			 * 이 부분에서 문제가 많았음
			 * Math.pow(125, 1/3) = 5가 될 줄 알았는데, 4.99999임 (부동소수점 부정확성 때문)
			 * 앞으로 이를 잘 고려해서 실수를 다뤄야한다고 느낌
			 * 
			 * 문제에 관해서 얘기하자면 startIndex와 endIndex는 사실 단순히 소수의 범위를 줄이기 위해서 정의한 것이므로 어느정도 오차가 나도 상관없음
			 * 어차피 if문으로 소수의 n 제곱이 범위 안에 들어가는지 체크하기 때문임
			 * 그래서 실수 연산의 부정확성을 감안해서 end에 1을 더하고 거기의 제곱근을 구함
			 * 
			 * start는 왜 -1을 안해줬냐면, 사실 해주고 풀었었는데 그럴 경우 start에 1이 들어올때 start - 1 = 0이 되며, 0은 몇제곱을 해도 0이므로,
			 * startIndex == 1 && endIndex==1을 만족하지 못해서 무한루프가 돎
			 * 그리고 어차피 (int) 형으로 변환하는데, start의 최소값은 1이고, root는 2니까 startIndex는 못해도 1이상일 수 밖에 없음
			 * 왜냐면 1의 제곱근, 1의 세제곱근 .. 을 구해봐야 1이기 때문
			 * 
			 * -> 궁금한 것은, 1.0의 5제곱근, 27제곱근 등... 이런것을 pow 연산했을 때 무조건 1.0이 나오나? 아까 Math.pow(125, 1/3)과 같이 뒷자리가 0.99999로 떨어지고,
			 * 이로 인해 (int) 캐스팅이 0이 되어서 무한 루프가 돌지는 않았다.
			 * 왜 1.0이 무조건 나오지? 실수의 부정확성 때문에 운이 좋지 않으면 0.99999... 가 나올 수도 있는 것 같은데? 
			 *  
			 */
			int endIndex = (int) Math.pow(end+1, (1.0/root));
			if (startIndex == 1 && endIndex == 1) {
//				System.out.println("root: " + root);
				break;
			}
//			System.out.println("root : " + root);
//			System.out.println("start : " + startIndex);
//			System.out.println("end : " + endIndex);
			
			for (int i=startIndex; i<=endIndex; i++) {
				if (sieve[i]) {
					long powed = (long)Math.pow(i, root);
					if (start <= powed && powed <= end) {
						count++;
//						System.out.println("powed : " + powed + " root : " + root + " i : " + i);
					}
				}
			}
			root++;
		}
		
		System.out.println(count);
	}
}

/*
100000000000000 100000000000000
10000000000000 100000000000000
10 100000000000000
99999999999999 100000000000000
1 100000000000000
8 27
8 9 16 25 27
*/