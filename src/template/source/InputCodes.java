package template.source;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class InputCodes {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int getInt() throws IOException {
		return Integer.parseInt(br.readLine());
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		StringTokenizer st = new StringTokenizer(br.readLine());
	}

}
