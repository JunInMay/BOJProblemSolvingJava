package problems.from.number06700;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Baekjoon6752 {
	static int toInt(String s) {
		return Integer.parseInt(s);
	}
	static int[] merge(int[] left, int[] right) {
		int leftLength = left.length;
		int leftIndex = 0;
		int rightLength = right.length;
		int rightIndex = 0;
		int[] result = new int[leftLength + rightLength];
		int resultIndex = 0;
		
		while (leftIndex < leftLength && rightIndex < rightLength) {
			if (left[leftIndex] <= right[rightIndex]) {
				result[resultIndex] = left[leftIndex];
				leftIndex++;
			} else {
				result[resultIndex] = right[rightIndex];
				rightIndex++;
			}
			resultIndex++;
		}
		
		while (leftIndex < leftLength){
			result[resultIndex] = left[leftIndex];
			leftIndex++;
			resultIndex++;
		}
		while (rightIndex < rightLength) {
			result[resultIndex] = right[rightIndex];
			rightIndex++;
			resultIndex++;
		}
		return result;
	}
	
	static int[] mergeSort(int[] mainArray) {
		if (mainArray.length == 1) {
			return mainArray;
		}
		int midPoint = mainArray.length / 2;
		int[] leftArray = mergeSort(Arrays.copyOfRange(mainArray, 0, midPoint));
		int[] rightArray = mergeSort(Arrays.copyOfRange(mainArray, midPoint, mainArray.length));
		
		return merge(leftArray, rightArray);
	}
	
	public static void main(String[] args) throws IOException {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		
		int remaining = toInt(br.readLine());
		int choreCount = toInt(br.readLine());
		int[] chores = new int[choreCount];
		
		for (int i=0; i<choreCount; i++) {
			chores[i] = toInt(br.readLine());
		}
		chores = mergeSort(chores);
		
		int result = 0;
		for (int i=0; i<chores.length; i++) {
			remaining -= chores[i];
			if (remaining < 0) break;
			result++;
		}
		
		System.out.println(result);
	}
}
