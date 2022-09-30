package problems.from.number01900;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon1907 {

	public static void main(String[] args) throws IOException {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		
		String[] inputTexts = br.readLine().split("[+=]");
		
		Term M1 = new Term(inputTexts[0]);
		Term M2 = new Term(inputTexts[1]);
		Term M3 = new Term(inputTexts[2]);
		
		boolean isFound = false;
		for (int i=1; i<11; i++) {
			for (int j=1; j<11; j++) {
				for (int k=1; k<11; k++) {
					Term A = M1.getProductedTerm(i);
					Term B = M2.getProductedTerm(j);
					Term C = M3.getProductedTerm(k);
					
					if (A.getCombinedTerm(B).equals(C)) {
						System.out.println(String.format("%d %d %d", i, j, k));
						isFound = true;
						return;
					}
				}
			}
		}
		if (!isFound) {
			System.out.println("NEMOGUCE");
		}
	}
}

class Term {
	int C;
	int H;
	int O;
	
	Term getCombinedTerm(Term term) {
		return new Term(C + term.C, H + term.H, O + term.O);
	}
	Term getProductedTerm(int multiplicand) {
		return new Term(C * multiplicand, H * multiplicand, O * multiplicand);
	}
	boolean equals(Term term2) {
		if (C == term2.C && H == term2.H && O == term2.O) {
			return true;
		}
		return false;
	}
	
	public String toString() {
		return "C : " + C + " H : " + H + " O : " + O;
	}
	Term (int C, int H, int O){
		this.C = C;
		this.H = H;
		this.O = O;
	}
	Term (String text){
		char lastAtom = 0;
		C = 0;
		H = 0;
		O = 0;
		for (int i=0; i<text.length(); i++) {
			char now = text.charAt(i);
			if (Character.isDigit(now)) {
				switch (lastAtom) {
				case 'C':
					C += Character.getNumericValue(now) - 1;
					break;
				case 'H':
					H += Character.getNumericValue(now) - 1;
					break;
				case 'O':
					O += Character.getNumericValue(now) - 1;
					break;
				}
			} else {
				lastAtom = now;
				switch (now) {
				case 'C':
					C += 1;
					break;
				case 'H':
					H += 1;
					break;
				case 'O':
					O += 1;
					break;
				}
			}
		}
	}
}