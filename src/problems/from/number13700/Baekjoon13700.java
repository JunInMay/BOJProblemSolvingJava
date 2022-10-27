package problems.from.number13700;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Baekjoon13700 {
	static int toInt(String s) {
		return Integer.parseInt(s);
	}
	
	public static void main(String[] args) throws IOException {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int buildingCount = toInt(st.nextToken());
		int start = toInt(st.nextToken());
		int destination = toInt(st.nextToken());
		int frontPower = toInt(st.nextToken());
		int backPower = toInt(st.nextToken());
		int policeStationCount = toInt(st.nextToken());
		boolean[] policeStations = new boolean[buildingCount+1];
		
		if (policeStationCount > 0) {
			st = new StringTokenizer(br.readLine());
			while (policeStationCount-- > 0) {
				policeStations[toInt(st.nextToken())] = true;
			}
		}
		
		int result = -1;
		ArrayDeque<Node> deque = new ArrayDeque<>();
		deque.add(new Node(start, 0));
		boolean[] visited = new boolean[buildingCount+1];
		visited[start] = true;
		while (!deque.isEmpty()) {
			Node now = deque.poll();
			int nowPosition = now.position;
			if (nowPosition == destination) {
				result = now.count;
				break;
			}
			if (policeStations[nowPosition]) {
				continue;
			}
			
			int frontPosition = nowPosition + frontPower;
			if (frontPosition > 0 && frontPosition < buildingCount+1) {
				if (!visited[frontPosition]) {
					Node front = new Node(frontPosition, now.count+1);
					deque.add(front);
					visited[frontPosition] = true;
				}
			}
			int backPosition = nowPosition - backPower;
			if (backPosition > 0 && backPosition < buildingCount+1) {
				if (!visited[backPosition]) {
					Node back = new Node(backPosition, now.count+1);
					deque.add(back);
					visited[backPosition] = true;
				}
			}
		}
		if (result >= 0) {
			System.out.println(result);
		} else {
			System.out.println("BUG FOUND");
		}
		
		
	}
	static class Node {
		int position;
		int count;
		Node (int position, int count) {
			this.position = position;
			this.count = count;
		}
	}

}