package problems.from.number14100;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 2023-09-27
public class Baekjoon14175 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int height = Integer.parseInt(st.nextToken());
        int width = Integer.parseInt(st.nextToken());
        int scale = Integer.parseInt(st.nextToken());

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < height; i++) {
            char[] line = br.readLine().toCharArray();
            for (int a = 0; a < scale; a++) {
                for (int j = 0; j < width; j++) {
                    for (int b = 0; b < scale; b++) {
                        sb.append(line[j]);
                    }
                }
                sb.append('\n');
            }
        }

        System.out.print(sb);
    }
}


// 2023-09-27
/*
수정 전 코드(passed)
public class Baekjoon14175 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int height = Integer.parseInt(st.nextToken());
        int width = Integer.parseInt(st.nextToken());
        int scale = Integer.parseInt(st.nextToken());

        char[][] result = new char[height * scale][width * scale];

        for (int i = 0; i < height; i++) {
            char[] line = br.readLine().toCharArray();
            for (int j = 0; j < width; j++) {

                for (int a = 0; a < scale; a++) {
                    for (int b = 0; b < scale; b++) {
                        result[(i * scale) + a][(j * scale) + b] = line[j];
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < result.length; i++) {
            sb.append(result[i]).append('\n');
        }
        System.out.print(sb);

    }
}
 */
