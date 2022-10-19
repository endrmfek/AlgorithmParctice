package programmers;

import java.util.HashMap;
import java.util.Map;


public class 성격유형검사하기 {
	//지표당 2개 옵션
	//n개의 질문 -> 각 질문당 7개 선택지
	//[3,2,1,0,1,2,3]
	//위 예시처럼 네오형이 비동의, 어피치형이 동의인 경우만 주어지지 않고, 질문에 따라 네오형이 동의, 어피치형이 비동의인 경우도 주어질 수 있습니다.
	// 두 성격 유형 중 사전 순으로 빠른 성격 유형
	//질문마다 판단하는 지표를 담은 1차원 문자열 배열 survey와 검사자가 각 질문마다 선택한 선택지를 담은 1차원 정수 배열 choices
	//1<= survey <=1000
	//
	public static String solution(String[] survey, int[] choices) {
        StringBuilder answer = new StringBuilder();
        Map<Character , Integer> MBTI = new HashMap<>();
        
        //["AN", "CF", "MJ", "RT", "NA"]
        //[5, 3, 2, 7, 5]
        for(int i=0; i<survey.length; i++) {
        	int preOrSur =choices[i] / 4; // 0이면 앞 1 이면 뒤
        	int score = choices[i] % 4; // 4면 0 ..
        	
        	
        	if(preOrSur == 0) { // 전자
        		char prefix = survey[i].charAt(0);
        		MBTI.put(prefix, MBTI.getOrDefault(prefix, 0) + (4-score));
        	} else { // 후자
        		char surfix = survey[i].charAt(1);
        		MBTI.put(surfix, MBTI.getOrDefault(surfix, 0) + score);
        	}
        }
        for(Map.Entry<Character, Integer> entry : MBTI.entrySet()) {
        	System.out.println(entry.getKey() + " : " + entry.getValue());
        }
        int R = MBTI.getOrDefault('R',0);
        int T = MBTI.getOrDefault('T',0);
        int C = MBTI.getOrDefault('C',0);
        int F = MBTI.getOrDefault('F',0);
        int J = MBTI.getOrDefault('J',0);
        int M = MBTI.getOrDefault('M',0);
        int A = MBTI.getOrDefault('A',0);
        int N = MBTI.getOrDefault('N',0);
        
        if( R >= T) {
        	answer.append("R");
        } else {
        	answer.append("T");
        }
        
        if(C >= F) {
        	answer.append("C");
        } else {
        	answer.append("F");
        }
        
        if(J>=M) {
        	answer.append("J");
        } else {
        	answer.append("M");
        }
        
        if(A>=N) {
        	answer.append("A");
        }else {
        	answer.append("N");
        }
        
        return answer.toString();
    }
	public static void main(String[] args) {
		System.out.println(solution(new String[] {"AN", "CF", "MJ", "RT", "NA"} , new int[] {5, 3, 2, 7, 5}));
	}
}
