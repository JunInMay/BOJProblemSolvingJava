package problems.from.number24000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

/*
 * Solution 1.(실패)
 * 실제로 병합 정렬을 구현
 * 병합 정렬을 실행할 때, 숫자가 대입 될 때 마다 배열 값을 HashMap에 String 형식으로 저장
 * 병합 정렬이 완료되고 난 후 HashMap에 목표 값 String이 있는지 확인
 * 
 * 첫번째 시도
 * - 실제로 left와 right가 구현된 것이 아니라 array의 idx를 조작해서 array를 직접 바꾸면
 * 2 1 이라는 배열을 정렬할 때 1 1 이라는 과정을 거치게 됨 -> 2가 소실됨
 * 따라서 temp 배열을 두고 array배열을 temp 배열에 복사한 뒤 array 값을 temp 배열에 저장, 이후 HashMap에 저장함
 * -> 배열 복사 시에 time complexity 상승
 * 
 * -> 그렇다고 left 배열과 right 배열로 슬라이싱 한다면 어떤 문제가 발생할까?
 * - 결국 병합 정렬이 되면서 숫자가 1회 바뀔 때 마다 그 배열을 목표 값과 비교하는 게 필요함
 * 그런데 left, right 배열을 따로 줘버리면
 * 목표 값의 길이는 5인데, left, right의 길이는 각각 1과 2라고 가정했을 때
 * 결국 left와 right를 병합정렬 하면서 숫자를 바꿀 때 마다 실제 array의 값에 또 할당을 해줘야 함
 * -> 어차피 임시 배열이 필요하고, 임시배열의 길이만큼 실제 array 값이 수정됨
 * 
 * 두번째 시도
 * 매 로직마다 배열을 전체를 복사하다보니 O(n lg n) 시간 복잡도에서 O(n^2 lg n) = O(n^2)이 됨
 * 따라서 .. 로직마다 수정할 배열만 복사하기로 했음
 * 처음에 비교할 구간에 속한 배열을 복사함
 * 원래 배열 [5 4 3 2 1] 에서 [5 4] 를 병합정렬 한다면 임시배열 [5 4]를 정의함
 * 5 4를 비교해서 실제로 4가 더 작으므로
 * 원배열 [5 4 3 2 1]에 [4 4 3 2 1] 과 같이 정의됨 -> 이 값을 HashMap에 저장
 * 아직 임시배열 [5 4]에서 5를 체크하지 않았으므로 체크하면
 * 원배열은 [4 5 3 2 1]과 같이 됨 -> 이 값을 HashMap에 또 저장 
 * 
 * -> 수정할 배열만 복사한다고 해서 time complexity가 초과되지 않을까?
 * 
 * 세번째 시도
 * HashMap을 없애버리고 result 값을 바꿈
 * HashMap에 데이터가 할당되는 시간을 없앴으나 어차피 할당 대신에 문자열 값을 비교하느라 시간을 씀 
 * 
 * [이유 찾기 시도]
 * 일단 일반적인 합병정렬을 했을 때 O(n lg n)의 시간 복잡도로 문제에서 제시한 500,000개의 데이터는 쉽게 정렬 가능
 * 그런데 시간 초과가 나는 이유는?
 * 추측 1. 내가 합병정렬을 이상하게 구현했다.
 * 추측 2. 데이터 비교(목표 값과 비교)에서 많은 시간을 잡아먹는다.
 * 
 * 따라서 일단 합병정렬이 이상하지 않을까? 새로 합병 정렬을 구현해본다.
 * - 결과 : 합병 정렬은 이상하지 않아다
 * 데이터 비교에서 많은 시간이 소요된다는 것을 깨달았다.
 * 그런데 어디서 많은 시간이 소요되는가?
 * 찾아봤더니 Arrays.toString은 O(n)이 걸린다.
 * 배열을 비교할 때 O(n)이 걸리면 너무 느려질 것이라 예상했기 때문에 toString으로 했었는데,
 * toString도 O(n)이다.
 * 합병정렬에서 숫자를 바꿀 때마다 toString을 하니까, O(n lg n * n) = O(n^2)가 된다. 시간 초과.
 * 
 * 그러면 비교를 어떻게 해야할까.
 * HashMap의 Key 값으로 배열을 넣으면 될까?
 * 그런데 Key 값으로 배열을 넣으면 배열의 값이 들어가는 것이 아니라 배열의 주소가 들어간다.
 * 해당 배열의 내부 값이 바뀌었더라도 주소가 같기 때문에 HashMap에 병합정렬 중인 배열을 아무리 넣어도 똑같은 배열을 넣는 것이나 다름이 없다.
 * 결국 배열 주소가 아니라 배열 내부의 값을 Key 값으로 해주어야 하는데, 배열 내부의 값을 Key 값으로 하려면
 * 배열 내부의 값을 모두 읽어야 하므로 결국 O(n)이 걸린다. 합병정렬과 함께 시간 초과.
 * 
 * Solution 2. 뭔가 다른 방법 찾기
 * 합병 정렬이랑 사실 상관이 없는건가?
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
		 * 테스트 영역
		 */
		Integer testNumber = 500000;
		arrayI = new int[testNumber];
		targetI = new int[testNumber];
		arraySize = testNumber;
		for (int i=0; i<testNumber; i++) {
			arrayI[i] = testNumber-i;
			targetI[i] = i+1;
		}
		System.out.println("테스트 개수 : " + testNumber);
		
//		mergeSort(0, arraySize);
		int[] testArray = Arrays.copyOf(arrayI, testNumber);
		mergeSort2(testArray, 0);
//		int[] realArray = Arrays.copyOf(arrayI, arraySize);
//		mergeSort2(realArray, 0);
		
		System.out.println(Arrays.toString(arrayI));
		
		System.out.println("콜드테스트 : " + calledTest);
		
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