package Problems.From.Number17500;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Baekjoon_17554 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		short k = Short.parseShort(br.readLine());
		boolean[] lights = new boolean[N];
		int[] counts = new int[k];
		
		for (int i = 0; i < k; i++) {
			int number = Integer.parseInt(br.readLine());
			int j = number-1;
			int simultaenousNumber = 0;
			while (j < N) {
				if (lights[j]) {
					lights[j] = false;
				} else {
					// ²¨Áü
					lights[j] = true;
				}
				j += number;
			}
			for (boolean light : lights) {
				if (light) {
					simultaenousNumber++;
				}
			}
			counts[i] = simultaenousNumber;
		}
		System.out.println(Arrays.stream(counts).max().getAsInt());
	}

}
