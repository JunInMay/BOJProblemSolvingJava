package problems.from.number04800;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Baekjoon4877 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String input = "";
		ArrayList<ArrayList<Integer>> baskets = new ArrayList<>();
		int basketCount = 0;
		while ((input = br.readLine()) != null) {
			StringTokenizer st = new StringTokenizer(input);
			ArrayList<Integer> basket = new ArrayList<>();
			
			while (st.hasMoreTokens()) {
				basket.add(Integer.parseInt(st.nextToken()));
			}
			baskets.add(basket);
			basketCount += 1;
		}
		
		double[][] probabilities = new double[10][basketCount];
		for (int i=0; i<10; i++) {
			double[] probability = new double[basketCount];
			if (i == 0) {
				for (int j=0; j<basketCount; j++) {
					if (j == 0) {
						probability[j] = 1;
					} else {
						probability[j] = 0;
					}
				}
			} else {
				double[] beforeProbability = probabilities[i-1];
				for (int j=0; j<basketCount; j++) {
					ArrayList<Integer> basket = baskets.get(j);
					double cardProbability = beforeProbability[j];
					
					double basketSum = 0;
					for (int k=0; k<basketCount; k++) {
						basketSum += basket.get(k);
					}
					
					for (int k=0; k<basketCount; k++) {
						probability[k] += (basket.get(k) / basketSum) * cardProbability;
					}
				}
			}
			probabilities[i] = probability;
		}
		
		StringBuilder sb = new StringBuilder();
		for (int i=0; i<10; i++) {
			for (int j=0; j<basketCount; j++) {
				sb.append(String.format("%.5f",probabilities[i][j]));
				if (j < basketCount-1) {
					sb.append(' ');
				} else {
					sb.append('\n');
				}
			}
		}
		System.out.print(sb);

	}

}
