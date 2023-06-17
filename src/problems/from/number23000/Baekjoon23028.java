package problems.from.number23000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon23028 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int semester = Integer.parseInt(st.nextToken());
		int majorCredits = Integer.parseInt(st.nextToken());
		int totalCredits = Integer.parseInt(st.nextToken());
		
		for (int i=0; i<10; i++, semester++) {
			if (semester >= 8) {
				continue;
			}
			
			st = new StringTokenizer(br.readLine());
			int majorSubjects = Integer.parseInt(st.nextToken());
			int electiveSubjects = Integer.parseInt(st.nextToken());
			
			int collectableMajorCredits = Math.min(6, majorSubjects) * 3;
			int collectableTotalCredits = Math.min(6, majorSubjects) * 3
					+ Math.min(6, Math.min(6-Math.min(6, majorSubjects), electiveSubjects)) * 3;
			
			majorCredits += collectableMajorCredits;
			totalCredits += collectableTotalCredits;
		}
		
		String result = "Nae ga wae";
		if (totalCredits >= 130 && majorCredits >= 66) {
			result = "Nice";
		}
		System.out.println(result);
	}

}
