package problems.from.number16500;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Baekjoon16558Failed {
	static boolean[] sieve;
	static int sieveSize = 300001;
	static ArrayList<Integer> primeNumbers;
	
	static int getSubprimeFibonacci(int left, int right) {
		if (!sieve[left + right]){
			for (int primeNumber : primeNumbers) {
				if ((left + right) % primeNumber == 0) {
					return (left + right) / primeNumber;
				}
			}
		}
		
		return left + right;
	}
	
	static int toInt(String s) {
		return Integer.parseInt(s);
	}
	
	public static void main(String[] args) throws IOException {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		
		sieve = new boolean[sieveSize];
		Arrays.fill(sieve, true);
		sieve[0] = false;
		primeNumbers = new ArrayList<>();
		
		for (int i=2; i<sieveSize; i++) {
			if (!sieve[i]) {
				continue;
			}
			primeNumbers.add(i);
			for (int j=i+i; j<sieveSize; j+=i) {
				sieve[j] = false;
			}
		}
		
		int iteration = toInt(br.readLine());
		for (int times=0; times<iteration; times++) {
			String[] splittedInput = br.readLine().split(" ");
			int caseIndex = toInt(splittedInput[0]);
			int limit = toInt(splittedInput[1]);
			int left = toInt(splittedInput[2]);
			int right = toInt(splittedInput[3]);
			
			ArrayList<Integer> SubprimeFibonacciArray = new ArrayList<>();
			SubprimeFibonacciArray.add(left);
			SubprimeFibonacciArray.add(right);
			for (int i=2; i<=limit; i++) {
				int next = getSubprimeFibonacci(left, right);
				SubprimeFibonacciArray.add(next);
				left = right;
				right = next;
			}
			
			int startIndex = limit;
			int endIndex = 0;
			boolean cycleFound = false;
			HashMap<String, Integer> Cases = new HashMap<>();
			for (int i=0; i<limit; i++) {
				StringBuilder sb = new StringBuilder();
				int fiboLeft = SubprimeFibonacciArray.get(i);
				int fiboRight = SubprimeFibonacciArray.get(i+1);
				sb.append(fiboLeft);
				sb.append(' ');
				sb.append(fiboRight);
				if (Cases.containsKey(sb.toString())) {
					startIndex = Cases.get(sb.toString());
					endIndex = i+1;
					cycleFound = true;
					break;
				}
				Cases.put(sb.toString(), i);
			}
			
			StringBuilder sb = new StringBuilder();
			if (cycleFound) {
				sb.append(String.format("%d %d %d\n", caseIndex, endIndex, endIndex-startIndex-1));
				int numberCount = 1;
				for (int i=startIndex; i<=endIndex; i++) {
					sb.append(SubprimeFibonacciArray.get(i));
					if (numberCount % 20 == 0) {
						sb.append('\n');
						numberCount = 1;
					} else { 
						sb.append(' ');
						numberCount++;
					}
						
				}
			} else {
				sb.append(String.format("%d %d %d\n", caseIndex, startIndex, endIndex));
				sb.append(SubprimeFibonacciArray.get(limit));
				sb.append('\n');
			}
			System.out.print(sb);
			
		}
	}
}

/*
1
1 1000 0 1

1
1 200 15 17

1
1 10 31 23

1
1 2 15 17

*/