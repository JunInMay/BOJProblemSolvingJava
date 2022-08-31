package problems.from.number23700;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


/* 1000000000000000 */
/* 444444444444445*/
public class Baekjoon23731 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		
		String inputText = br.readLine();
		Long number = Long.parseLong(inputText);
		
		for(int i=0; i<inputText.length(); i++) {
			Long divisor = (long) Math.pow(10, i+1);
			Long modValue = (long) (number % divisor);
			
			if (modValue >= divisor/2) {
				number -= modValue;
				number += divisor;
			}
		}
		System.out.println(number);
	}
}
