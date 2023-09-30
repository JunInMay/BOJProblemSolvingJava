package problems.from.number06600;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon6609 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = "";
        StringBuilder sb = new StringBuilder();
        while ((input = br.readLine()) != null) {
//        while (true) {
            input = br.readLine();
            StringTokenizer st = new StringTokenizer(input);

            long mosquitoCount = Long.parseLong(st.nextToken());
            long pupaCount = Long.parseLong(st.nextToken());
            long larvaCount = Long.parseLong(st.nextToken());
            long eggPerMosquito = Long.parseLong(st.nextToken());
            long toPupaRatio = Long.parseLong(st.nextToken());
            long toMosquitoRatio = Long.parseLong(st.nextToken());
            long weekCount = Long.parseLong(st.nextToken());
            long temp;

            for (int i = 0; i < weekCount; i++) {
                temp = mosquitoCount;
                mosquitoCount = pupaCount / toMosquitoRatio;
                pupaCount = larvaCount / toPupaRatio;
                larvaCount = temp * eggPerMosquito;
            }

            sb.append(mosquitoCount).append('\n');
        }

        System.out.print(sb);
    }
}
/*
100000 100000 100000 100 10 10 1000
100000 100000 100000 100 10 10 1
100000 100000 100000 100 10 10 2
 */