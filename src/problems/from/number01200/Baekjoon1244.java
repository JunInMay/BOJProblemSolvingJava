package problems.from.number01200;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baekjoon1244 {
	
	static int toInt(String s) {
		return Integer.parseInt(s);
	}
	
	public static void main(String[] args) throws IOException {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		
		int switchCount = toInt(br.readLine());
		int[] switches = Arrays.stream(br.readLine().split(" ")).mapToInt(Baekjoon1244::toInt).toArray();
		int studentCount = toInt(br.readLine());
		
		int iteration = 0;
		while (iteration++ < studentCount) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int gender = toInt(st.nextToken());
			int number = toInt(st.nextToken());
			
			if (gender == 1) {
				for (int i=0; i<switchCount; i++) {
					if ((i+1) % number == 0) {
						switches[i] = (switches[i]+1) % 2;
					}
				}
			} else {
				switches[number-1] = (switches[number-1]+1) % 2;
				for (int i=1; i<Math.min(number, switchCount-number+1); i++) {
					if (switches[number-1-i] == switches[number-1+i]) {
						switches[number-1-i] = (switches[number-1-i]+1) % 2;
						switches[number-1+i] = (switches[number-1+i]+1) % 2;
					} else {
						break;
					}
				}
			}
		}
		
		String result = "";
		for (int i=0; i<switchCount; i++) {
			result += Integer.toString(switches[i]);
			if ((i+1) % 20 == 0) {
				result += "\n";
			} else {
				result += " ";
			}
		}
		System.out.println(result.trim());
	}
}

/*
8
0 0 0 0 0 0 0 0
8
1 2
1 3
1 4
1 5
2 2
2 3
2 4
2 5

8
0 1 1 0 1 0 0 0
4
2 2
2 3
2 4
2 5

8
0 1 1 0 1 0 0 0
1
2 2

8
0 0 1 0 1 0 0 0
1
2 3

8
0 1 0 1 1 0 0 0
1
2 4

1 1 0 0 1 0 1 0
0 1 0 0 1 0 0 0

*/
