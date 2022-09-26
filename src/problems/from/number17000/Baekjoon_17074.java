package problems.from.number17000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon_17074 {
	
	public static int toInt(String s) {
		return Integer.parseInt(s);
	}
	
	public static void main(String[] args) throws IOException {
		
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		int arraySize = toInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		ArrayElement[] array = new ArrayElement[arraySize];
		
		for (int i=0; i<arraySize; i++) {
			array[i] = new ArrayElement(toInt(st.nextToken()));
		}
		
		int leftValue = Integer.MIN_VALUE;
		int rightValue = Integer.MAX_VALUE;
		boolean left = true;
		boolean right = true;
		for (int i=0; i<arraySize; i++) {
			int leftIndex = i;
			int rightIndex = arraySize-1-i;
			
			ArrayElement leftElement = array[leftIndex];
			if (leftElement.value < leftValue) {
				left = false;
			} 
			leftElement.left = left;
			leftValue = Math.max(leftValue, leftElement.value);
			
			ArrayElement rightElement = array[rightIndex];
			if (rightElement.value > rightValue) {
				right = false;
			}
			rightElement.right = right;
			rightValue = Math.min(rightValue, rightElement.value);
		}
		
		int result = 0;
		for (int i=0; i<arraySize; i++) {
			boolean isLeftSorted = false;
			boolean isRightSorted = false;
			if (i == 0) {
				isLeftSorted = true;
				if (array[i+1].right) {
					isRightSorted = true;
				}
			} else if (0 < i && i < arraySize-1 && (array[i-1].value <= array[i+1].value)) {
				if (array[i-1].left) {
					isLeftSorted = true;
				}
				if (array[i+1].right) {
					isRightSorted = true;
				}
			} else if (i == arraySize-1){
				if (array[i-1].left) {
					isLeftSorted = true;
				}
				isRightSorted = true;
			}
			
			if (isLeftSorted && isRightSorted) {
//				System.out.println("°ª : " + array[i].value + " left : " + array[i].left + " right : " + array[i].right);
				result++;
			}
		}
		
		System.out.println(result);
	}
}

class ArrayElement{
	int value;
	boolean left;
	boolean right;
	
	ArrayElement(int value){
		this.value = value;
		left = false;
		right = false;
	}
}

/*
8
1 2 3 4 8 5 6 7
*/