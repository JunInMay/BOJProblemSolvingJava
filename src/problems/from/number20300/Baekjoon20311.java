package problems.from.number20300;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Baekjoon20311 {
	static int toInt(String s) {
		return Integer.parseInt(s);
	}
	
	public static void main(String[] args) throws IOException {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int tubesCount = toInt(st.nextToken());
		int colorsCount = toInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		ArrayList<Tube> tubes = new ArrayList<>();
		for (int i=0; i<colorsCount ; i++) {
			int tubeCount = toInt(st.nextToken());
			
			tubes.add(new Tube(i+1, tubeCount));
		}
		Collections.sort(tubes);
		
		Tube first = null;
		Tube second = null;
		ArrayList<Integer> firstArrangement = new ArrayList<>();
		for (Tube tube : tubes) {
			if (first == null) {
				if (second == null) {
					first = tube;
					continue;
				} else {
					first = second;
					second = tube;
				}
			} else if (second == null) {
				second = tube;
			}
			int firstColor = first.color;
			int secondColor = second.color;
			while (true) {
				if (first.left == 0) {
					first = null;
					break;
				}
				if (second.left == 0) {
					second = null;
					break;
				}
				if (firstArrangement.size() == 0) {
					firstArrangement.add(firstColor);
					first.left--;
					continue;
				}
				int lastIndex = firstArrangement.size() - 1 ;
				int lastColor = firstArrangement.get(lastIndex);
				if (lastColor != firstColor) {
					firstArrangement.add(firstColor);
					first.left--;
				} else {
					firstArrangement.add(secondColor);
					second.left--;
				}
			}
			
		}
		Tube leftTube = null;
		if (first != null) {
			leftTube = first;
		} else {
			leftTube = second;
		}
		ArrayList<Integer> secondArrangement = new ArrayList<>();
		leftTube.left--;
		secondArrangement.add(leftTube.color);
		int nextIndex = firstArrangement.size()-1;
		int before = secondArrangement.get(0);
		int next = 0;
		while (true) {
			if (nextIndex < 0) {
				break;
			}
			next = firstArrangement.get(nextIndex);
			
			if (before != leftTube.color && next != leftTube.color && leftTube.left > 0) {
				secondArrangement.add(leftTube.color);
				leftTube.left--;
			} 
			secondArrangement.add(next);
			nextIndex--;
			before = next;
		}
		StringBuilder result = new StringBuilder();
		if (leftTube.left > 0) {
			result.append(-1);
		} else {
			Collections.reverse(secondArrangement);
			for (int n : secondArrangement) {
				result.append(n).append(' ');
			}
		}
		System.out.println(result.toString().trim());
	}
}

class Tube implements Comparable<Tube> {
	int color;
	int left;
	
	Tube(int color, int left){
		this.color = color;
		this.left = left;
	}

	@Override
	public int compareTo(Tube o) {
		if (o.left < this.left) {
			return -1;
		} else if (o.left > this.left) {
			return 1;
		}
		return 0;
	}
}


/*
20 6
6 6 4 4 2 2
20 4
5 1 1 1
20 4
5 3 2 1
20 4
6 5 4 4
20 4
3 3 2 2
20 2
10 10
20 2
2 1
20 1
1

*/