package problems.from.number04200;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Baekjoon4283 {
	static int toInt(String s) {
		return Integer.parseInt(s);
	}
	
	static double getLog(Double d) {
		return Math.log(d) / Math.log(2);
	}
	
	static int binarySearch(int left, int right, ArrayList<Double> list, Double value) {
		int mid = (left + right) / 2;
		
		if (list.get(mid) <= value && value < list.get(mid+1)) {
			return mid;
		}
		
		if (list.get(mid) < value) {
			return binarySearch(mid, right, list, value);
		} else {
			return binarySearch(left, mid, list, value);
		}
	}

	public static void main(String[] args) throws IOException {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		
		ArrayList<Double> factorialList = new ArrayList<>();
		factorialList.add(getLog(0d));
		factorialList.add(getLog(1d));
		Double elem = factorialList.get(1);
		int idx = 2;
		
		while (elem < Math.pow(2, 22.1)) {
			elem = factorialList.get(idx-1) + getLog((double) idx);
			factorialList.add(elem);
			idx += 1;
		}
		
		while(true) {
			String inputText = br.readLine();
			
			if(inputText.length() < 4) {
				break;
			}
			
			int generation = toInt(inputText)/10 - 194;
			int searchValue = (int) Math.pow(2, generation);
			
			System.out.println(binarySearch(0, factorialList.size()-1, factorialList, (double)searchValue));
		}
	}

}
