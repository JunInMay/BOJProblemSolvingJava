package problems.from.number26100;

import java.io.*;
import java.util.*;

public class Baekjoon26123 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int cityCount = Integer.parseInt(st.nextToken());
		int dayCount = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		ArrayList<Integer> cities = new ArrayList<>();
		while (st.hasMoreTokens()) {
			cities.add(Integer.parseInt(st.nextToken()));
		}
		cities.sort(Comparator.reverseOrder());
		int destroyCount = 0;
		int startIndex = 0;
		int destroyFloor = cities.get(0);
		long result = 0;
		while (dayCount-- > 0) {
			if (destroyFloor == 0) {
				break;
			}
			for (; startIndex<cityCount; startIndex++) {
				if (cities.get(startIndex) >= destroyFloor) {
					destroyCount += 1;
				} else {
					break;
				}
			}
			destroyFloor -= 1;
			result += destroyCount;
		}
		System.out.println(result);
	}
}
