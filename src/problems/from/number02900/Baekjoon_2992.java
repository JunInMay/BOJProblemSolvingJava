package problems.from.number02900;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon_2992 {
	static int[] componentArray;

	public static void main(String[] args) throws IOException {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		String inputText = br.readLine();
				
		componentArray = getComponent(inputText);
		int inputNumber = Integer.parseInt(inputText);

		int size = inputText.length();
		String startText = "1";
		String endText = "10";
		for (int i = 0; i < size-1; i++) {
			startText += "0";
			endText += "0";
		}
		int startNumber = Integer.parseInt(startText);
		int endNumber = Integer.parseInt(endText);
		int answer = 0;
		
		for (int i = startNumber; i < endNumber; i++) {
			if(isSameComponent(getComponent(Integer.toString(i))) && i > inputNumber) {
				answer = i;
				break;
			}
		}
		System.out.println(answer);
	}
	public static int toInt(char s) {
		return Integer.parseInt(Character.toString(s));
	}
	
	public static int[] getComponent(String text) {
		int[] componentArray = new int[10];
		
		for (int i = 0; i < text.length(); i++) {
			componentArray[toInt(text.charAt(i))]++;
		}
		
		return componentArray;
	}
	
	public static boolean isSameComponent(int[] target) {
		boolean result = true;
		for (int i = 0; i < componentArray.length; i++) {
			if (componentArray[i] == target[i]) {
				continue;
			} else {
				result = false;
			}
		}
		return result;
	}
}
