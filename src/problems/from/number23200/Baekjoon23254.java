package problems.from.number23200;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Baekjoon23254 {
	

	public static void main(String[] args) throws IOException {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int remainingHour = Integer.parseInt(st.nextToken()) * 24;
		int subjectCount = Integer.parseInt(st.nextToken());
		
		int[] basePoints = new int[subjectCount];
		int[] studyPoints = new int[subjectCount];
		int result = 0;
		st = new StringTokenizer(br.readLine());
		for (int i=0; i<subjectCount; i++) {
			int basePoint = Integer.parseInt(st.nextToken());
			basePoints[i] = basePoint;
			result += basePoint; 
		}
		
		st = new StringTokenizer(br.readLine());
		for (int i=0; i<subjectCount; i++) {
			studyPoints[i] = Integer.parseInt(st.nextToken());
		}
		
		ArrayList<StudyNode> nodeList = new ArrayList<>();
		for (int i=0; i<subjectCount; i++) {
			int baseTime = (100 - basePoints[i]) / studyPoints[i];
			int leftTime = (100 - basePoints[i]) % studyPoints[i];
			nodeList.add(new StudyNode(studyPoints[i], baseTime));
			nodeList.add(new StudyNode(leftTime, 1));
		}
		Collections.sort(nodeList);
		
		for(StudyNode node : nodeList) {
			if (remainingHour == 0) {
				break;
			}
			int studyPoint = node.studyPoint;
			int hour = node.hour;
			
			int studyHour = Math.min(remainingHour, hour);
			remainingHour -= studyHour;
			result += studyPoint * studyHour;
		}
		
		System.out.println(result);
	}
}

class StudyNode implements Comparable<StudyNode>{
	int studyPoint;
	int hour;
	
	StudyNode(int sp, int h){
		studyPoint = sp;
		hour = h;
	}
	
	@Override
	public int compareTo(StudyNode o) {
		if (this.studyPoint > o.studyPoint) {
			return -1;
		} else if (this.studyPoint == o.studyPoint){
			return 0;
		} else {
			return 1;
		}
	}
}

/*
8 7
30 15 70 50 40 40 50
2 2 1 3 1 2 1

1 2
70 90
3 8


*/