package problems.from.number05600;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baekjoon5635 {
	static int toInt(String s) {
		return Integer.parseInt(s);
	}
	
	public static void main(String[] args) throws IOException {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		
		int studentCount = toInt(br.readLine());
		
		Student[] students = new Student[studentCount];
		for (int i=0; i<studentCount; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			String name = st.nextToken();
			int day = toInt(st.nextToken());
			int month = toInt(st.nextToken());
			int year = toInt(st.nextToken());
			Student s = new Student(name, day, month, year);
			students[i] = s;
		}
		Arrays.sort(students);
		
		System.out.println(students[0].name);
		System.out.println(students[studentCount-1].name);
		
	}
}

class Student implements Comparable<Student>{
	String name;
	int year;
	int month;
	int day;
	
	Student(String name, int day, int month, int year){
		this.name = name;
		this.year = year;
		this.month = month;
		this.day = day;
	}
	
	@Override
	public int compareTo(Student o) {
		if (year < o.year) {
			return 1;
		} else if (year == o.year) {
			if (month < o.month) {
				return 1;
			} else if (month == o.month) {
				if (day < o.day) {
					return 1;
				} else {
					return -1;
				}
			}
		}
		return -1;
	}
}
