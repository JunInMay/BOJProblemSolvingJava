package problems.from.number24200;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Baekjoon24228 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        BigInteger chopstickKinds = new BigInteger(st.nextToken());
        BigInteger pairRequired = new BigInteger(st.nextToken());

        System.out.println((chopstickKinds.add(BigInteger.ONE)).add(pairRequired.subtract(BigInteger.ONE).multiply(BigInteger.TWO)));
    }
}
