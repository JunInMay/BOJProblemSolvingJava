package problems.from.number24300;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baekjoon24390 {
	static int[] dTStarted = {60, 6, 3, 1};

	public static void main(String[] args) throws IOException {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		StringTokenizer st = new StringTokenizer(br.readLine(), ":");
		
		int minutes = Integer.parseInt(st.nextToken());
		int seconds = Integer.parseInt(st.nextToken());
		int time = (minutes * 60 + seconds)/10;
		/*
		 * 시작 버튼이 눌렸는지/안눌렸는지에 따른 최적화 케이스를 메모함
		 * optimizedCases[3][0] = 시작 버튼을 누르지 않고 30초를 만드는 경우 = 3(10초를 3번 누르므로)
		 * optimizedCases[3][1] = 시작 버튼을 누르고 30초를 만드는 경우 = 1
		 */
		int[][] optimizedCases = new int[361][2];
		for (int i=0; i<361; i++) {
			Arrays.fill(optimizedCases[i], Integer.MAX_VALUE-1);
		}
		optimizedCases[0][0] = 0;
		optimizedCases[3][1] = 1;
		
		for (int i=0; i<361; i++) {
			for (int j=0; j<dTStarted.length; j++) {
				int beforeIndex = i - dTStarted[j];
				if (beforeIndex < 0) {
					continue;
				}
				for (int k=0; k<2; k++) {
					// 시작버튼을 누르는 케이스는 dTStarted[j] == 3일 경우이고, k == 0일 때(시작 버튼을 누르지 않는 케이스) 시작버튼을 누르는 경우는 계산되면 안됨
					if (!(k==0 && dTStarted[j] == 3)) {
						optimizedCases[i][k] = Math.min(optimizedCases[i][k], optimizedCases[beforeIndex][k] + 1);
					}
				}
			}
		}
		
		// 결과는 시작버튼을 누르지 않고 목표 시간에 도달한 최적값 + 시작버튼 누르기 1회 / 시작버튼을 누른채로 목표 시간에 도달한 최적값 의 최소값임 
		int result = Math.min(optimizedCases[time][0]+1, optimizedCases[time][1]);
		System.out.println(result);
	}
}
