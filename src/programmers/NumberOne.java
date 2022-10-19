package programmers;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class NumberOne {
	
	public int[] solution(String[] students) {
		int[] result = new int[students.length];
        List<Student> list = new ArrayList<>();
        
        for(int i=0; i<students.length; i++) {
        	char[] scores = students[i].toCharArray();
        	Student student = new Student(i+1, 10, 0, 0);
        	
        	for(char score : scores) {
        		if(score == 'A') {
        			student.totalScore += 1;
        		}
        		
        		if(score == 'L') { //지각
        			student.tardy += 1;
        		}
        		
        		if(score == 'P') {
        			student.absent += 1;
        		}
        	}
        	
        	int wlrkr = student.tardy / 2;
        	
        	student.absent += wlrkr;
        	
        	if( student.absent >= 3) {
        		student.totalScore = 0;
        	} else {
        		student.totalScore -= student.absent;
        	}
        	
        	list.add(student);
        	
        }
        
        list.sort(new Comparator<Student>() {
        	@Override
        	public int compare(Student o1, Student o2) {
        		// TODO Auto-generated method stub
        		if(o1.totalScore == o2.totalScore) {
        			return o1.index - o2.index;
        		}
        		return o2.totalScore -o1.totalScore;
        	}
        });
        for(int i=0; i<students.length; i++) {
    		result[i] = list.get(i).index;
    	}
        return result;
    }
	
	static class Student{
		int index;
		int totalScore;
		int absent;
		int tardy;
		public Student(int index , int totalScore, int absent, int tardy) {
			this.index = index;
			this.totalScore = totalScore;
			this.absent = absent;
			this.tardy = tardy;
		}
		public int getTotalScore() {
			return totalScore;
		}
		
		
		
	}
}

