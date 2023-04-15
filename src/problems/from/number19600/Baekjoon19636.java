package problems.from.number19600;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon19636 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int weight = Integer.parseInt(st.nextToken());
        int basalMetabolicRate = Integer.parseInt(st.nextToken());
        int originalBasalMetabolicRate = basalMetabolicRate;
        int threshold = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int daysOnDiet = Integer.parseInt(st.nextToken());
        int energyGainOnDiet = Integer.parseInt(st.nextToken());
        int energySpentOnDiet = Integer.parseInt(st.nextToken());

        StringBuilder result = new StringBuilder();
        int firstWeight = weight + (energyGainOnDiet - (basalMetabolicRate + energySpentOnDiet)) * daysOnDiet;

        String firstResult = String.format("%d %d", firstWeight, basalMetabolicRate);
        if (firstWeight <= 0) {
            firstResult = "Danger Diet";
        }

        boolean isSheDead = false;
        for (int i=0; i<daysOnDiet; i++) {
            int dailyEnergySpent = basalMetabolicRate + energySpentOnDiet;
            int weightFluctuation = Math.abs(energyGainOnDiet - dailyEnergySpent);
            weight -= weightFluctuation;
            if (weightFluctuation > threshold) {
                basalMetabolicRate -= Math.round((double) weightFluctuation / 2);
            }

            if (weight <= 0 || basalMetabolicRate <= 0) {
                isSheDead = true;
                break;
            }
        }
        System.out.println(firstResult);
        String yoyoResult = "NO";
        if (basalMetabolicRate < originalBasalMetabolicRate) {
            yoyoResult = "YOYO";
        }
        String secondResult = "Danger Diet";
        if (!isSheDead) {
            secondResult = String.format("%d %d %s", weight, basalMetabolicRate, yoyoResult);
        }
        System.out.println(secondResult);
    }
}

/*
100000 1500 500
5 1000 700

94000 1500
97300 600 YOYO

 */