package problems.from.number12000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon12039 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int caseCount = Integer.parseInt(br.readLine());
		
		for (int c=1; c<=caseCount; c++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int consonantCount = Integer.parseInt(st.nextToken());
			int vowelCount = Integer.parseInt(st.nextToken());
			int goalLength = Integer.parseInt(st.nextToken());
			Node.consonant = consonantCount;
			Node.vowel = vowelCount;
			Node now = new Node(0, 1);
			for (int i=1; i<goalLength; i++) {
				now = now.getNextNode();
			}
			System.out.printf("Case #%d: %d\n", c, now.addCase());
		}
	}
}
class Node {
	long cCase;
	long vCase;
	static int consonant;
	static int vowel;
	static int moduloNumber = (int)(1e+9)+7;
	Node (long c, long v){
		cCase = (c * consonant) % moduloNumber;
		vCase = (v * vowel) % moduloNumber;
	}
	Node getNextNode(){
		return new Node(vCase, cCase + vCase);
	}
	long addCase() {
		return (cCase + vCase) % moduloNumber;
	}
//	public String toString() {
//		return "cCase : " + cCase + "vCase : " + vCase;
//	}
}

/*
1
2 3 2
*/