package problems.from.number05800;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon5839 {
	static int toInt(String s) {
		return Integer.parseInt(s);
	}

	public static void main(String[] args) throws IOException {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = toInt(st.nextToken());
		int M = toInt(st.nextToken());
		
		Segment[] bessieSegment = new Segment[N];
		Segment[] elsieSegment = new Segment[M];
		int runningTime = 0;
		
		for (int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			int speed = toInt(st.nextToken());
			int time = toInt(st.nextToken());
			bessieSegment[i] = new Segment(speed, time);
			runningTime += time;
		}
		for (int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			elsieSegment[i] = new Segment(toInt(st.nextToken()), toInt(st.nextToken()));
		}
		
		int now = 0;
		char read = 'n'; // 아무도 리드하고 있지 않음
		Segment bessie = new Segment();
		Segment elsie = new Segment();
		int bessieIdx = 0;
		int elsieIdx = 0;
		int leadChange = 0;
		int bessieLocation = 0;
		int elsieLocation = 0;
		while (now < runningTime) {
			if (bessie.time == 0) {
				bessie = bessieSegment[bessieIdx];
				bessieIdx++;
			}
			if (elsie.time == 0) {
				elsie = elsieSegment[elsieIdx];
				elsieIdx++;
			}
			
			bessieLocation += bessie.speed;
			bessie.time--;
			elsieLocation += elsie.speed;
			elsie.time--;
			
			if (read == 'b' && bessieLocation < elsieLocation) {
				read = 'e';
				leadChange++;
			} else if (read == 'e' && elsieLocation < bessieLocation) {
				read = 'b';
				leadChange++;
			} else if (read == 'n') {
				if (bessieLocation < elsieLocation) {
					read = 'e';
				} else if (elsieLocation < bessieLocation) {
					read = 'b';
				}
			}
//			System.out.println("bessie Time : " + bessie.time + " elsie Time : " + elsie.time);
			
			now++;
		}
		System.out.println(leadChange);

	}

}

class Segment {
	int time = 0;
	int speed = 0;
	
	Segment(int s, int t){
		time = t;
		speed = s;
	}
	Segment(){
	}
}
