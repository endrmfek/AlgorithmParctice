package programmers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class 순위검색 {
	static HashMap<String, List<Integer>> map;
	
	public static int[] solution(String[] info, String[] query) {
		int[] answer = new int[query.length];
		map = new HashMap<>();
		
		//초기화를 해야겟져
		for(int i=0; i<info.length; i++) {
			String[] p = info[i].split(" ");
			dfs(p, "", 0); // info조합 후 map에 삽입까지.
		}
		
		//바이너리 정렬  ? -> 정렬 꼭 필요
		for(String key : map.keySet()) {
			Collections.sort(map.get(key));
		}
		
		for(int i=0; i<query.length; i++) {
			query[i] = query[i].replaceAll(" and ", "");
			String[] q = query[i].split(" "); // [문자열 , 점수]
			answer[i] = map.containsKey(q[0]) ? binary(q[0] , Integer.parseInt(q[1])) : 0;
		}
		return answer;
	}
	
	public static void dfs(String[] q, String str, int depth) {
		
		if (depth == 4) {
			
			if(!map.containsKey(str)) { // 가지지 않는다며는
				List<Integer> list = new ArrayList<>();
				map.put(str, list);
			}
			map.get(str).add(Integer.parseInt(q[4]));
			return;
		}
		
		dfs(q, str+"-" , depth+1);
		dfs(q, str+q[depth], depth+1);
		
	}
	
	static int binary(String key, int score) {
		List<Integer> list = map.get(key);
		int start = 0, end = list.size() -1;
		
		while (start <= end) {
			int mid = (start + end) / 2;
			
			if (list.get(mid) < score) {
				start = mid + 1;
			} else { // 크거나 같다!
				end = mid-1;
			}
		}
		return list.size() - start;
	}
	
	public static void main(String[] args) {
		String[] info = {"java backend junior pizza 150","python frontend senior chicken 210","python frontend senior chicken 150","cpp backend senior pizza 260","java backend junior chicken 80","python backend senior chicken 50"};
		String[] query = {"java and backend and junior and pizza 100","python and frontend and senior and chicken 200","cpp and - and senior and pizza 250","- and backend and senior and - 150","- and - and - and chicken 100","- and - and - and - 150"};
		solution(info, query);
	}
}
	
	

