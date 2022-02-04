package dfs_bfs;

public class Bracket {
	
	public int balancedIndex(String p) {
		int count = 0;
		for(int i=0; i<p.length(); i++) {
			if(p.charAt(i) == '(') count +=1;
			else count -= 1;
			if(count == 0) return i;
		}
		return -1;
	}
	
	public boolean checkProper(String p) {
		int count = 0;
		for(int i=0; i<p.length(); i++) {
			if(p.charAt(i) == '(') count +=1;
			else {
				if(count == 0) {
					return false;
				}
				count -=1;
			}
		}
		return true;
	}
	
	public String solution(String p) {
		String answer = "";
		if(p.equals("")) return answer; // 1. 빈문자열이면 빈문자열
		int index = balancedIndex(p);
		String u = p.substring(0,index+1); //분리해
		String v = p.substring(index+1);
		
		if(checkProper(u)) { //u가 적절하다면
			answer = u + solution(v); //문자열을 붙이고 1단계부터
			
		}
		else { //아니라면
			
			answer ="("; //4-1
			answer += solution(v); //4-2
			answer +=")"; //4-3
			u = u.substring(1,u.length()-1); //4-4
			String temp = "";
			for(int i=0; i<u.length(); i++) {
				if(u.charAt(i) == '(') temp += ")";
				else temp += "(";
			}
			answer += temp;
			
		}
		return answer;
	}
	
	public static void main(String[] args) {
		Bracket b = new Bracket();
		System.out.println(b.solution("()))((()"));
	}
}
