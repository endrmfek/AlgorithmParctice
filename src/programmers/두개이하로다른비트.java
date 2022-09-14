package programmers;

public class 두개이하로다른비트 {
	public long[] solution(long[] numbers) {
		//다른지점이 두개 이하면서 제일 작은수.
		//dfs해야돼? -> 아니야..
		//규칙을 찾아야되네..
        long[] answer = new long[numbers.length];
        
        for(int i=0; i<numbers.length; i++) {
        	if(numbers[i] % 2 == 0) { // 짝수이면
        		answer[i] = numbers[i] + 1; // 맨 마지막비트가 0이라 1 더해주면 끝.
        	} else {
        		StringBuilder sb = new StringBuilder();
        		String binary = Long.toBinaryString(numbers[i]);
        		
        		if(!binary.contains("0")) { // 홀수인데 0이 없으면 두번째에 0넣으면돼.
        			sb.append("10"); // 7 -> 0111 -> 1011 -> 11
        			sb.append(binary.substring(1).replace("0", "1"));
        		} else { //홀수인데 0이 있으면
        			int lastIndex = binary.lastIndexOf("0"); // 제일 끝에 0을 찾고 
        			int firstOneIndex = binary.indexOf("1", lastIndex); //
        			
        			sb.append(binary, 0, lastIndex).append("1"); //제일 끝에 0을 1로 바꾸고
        			sb.append("0"); // 그 바로 다음거 0으로 바꾸고
        			sb.append(binary.substring(firstOneIndex + 1));
        		}
        		answer[i] = Long.parseLong(sb.toString(), 2);
        	}
        }
        return answer;
    }
}
