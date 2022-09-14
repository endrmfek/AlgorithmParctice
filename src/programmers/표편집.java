package programmers;

import java.util.Stack;

public class 표편집 {
	//단, 한 번에 한 행만 선택할 수 있으며, 표의 범위(0행 ~ 마지막 행)를 벗어날 수 없습니다.
	public String solution(int n, int k, String[] cmd) {
		//n = 행 , k = 인덱스 위치
        String answer = "";
        Stack<Integer> remove = new Stack<>();
        
        int size = n;
        
        for(int i=0; i<cmd.length; i++) {
        	char c = cmd[i].charAt(0); // 난 왜 split으로 짜르려고했는가.. ㅠㅠ 문자열 그대로 사용.
        	if(c == 'D') { 
        		k += Integer.parseInt(cmd[i].substring(2)); //index 변수를 만들지 않고 바로 k를 사용하는 묘수..
        	}
        	if(c == 'U') {
        		k -= Integer.parseInt(cmd[i].substring(2));
        	}
        	if(c == 'C') { //삭제시 인덱스 보관과 마지막 요소 삭제시 인덱스는 바로 위로 보존
        		remove.add(k);
        		size--;
        		if(k == size) {
        			k--;
        		}
        	}
        	if(c=='Z') { // 최근 삭제 목록이 k보다 작으면 인덱스값 증가.
        		if(remove.pop() <=k) {
        			k++;
        		}
        		size++;
        	}
        }
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<size; i++) {
        	sb.append("O");
        	System.out.println(sb.toString());
        }
        while(!remove.isEmpty()) {
        	sb.insert(remove.pop().intValue(), "X");
        }
        answer = sb.toString();
        
        return answer;
    }
}
