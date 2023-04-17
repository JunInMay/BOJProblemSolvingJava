package problems.from.number15800;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Baekjoon15886 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int size = Integer.parseInt(br.readLine());
		String map = br.readLine();
		Pattern pattern = Pattern.compile("W+");
		Matcher matcher = pattern.matcher(map);
		
		int result = 0;
		while (matcher.find()) {
			result += 1;
		}
		System.out.println(result);
	}

}
