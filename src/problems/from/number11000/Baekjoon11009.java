package problems.from.number11000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Baekjoon11009 {
	static Fraction result;
	
	// dreamoon이 빨간 공을 뽑을 확률을 재귀적으로 구한다.
	static void getProbability(int remainingRed, int remainingWhite, Fraction beforeProbability) {
		/*
		 * 지금 drazil의 순서가 끝났고, 지금까지 차례로 흰색 공만 뽑았다고 하자.
		 * dreamoon이 빨간 공을 뽑을 확률을 구하기 위해선 아래와 같은 경우를 고려해야 한다.
		 * 1. dreamoon이 "빨간" 공을 뽑았을 경우
		 * 2. dreamoon이 "흰색" 공을 뽑았고, drazil도 "흰색" 공을 뽑아서 다시 dreamoon 차례가 되는 경우
		 * 
		 * 1번 케이스에선 결과 값에 더해주면 된다.
		 * 2번 케이스에서 재귀가 가능하다.
		 * 
		 * 그러나 2번 케이스로 가기 위해선 흰색 공이 2개 이상 남아있어야 한다.
		 * 그래야 dreamoon이 "흰색" 공을 뽑고, 그 뒤 drazil도 "흰색" 공을 뽑아서(2개가 감소함) 다시 dreamoon 차례가 될 수 있기 때문이다.
		 */
		int sum = remainingRed + remainingWhite;
		Fraction redProbability = beforeProbability.multiply(new Fraction(remainingRed, sum));
		result = result.add(redProbability);
		
		// 흰색 공이 2개 이상 남았는지 체크한다.
		if (remainingWhite < 2) {
			return;
		}
		
		/* 
		 * 기존 확률(흰 * 흰 * 흰 * 흰 * ...)에 (흰 * 흰)을 곱해주고 재귀한다.
		 * 이 때 감소한 흰색 공의 개수를 유의하면서 반복하자.
		 */
		Fraction whiteProbability = new Fraction(remainingWhite, sum);
		Fraction drazilProbability = new Fraction(remainingWhite - 1, sum - 1);
		Fraction nextProbability = beforeProbability.multiply(whiteProbability).multiply(drazilProbability);
		getProbability(remainingRed, remainingWhite - 2, nextProbability);
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringBuilder sb = new StringBuilder();
		int caseCount = Integer.parseInt(br.readLine());
		Fraction initialResult = new Fraction(0, 0);
		Fraction initialProbability = new Fraction(1, 1);
		while (caseCount --> 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int red = Integer.parseInt(st.nextToken());
			int white = Integer.parseInt(st.nextToken());
			result = initialResult;
			Fraction nextProbability = initialProbability;
			
			getProbability(red, white, nextProbability);
			
			sb.append(result).append('\n');
		}
		System.out.print(sb);
	}
}

// 분수 클래스 정의
class Fraction {
	BigInteger numerator;
	BigInteger denominator;
	
	Fraction(BigInteger n, BigInteger d) {
		numerator = n;
		denominator = d;
	}
	
	Fraction(int n, int d) {
		numerator = new BigInteger(String.valueOf(n));
		denominator = new BigInteger(String.valueOf(d));
	}
	
	static BigInteger GCD(BigInteger l, BigInteger r) {
		return l.gcd(r);
	}
	
	// 약분
	void reduce() {
		BigInteger gcd = GCD(numerator, denominator);
		numerator = numerator.divide(gcd);
		denominator = denominator.divide(gcd);
	}
	
	// 곱셈
	Fraction multiply(Fraction f) {
		Fraction result = new Fraction(numerator.multiply(f.numerator), denominator.multiply(f.denominator));
		result.reduce();
		
		return result;
	}
	
	// 더하기
	Fraction add(Fraction f) {
		Fraction result;
		if (numerator.compareTo(BigInteger.ZERO) != 0) {
			BigInteger commonDenominator = denominator.multiply(f.denominator);
			BigInteger resultNumerator = numerator.multiply(commonDenominator.divide(denominator)).add(f.numerator.multiply(commonDenominator.divide(f.denominator)));
			
			result = new Fraction(resultNumerator, commonDenominator);
			result.reduce();
		} else {
			result = new Fraction(f.numerator, f.denominator);
		}
		return result;
	}
	
	@Override
	public String toString() {
		return numerator + "/" + denominator;
	}
}
