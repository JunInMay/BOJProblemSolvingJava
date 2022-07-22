package problems.from.number17900;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Baekjoon_17901 {
	
	public static int toInt(String s) {
		return Integer.parseInt(s);
	}

	public static void main(String[] args) throws IOException {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		
		Map<Integer, List<Integer>> indexByNumbers = new HashMap<>();
		Map<Integer, Integer> minimumByNumbers = new HashMap<>();
		
		int people = toInt(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i=0; i<people; i++) {
			int number = toInt(st.nextToken());
			if (indexByNumbers.containsKey(number)) {
				indexByNumbers.get(number).add(i);
			} else {
				List<Integer> indexList = new ArrayList<>();
				indexList.add(i);
				indexByNumbers.put(number, indexList);
			}
		}
	
		
		for (Integer key : indexByNumbers.keySet()) {
			List<Integer> indexList = indexByNumbers.get(key);
			int tempMin = Integer.MAX_VALUE;
			for (int i=0; i<indexList.size()-1; i++) {
				int front = indexList.get(i);
				int rear = indexList.get(i+1);
				tempMin = Math.min(tempMin, rear-front);
				
			}
			minimumByNumbers.put(key, tempMin);
		}
		
		int result = Integer.MAX_VALUE;
		for (Integer key : minimumByNumbers.keySet()) {
			result = Math.min(result, minimumByNumbers.get(key));
		}
		
		if (result == Integer.MAX_VALUE) {
			System.out.println(people);
		} else {
			System.out.println(result);
		}

	}

}


/*
5
1 2 1 3 2

4
1 2 1 3

19
1 2 3 4 5 6 7 8 9 10 9 8 7 6 5 4 3 2 1

11
1 3 1 3 4 5 6 7 8 9 1

*/
