package programmers;

public class 수박 {
	public String solution(int n) {
        String answer = "";
        
        StringBuilder sb = new StringBuilder();
        
        for(int i=1; i<=n; i++) {
        	if (i%2 == 1) {
        		sb.append("수");
        	} else {
        		sb.append("박");
        	}
        }
        
        return sb.toString();
    }
}
