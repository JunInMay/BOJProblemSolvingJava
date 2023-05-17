package problems.from.number24500;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Baekjoon24570 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		Pattern pattern = Pattern.compile("[A-Z]+[\\+\\-]\\d+", Pattern.CASE_INSENSITIVE);
		Matcher matcher = pattern.matcher(input);
		
		StringBuilder sb = new StringBuilder();
		while (matcher.find()) {
			String instruction = matcher.group();
			String[] particles = instruction.split("[\\+\\-]");
			
			String tune = "tighten";
			if (instruction.contains("-")) {
				tune = "loosen";
			}
			
			sb.append(String.format("%s %s %s\n", particles[0], tune, particles[1]));
		}
		System.out.print(sb);
		
	}

}
