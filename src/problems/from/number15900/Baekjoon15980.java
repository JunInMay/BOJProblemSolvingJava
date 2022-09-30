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
	* 문제를 잘못 읽은걸 깨닫고 급하게 수정함... 많이 잘못된 코드일 수 있음
	* 명상의 결과는 각 시간대별 정신의 중심값의 최대치
	* 1초에 1, 2초에 -2, 3초에 -4면 3초의 abs(-4)가 최대치
	* 
	* 새를 잡지 않았을 때 각 초별 명상의 결과를 받고, 임의의 새(exceptionalIndex로 판별)가 잡혔다고 가정했을 때 각 초별 정신의 중심의 값을 구하며 최대치를 반환하는 함수
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
		
		// 새들 입력받기
		for (int i=0; i<countBirds; i++) {
			st = new StringTokenizer(br.readLine());
			String position = st.nextToken();
			String twittering = st.nextToken();
			
			birds[i] = new Bird(position, twittering);
		}
		
		// 각 시간대별로 명상 결과를 저장함
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
		
		// 새들을 하나씩 빼보면서 결과를 sumCases에 저장 sumCases[n] = birds[n]을 뺐을 때의 명상 결과
		int[] sumCases = new int[countBirds];
		for (int i=0; i<countBirds; i++) {
			sumCases[i] = getMeditationSum(meditationResults, birds, i, meditationTime);
		}
		
		// sumCases엔 각 새를 잡았을 때 정신의 중심의 절댓값의 최대값을 저장하고 있으므로, sumCases의 최소값이 되게하는 새와 그 때의 정신의 중심의 절댓값의 최대값을 출력함
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