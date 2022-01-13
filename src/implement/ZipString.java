package implement;

public class ZipString {
	public int solution(String s) {
		int answer = s.length();
		for(int step=1; step<s.length()+1; step++) {
			String comp ="";
			String prev = s.substring(0,step);
			int cnt=1;
			
			for(int j=step; j<s.length(); j += step) { // step 단위로 압축 검사 (왜 step부터야? -> index 0일때 처리를 위에서 했잖아.)
				String sub ="";
				for(int k=j; k<j+step; k++) { //step범위 내에서 sub 문자열이 prev랑 일치하냐?
					if(k<s.length()) sub += s.charAt(k);
				}
				if(prev.equals(sub)) cnt +=1; //똑같으면 step만큼 앞으로가서 또 검사해야지. 
				else { //다르면 prev바꿔서 압축검사 다시해야지
					comp += (cnt >=2)? cnt+prev : prev;
					sub = "";
					for(int k=j; k<j+step; k++) { //step범위 내에서 sub 문자열이 prev랑 일치하냐?
						if(k<s.length()) sub += s.charAt(k);
					}
					prev = sub; //안맞는 친구로 다시 압축문자열 설정.
					cnt = 1;
				}
			}
			comp += (cnt>=2)? cnt+prev: prev;
			answer = Math.min(answer, comp.length());
		}
		return answer;
	}
	
	public static void main(String[] args) {
		ZipString z = new ZipString();
		System.out.println(z.solution("aabbaccc"));
	}
}
