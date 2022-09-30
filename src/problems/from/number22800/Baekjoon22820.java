package problems.from.number22800;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon22820 {
	static int toInt(String s) {
		return Integer.parseInt(s);
	}
	
	public static void main(String[] args) throws IOException {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		
		int iteration = toInt(br.readLine()); 
		for (int times=0; times<iteration; times++) {
			int[][] table = new int[5][5];
			for (int i=0; i<5; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j=0; j<5; j++) {
					table[i][j] = toInt(st.nextToken());
				}
			}
			
			int result = 0;
			for (int startY=0; startY<5; startY++) {
				for (int startX=0; startX<5; startX++) {
					if (table[startY][startX] == 0) {
						continue;
					}
					
					int maxRectangle = 0;
					for (int height=0; height<Math.min(5, 5-startY); height++) {
						int rectangle = 0;
						boolean isRectangle = true;
						for (int dX=0; dX<Math.min(5, 5-startX); dX++) {
							int line = 0;
							for (int dY=0; dY<height+1; dY++) {
								if (table[startY+dY][startX+dX] == 0) {
									isRectangle = false;
									break;
								}
								line++;
							}
							if (!isRectangle) {
								break;
							}
							rectangle += line;
						}
						maxRectangle = Math.max(maxRectangle, rectangle);
					}
					
					result = Math.max(result, maxRectangle);
				}
			}
			System.out.println(result);
			br.readLine();
		}
	}
}

/*

1
1 1 1 1 1
1 0 1 1 0
0 0 1 1 0
1 0 1 0 1
0 1 1 1 0

3
1 1 0 1 0
0 1 1 1 1
1 0 1 0 1
0 1 1 1 0
0 1 1 0 0

0 1 0 1 1
0 1 0 1 0
0 0 1 0 0
0 0 1 1 0
1 0 1 0 0

1 1 1 1 0
1 1 1 1 0
1 1 1 1 1
1 1 1 1 0
1 1 1 1 1

1
0 0 0 0 0
0 0 0 0 0
1 1 1 0 1
0 1 1 0 0
0 0 0 0 0

1
1 0 1 1 1
1 1 1 1 1
0 1 0 1 0
1 1 1 1 1
1 1 1 0 1

1
0 0 0 0 0
0 0 0 0 0
1 1 1 1 1
0 0 0 0 0
0 0 0 0 0

1
0 0 0 0 0
0 0 1 0 0
1 0 0 0 1
0 0 1 0 0
0 0 0 0 0

1
1 1 0 0 0
0 1 0 0 0
0 0 1 0 1
1 0 1 1 1
1 1 0 0 0




*/