package problems.from.number02800;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Baekjoon2891 {
	static int toInt(String s) {
		return Integer.parseInt(s);
	}
	static boolean isIndexable(int index, int length) {
		if (index < 0 || index == length) {
			return false;
		}
		return true;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String originalMetaInput = br.readLine();
		String[] splittedMetaInput = originalMetaInput.split(" ");
		int teamCount = toInt(splittedMetaInput[0]);
		int destroyedKayakCount = toInt(splittedMetaInput[1]);
		int extraKayakCount = toInt(splittedMetaInput[2]);
		
		boolean[] participants = new boolean[teamCount];
		Arrays.fill(participants, true);
		
		String originalDestroyedKayakInput = br.readLine();
		String[] splittedDestroyedKayakInput = originalDestroyedKayakInput.split(" ");
		for (int i=0; i<destroyedKayakCount; i++) {
			int destroyedIndex = toInt(splittedDestroyedKayakInput[i]) - 1;
			participants[destroyedIndex] = false; 
		}
		
		boolean[] hasExtraKayak = new boolean[teamCount];
		String originalExtraKayakInput = br.readLine();
		String[] splittedExtraKayakInput = originalExtraKayakInput.split(" ");
		for (int i=0; i<extraKayakCount; i++) {
			int extraKayakIndex = toInt(splittedExtraKayakInput[i]) - 1;
			hasExtraKayak[extraKayakIndex] = true;
		}
		
		for (int i=0; i<teamCount; i++) {
			int leftIndex = i-1;
			int rightIndex = i+1;
			if (participants[i] && hasExtraKayak[i]) {
				if (isIndexable(leftIndex, teamCount) && !participants[leftIndex]) {
					participants[leftIndex] = true;
					hasExtraKayak[i] = false;
				} else if (isIndexable(rightIndex, teamCount) && !participants[rightIndex]) {
					participants[rightIndex] = true;
					hasExtraKayak[i] = false;
				}
			} else if (!participants[i] && hasExtraKayak[i]){
				participants[i] = true;
				hasExtraKayak[i] = false;
			}
		}
		int result = 0;
		for (int i=0; i<teamCount; i++) {
			if (!participants[i]) {
				result++;
			}
		}
		System.out.println(result);
	}
}
