package programmers;

import java.util.ArrayList;
import java.util.Collections;

public class 자연수뒤집어배열로 {
	//그냥 뒤집는거구나.
	public int[] solution(long n) {
        ArrayList<Long> answer = new ArrayList<>();
        
        while(n!=0) { // 123-> 3 2 1
        	long remainder = n %10;
        	n = n/10;
        	answer.add(remainder);
        }
        
        
        
        return answer.stream().mapToInt(i->i.intValue()).toArray();
    }
}
