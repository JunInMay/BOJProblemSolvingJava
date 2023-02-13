package problems.from.number09100;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Baekjoon9196 {

	public static void main(String[] args) throws IOException {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		
		List<Rectangle> rectangleList = new ArrayList<Rectangle>();
		for (int i=1; i<=140; i++) {
			for (int j=i+1; j<=141; j++) {
				rectangleList.add(new Rectangle(i, j));
			}
		}
		Collections.sort(rectangleList);
		
		while (true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int height = Integer.parseInt(st.nextToken());
			int width = Integer.parseInt(st.nextToken());
			if (height == 0 && width == 0) {
				break;
			}
			
			for (int i=0; i<rectangleList.size()-1; i++) {
				Rectangle now = rectangleList.get(i);
				Rectangle next = rectangleList.get(i+1);
				if (now.height == height && now.width == width) {
					System.out.printf("%d %d\n", next.height, next.width);
				}
			}
		}
	}
	
	static class Rectangle implements Comparable<Rectangle>{
		int height;
		int width;
		int diagonal;
		Rectangle next;
		Rectangle(int height, int width) {
			this.height = height;
			this.width = width;
			diagonal = height * height + width * width;
		}
		
		@Override
		public int compareTo(Rectangle o) {
			if (this.diagonal < o.diagonal) {
				return -1;
			} else if (this.diagonal == o.diagonal) {
				if (this.height < o.height) {
					return -1;
				} else {
					return 1;
				}
			}
			return 1;
		}
	}
}
