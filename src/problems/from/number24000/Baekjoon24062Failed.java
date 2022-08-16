package problems.from.number24000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Baekjoon24062Failed {
	static Integer[] array;
	static Integer[] target;
	static HashMap<String, Boolean> checkedArrays;
	static Integer arraySize;
	static int result;
	
	static int toInt(String s) {
		return Integer.parseInt(s);
	}
	
	public static void main(String[] args) throws IOException {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		
		arraySize = toInt(br.readLine());
		array = new Integer[arraySize];
		target = new Integer[arraySize];
		checkedArrays = new HashMap<>();
		
		array = Arrays.stream(br.readLine().split(" ")).map(Integer::parseInt).toArray(Integer[]::new);
		target = Arrays.stream(br.readLine().split(" ")).map(Integer::parseInt).toArray(Integer[]::new);
		
		mergeSort(0, arraySize);
		
//		for (Map.Entry<String, Boolean> e : checkedArrays.entrySet()) {
//			System.out.println(e.getKey());
//		}
		if (checkedArrays.containsKey(Arrays.toString(target))) {
			System.out.println("1");
		} else {
			System.out.println("0");
		}
	}
	
	static void mergeSort(int startIdx, int endIdx) {
		if (endIdx - startIdx != 1) {
			int midIdx = (int) Math.round(((double) startIdx + endIdx) / 2);
			mergeSort(startIdx, midIdx);
			mergeSort(midIdx, endIdx);
			merge(startIdx, midIdx, endIdx);
		}
	}
	
	static void merge(int leftStartIdx, int midIdx, int rightEndIdx) {
		int leftIdx = leftStartIdx;
		int rightIdx = midIdx;
		int tempIdx = leftStartIdx;
		Integer[] temp = Arrays.copyOf(array, arraySize);
		
		while (leftIdx < midIdx && rightIdx < rightEndIdx) {
			if (array[leftIdx] <= array[rightIdx]) {
				temp[tempIdx] = array[leftIdx];
				leftIdx++;
			} else {
				temp[tempIdx] = array[rightIdx];
				rightIdx++;
			}
			tempIdx++;
			
			checkedArrays.put(Arrays.toString(temp), true);
		}
		
		while (leftIdx < midIdx) {
			temp[tempIdx] = array[leftIdx];
			
			leftIdx++;
			tempIdx++;
			checkedArrays.put(Arrays.toString(temp), true);
		}
		while (rightIdx < rightEndIdx) {
			temp[tempIdx] = array[rightIdx];
			
			rightIdx++;
			tempIdx++;
			checkedArrays.put(Arrays.toString(temp), true);
		}
		
		array = Arrays.copyOf(temp, arraySize);
	}

}
