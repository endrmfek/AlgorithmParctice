package programmers;

import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;

public class 문자열내마음대로정렬하기 {
	public String[] solution(String[] strings, int n) {
        String[] answer = strings;
        Arrays.sort(answer, new Comparator<String>() {
        
        	public int compare(String o1, String o2) {
        		if (o1.charAt(n) != o2.charAt(n)) {
        			return o1.charAt(n) - o2.charAt(n);
        		} else {        			
        			return o1.compareTo(o2);
        		}
        	};
		});
        
        return answer;
    }
}
