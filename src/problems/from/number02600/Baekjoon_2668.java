package problems.from.number02600;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Baekjoon_2668 {
	public static int toInt(String s) {
		return Integer.parseInt(s);
	}
	
	public static void main(String[] args) throws IOException {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		
		int numberCount = toInt(br.readLine());
		int[] numberTable = new int[numberCount+1];
		
		Set<Integer> keySet = new HashSet<>();
		Set<Integer> valueSet = new HashSet<>(); 
		
		for (int i=0; i<numberCount; i++) {
			int value = toInt(br.readLine());
			numberTable[i+1] = value;
			keySet.add(i+1);
			valueSet.add(value);
		}
		
		while (!valueSet.containsAll(keySet)) {
			// keySet이 valueSet이 되는 것이 중요포인트
			keySet = new HashSet<>(valueSet);
			valueSet.clear();
			Iterator<Integer> keysetIterator = keySet.iterator();
			
			while(keysetIterator.hasNext()) {
				int e = keysetIterator.next();
				valueSet.add(numberTable[e]);
			}
		}
		
		Integer[] answerArray = keySet.toArray(new Integer[0]);
		Arrays.sort(answerArray);
		int size = keySet.size();
		
		System.out.println(size);
		for (int number : answerArray) {
			System.out.println(number);
		}
	}
}