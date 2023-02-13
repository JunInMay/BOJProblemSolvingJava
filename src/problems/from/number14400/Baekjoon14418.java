package problems.from.number14400;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baekjoon14418 {
	static Rectangle verifyRectangle(int[] rectangle) {
		int standard = rectangle.length;
		int height = -1;
		int width = 0;
		
		for (int i=0; i<standard; i++) {
			int now = rectangle[i];
			if (now != standard) {
				if (height < 0) {
					height = now;
				} else if (now != height) {
					return new Rectangle(-1, -1);
				} else {
					width++;
				}
			}
		}
		return new Rectangle(width+1, standard - height);
	}
	static int[] fill(int[] array, Rectangle rect) {
		int[] result = Arrays.copyOf(array, array.length);
		for (int i=0; i<rect.x; i++) {
			result[i] += rect.y;
		}
		return result;
	}

	public static void main(String[] args) throws IOException {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		
		Rectangle maxRect = new Rectangle(0, 0);
		int maxIndex = -1;
		Rectangle rectA = null;
		Rectangle rectB = null;
		Rectangle[] rectangles = new Rectangle[3];
		int maxSide = 0;
		for (int i=0; i<3; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int max = Math.max(x, y);
			Rectangle now = new Rectangle(x, y);
			rectangles[i] = now;
			if (max > maxSide) {
				maxSide = max;
				maxRect = now;
				maxIndex = i;
			}
		}
		for (int i=0; i<3; i++) {
			if (i!= maxIndex) {
				if (rectA == null) {
					rectA = rectangles[i];
				} else {
					rectB = rectangles[i];
				}
			}
		}

		int[] tempRectangle = new int[maxSide];
		if (maxRect.x < maxRect.y) {
			tempRectangle = fill(tempRectangle, maxRect.rotate());
		} else {
			tempRectangle = fill(tempRectangle, maxRect);
		}
		Rectangle resultRectangle = verifyRectangle(fill(tempRectangle, rectA));
		Rectangle resultRotatedRectangle = verifyRectangle(fill(tempRectangle, rectA.rotate()));
		if (resultRectangle.equals(rectB) || resultRotatedRectangle.equals(rectB)) {
			System.out.println("YES");
		} else {
			System.out.println("NO");
		}
	}
}

class Rectangle {
	int x;
	int y;
	Rectangle(int x, int y){
		this.x = x;
		this.y = y;
	}
	Rectangle rotate() {
		return new Rectangle(this.y, this.x);
	}
	public boolean equals(Rectangle rect) {
		if (this.x == rect.x && this.y == rect.y) {
			return true;
		}
		if (this.y == rect.x && this.x == rect.y) {
			return true;
		}
		return false;
	}
}