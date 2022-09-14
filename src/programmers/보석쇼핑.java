package programmers;

import java.util.*;

public class 보석쇼핑 {
	//싹슬이
	//진열된 모든 종류의 보석을 적어도 1개 이상 포함하는 가장 짧은 구간을 찾아서 구매
	//모든 종류의 보석을 포함하는 가장 짧은 구간.
	//효율성 테스트가 있네? 씨발거
	
	public int[] solution(String[] gems) {
        int[] answer = new int[2];
        Set<String> set = new HashSet<>(Arrays.asList(gems));
        Map<String , Integer> map = new HashMap<>();
        Queue<String> q = new LinkedList<>();
        
        int start = 0;
        int tempStart =0;
        int length = Integer.MAX_VALUE;
        
        for(int i=0; i<gems.length; i++) {
        	String name = gems[i];
        	map.put(name , map.getOrDefault(name, 0) + 1);
        	q.offer(name);
        	
        	while(true) {
        		String temp = q.peek();
        		if(map.get(temp) > 1) {
        			map.put(temp, map.get(temp)-1);
        			q.poll();
        			tempStart++;
        		} else {
        			break;
        		}
        	}
        	
        	if(map.size() == set.size() && length > q.size()) {
        		length = q.size();
        		start = tempStart;
        	}
        }
        
        
        return new int[] {start+1, start+length};
    }
}
