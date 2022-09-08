package problems.from.number05000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Baekjoon5040 {

	public static void main(String[] args) throws IOException {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		
		char[] keyPhrase = br.readLine().replaceAll("\\s", "").toCharArray(); // 암호키
		char[] text = br.readLine().replaceAll("\\s", "").toCharArray(); // 암호화할 문자
		boolean[] isUsed = new boolean[26]; // 26자 알파벳 사용 여부
		isUsed[16] = true; // q는 사용하지 않음
		char[] inputAlphabet = new char[25]; // 5x5 배열에 입력할 알파벳 25자
		
		/*
		 * 5*5 테이블 짜기
		 * [Solution]
		 * 1. keyPhrase에서 중복하지 않는 알파벳을 inputAlphabet에 넣는다.
		 * 2. 남은 알파벳 26자(q빼면 실제론 25자) 중에서 안쓰이는 것들을 알파벳 순으로 inputAlphabet에 넣는다.
		 * 3. 5*5 테이블에 inputAlphabet을 차례로 넣는다.
		 */
		int inputAlphabetIndex = 0;
		int keyPhraseIndex = 0;
		while (keyPhraseIndex < keyPhrase.length) {
			int alphabetIndex = ((int)keyPhrase[keyPhraseIndex]-97);
			if (!isUsed[alphabetIndex]) {
				isUsed[alphabetIndex] = true;
				inputAlphabet[inputAlphabetIndex] = keyPhrase[keyPhraseIndex];
				
				inputAlphabetIndex++;
			}
			keyPhraseIndex++;
		}
		for (int i=inputAlphabetIndex; i<25; i++) {
			for (int k=0; k<26; k++) {
				if (!isUsed[k]) {
					isUsed[k] = true;
					inputAlphabet[i] = (char)(k+97);
					inputAlphabetIndex++;
					break;
				}
			}
		}
		
		inputAlphabetIndex = 0;
		char[][] keyArray = new char[5][5];
		for (int i=0; i<5; i++) {
			for (int j=0; j<5; j++) {
				keyArray[i][j] = inputAlphabet[inputAlphabetIndex];
				inputAlphabetIndex++;
			}
		}
		/*
		 * 암호화할 문자를 2개 문자씩 나누기
		 * [Rule]
		 * 1. 문자를 2개마다 끊는다.
		 * 2. 끊었을 때 동일한 문자가 반복되거나, 문자가 1개밖에 안남았을 경우 첫 문자에 x를 붙인다.
		 * [Solution]
		 * 1. 두 개의 문자열을 저장하는 Pair 라는 객체를 활용한다.
		 * 2. 암호화할 텍스트를 문자열 1개마다 체크한다. 그러기 위해 인덱스(여기서 idx 변수)를 사용한다.
		 * 3. Rule 2번에 해당하지 않을 경우 idx를 2회 늘린다. 2개의 문자열을 묶었기 때문이다.
		 * 4. Rule 2번에 해당할 경우 x를 붙이고, idx는 1회만 늘린다. 다음 문자열을 묶지 않고 x를 직접 추가해주기 때문이다.
		 */
		ArrayList<Pair> pairList = new ArrayList<>();
		int idx = 0;
		while (idx < text.length) {
			char now = text[idx];
			Pair pair;
			if (idx+1 != text.length) {
				char next = text[idx+1];
				if (now == next) {
					pair = new Pair(now, 'x');
				} else {
					pair = new Pair(now, next);
					idx++;
				}
			} else {
				pair = new Pair(now, 'x');
			}
			pairList.add(pair);
			idx++;
		}
		
		/*
		 * 테이블을 이용해서 암호화하기
		 * [Solution]
		 * 1. 각 pair의 left, right의 X, Y 값을 찾는다.
		 * 2. pair마다 left와 right 값이 같은 경우는 없다.(암호화할 문자를 2개 문자씩 나누기 파트의 Rule 2번 참조 - left와 right가 같지 않도록 x를 추가하고 있음)
		 * 3. 따라서 X,Y 좌표가 같은 경우는 없다.
		 */
		String encodedText = "";
		for (Pair p : pairList) {
			for (int i=0; i<5; i++) {
				for (int j=0; j<5; j++) {
					if (keyArray[i][j] == p.left) {
						p.setLeftCoordinate(i, j);
					}
					if (keyArray[i][j] == p.right) {
						p.setRightCoordinate(i, j);
					}
				}
			}
			int leftX = p.leftX;
			int leftY = p.leftY;
			int rightX = p.rightX;
			int rightY = p.rightY;
			
			if (leftX == rightX) {
				encodedText += keyArray[(leftY+1)%5][leftX];
				encodedText += keyArray[(rightY+1)%5][rightX];
			} else if (leftY == rightY) {
				encodedText += keyArray[leftY][(leftX+1)%5];
				encodedText += keyArray[rightY][(rightX+1)%5];
			} else {
				encodedText += keyArray[leftY][rightX];
				encodedText += keyArray[rightY][leftX];
			}
			
		}
		System.out.println(encodedText.toUpperCase());
		
	}
}

class Pair{
	char left;
	char right;
	int leftX;
	int leftY;
	int rightX;
	int rightY;
	
	Pair(char left, char right){
		this.left = left;
		this.right = right;
	}
	void setLeftCoordinate(int Y, int X) {
		this.leftX = X;
		this.leftY = Y;
	}
	void setRightCoordinate(int Y, int X) {
		this.rightX = X;
		this.rightY = Y;
	}
}
/*
playfair example
jtxm
*/