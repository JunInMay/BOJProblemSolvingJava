package problems.from.number01300;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon1343 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String A = "AAAA";
		String B = "BB";
		String board = br.readLine();
		
		StringBuilder result = new StringBuilder();
		int area = 0;
		for (int i=0; i<board.length(); i++){
			char now = board.charAt(i);
			if (now == 'X') {
				area += 1;
			}
			if (now == '.' || i == board.length() - 1) {
				boolean fillable = area % 2 == 0 ? true : false;
				if (fillable) {
					int aCount = area / 4;
					int bCount = (area % 4) / 2;
					while (aCount-- > 0) {
						result.append(A);
					}
					while (bCount-- > 0) {
						result.append(B);
					}
					if (now == '.') {
						result.append('.');
					}
					area = 0;
				} else {
					result = new StringBuilder("-1");
					break;
				}
			}
		}
		System.out.println(result);
	}
}
