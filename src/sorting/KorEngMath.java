package sorting;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Scanner;

class Student implements Comparable<Student>{
	private String name;
	private int kor;
	private int eng;
	private int math;
	
	public Student(String name, int kor, int eng, int math) {
		this.name= name;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
	}
	public String getName() {
		return name;
	}
	public int getKor() {
		return kor;
	}
	public int getMath() {
		return math;
	}
	public int getEng() {
		return eng;
	}
	
	@Override
	public int compareTo(Student other) {
		if(other.kor == this.kor && this.eng == other.eng && this.math == other.math) {
			return this.name.compareTo(other.name);
		}
		
		if(other.kor == this.kor && this.eng == other.eng) {
			return other.math - this.math;
		}
		
		if(other.kor == this.kor) {
			return this.eng - other.eng;
		}
		
		return other.kor - this.kor ;
	}
}

public class KorEngMath {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n= sc.nextInt();
		
		ArrayList<Student> students = new ArrayList<>();
		for(int i=0; i<n; i++) {
			
			String name = sc.next();
			int kor = sc.nextInt();
			int eng = sc.nextInt();
			int math = sc.nextInt();
			students.add(new Student(name, kor, eng, math));
		}
		
		Collections.sort(students);
		
		for(Student s : students) {
			System.out.println(s.getName());
		}
	}
}
