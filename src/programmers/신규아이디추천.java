package programmers;

import java.util.Deque;
import java.util.LinkedList;

public class 신규아이디추천 {
	public String solution(String new_id) {
		String answer = "";
		String temp = new_id.toLowerCase(); //1단계
		
		temp = temp.replaceAll("[^-_.a-z0-9]","");
		temp = temp.replaceAll("[.]{2,}",".");
		temp = temp.replaceAll("^[.][.]$", "");
		
		if (temp.isEmpty()) {
			temp += 'a';
		}
		
		if (temp.length() >= 16) {
			temp = temp.substring(0,15);
			temp = temp.replaceAll("[.]$", "");
		}
		
		if (temp.length() <=2) {
			while (temp.length() < 3) {
				temp += temp.charAt(temp.length()-1);
			}
		}
		
		answer = temp;
		return answer;
		
			
	}
}
