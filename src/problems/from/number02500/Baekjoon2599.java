package problems.from.number02500;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * Ǯ�� ���� �ذ���
 * [������ Ǯ��]
 * https://settembre.tistory.com/73
 * 
 * A�ʱ� ���� aM, A�ʱ� ���� aG�� ���� ������ ǥ���ϰ�,
 * A�ʱ� ���� B�ʱ� ���� ¦�������� ��츦 aB�� �ϰ�,
 * A�ʱ� ���� C�ʱ� ���� ¦�������� ��츦 aC�� ���� ������ ǥ���Ѵٸ�
 * ������ �����Ѵ�.
 * 
 * aM = aB + aC
 * aB = ?
 * aC = aM - aB
 * bC = cG - aC
 * bA = bM - bC
 * cA = aG - bA
 * cB = cM - cA
 * 
 * ���� aB�� �������ָ� ������ �ذ��.
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
