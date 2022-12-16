package problems.from.number24500;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Baekjoon24524 {

	public static void main(String[] args) throws IOException {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		
		char[] input = br.readLine().toCharArray();
		HashMap<Character, Node> map = new HashMap<>();
		for (int i=0; i<input.length; i++) {
			Node node = map.getOrDefault(input[i], new Node());
			node.indexes.add(i);
			map.put(input[i], node);
		}
		char[] goal = br.readLine().toCharArray();
		int iteration = map.getOrDefault(goal[0], new Node()).indexes.size();
		
		System.out.println(map.get('a'));
		System.out.println(map.get('b'));
		System.out.println(map.get('c'));
		int result = 0;
		for (int i=0; i<iteration; i++) {
			System.out.println("-----반복 : " + i + " ------");
			int nowIndex = -1;
			for (int j=0; j<goal.length; j++) {
				Node node = map.getOrDefault(goal[j], new Node());
				if (node.index + 1 == node.indexes.size()) {
					break;
				}
				node.index++;
				System.out.println("노드인덱 : " + node.index);
				while (node.index + 1 < node.indexes.size() && node.indexes.get(node.index) <= nowIndex) {
					node.index++;
				}
				int position = node.indexes.get(node.index); 
				System.out.println(goal[j] + " : " + position);
				if (position <= nowIndex) {
					break;
				}
				nowIndex = position;
				
				if (j == goal.length-1) {
					System.out.println("########## 만들어짐!!!!");
					result++;
				}
			}
		}
		System.out.println(result);
		
		
		
	}

}
class Node {
	ArrayList<Integer> indexes;
	int index;
	
	Node(){
		indexes = new ArrayList<>();
		index = -1;
	}
	
	@Override
	public String toString() {
		return "리스트 : " + indexes.toString() + " 인덱스 : " + index; 
	}
}

/*

abc
dxz

aabb
ab

aabb
ba

abba
ab

abcabcaabbc
abc

abbabbabc
abc

caaaabcbb
abc


ccccaaaaaaaaaaaaaaaaaaaaaaabcbbbbbbbbbbbbbbbbbbbbbbc
abc

*/