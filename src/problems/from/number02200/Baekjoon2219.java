package problems.from.number02200;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Baekjoon2219 {
	static int toInt(String s) {
		return Integer.parseInt(s);
	}
	
	public static void main(String[] args) throws IOException {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		
		String originalMetaInput = br.readLine();
		String[] splittedMetaInput = originalMetaInput.split(" ");

		int computerCount = toInt(splittedMetaInput[0]);
		int connectionCount = toInt(splittedMetaInput[1]);
		
		int[][] connections = new int[computerCount][computerCount];
		for (int i=0; i<connections.length; i++) {
			Arrays.fill(connections[i], 3000000);
			connections[i][i] = 0;
		}
		
		for (int i=0; i<connectionCount; i++) {
			String originalConnectionInput = br.readLine();
			String[] splittedConnectionInput = originalConnectionInput.split(" ");
			int firstNode = toInt(splittedConnectionInput[0]) - 1;
			int secondNode = toInt(splittedConnectionInput[1]) - 1;
			int connectionCost = toInt(splittedConnectionInput[2]);
			
			connections[firstNode][secondNode] = Math.min(connections[firstNode][secondNode], connectionCost);
			connections[secondNode][firstNode] = Math.min(connections[secondNode][firstNode], connectionCost);
		}
		
		for (int jointIndex=0; jointIndex<computerCount; jointIndex++) {
			for (int startIndex=0; startIndex<computerCount; startIndex++) {
				for (int endIndex=0; endIndex<computerCount; endIndex++) {
					int originalConnection = connections[startIndex][endIndex];
					int alternativeConnection = connections[startIndex][jointIndex] + connections[jointIndex][endIndex];
					
					connections[startIndex][endIndex] = Math.min(originalConnection, alternativeConnection);
				}
			}
		}
		
		int minConnectionCost = Integer.MAX_VALUE;
		int minCostComputer = 0;
		for (int i=0; i<computerCount; i++) {
			int nodeConnectionCost = Arrays.stream(connections[i]).sum();
			if (minConnectionCost > nodeConnectionCost) {
				minConnectionCost = nodeConnectionCost;
				minCostComputer = i+1;
			}
		}
		System.out.println(minCostComputer);
	}
}
