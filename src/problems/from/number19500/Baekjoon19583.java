package problems.from.number19500;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Baekjoon19583 {

	public static void main(String[] args) throws IOException {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		String[] allocationTimeArray = br.readLine().split(" ");
		Time startTime = new Time(allocationTimeArray[0]);
		Time endTime= new Time(allocationTimeArray[1]);
		Time endStreamingTime = new Time(allocationTimeArray[2]);
		
		String inputText;
		HashMap<String, State> memberStates = new HashMap<>();
		int result = 0;
		
		while (true) {
			inputText = br.readLine();
			if (inputText == null || inputText.equals("")) {
				break;
			}
			String[] allocationInputTextArray = inputText.split(" ");
			Time logTime = new Time(allocationInputTextArray[0]);
			String name = allocationInputTextArray[1];
			
			if (!memberStates.containsKey(name)) {
				memberStates.put(name, State.Default);
			}
			
			State stateNow = memberStates.get(name);
			
			switch (stateNow) {
				case Default:
					if (logTime.isSoonerThan(startTime)) {
						memberStates.put(name, State.Start);
					}
					break;
				case Start:
					if (logTime.isLaterThan(endTime) && logTime.isSoonerThan(endStreamingTime)) {
						memberStates.put(name, State.End);
						result++;
					}
					break;
			}
		}
		
		System.out.println(result);
		
	}
}
enum State{
	Default, Start, End
}

class Time {
	int Hours, Minutes;
	
	public Time(String inputString) {
		String[] timeString = (inputString.split(":"));
		this.Hours = Integer.parseInt(timeString[0]);
		this.Minutes= Integer.parseInt(timeString[1]);
	}
	public boolean isSoonerThan(Time t) {
		if (this.Hours < t.Hours) {
			return true;
		} else if (this.Hours > t.Hours) {
			return false;
		} else {
			if (this.Minutes <= t.Minutes) {
				return true;
			} else {
				return false;
			}
		}
	}
	public boolean isLaterThan(Time t) {
		if (t.Hours < this.Hours) {
			return true;
		} else if (t.Hours > this.Hours) {
			return false;
		} else {
			if (this.Minutes >= t.Minutes) {
				return true;
			} else {
				return false;
			}
		}		
	}
}
/*
22:00 23:00 23:30
06:00 ¤±
06:30 ¤±¤±
 */
//class log {
//	private Time time;
//	private String user;
//	
//	public log(String Hours, String Minutes, String user) {
//		time = new Time(Hours, Minutes);
//	}
//	
//	public String getUser() {
//		return user;
//	}
//}