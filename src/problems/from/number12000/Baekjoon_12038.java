package problems.from.number12000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Baekjoon_12038 {
	static InputStreamReader isr = new InputStreamReader(System.in);
	static BufferedReader br = new BufferedReader(isr);
	static ArrayList<String> candidatesList = new ArrayList<>();
	static int goal;

	public static int toInt(String s) {
		return Integer.parseInt(s);
	}
	public static String toString(int i) {
		return Integer.toString(i);
	}
	public static void getCandidate(String candidate, boolean consonantGettable) {
		if (candidate.length() == goal) {
			candidatesList.add(candidate);
		} else {
			int nextLength = candidate.length() + 1;
			if (consonantGettable && nextLength < goal) {
				getCandidate(candidate + "c", false);
				
			}
			getCandidate(candidate + "v", true);
		}
	}
	
	public static BigInteger[] answer() throws IOException {
		int cases = toInt(br.readLine());
		BigInteger[] result = new BigInteger[cases];
		StringTokenizer st;
		for (int i=0; i<cases; i++) {
			result[i] = new BigInteger("0");
			candidatesList = new ArrayList<>();
			st = new StringTokenizer(br.readLine());
			int C = toInt(st.nextToken());
			int V = toInt(st.nextToken());
			int L = toInt(st.nextToken());
			goal = L;
			getCandidate("", true);
			for (String line : candidatesList) {
				int cCount = 0;
				int vCount = 0;
				for (char c : line.toCharArray()) {
					if (c == 'c') {
						cCount++;
					} else {
						vCount++;
					}
				}
				BigInteger cCases = new BigInteger(toString(C)).pow(cCount);
				BigInteger vCases = new BigInteger(toString(V)).pow(vCount);
				result[i] = result[i].add(cCases.multiply(vCases));	
			}
			
		}
		return result;
	}
	public static void main(String args[]) throws IOException {
		int a = (int) Math.pow(10, 9)+7;
		BigInteger[] result = answer();
		
		for (int i=0; i<result.length; i++) {
			
			System.out.printf("Case #%d: %d\n",i+1, result[i].mod(new BigInteger(Integer.toString(a))).intValue());
		}
	}
}

/*
3
1 1 4
1 2 2
50 50 15

1
1 1 3
*/