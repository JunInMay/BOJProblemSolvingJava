package problems.from.number09830;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baekjoon9830 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int paintingJobs = Integer.parseInt(br.readLine());
		StringTokenizer values = new StringTokenizer(br.readLine());
		StringTokenizer increases = new StringTokenizer(br.readLine());
		
		Job[] jobs = new Job[paintingJobs];
		for (int i=0; i<paintingJobs; i++) {
			int value = Integer.parseInt(values.nextToken());
			int increase = Integer.parseInt(increases.nextToken());
			Job job = new Job(value, increase);
			jobs[i] = job;
		}
		Arrays.sort(jobs);
		
		int day = 0;
		int result = 0;
		for (int i=0; i<paintingJobs; i++) {
			result += jobs[i].value + jobs[i].increase * day++;
		}
		System.out.println(result);
	}
}

class Job implements Comparable<Job> {
	int value, increase;
	
	Job (int v, int i) {
		value = v;
		increase = i;
	}
	
	@Override
	public int compareTo(Job o) {
		
		return - (increase - o.increase);
	}
}
