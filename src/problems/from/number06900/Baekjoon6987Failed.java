package problems.from.number06900;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

/**
 * 백트래킹으로 풀어야 하는데, 생각해내질 못해서 다른 방법을 생각해서 시도했음
 * 그러나 틀림 결국 백트래킹으로 해야하는듯.
 *
 */
public class Baekjoon6987Failed {

	public static void main(String[] args) throws IOException {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		
		StringBuilder sb = new StringBuilder();
		for (int caseCount=0; caseCount<4; caseCount++) {
			ArrayList<Country> countries = new ArrayList<>();
			ArrayList<Country> leftCountries = new ArrayList<>();
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i=0; i<6; i++) {
				int win = Integer.parseInt(st.nextToken());
				int draw = Integer.parseInt(st.nextToken());
				int lose = Integer.parseInt(st.nextToken());
				
				Country c = new Country(win, draw, lose);
				countries.add(c);
				leftCountries.add(new Country(0, 0, 0));
			}
			Collections.sort(countries, Collections.reverseOrder());

			int result = 1;
			for (int i=0; i<6; i++) {
				Country now = countries.get(i);
				if (now.win + now.draw + now.lose != 5) {
					result = 0;
					break;
				}
				
				Country candidate = null;
				for (int j=0; j<leftCountries.size(); j++) {
					Country leftCountry = leftCountries.get(j);
					if (now.win >= leftCountry.win && now.draw >= leftCountry.draw && now.lose >= leftCountry.lose) {
						candidate = leftCountry;
						leftCountries.remove(j);
						break;
					}
				}
				if (candidate == null) {
					result = 0;
					break;
				}
				int loseLeft = now.win - candidate.win;
				int drawLeft = now.draw - candidate.draw;
				int winLeft = now.lose - candidate.lose;
				
				for (int j=0; j<leftCountries.size(); j++) {
					Country leftCountry = leftCountries.get(j);
					if (loseLeft > 0) {
						loseLeft -= 1;
						leftCountry.lose += 1;
					} else if (drawLeft > 0) {
						drawLeft -= 1;
						leftCountry.draw += 1;
					} else if (winLeft > 0){
						winLeft -= 1;
						leftCountry.win += 1;
					}
				}
				
				System.out.println("cycle : " + i + " country : " + now);
				for (Country c : leftCountries) {
					System.out.println("win, draw, lose : " + c.toString());
				}
				
				
			}
			sb.append(result);
			sb.append(' ');
		}
		System.out.println(sb.toString().trim());

	}
}

class Country implements Comparable<Country> {
	int win, draw, lose;
	
	Country (int w, int d, int l){
		win = w;
		draw = d;
		lose = l;
	}

	@Override
	public int compareTo(Country o) {
		if (win - o.win == 0) {
			if (draw - o.draw == 0) {
				return lose - o.lose;
			}
			return draw - o.draw;
		}
		return win - o.win;
	}
	
	@Override
	public String toString(){
		return win + " " + draw + " " + lose;
	}
}
