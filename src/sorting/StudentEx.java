package sorting;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class StudentEx implements Comparable<StudentEx>{
	public String name;
	public double gradePointAverage;
	
	public int compareTo(StudentEx that) {
		return name.compareTo(that.name);
	}
	
	public StudentEx(String name, double gradePointAverage) {
		this.name = name;
		
		this.gradePointAverage = gradePointAverage;
	}
	
	public static void sortByName(List<StudentEx> students) {
		Collections.sort(students);
	}
	
	public static void sortByGPA(List<StudentEx> students) {
		Collections.sort(students, Collections.reverseOrder(new Comparator<StudentEx>() {
			@Override
			public int compare(StudentEx a, StudentEx b) {
				return Double.compare(a.gradePointAverage, b.gradePointAverage);
			}
		}));
	}
}
