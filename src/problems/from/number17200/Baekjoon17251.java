package problems.from.number17200;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baekjoon17251 {

	public static void main(String[] args) throws IOException {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		
		int length = Integer.parseInt(br.readLine());
		int[] array = new int[length];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i=0; i<length; i++) {
			array[i] = Integer.parseInt(st.nextToken());
		}
		int max = Arrays.stream(array).max().getAsInt();
		
		ArrayList<Integer> maxIndexList = new ArrayList<>();
		for (int i=0; i<length; i++) {
			if (array[i] == max) {
				maxIndexList.add(i);
			}
		}
		int redLose = maxIndexList.get(0);
		int redWin = length - 1 - maxIndexList.get(maxIndexList.size()-1);
		System.out.println("패 ㅣ " + redLose);
		System.out.println("승ㄹㅣ " + redWin);
		System.out.println("승류ㅜㄹ : " + (double) redWin / (redLose + redWin));
		String result = "B";
		if (redWin > redLose) {
			result = "R";
		} else if (redWin == redLose) {
			result = "X";
		}
		System.out.println(result);
	}

}

/*




6
9 15 18 7 13 11

result : R

10
26 25 9 27 7 30 15 20 8 16

result : B



*/


