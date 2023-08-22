package problems.from.number05700;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon5723 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringBuilder sb = new StringBuilder();
		while (true) {
			int dayCount = Integer.parseInt(br.readLine());
			
			if (dayCount == 0) {
				break;
			}
			
			Date before = null;
			int consumtionDifferenceSum = 0;
			int daysDetermined = 0;
			for (int i = 0; i < dayCount; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				
				int day = Integer.parseInt(st.nextToken());
				int month = Integer.parseInt(st.nextToken());
				int year = Integer.parseInt(st.nextToken());
				int consumption = Integer.parseInt(st.nextToken());
				
				Date now = new Date(day, month, year, consumption);
				if (before == null) {
					before = now;
					continue;
				}
				
				before.goTomorrow();
				if (before.equals(now)) {
					consumtionDifferenceSum += now.consumption - before.consumption;
					daysDetermined += 1;
				}
				before = now;
			}
			
			sb.append(String.format("%d %d\n", daysDetermined, consumtionDifferenceSum));
		}
		
		System.out.print(sb);
	}

}

class Date {
	static int[] ends = {
			0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31
	};
	int day, month, year, consumption;
	
	Date (int d, int m, int y, int c) {
		day = d;
		month = m;
		year = y;
		consumption = c;
	}
	
	void goTomorrow () {
		int nextDay = day + 1;
		int endDay = getEndOfMonth();
		
		if (day == endDay) {
			nextDay = 1;
			month = month % 12 + 1;
			if (month == 1) {
				year += 1;
			}
		}
		day = nextDay;
	}
	
	int getEndOfMonth () {
		int endDay = ends[month];
		if (month == 2 && isLeapYear(year)) {
			endDay += 1;
		}
		return endDay;
	}
	
	static boolean isLeapYear (int year) {
		boolean result = false;
		if (year % 400 == 0 || (year % 4 == 0 && year % 100 != 0)) {
			result = true;
		}
		
		return result;
	}
	
	boolean equals (Date d) {
		if (day == d.day && month == d.month && year == d.year) {
			return true;
		}
		return false;
	}
	
}