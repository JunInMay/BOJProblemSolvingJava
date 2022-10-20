package problems.from.number14400;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Baekjoon14410 {
	static int toInt(String s) {
		return Integer.parseInt(s);
	}
	
	public static void main(String[] args) throws IOException {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		int clientCount = toInt(br.readLine());
		
		Integer[] clientBalances = new Integer[clientCount];
		StringTokenizer st = new StringTokenizer(br.readLine());
		long balanceSum = 0;
		for (int i=0; i<clientCount; i++) {
			int balance = toInt(st.nextToken());
			clientBalances[i] = balance;
			balanceSum += balance;
		}
		Arrays.sort(clientBalances, Collections.reverseOrder());
		
		long tempSum = 0;
		double maxParetoGap = -1;
		double maxParetoA = 0;
		double maxParetoB = 0;
		for (int i=0; i<clientCount; i++) {
			tempSum += clientBalances[i];
			double tempParetoA = (double)(i+1) / clientCount * 100;
			double tempParetoB = (double)(tempSum) / balanceSum * 100;
			double tempParetoGap = tempParetoB - tempParetoA;
			
			if (tempParetoGap > maxParetoGap) {
				maxParetoGap = tempParetoGap;
				maxParetoA = tempParetoA;
				maxParetoB = tempParetoB;
			}
		}
		
		System.out.println(new BigDecimal(maxParetoA).toPlainString());
		System.out.println(new BigDecimal(maxParetoB).toPlainString());
	}
}
