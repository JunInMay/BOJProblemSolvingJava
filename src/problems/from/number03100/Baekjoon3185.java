package problems.from.number03100;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Baekjoon3185 {

	public static void main(String[] args) throws IOException {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		
		String answer = br.readLine();
			
		String firstHint = answer.replaceAll("[A-Za-z]", ".");
		System.out.println(firstHint);
		
		Pattern pattern = Pattern.compile("[A-Za-z]");
		Matcher matcher = pattern.matcher(answer);
		double letterCount = 0;
		while (matcher.find()) {
			letterCount++;
		}
		StringBuilder secondHint = new StringBuilder();
		int offMasked = 0;
		int offMaskedIndex = 0;
		for (int i=0; i<firstHint.length(); i++) {
			char now = answer.charAt(i);
			if (((64 < now && now < 91) || (96 < now && now < 123)) && offMasked < Math.round(letterCount / 3)) {
				secondHint.append(now);
				offMasked++;
				offMaskedIndex = i;
			} else {
				secondHint.append(firstHint.charAt(i));
			}
		}
		System.out.println(secondHint);
		
		String tempString = answer.substring(offMaskedIndex+1);
		StringBuilder thirdHint = new StringBuilder();
		offMasked = 0;
		if (tempString.matches(".*[AEIOUaeiou].*")) {
			for (int i=0; i<secondHint.length(); i++) {
				String now = Character.toString(answer.charAt(i));
				if (now.matches("[AEIOUaeiou]")) {
					thirdHint.append(now);
				} else {
					thirdHint.append(secondHint.charAt(i));
				}
			}
		} else {
			for (int i=0; i<secondHint.length(); i++) {
				char now = answer.charAt(i);
				if (((64 < now && now < 91) || (96 < now && now < 123)) && offMasked < Math.round(letterCount / 3 * 2)) {
					thirdHint.append(now);
					offMasked++;
				} else {
					thirdHint.append(secondHint.charAt(i));
				}
			}
		}
		System.out.println(thirdHint);
		
	}
}
