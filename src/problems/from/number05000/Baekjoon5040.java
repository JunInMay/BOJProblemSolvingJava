package problems.from.number05000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Baekjoon5040 {

	public static void main(String[] args) throws IOException {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		
		char[] keyPhrase = br.readLine().replaceAll("\\s", "").toCharArray(); // ��ȣŰ
		char[] text = br.readLine().replaceAll("\\s", "").toCharArray(); // ��ȣȭ�� ����
		boolean[] isUsed = new boolean[26]; // 26�� ���ĺ� ��� ����
		isUsed[16] = true; // q�� ������� ����
		char[] inputAlphabet = new char[25]; // 5x5 �迭�� �Է��� ���ĺ� 25��
		
		/*
		 * 5*5 ���̺� ¥��
		 * [Solution]
		 * 1. keyPhrase���� �ߺ����� �ʴ� ���ĺ��� inputAlphabet�� �ִ´�.
		 * 2. ���� ���ĺ� 26��(q���� ������ 25��) �߿��� �Ⱦ��̴� �͵��� ���ĺ� ������ inputAlphabet�� �ִ´�.
		 * 3. 5*5 ���̺� inputAlphabet�� ���ʷ� �ִ´�.
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
		 * ��ȣȭ�� ���ڸ� 2�� ���ھ� ������
		 * [Rule]
		 * 1. ���ڸ� 2������ ���´�.
		 * 2. ������ �� ������ ���ڰ� �ݺ��ǰų�, ���ڰ� 1���ۿ� �ȳ����� ��� ù ���ڿ� x�� ���δ�.
		 * [Solution]
		 * 1. �� ���� ���ڿ��� �����ϴ� Pair ��� ��ü�� Ȱ���Ѵ�.
		 * 2. ��ȣȭ�� �ؽ�Ʈ�� ���ڿ� 1������ üũ�Ѵ�. �׷��� ���� �ε���(���⼭ idx ����)�� ����Ѵ�.
		 * 3. Rule 2���� �ش����� ���� ��� idx�� 2ȸ �ø���. 2���� ���ڿ��� ������ �����̴�.
		 * 4. Rule 2���� �ش��� ��� x�� ���̰�, idx�� 1ȸ�� �ø���. ���� ���ڿ��� ���� �ʰ� x�� ���� �߰����ֱ� �����̴�.
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
		 * ���̺��� �̿��ؼ� ��ȣȭ�ϱ�
		 * [Solution]
		 * 1. �� pair�� left, right�� X, Y ���� ã�´�.
		 * 2. pair���� left�� right ���� ���� ���� ����.(��ȣȭ�� ���ڸ� 2�� ���ھ� ������ ��Ʈ�� Rule 2�� ���� - left�� right�� ���� �ʵ��� x�� �߰��ϰ� ����)
		 * 3. ���� X,Y ��ǥ�� ���� ���� ����.
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