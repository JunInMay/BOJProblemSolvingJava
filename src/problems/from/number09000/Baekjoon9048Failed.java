package problems.from.number09000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon9048Failed {
	
	static int getCost(int from, int to, int variation, boolean[] array, int left, int right) {
		int i = variation == 1 ? from : from-1;
		to = variation == 1 ? to : to-1;
		int result = 0;
		while (i != to) {
			if (array[i]) {
				int position = i+1;
				int distanceLeft = position - left;
				int distanceRight = right - position;
				int cost = 0;
				if (distanceLeft <= distanceRight) {
					left += distanceLeft;
					cost = distanceLeft * 2;
				} else {
					right -= distanceRight;
					cost = distanceRight * 2;
				}
				result += cost;
			}
			i += variation;
		}
		return result;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int caseCount = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		while (caseCount-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int height = Integer.parseInt(st.nextToken());
			int width = Integer.parseInt(st.nextToken());
			int officeCount = Integer.parseInt(st.nextToken());
			
			boolean[][] isLightOn = new boolean[height][width];
			for (int i=0; i<officeCount; i++) {
				st = new StringTokenizer(br.readLine());
				int y = Integer.parseInt(st.nextToken());
				int x = Integer.parseInt(st.nextToken());
				isLightOn[y-1][x-1] = true;
			}
			
			int result = height * 2 + width + 1; // Default value
			for (int i=0; i<height; i++) {
				int left = 0;
				int right = width+1;
				
				int leftCost = getCost(0, width, 1, isLightOn[i], left, right);
				int rightCost = getCost(width, 0, -1, isLightOn[i], left, right);
				result += Math.min(leftCost, rightCost);
			}
			sb.append(result);
			sb.append('\n');
		}
		System.out.print(sb);
	}
}

/*
1
1 1 1
1 1



1
2 2 2
1 1
2 2



1
1 3 2
1 2
1 3

1
2 2 4
1 1
1 2
2 1
2 2

*/