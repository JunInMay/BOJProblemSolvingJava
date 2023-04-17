package problems.from.number08000;

import java.io.*;
import java.util.*;

public class Baekjoon8002 {
	static int length;
	static int[] result;
	static Compatibility[] compatibilities;
	static boolean resultFound;
	static boolean flag = false;
	
	static void dfs(boolean[] collected, int level, int[] sequence) {
		if (flag) {
			return;
		}
		if (level == length) {
			for (int i=0; i<length; i++) {
				resultFound = true;
				Compatibility comp = compatibilities[i];
				int a = 0;
				int b = 0;
				int[] compSequence = comp.sequence;
				for (int j=0; j<length; j++) {
					if (collected[compSequence[j]]) {
						b += compSequence[j];
						if (sequence[j] == compSequence[j]) {
							a += compSequence[j];
							b -= compSequence[j];
						}
					}
				}
				if (a != comp.a || b != comp.b) {
					resultFound = false;
					break;
				}
			}
			if (resultFound) {
				result = sequence.clone();
				flag = true;
			}
			return;
		}
		
		for (int i=1; i<=9; i++) {
			if (collected[i]) {
				continue;
			}
			sequence[level] = i;
			collected[i] = true;
			dfs(collected, level+1, sequence);
			collected[i] = false;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		length = Integer.parseInt(br.readLine());
		
		compatibilities = new Compatibility[length];
		
		for (int i=0; i<length; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int[] sequence = new int[length];
			
			for (int j=0; j<length; j++) {
				sequence[j] = Integer.parseInt(st.nextToken());
			}
			compatibilities[i] = new Compatibility(a, b, sequence);
		}
		
		dfs(new boolean[10], 0, new int[length]);
		StringBuilder sb = new StringBuilder();
		for (int i=0; i<length; i++) {
			sb.append(result[i]);
			sb.append(' ');
		}
		System.out.println(sb.toString().strip());
	}

}

class Compatibility {
	int a, b;
	int[] sequence;
	
	Compatibility(int a, int b, int[] sequence){
		this.a = a;
		this.b = b;
		this.sequence = sequence;
	}
}
