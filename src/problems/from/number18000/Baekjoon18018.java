package problems.from.number18000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;

public class Baekjoon18018 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String firstWord = br.readLine();
		Character firstLetter = firstWord.charAt(firstWord.length()-1);
		
		int animalCount = Integer.parseInt(br.readLine());
		HashMap<Character, ArrayList<String>> animalStartWith = new HashMap<>();
		while(animalCount-- > 0) {
			String animal = br.readLine();
			Character nowFirst = animal.charAt(0);
			
			animalStartWith.putIfAbsent(nowFirst, new ArrayList<>());
			animalStartWith.get(nowFirst).add(animal);
		}
		
		String result = "?";
		for(Entry<Character, ArrayList<String>> entry : animalStartWith.entrySet()) {
			ArrayList<String> candidates = entry.getValue();
			for (String candidate : candidates) {
				if (candidate.charAt(0) == firstLetter) {
					Character lastLetter = candidate.charAt(candidate.length()-1);
					boolean nextExist = false;
					ArrayList<String> nextCandidates = animalStartWith.getOrDefault(lastLetter, new ArrayList<>());
					for (String nextCandidate : nextCandidates) {
						if (nextCandidate.charAt(0) == lastLetter && !nextCandidate.equals(candidate)) {
							nextExist = true;
							break;
						}
					}
					if (!nextExist) {
						result = candidate + "!"; 
						break;
					} else if (result.equals("?")){
						result = candidate;
					}
				}
			}
		}
		System.out.println(result);
	}

}

/*

hare
3
eee
cat
eagle


*/