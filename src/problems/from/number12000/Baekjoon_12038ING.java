package problems.from.number12000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Baekjoon_12038ING {
	static InputStreamReader isr = new InputStreamReader(System.in);
	static BufferedReader br = new BufferedReader(isr);
	static ArrayList<String> candidatesList = new ArrayList<>();
	static int goal;
	static BigInteger cCount;
	static BigInteger vCount;

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
				cCount.add(new BigInteger("1"));
			}
			getCandidate(candidate + "v", true);
			vCount.add(new BigInteger("1"));
		}
	}
	
	public static BigInteger answer() throws IOException {
		int cases = toInt(br.readLine());
		StringTokenizer st;
		for (int i=0; i<cases; i++) {
			candidatesList = new ArrayList<>();
			cCount = new BigInteger("0");
			vCount = new BigInteger("0");
			st = new StringTokenizer(br.readLine());
			int C = toInt(st.nextToken());
			int V = toInt(st.nextToken());
			int L = toInt(st.nextToken());
			goal = L;
			getCandidate("", true);
			System.out.println(cCount + " " + vCount);
			for (String s : candidatesList) {
				System.out.println(s);
			}
		}
		
		
		
		return new BigInteger("100");
	}
	public static void main(String args[]) throws IOException {
		int a = (int) Math.pow(10, 9)+7;
		System.out.println(answer().mod(new BigInteger(Integer.toString(a))));
		
	}
}
