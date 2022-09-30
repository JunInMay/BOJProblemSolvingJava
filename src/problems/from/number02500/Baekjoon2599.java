package problems.from.number02500;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 풀이 보고 해결함
 * [참고한 풀이]
 * https://settembre.tistory.com/73
 * 
 * A초교 남을 aM, A초교 여를 aG와 같은 식으로 표기하고,
 * A초교 남이 B초교 여와 짝지어지는 경우를 aB라 하고,
 * A초교 남이 C초교 여와 짝지어지는 경우를 aC와 같은 식으로 표기한다면
 * 다음이 성립한다.
 * 
 * aM = aB + aC
 * aB = ?
 * aC = aM - aB
 * bC = cG - aC
 * bA = bM - bC
 * cA = aG - bA
 * cB = cM - cA
 * 
 * 따라서 aB만 결정해주면 문제가 해결됨.
 */
public class Baekjoon2599 {
	public static int toInt(String s) {
		return Integer.parseInt(s);
	}
	
	public static void main(String[] args) throws IOException {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		StringTokenizer st;

		int studentCount = toInt(br.readLine());
		int[] boys = new int[3];
		int[] girls = new int[3];
		
		for (int i=0; i<3; i++) {
			st = new StringTokenizer(br.readLine());
			
			boys[i] = toInt(st.nextToken());
			girls[i] = toInt(st.nextToken());
		}
		
		String result = "";
		boolean gotAnswer = false;
		
		for (int i=0; i<boys[0]+1; i++) {
			gotAnswer = true;
			int aB = i;
			int aC = boys[0] - aB;
			int bC = girls[2] - aC;
			int bA = boys[1] - bC;
			int cA = girls[0] - bA;
			int cB = boys[2] - cA;
			
			int[] answerList = {aB, aC, bA, bC, cA, cB};
			
			for (int number : answerList) {
				if (number < 0) {
					gotAnswer = false;
					break;
				}
			}
			if (gotAnswer) {
				System.out.println("1");
				for (int j=0; j<3; j++) {
					System.out.println(String.format("%d %d", answerList[j*2], answerList[j*2+1]));
				}
				break;
			}
		}
		
		if(!gotAnswer) {
			System.out.println("0");
		}
	}
}