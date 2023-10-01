package problems.from.number22000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon22061 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int caseCount = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        while (caseCount --> 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int singleRoubleCount = Integer.parseInt(st.nextToken());
            int doubleRoubleCount = Integer.parseInt(st.nextToken());
            int price = Integer.parseInt(st.nextToken());

            String result = "NO";
            if (price <= singleRoubleCount + doubleRoubleCount * 2) {
                if (price % 2 != 0) {
                    if (singleRoubleCount != 0) {
                        result = "YES";
                    }
                } else {
                    result = "YES";
                }
            }

            sb.append(result).append('\n');
        }

        System.out.print(sb);
    }
}
