package problems.from.number17900;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Baekjoon17998 {
//	"asdf"
	static char[] insertCase;
	static char[] replaceCase;
	static char[] removeCase;
	static void insert(String base, int insertIndex, char insertValue) {
		int stringCaseIndex = 0;
		for (int i=0; i<insertIndex; i++) {
			insertCase[stringCaseIndex++] = base.charAt(i);
		}
		insertCase[stringCaseIndex++] = insertValue;
		for (int i=insertIndex; i<base.length(); i++) {
			insertCase[stringCaseIndex++] = base.charAt(i);
		}
	}
	static void replace(String base, int replaceIndex, char replaceValue) {
		if (replaceIndex > 0) {
			replaceCase[replaceIndex] = replaceValue;
			replaceCase[replaceIndex-1] = base.charAt(replaceIndex-1);
		} else {
			replaceCase = base.toCharArray();
			replaceCase[replaceIndex] = replaceValue;
		}
	}
	static void remove(String base, int removeIndex) {
		int stringCaseIndex = 0;
		for (int i=0; i<base.length(); i++) {
			if (i == removeIndex) {
				continue;
			}
			removeCase[stringCaseIndex++] = base.charAt(i);
		}
	}

	public static void main(String[] args) throws IOException {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		
		char[] alphabets = br.readLine().toCharArray();
		String base = br.readLine();
		insertCase = new char[base.length()+1];
		replaceCase = new char[base.length()];
		removeCase = new char[base.length()-1];
		
		HashSet<String> set = new HashSet<>();
		for (int i=0; i<alphabets.length; i++) {
			char alphabet = alphabets[i];
			for (int j=0; j<base.length()+1; j++) {
				insert(base, j, alphabet);
				set.add(new String(insertCase));
			}
			for (int j=0; j<base.length(); j++) {
				replace(base, j, alphabet);
				remove(base, j);

				set.add(new String(replaceCase));
				set.add(new String(removeCase));
			}
		}
		set.remove(base);
		ArrayList<String> list = new ArrayList<>(set);
		Collections.sort(list);
		StringBuilder sb = new StringBuilder();
		for (String result : list) {
			sb.append(result);
			sb.append('\n');
		}
		System.out.println(sb);
	}
}
/*



abcdefghijklmnopqrstuvwxyz
asdfqwerzxcvtyuighjklbnmasdfghjklqwertyuizxcvbnmopqwertyuiasdfghjklzxcvbnmqwertyuiasdfghjklzxcvbnmop


*/