package problems.from.number08700;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 * �޸� �ʰ� ������ �޾��� ������, �Ʒ��� �ذ������ ����
 * 
 * Goal : int[]�� ���� 1 2 3 4 5 6 -1 3 -2 4 ... �� ���� ����ϱ�, �ִ� ���� : 1,000,000��
 * 
 * 1. Array�� for���� ���鼭 ���� �迭 ���� String�� '+' �������� �̾� ���̱�
 * -> ����, String : immutable ��ü, �Һ� ��ü, ��ȭ�� �� ���� ��ü�̹Ƿ� + ������ �� ������ String���� ���� �����ȴٰ� ���� ��
 * -> 100������ String�� �����Կ� ���� �޸� �ʰ� ���輺 ���� -> ä���� 15%? ���������� �޸� �ʰ�
 * 
 * 2. 1�� ������� String�� ¥�� BufferedWriter ����ؼ� ���
 * -> ����, ������ 100������ String�� ����� ������ ����
 * 
 * 3. Arrays.toString���� for���� ���� �ʰ� ��� String�� ���� �� replaceAll�� ���� ����ǥ���� �ۼ��ؼ� [1, 2, 3, ...]�� ���� �Ǿ��ִ� String ���� 1, 2, 3... ���� ����
 * -> ����, replaceAll�� �ᱹ ���������� String�� ���� ���� ä���� 33% ���������� �޸� �ʰ�
 * 	�� �ñ��� : replaceAll�� ���� immutable�� String�� �ݺ������� ����ٰ�? �׷� replaceAll�̶� �޼ҵ�� Ȱ���ص� �Ǵ� �޼ҵ��ΰ�? �ƴϸ� �� ������ ����ǥ���� ����? �̶�°� �����ϳ�?
 * 
 * 4. ������ �ʿ��� Object ������(Array, Deque ��)�� while�� �ۿ��� ����
 * -> ����, �ǹ� ���� �õ���� ���� �˰�� �־����� Ȥ�� ���� �õ������� ���� ����. while�� �ۿ��� �����ϳ� �ȿ��� �����ϳ� ������ GC�� ��Ʈ���Ѵ�.
 * 
 * 5. Array�� for���� ���鼭 ���� ������ StringBuilder�� ����
 * -> ����, ���� String�� ��� ���� ����� ���� ��������.
 * -> �߰������� StringBuilder�� ���⸸ �ϸ� BufferedWriter�� �Ƚᵵ Ǯ�ȴ�.
 */

public class Baekjoon8774 {
	static int toInt(String s) {
		return Integer.parseInt(s);
	}
	
	public static void main(String[] args) throws IOException {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		
		int casesCount = toInt(br.readLine().trim()); 
		int iterationCount = 0;
		while(iterationCount++ < casesCount) {
			int listSize = toInt(br.readLine().trim());
			StringTokenizer st = new StringTokenizer(br.readLine());
			ArrayDeque<HektorData> dataList = new ArrayDeque<>();
			int[] resultList = new int[listSize];
			Arrays.fill(resultList, -1);
			
			for (int i=0; i<listSize; i++) {
				int value = toInt(st.nextToken());
				
				while (!dataList.isEmpty() && dataList.getFirst().value < value) {
					HektorData topData = dataList.pop();
					resultList[topData.index] = i;
				}
				dataList.push(new HektorData(value, i));
			}
			
			StringBuilder sb = new StringBuilder();
			for (int number : resultList) {
				sb.append(number);
				sb.append(" ");
			}
			System.out.println(sb);
		}
	}
}

class HektorData {
	int value;
	int index;

	HektorData(int value, int index){
		this.value = value;
		this.index = index;
	}
}
/*
1
9
3 2 1 3 2 1 4 2 1
 */
