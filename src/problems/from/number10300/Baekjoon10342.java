package problems.from.number10300;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon10342 {
	
	static int getNextY (int nowY, int direction, boolean isDirectionHorizontal) {
		int result = nowY;
		if (!isDirectionHorizontal) {
			result = nowY + direction;
		}
		return result;
	}
	
	static int getNextX (int nowX, int direction, boolean isDirectionHorizontal) {
		int result = nowX;
		if (isDirectionHorizontal) {
			result = nowX + direction;
		}
		return result;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringBuilder sb = new StringBuilder();
		int houseIndex = 1;
		while (true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int cols = Integer.parseInt(st.nextToken());
			int rows = Integer.parseInt(st.nextToken());
			
			if (cols == 0) break;
			
			char[][] room = new char[rows][cols];
			int entranceY = -1;
			int entranceX = -1;
			for (int i=0; i<rows; i++) {
				char[] line = br.readLine().toCharArray();
				for (int j=0; j<cols; j++) {
					if (line[j] == '*') {
						entranceY = i;
						entranceX = j;
					}
					room[i][j] = line[j];
				}
			}
			
			char now = '*';
			int nowY = entranceY;
			int nowX = entranceX;
			boolean isDirectionHorizontal = false;
			int direction = -1;
			if (entranceX == 0 || entranceY == 0) {
				direction = 1;
			}
			if (entranceX == 0 || entranceX == cols-1) {
				isDirectionHorizontal = true;
			}
			
			while (true) {
				if (now == '/') {
					direction *= -1;
					isDirectionHorizontal = !isDirectionHorizontal;
				} else if (now == '\\') {
					isDirectionHorizontal = !isDirectionHorizontal;
				} else if (now == 'x') {
					room[nowY][nowX] = '&';
					break;
				}
				int nextY = getNextY(nowY, direction, isDirectionHorizontal);
				int nextX = getNextX(nowX, direction, isDirectionHorizontal);
				char next = room[nextY][nextX];
				nowY = nextY;
				nowX = nextX;
				now = next;
			}
			
			sb.append(String.format("HOUSE %d\n", houseIndex));
			for (int i=0; i<rows; i++) {
				sb.append(new String(room[i])).append('\n');
			}
			houseIndex++;
		}
		System.out.println(sb);
	}

}

/*

11 6
xxxxxxxxxxx
x../..\...x
x..../....x
x../......*
x.........x
xxxxxxxxxxx

4 4
xxxx
x..x
x..*
xxxx
4 4
xx*x
x..x
x..x
xxxx
4 4
xxxx
x..x
*..x
xxxx
4 4
xxxx
x..x
x..x
xx*x


*/