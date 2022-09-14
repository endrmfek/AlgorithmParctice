package programmers;

import java.util.ArrayList;
import java.util.Collections;

public class 정수내림차순 {
	public long solution(long n) {
        long answer = 0;
        StringBuilder sb = new StringBuilder();
        ArrayList<Long> arr = new ArrayList<>();
        while(n != 0) {
        	Long remainer = n % 10;
        	n = n /10;
        	arr.add(remainer);
        }
        arr.sort(Collections.reverseOrder());
        
        for(Long a : arr) {
        	sb.append(a);
        }
        return Long.parseLong(sb.toString());
    }
}
