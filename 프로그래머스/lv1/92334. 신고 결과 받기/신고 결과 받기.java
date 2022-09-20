import java.util.*;
import java.util.stream.*;

class Solution {
    //각 유저는 한번에 한명의 유저를 신고할 수 있음.
	//신고 횟수에 제한은 없음. 단 동일한 유저는 안돼.
	//k번 이상 신고된 유저는 게시판 이용이 정지됨. -> 해당유저 신고한 모든 유저에게 메일 발송
	//이용자 ID -> id_list , 각 이용자가 신고한 이용자의 ID정보 -> report, 정지 기준 K
	//report = [이용자id 신고자id]
	public static int[] solution(String[] id_list, String[] report, int k) {
		Map<String , Set<String>> map = new HashMap<>(); // [신고당한애 : {신고한애}]
		
		for(String r : report) {
			String[] users = r.split(" ");
			Set<String> reporters = map.getOrDefault(users[1], new HashSet<>());
			reporters.add(users[0]);
			map.put(users[1], reporters);
		}
		
		Map<String , Integer> count = new LinkedHashMap<>(); // 순서보장
		
		for(String id : id_list) {
			count.put(id, 0);
		}
		
		for(Map.Entry<String, Set<String>> entry : map.entrySet()) {
			if(entry.getValue().size() >= k ) { // 누군진 모르겠지만 신고자가 2명 이상이면
				for(String value : entry.getValue()) { // 각 신고자는 1점 획득.
					count.put(value, count.getOrDefault(value, 0) + 1);
				}
			}
		}
		
		return count.values().stream().mapToInt(Integer::intValue).toArray();
    }
}