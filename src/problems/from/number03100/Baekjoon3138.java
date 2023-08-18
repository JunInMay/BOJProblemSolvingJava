package problems.from.number03100;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon3138 {
	static int roadIndex;
	static int roadIndexStart;
	static int maxLength;
	
	static void checkMaxParkingSpot(char[] road) {
		roadIndex = -1;
		roadIndexStart = -1;
		maxLength = -1;
		int currentIndex = -1;
		int currentIndexStart = -1;
		int currentLength = 0;
		boolean isPillarBefore = true;
		
		for (int i = 0; i < road.length; i++) {
			char now = road[i];
			if (now == '.') {
				if (isPillarBefore) {
					currentLength += 1;
					currentIndexStart = i;
					isPillarBefore = false;
				} else {
					currentIndex += 1;
					currentLength += 1;
				}
				
				if (currentLength > maxLength) {
					roadIndex = currentIndex;
					roadIndexStart = currentIndexStart;
					maxLength = currentLength;
				}
			} else {
				isPillarBefore = true;
				currentLength = 0;
			}
		}
		
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int pillarCount = Integer.parseInt(st.nextToken());
		int carLength = Integer.parseInt(st.nextToken());
		
		char[] road = br.readLine().toCharArray();
		
		while (true) {
			checkMaxParkingSpot(road);
			if (maxLength < carLength || pillarCount == 0) {
				break;
			}
			
			road[roadIndexStart + carLength - 1] = 'X';
			pillarCount -= 1;
		}
		System.out.println(road);
	}

}
