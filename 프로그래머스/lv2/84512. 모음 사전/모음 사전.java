import java.util.*;
class Solution {
    //모음개수 6개니까.. n이 6이겠죵?~
	static final int VOWELNUMBER = 5;
	static List<String> bucket;
//	 'A', 'E', 'I', 'O', 'U'
	public static int solution(String word) {
        int answer = 0;
        //순서와 인덱스 ? -> 무조건 arraylist 써야지.
        bucket = new ArrayList<>();
        dfs("AEIOU", "", 0);
        answer = bucket.indexOf(word);
        return answer;
        
        //A , AA ,AAA, AAAA, AAAAA
    }
	
	static void dfs(String word, String str, int depth) {
		// System.out.println(str);
        bucket.add(str);
        
        if(depth == 5) {
            return;
        }
        
        for (int i = 0; i < word.length(); i++) {
            dfs(word, str + word.charAt(i), depth + 1);
        }
    }
	
	public static void main(String[] args) {
		solution("aeiou");
	}
}