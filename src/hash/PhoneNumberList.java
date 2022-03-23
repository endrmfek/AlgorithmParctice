package hash;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class PhoneNumberList {
	public boolean solution(String[] phone_book) {
		
		boolean answer = true;
		Map<String, Integer> phoneMap = new HashMap<>();
		
		for(int i=0; i<phone_book.length; i++) {
			phoneMap.put(phone_book[i], i);
		}
		
		
		for(int i=0; i<phone_book.length && answer; i++) {
			for(int j=1; j<phone_book[i].length(); j++) {
				System.out.println(phone_book[i].substring(0,j));
				if(phoneMap.containsKey(phone_book[i].substring(0,j))) { // 내 자신 어떻
					answer = false;
					break;
				}
			}
		}
		
        
        return answer;
    }
	
	public static void main(String[] args) {
		PhoneNumberList p = new PhoneNumberList();
		String[] s = {"119", "97674223", "1195524421"};
		p.solution(s);
		
		
	}
}
