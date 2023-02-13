package problems.from.number15700;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Baekjoon15761 {

	public static void main(String[] args) throws IOException {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		
		int cowCount = Integer.parseInt(br.readLine());
		int size = cowCount;
		
		ArrayList<Integer> descCows = new ArrayList<>();
		ArrayList<Integer> ascCows = new ArrayList<>();
		StringTokenizer st = new StringTokenizer(br.readLine());
		while (cowCount-- > 0) {
			int cow = Integer.parseInt(st.nextToken());
			descCows.add(cow);
			ascCows.add(cow);
		}
		
		Collections.sort(descCows, Collections.reverseOrder());
		Collections.sort(ascCows);
		int result = 0;
		ArrayList<Integer> acceptedCows = new ArrayList<>();
		int ascIndex = 0;
		int descIndex = 0;
		while (true) {
			if (ascCows.get(ascIndex) < acceptedCows.size()) {
				ascIndex++;
				continue;
			}
			if (descIndex <= (size - ascIndex - 1)) {
				acceptedCows.add(descCows.get(descIndex));
				descIndex++;
				result++;
			} else {
				break;
			}
		}
//		System.out.println(acceptedCows);
		System.out.println(result);
	}

}



/*

5
400 2 1 2 7


*/