package programmers;
import java.util.*;
import java.util.regex.Pattern;


public class 불량사용자 {
	
	HashSet<HashSet<String>> result;
	ArrayList<ArrayList<String>> bannedUserList;
	public int solution(String[] user_id, String[] banned_id) {
		//제재 아이디 목록들을 구했을 때 아이디들이 나열된 순서와 관계없이 아이디 목록의 내용이 동일하다면 같은 것으로 처리하여 하나로 세면 됩니다.
		// ab*de -> abcde 같이 매턴패칭 ? -> 정규표현식써라진짜. 개필수다.
		
		result = new HashSet<>();
		bannedUserList = new ArrayList<>();
		
		for(String ban : banned_id) {
			bannedUserList.add(patternMathcing(ban , user_id)); //ban마다 후보군이 리스트로.
		}
		
		dfs(new HashSet<>(), 0);
		
		return result.size();
	}
	
	ArrayList<String> patternMathcing(String ban, String[] user_id) {
		String pattern = ban.replaceAll("*", "."); 
//		System.out.println(pattern);
		ArrayList<String> value = new ArrayList<>();
		
		for(String user : user_id) {
			boolean isMatch = Pattern.matches(pattern , user);
			if(isMatch) {
				value.add(user);
			}
		}
		return value;
	}
	
	void dfs(HashSet<String> add,  int depth) {
		if (depth == bannedUserList.size()) {
			result.add(new HashSet<>(add));
			return;
		}
		
		for(String userId : bannedUserList.get(depth)) {
			if(!add.contains(userId)) {
				add.add(userId);
				dfs(add, depth+1);
				add.remove(userId);
			}
		}
	}
}
