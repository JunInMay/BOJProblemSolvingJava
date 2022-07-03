// 20901 Adolescent Architecture
package problems.from.number20900;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Baekjoon_20901Failed {
		
	public static int toInt(String s) {
		return Integer.parseInt(s);
	}
	public static void main(String[] args) throws IOException {
		
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		int inputIterationTimes = toInt(br.readLine());
		StringTokenizer st;
		
		ToyBlock[] toyBlocks = new ToyBlock[inputIterationTimes];
		
		for (int i = 0; i <inputIterationTimes; i++) {
			st = new StringTokenizer(br.readLine());
			String type = st.nextToken();
			int size = toInt(st.nextToken());
			ToyBlock tb = new ToyBlock(type, size);
			toyBlocks[i] = tb;
		}
		toyBlocks = mergeSort(toyBlocks);
		System.out.println("-----");
		for (ToyBlock tb : toyBlocks) {
			System.out.print(tb.type + " " + tb.size+"\n");
		}	
		System.out.println("-----");
		
		boolean isImpossible = false;
		for (int i = 0; i < toyBlocks.length-1; i++) {
			if (ToyBlock.canStack(toyBlocks[i], toyBlocks[i+1])) {
				continue;
			} else {
				isImpossible = true;
				break;
			}
		}
		if (isImpossible) {
			System.out.println("Impossible");
		} else {
			for (ToyBlock tb : toyBlocks) {
				System.out.print(tb.type + " " + tb.size+"\n");
			}	
		}
		
	}
	public static ToyBlock[] merge(ToyBlock[] left, ToyBlock[] right) {
		int leftIndex = 0, rightIndex = 0;
		ToyBlock[] result = new ToyBlock[left.length + right.length];
		int resultIndex = 0;
		
		while (leftIndex < left.length && rightIndex < right.length) {
			if (left[leftIndex].getSize() < right[rightIndex].getSize()) {
				result[resultIndex] = left[leftIndex];
				leftIndex++;
			} else if (left[leftIndex].getSize() == right[rightIndex].getSize()) {
				
				if (!ToyBlock.isSameType(left[leftIndex], right[rightIndex])) {
					
					if (left[leftIndex].type.equals(ToyBlock.cylinder)) {
						result[resultIndex] = left[leftIndex];
						leftIndex++; 
					} else {
						result[resultIndex] = right[rightIndex];
						rightIndex++;
					}
				} else {
					result[resultIndex] = left[leftIndex];
					leftIndex++;
				}
			} else {
				result[resultIndex] = right[rightIndex];
				rightIndex++;
			}
			resultIndex++;
		}
		while (leftIndex < left.length) {
			result[resultIndex] = left[leftIndex];
			leftIndex++;
			resultIndex++;
		}
		while (rightIndex < right.length) {
			result[resultIndex] = right[rightIndex];
			rightIndex++;
			resultIndex++;
		}
		return result;
	}
	
	public static ToyBlock[] mergeSort(ToyBlock[] toyBlocks) {
		int length = toyBlocks.length;
		if (length > 1) {
			int mid = length / 2;
			ToyBlock[] left = mergeSort(Arrays.copyOfRange(toyBlocks, 0, mid));
			ToyBlock[] right = mergeSort(Arrays.copyOfRange(toyBlocks, mid, length));
			
			return merge(left, right);
		} else {
			return toyBlocks;
		}		
	}
}

class ToyBlock {
	public String type;
	public int size;
	public static final String cylinder = "cylinder";
	public static final String cube = "cube";
	
	ToyBlock(String type, int size){
		this.type = type;
		this.size = size;
	}
	
	public double getDiagonal() {
		double diagonal = 0;
		return this.size * Math.sqrt(2);
	}
	
	public int getDiameter() {
		return this.size * 2;
	}
	
	public static boolean isSameType(ToyBlock a, ToyBlock b) {
		return a.type.equals(b.type);
	}
	
	public static boolean canStack(ToyBlock upper, ToyBlock lower) {
		boolean result = true;
		if (upper.type.equals(cube) && lower.type.equals(cylinder)) {
			if (upper.getComparableSize() > lower.getComparableSize()) {
				result = false;
			}
		}
		
		return result;
	}
	
	public int getSize() {
		if (type.equals(cylinder)) {
			return getDiameter();
		} else {
			return size;
		}
	}
	
	public double getComparableSize() {
		if (type.equals(cylinder)) {
			return getDiameter();
		} else {
			return getDiagonal();
		}
	}
}


/*
*
2
cube 4
cylinder 2

3
cube 6
cube 5
cylinder 3

5
cube 10
cube 9
cube 8
cylinder 4
cube 7

4
cube 10
cube 9
cube 8
cylinder 4
*/
