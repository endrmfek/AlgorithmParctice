package programmers;

import java.util.Arrays;

public class 김서방찾기 {
	public String solution(String[] seoul) {
        String answer = "";
        int temp = 0;
        for(int i=0; i<seoul.length; i++) {
        	if (seoul[i].equals("Kim")) {
        		temp = i;
        		break;
        	}
        }
        return "김서방은 "+ String.valueOf(temp) +"에 있다";
    }
}
