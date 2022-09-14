package programmers;

public class 이상한문자만들기 {
	public String solution2(String s) {
        //각 단어의 짝수번째 알파벳은 대문자로, 홀수번째 알파벳은 소문자
		
        StringBuilder sb = new StringBuilder();
        String[] words = s.split(" ");
        for(String word: words) {
        	char[] arr = word.toCharArray();
        	for(int i=0; i<arr.length; i++) {
        		if ((i)%2 == 0) { // 짝수면
        			arr[i] = Character.toUpperCase(arr[i]);
        		}
        	}
        	sb.append(arr);
        	sb.append(" ");
        }
        sb.deleteCharAt(sb.length()-1);
        
        return sb.toString();
    }
	
	public String solution(String s) {
        //각 단어의 짝수번째 알파벳은 대문자로, 홀수번째 알파벳은 소문자
		String answer = "";
		char[] arr = s.toCharArray();
		int idx =0;
		
		for(int i=0; i<arr.length; i++) {
			
			if (arr[i] == ' ') {
				idx = 0;
			} 
			else {
				if (idx%2==0) {
					arr[i] = Character.toUpperCase(arr[i]);
					idx++;
				} else {
					arr[i] = Character.toLowerCase(arr[i]);
					idx++;
				}
				
			}
		}
        return new String(arr);
    }
}
