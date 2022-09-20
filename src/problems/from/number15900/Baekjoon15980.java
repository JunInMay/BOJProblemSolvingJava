package problems.from.number15900;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon15980 {
	static int toInt(String s) {
		return Integer.parseInt(s);
	}
	static int toInt(Character s) {
		return Integer.parseInt(s.toString());
	}
	/*
	* ������ �߸� ������ ���ݰ� ���ϰ� ������... ���� �߸��� �ڵ��� �� ����
	* ����� ����� �� �ð��뺰 ������ �߽ɰ��� �ִ�ġ
	* 1�ʿ� 1, 2�ʿ� -2, 3�ʿ� -4�� 3���� abs(-4)�� �ִ�ġ
	* 
	* ���� ���� �ʾ��� �� �� �ʺ� ����� ����� �ް�, ������ ��(exceptionalIndex�� �Ǻ�)�� �����ٰ� �������� �� �� �ʺ� ������ �߽��� ���� ���ϸ� �ִ�ġ�� ��ȯ�ϴ� �Լ�
	*/
	static int getMeditationSum(int[] meditationResults, Bird[] birds, int exceptionalIndex, int meditationTime) {
		int meditation = 0;
		int maxMeditation = 0;
		for (int i=0; i<meditationTime; i++) {
			if (birds[exceptionalIndex].position.equals("L")) {
				meditation += meditationResults[i] + toInt(birds[exceptionalIndex].twittering.charAt(i));
			} else {
				meditation += meditationResults[i] - toInt(birds[exceptionalIndex].twittering.charAt(i));
			}
			maxMeditation = Math.max(maxMeditation, Math.abs(meditation));
		}
		
		return maxMeditation;
	}
	
	public static void main(String[] args) throws IOException {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		StringTokenizer st = new StringTokenizer(br.readLine()); 
		
		int countBirds = toInt(st.nextToken());
		int meditationTime = toInt(st.nextToken());
		Bird[] birds = new Bird[countBirds];
		
		// ���� �Է¹ޱ�
		for (int i=0; i<countBirds; i++) {
			st = new StringTokenizer(br.readLine());
			String position = st.nextToken();
			String twittering = st.nextToken();
			
			birds[i] = new Bird(position, twittering);
		}
		
		// �� �ð��뺰�� ��� ����� ������
		int[] meditationResults = new int[meditationTime]; 
		for (int i=0; i<meditationTime; i++) {
			int meditationValue = 0;
			for (int j=0; j<countBirds; j++) {
				if (birds[j].position.equals("L")) {
					meditationValue -= toInt(birds[j].twittering.charAt(i));
				} else {
					meditationValue += toInt(birds[j].twittering.charAt(i));
				}
			}
			meditationResults[i] = meditationValue;
		}
		
		// ������ �ϳ��� �����鼭 ����� sumCases�� ���� sumCases[n] = birds[n]�� ���� ���� ��� ���
		int[] sumCases = new int[countBirds];
		for (int i=0; i<countBirds; i++) {
			sumCases[i] = getMeditationSum(meditationResults, birds, i, meditationTime);
		}
		
		// sumCases�� �� ���� ����� �� ������ �߽��� ������ �ִ밪�� �����ϰ� �����Ƿ�, sumCases�� �ּҰ��� �ǰ��ϴ� ���� �� ���� ������ �߽��� ������ �ִ밪�� �����
		int result = Integer.MAX_VALUE;
		int minIndex = 0;
		for (int i=0; i<countBirds; i++) {
			if (sumCases[i] < result) {
				result = sumCases[i];
				minIndex = i;
			}
		}
		System.out.println((minIndex+1) + "\n" + (result));
	}
}

class Bird{
	String position;
	String twittering;
	
	Bird(String position, String twittering){
		this.position = position;
		this.twittering = twittering;
	}
}


/*
2 5
L 11100
R 11000
 * */
