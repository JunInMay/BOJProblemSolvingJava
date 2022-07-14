package problems.from.number02800;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon_2885 {
	
	public static int toInt(String s) {
		return Integer.parseInt(s);
	}
	
	public static void main(String[] args) throws IOException {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		
		int K = toInt(br.readLine());
		int chocolateSize = 1;
		
		while (K > chocolateSize) {
			chocolateSize *= 2;
		}
		System.out.print(chocolateSize + " ");
		int now = K;
		int sliceCount = 0;
		
		while (now > 0) {
			if (chocolateSize > now) {
				chocolateSize /= 2;
				sliceCount++;
			} else {
				now -= chocolateSize;
			}
		}
		System.out.println(sliceCount);
	}

}
