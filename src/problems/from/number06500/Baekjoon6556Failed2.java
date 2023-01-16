package problems.from.number06500;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Baekjoon6556Failed2 {
	static ArrayList<Long> factorials = new ArrayList<>();
	
	static long getFactorial(int number) {
		for (int n = factorials.size(); n<=number; n++) {
			factorials.add(getFactorial(n-1) * n);
		}
		return factorials.get(number);
		
	}
	
	public static void main(String[] args) throws IOException {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		factorials.add(1L);
		
		while (true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int width = Integer.parseInt(st.nextToken());
			int height = Integer.parseInt(st.nextToken());
			
			long permutation = getFactorial(width+height) / getFactorial(width);
			long combination = permutation / getFactorial(height);
			System.out.println(combination);
		}
	}

}
