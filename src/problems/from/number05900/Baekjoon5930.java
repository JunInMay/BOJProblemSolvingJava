package problems.from.number05900;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class Baekjoon5930 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int getInt() throws IOException {
		return Integer.parseInt(br.readLine());
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		int noteCount = getInt();
		int[] note = new int[noteCount];
		for (int i=0; i<noteCount; i++) {
			note[i] = getInt();
		}
		int chordCount = getInt();
		int[] chord = new int[chordCount];
		for (int i=0; i<chordCount; i++) {
			chord[i] = getInt();
		}
		
		int chordScale = Arrays.stream(chord).min().getAsInt();
		for (int i=0; i<chordCount; i++) {
			chord[i] -= chordScale;
		}
		Arrays.sort(chord);
		
		int count = 0;
		int[] tempChordArray = new int[chordCount];
		ArrayList<Integer> indexes = new ArrayList<>();
		for (int i=0; i<noteCount; i++) {
			if (i + chordCount > noteCount) {
				break;
			}
			for (int j=0; j<chordCount; j++) {
				tempChordArray[j] = note[i+j];
			}
			int noteScale = chord[0] - Arrays.stream(tempChordArray).min().getAsInt();
			for (int j=0; j<chordCount; j++) {
				tempChordArray[j] += noteScale;
			}
			Arrays.sort(tempChordArray);
			if (Arrays.equals(chord, tempChordArray)) {
				indexes.add(i+1);
				count++;
			}
		}
		System.out.println(count);
		for (int i=0; i<count; i++) {
			System.out.println(indexes.get(i));
		}
	}
}



/*

6
1
2
3
10
11
12
3
4
5
6

 * */
