package problems.from.number24000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

/*
 * Solution 1.(����)
 * ������ ���� ������ ����
 * ���� ������ ������ ��, ���ڰ� ���� �� �� ���� �迭 ���� HashMap�� String �������� ����
 * ���� ������ �Ϸ�ǰ� �� �� HashMap�� ��ǥ �� String�� �ִ��� Ȯ��
 * 
 * ù��° �õ�
 * - ������ left�� right�� ������ ���� �ƴ϶� array�� idx�� �����ؼ� array�� ���� �ٲٸ�
 * 2 1 �̶�� �迭�� ������ �� 1 1 �̶�� ������ ��ġ�� �� -> 2�� �ҽǵ�
 * ���� temp �迭�� �ΰ� array�迭�� temp �迭�� ������ �� array ���� temp �迭�� ����, ���� HashMap�� ������
 * -> �迭 ���� �ÿ� time complexity ���
 * 
 * -> �׷��ٰ� left �迭�� right �迭�� �����̽� �Ѵٸ� � ������ �߻��ұ�?
 * - �ᱹ ���� ������ �Ǹ鼭 ���ڰ� 1ȸ �ٲ� �� ���� �� �迭�� ��ǥ ���� ���ϴ� �� �ʿ���
 * �׷��� left, right �迭�� ���� �������
 * ��ǥ ���� ���̴� 5�ε�, left, right�� ���̴� ���� 1�� 2��� �������� ��
 * �ᱹ left�� right�� �������� �ϸ鼭 ���ڸ� �ٲ� �� ���� ���� array�� ���� �� �Ҵ��� ����� ��
 * -> ������ �ӽ� �迭�� �ʿ��ϰ�, �ӽù迭�� ���̸�ŭ ���� array ���� ������
 * 
 * �ι�° �õ�
 * �� �������� �迭�� ��ü�� �����ϴٺ��� O(n lg n) �ð� ���⵵���� O(n^2 lg n) = O(n^2)�� ��
 * ���� .. �������� ������ �迭�� �����ϱ�� ����
 * ó���� ���� ������ ���� �迭�� ������
 * ���� �迭 [5 4 3 2 1] ���� [5 4] �� �������� �Ѵٸ� �ӽù迭 [5 4]�� ������
 * 5 4�� ���ؼ� ������ 4�� �� �����Ƿ�
 * ���迭 [5 4 3 2 1]�� [4 4 3 2 1] �� ���� ���ǵ� -> �� ���� HashMap�� ����
 * ���� �ӽù迭 [5 4]���� 5�� üũ���� �ʾ����Ƿ� üũ�ϸ�
 * ���迭�� [4 5 3 2 1]�� ���� �� -> �� ���� HashMap�� �� ���� 
 * 
 * -> ������ �迭�� �����Ѵٰ� �ؼ� time complexity�� �ʰ����� ������?
 * 
 * ����° �õ�
 * HashMap�� ���ֹ����� result ���� �ٲ�
 * HashMap�� �����Ͱ� �Ҵ�Ǵ� �ð��� �������� ������ �Ҵ� ��ſ� ���ڿ� ���� ���ϴ��� �ð��� �� 
 * 
 * [���� ã�� �õ�]
 * �ϴ� �Ϲ����� �պ������� ���� �� O(n lg n)�� �ð� ���⵵�� �������� ������ 500,000���� �����ʹ� ���� ���� ����
 * �׷��� �ð� �ʰ��� ���� ������?
 * ���� 1. ���� �պ������� �̻��ϰ� �����ߴ�.
 * ���� 2. ������ ��(��ǥ ���� ��)���� ���� �ð��� ��ƸԴ´�.
 * 
 * ���� �ϴ� �պ������� �̻����� ������? ���� �պ� ������ �����غ���.
 * - ��� : �պ� ������ �̻����� �ʾƴ�
 * ������ �񱳿��� ���� �ð��� �ҿ�ȴٴ� ���� ���޾Ҵ�.
 * �׷��� ��� ���� �ð��� �ҿ�Ǵ°�?
 * ã�ƺô��� Arrays.toString�� O(n)�� �ɸ���.
 * �迭�� ���� �� O(n)�� �ɸ��� �ʹ� ������ ���̶� �����߱� ������ toString���� �߾��µ�,
 * toString�� O(n)�̴�.
 * �պ����Ŀ��� ���ڸ� �ٲ� ������ toString�� �ϴϱ�, O(n lg n * n) = O(n^2)�� �ȴ�. �ð� �ʰ�.
 * 
 * �׷��� �񱳸� ��� �ؾ��ұ�.
 * HashMap�� Key ������ �迭�� ������ �ɱ�?
 * �׷��� Key ������ �迭�� ������ �迭�� ���� ���� ���� �ƴ϶� �迭�� �ּҰ� ����.
 * �ش� �迭�� ���� ���� �ٲ������ �ּҰ� ���� ������ HashMap�� �������� ���� �迭�� �ƹ��� �־ �Ȱ��� �迭�� �ִ� ���̳� �ٸ��� ����.
 * �ᱹ �迭 �ּҰ� �ƴ϶� �迭 ������ ���� Key ������ ���־�� �ϴµ�, �迭 ������ ���� Key ������ �Ϸ���
 * �迭 ������ ���� ��� �о�� �ϹǷ� �ᱹ O(n)�� �ɸ���. �պ����İ� �Բ� �ð� �ʰ�.
 * 
 * Solution 2. ���� �ٸ� ��� ã��
 * �պ� �����̶� ��� ����� ���°ǰ�?
 */

public class Baekjoon24062Failed {
	static int[] arrayI;
	static int[] targetI;
	static HashMap<int[], Boolean> checkedArrays;
	static Integer arraySize;
	static int result = 0;
	
	static int calledTest = 0;
	
	static int toInt(String s) {
		return Integer.parseInt(s);
	}
	
	public static void main(String[] args) throws IOException {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		
		arraySize = toInt(br.readLine());
		arrayI = new int[arraySize];
		targetI = new int[arraySize];
		checkedArrays = new HashMap<>();
		
		arrayI = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		targetI = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		
		arrayI = (int[]) arrayI;
		
		/*
		 * �׽�Ʈ ����
		 */
		Integer testNumber = 500000;
		arrayI = new int[testNumber];
		targetI = new int[testNumber];
		arraySize = testNumber;
		for (int i=0; i<testNumber; i++) {
			arrayI[i] = testNumber-i;
			targetI[i] = i+1;
		}
		System.out.println("�׽�Ʈ ���� : " + testNumber);
		
//		mergeSort(0, arraySize);
		int[] testArray = Arrays.copyOf(arrayI, testNumber);
		mergeSort2(testArray, 0);
//		int[] realArray = Arrays.copyOf(arrayI, arraySize);
//		mergeSort2(realArray, 0);
		
		System.out.println(Arrays.toString(arrayI));
		
		System.out.println("�ݵ��׽�Ʈ : " + calledTest);
		
		System.out.println(result);
		
		for (Map.Entry<int[], Boolean> e : checkedArrays.entrySet()) {
			System.out.println("Key : " + e.getKey());
		}
	}
	
	static int[] mergeSort2(int[] arrayForSort, int standard) {
		if (arrayForSort.length == 1) {
			return arrayForSort;
		}
		
		int midIdx = (int) Math.round(((double) arrayForSort.length) / 2);
		int[] left = Arrays.copyOfRange(arrayForSort, 0, midIdx);
		int[] right = Arrays.copyOfRange(arrayForSort, midIdx, arrayForSort.length);
		
		return merge2(mergeSort2(left, standard), mergeSort2(right, standard+midIdx), standard);
	}
	
	static int[] merge2(int[] left, int[] right, int standard) {
		int leftIdx = 0;
		int rightIdx = 0;
		int resultIdx = 0;
		int arrIdx = standard;
		
		int[] temp = new int[left.length + right.length];
		
		while (leftIdx < left.length && rightIdx < right.length) {
			if (left[leftIdx] <= right[rightIdx]) {
				temp[resultIdx] = left[leftIdx++];
			} else {
				temp[resultIdx] = right[rightIdx++];
			}
			arrayI[arrIdx++] = temp[resultIdx++];
			checkedArrays.put(arrayI, true);
			calledTest++;
		}
		
		while (leftIdx < left.length) {
			temp[resultIdx] = left[leftIdx++];
			arrayI[arrIdx++] = temp[resultIdx++];
			checkedArrays.put(arrayI, true);
			calledTest++;
		}
		while (rightIdx < right.length) {
			temp[resultIdx] = right[rightIdx++];
			arrayI[arrIdx++] = temp[resultIdx++];
			checkedArrays.put(arrayI, true);
			calledTest++;
		}
		
		return temp;
	}
	
	static Integer[] merge3(Integer[] left, Integer[] right, int standard) {
		int leftIdx = 0;
		int rightIdx = 0;
		int resultIdx = 0;
		
		Integer[] result = new Integer[left.length + right.length];
		
		while (leftIdx < left.length && rightIdx < right.length) {
			if (left[leftIdx] <= right[rightIdx]) {
				result[resultIdx++] = left[leftIdx++];
			} else {
				result[resultIdx++] = right[rightIdx++];
			}
			calledTest++;
		}
		
		while (leftIdx < left.length) {
			result[resultIdx++] = left[leftIdx++];
			calledTest++;
		}
		while (rightIdx < right.length) {
			result[resultIdx++] = right[rightIdx++];
			calledTest++;
		}
		
		return result;
	}
	
	static void mergeSort(int startIdx, int endIdx) {
		calledTest++;
		if (endIdx - startIdx != 1) {
			int midIdx = (int) Math.round(((double) startIdx + endIdx) / 2);
			mergeSort(startIdx, midIdx);
			mergeSort(midIdx, endIdx);
			merge(startIdx, midIdx, endIdx);
		}
	}
	
	static void merge(int leftStartIdx, int midIdx, int rightEndIdx) {
		int leftIdx = 0;
		int rightIdx = midIdx - leftStartIdx;
		midIdx -= leftStartIdx;
		int arrIdx = leftStartIdx;
		int endIdx = rightEndIdx - leftStartIdx;
		int mergeLength = rightEndIdx - leftStartIdx;
		
		Integer[] comparison = new Integer[mergeLength];
		int comparisonIdx = 0;
		
		for (int i=leftStartIdx; i<rightEndIdx; i++) {
			comparison[comparisonIdx] = arrayI[i];
			comparisonIdx++;
		}
		
		while (leftIdx < midIdx && rightIdx < endIdx) {
			if (comparison[leftIdx] <= comparison[rightIdx]) {
				arrayI[arrIdx] = comparison[leftIdx];
				leftIdx++;
			} else {
				arrayI[arrIdx] = comparison[rightIdx];
				rightIdx++;
			}
			arrIdx++;
			if (Arrays.toString(arrayI).equals(Arrays.toString(targetI))) {
				result = 1;
			}
		}
		
		while (leftIdx < midIdx) {
			arrayI[arrIdx] = comparison[leftIdx];

			leftIdx++;
			arrIdx++;
			if (Arrays.toString(arrayI).equals(Arrays.toString(targetI))) {
				result = 1;
			}
		}
		while (rightIdx < endIdx) {
			arrayI[arrIdx] = comparison[rightIdx];
			
			rightIdx++;
			arrIdx++;

			if (Arrays.toString(arrayI).equals(Arrays.toString(targetI))) {
				result = 1;
			}
		}
	}
}

/*
5
1 1 1 1 1
1 1 1 1 0

5
4 5 1 3 2
4 5 1 3 2

5
4 5 1 3 2
1 4 5 2 3

5
5 4 1 3 2
1 4 5 2 3

*/