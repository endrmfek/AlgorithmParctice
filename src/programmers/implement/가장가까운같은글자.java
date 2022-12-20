package programmers.implement;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class 가장가까운같은글자 {
    public int[] solution(String s) {
        int[] answer = new int[s.length()];
        Set<Character> set = new HashSet<>();
        char[] chars = s.toCharArray();
        for(int i=0; i<chars.length; i++) {
            char c = chars[i];
            if(!set.contains(c)) {
                answer[i] = -1;
                set.add(c);
            } else {
                int count = 1;
                for(int j=i-1; j>=0; j--) {
                    if(chars[j] == c) {
                        answer[i] = count;
                        break;
                    } else {
                        count++;
                    }
                }
            }
        }
        return answer;
    }
}
