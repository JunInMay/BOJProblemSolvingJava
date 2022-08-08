package problems.from.number15700;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Baekjoon_15720 {
	public static int toInt(String s) {
		return Integer.parseInt(s);
	}
	
	public static void main(String[] args) throws IOException {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int burgersCount = toInt(st.nextToken());
		int sidesCount= toInt(st.nextToken());
		int drinksCount = toInt(st.nextToken());
		
		int[] burgers = new int[burgersCount];
		int[] sides = new int[sidesCount];
		int[] drinks = new int[drinksCount];
		
		Integer[][] menu = {new Integer[burgersCount], new Integer[sidesCount], new Integer[drinksCount]};
		int minLength = Integer.MAX_VALUE;
		int priceSum = 0;
		
		for (int i=0; i<menu.length; i++) {
			st = new StringTokenizer(br.readLine()); 
			minLength = Math.min(menu[i].length, minLength);
			for (int j=0; j<menu[i].length; j++) {
				int price = toInt(st.nextToken());
				menu[i][j] = price;
				priceSum += price;
			}
			Arrays.sort(menu[i], Collections.reverseOrder());
		}
		
		int discountSum = 0;
		for (int i=0; i<menu.length; i++) {
			for (int j=0; j<menu[i].length; j++) {
				if (j < minLength) {
					discountSum += menu[i][j] * 0.9;
				} else {
					discountSum += menu[i][j];
				}
			}
		}
		
		System.out.println(priceSum);
		System.out.println(discountSum);
		
		
		
	}
}
