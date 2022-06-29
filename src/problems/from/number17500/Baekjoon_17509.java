package problems.from.number17500;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baekjoon_17509 {
	public static int[] merge(int[] left, int[] right) {
		int sumLength = left.length + right.length;
		int leftIndex = 0;
		int rightIndex = 0;
		int resultIndex = 0;
		int[] result = new int[sumLength];
		
		while (leftIndex < left.length && rightIndex < right.length) {
			if (left[leftIndex] < right[rightIndex]) {
				result[resultIndex] = left[leftIndex];
				leftIndex++;
			} else {
				result[resultIndex] = right[rightIndex];
				rightIndex++;
			}
			resultIndex++;
		}
		while (leftIndex < left.length) {
			result[resultIndex] = left[leftIndex];
			resultIndex++;
			leftIndex++;
		}
		while (rightIndex < right.length) {
			result[resultIndex] = right[rightIndex];
			resultIndex++;
			rightIndex++;
		}
		
		return result;
	}
	public static int[] mergeSort(int[] array) {
		int length = array.length;
		
		if (length != 1) {
			int mid = length/2;
			int[] left = mergeSort(Arrays.copyOfRange(array, 0, mid));
			int[] right = mergeSort(Arrays.copyOfRange(array, mid, length));
			
			return merge(left, right);
		} else {
			return array;
		}
	}
	public static int toInt(String text) {
		return Integer.parseInt(text);
	}
	public static void main(String[] args) throws IOException {
		int[] times = new int[11];
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int incorrectCount = 0;
		
		for (int i = 0; i < 11; i++) {
			st = new StringTokenizer(br.readLine());
			times[i] = toInt(st.nextToken());
			incorrectCount += toInt(st.nextToken());
		}
		int[] sortedTimes = mergeSort(times);
		
		int sumTime = 0;
		int result = 0;
		for (int i = 0; i < 11; i++) {
			sumTime += sortedTimes[i];
			result += sumTime;
		}
		System.out.println(result + incorrectCount * 20);
	}
}
