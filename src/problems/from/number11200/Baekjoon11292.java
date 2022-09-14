package problems.from.number11200;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Baekjoon11292 {
	static int toInt(String s) {
		return Integer.parseInt(s);
	}
	
	public static void main(String[] args) throws IOException{
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		while (true) {
			int cases = toInt(br.readLine());
			if (cases == 0) {
				break;
			}
			
			Student[] students = new Student[cases];
			for (int i=0; i<cases; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				String name = st.nextToken();
				float height = Float.parseFloat(st.nextToken());
				Student student = new Student(name, height);
				students[i] = student;
			}
			
			float maxHeight = Arrays.stream(students).max(new Comparator<Student>() {
				@Override
				public int compare(Student o1, Student o2) {
					if (o1.height > o2.height) {
						return 1;
					} else if (o1.height == o2.height) {
						return 0;
					}
					return -1;
				}
			}).get().height;
			
			String result = "";
			for (Student s : students) {
				if (s.height == maxHeight) {
					result += " " + s.name;
				}
			}
			System.out.println(result.trim());
		}
	}
}

class Student {
	float height;
	String name;
	
	Student(String name, float height){
		this.name = name;
		this.height = height;
	}
}
