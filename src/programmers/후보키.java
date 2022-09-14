package programmers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class 후보키 {
	
	List<String> candi = new ArrayList<>();
	
	public int solution(String[][] relation) { 
		int answer = 0;
		
		for(int i=0; i<relation[0].length; i++) { // 각 튜플에 대해
			boolean[] visited = new boolean[relation[0].length];
			dfs(visited, 0, 0, i+1 , relation);
		}
		answer = candi.size();
		return answer;
	}
	
	void dfs(boolean[] visited, int start, int depth, int end, String[][] relation) {
		if (depth == end) { // 1~ 4
			List<Integer> list = new ArrayList<>();
			String key = "";
			for(int i=0; i<visited.length; i++) {
				if (visited[i]) { //해당 컬럼의 인덱스 쳐넣어.
					key += String.valueOf(i);
					list.add(i);
				}
			}
			
			//유일성, 최소성 검사해야되거든여
			
			Map<String, Integer> map = new HashMap<>();
			
			for(int i=0; i<relation.length; i++) { //모든 로우를 돌아봐바
				String s ="";
				for(Integer j : list) {// 각 로우의 컬럼들 뺴봐
					s += relation[i][j];
				}
				
				if(map.containsKey(s)) { //해당 값이 중복이 된다면 나가
					return;
				} else {
					map.put(s , 0);
				}
			} // 여기서 유일성을이미 검사를 하는거지.
			
			//map 크기가 릴레이션 크기랑 같으면 중복은 없는거야.
			
			for (String s : candi) {
				int count = 0;
				for(int i=0; i<key.length(); i++) {
					String subS = String.valueOf(key.charAt(i));
					if(s.contains(subS)) count++;
				}
				if(count == s.length()) return; //14 , 124 -> 124는 14를 포함해.
			}
			candi.add(key);
			
			return;
		}
		
		for(int i=start; i<visited.length; i++) {
			if (visited[i]) continue; // 방문했으면 다음
			
			visited[i] = true;
			dfs(visited, i, depth+1, end, relation);
			visited[i] = false; // 갔다오면 해제해줘야대..
		}
	}
	
	
		
	
	
	public static void main(String[] args) {
		String[][] f = {{"100","ryan","music","2"},{"200","apeach","math","2"},{"300","tube","computer","3"},{"400","con","computer","4"},{"500","muzi","music","3"},{"600","apeach","music","2"}};
//		solution(f);
	}
}
