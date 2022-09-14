package programmers;

import java.util.ArrayList;
import java.util.List;

//1번부터 번호 순서대로 한 사람씩 차례대로 단어를 말합니다.
//마지막 사람이 단어를 말한 다음에는 다시 1번부터 시작합니다.
//앞사람이 말한 단어의 마지막 문자로 시작하는 단어를 말해야 합니다.
//이전에 등장했던 단어는 사용할 수 없습니다.
//한 글자인 단어는 인정되지 않습니다.
public class 영어끝말잇기 {
	public int[] solution(int n, String[] words) { // 해결완료.
        int[] answer = {};
        List<String> wordList = new ArrayList<>();
        int order = 1;
        double temp = 1;
        int turn = 1;
        boolean flag = false;
        String pre = words[0];
        if (words.length == 1) {
        	return new int[] {0,0};
        }
        wordList.add(pre);
        for(int i=1; i<words.length; i++) {
        	temp += 1;
        	order = (i+1) % n; // 번호
        	String now = words[i];
        	
        	turn = (int) Math.ceil(temp/n);
        	
        	if (wordList.contains(now)) {
        		flag = true;
        		//순서 , 차례
        		break;
        	}
        	//앞사람이 말한 단어의 마지막 문자로 시작하는 단어를 말해야 합니다.
        	if (pre.charAt(pre.length()-1) != now.charAt(0)) {
        		flag = true;
        		//순서, 차례
        		break;
        	}
        	if(now.length() == 1) {
        		flag = true;
        		break;
        	}
        	wordList.add(now);
        	pre = now;
        }
        
        if (flag) {
        	if(order == 0) {
        		order = n;
        	}
        	return new int[] {order, turn};
        } else {
        	return new int[] {0,0};
        }
        
    }
}
