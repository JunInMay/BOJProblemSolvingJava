package problems.from.number21800;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Baekjoon_21821 {
	
	public static int toInt(String s) {
		return Integer.parseInt(s);
	}
	
	public static void main(String[] args) throws IOException {
		
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int K, N;
		K = toInt(st.nextToken()); 
		N = toInt(st.nextToken());
		
		Map<String, Integer> nameIndex = new HashMap<>();
		int[] points = new int[N];
		String[] names = new String[N];
		
		st = new StringTokenizer(br.readLine());
		for (int i=0; i<N; i++) {
			String name = st.nextToken();
			nameIndex.put(name, i);
			points[i] = 0;
			names[i] = name;
		}
		
		String before;
		String name;
		for (int i=0; i<K; i++) {
			String paper = br.readLine();
			st = new StringTokenizer(paper);
			before = "";
			int level = 0;
			
			for (int j=0; j<N; j++) {
				name = st.nextToken();
				if (before.equals("")) {
					before = name;
					continue;
				} else {
					
					int result = name.compareTo(before);
					if (result > 0 || result == 0) {
						System.out.println("여기로 와야지 네임아.. : " + name);
					} else {
						System.out.println("여긴 왜올라? 네임아? : " + name + " 비포어 : " + before + " 뭐지 : " + name.compareTo(before));
						level++;
					}
					System.out.println("비교할 name : " + name + " before : " + before + "결과값  : " + name.compareTo(before) + " now : " + paper);
					points[nameIndex.get(name)] += level;
					System.out.println("과연 네임값은? : " + points[nameIndex.get(name)]);
					before = name;
				}
			}
		}
		for (int point : points) {
			System.out.println("포인트 : " + point);
		}
		
		
		for (int i=0; i<N; i++) {
			String line = "";
			for (int j=0; j<N; j++) {
				if (j==i) {
					line += "B";
					continue;
				}
				
				if (points[j] < points[i]) {
					line += "1";
				} else if (points[j] == points[i]) {
					line += "?";
				} else {
					line += "0";
				}
			}
			System.out.println(line);
		}
		
	}

}

/*
1 3
elsi mild dean
dean elsi mild
2 3
elsie mildred dean
elsie mildred dean
elsie dean mildred

2 3
elsie mildred ekan
elsie mildred ekan
elsie ekan mildred
 */
