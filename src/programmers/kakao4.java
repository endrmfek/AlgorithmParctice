package programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class kakao4 {
	//이진트리 -> 수 표현
    // 이진수를 저장할 빈 문자열
    // 더미노드 추가 -> 원래 이진트리 높이와 같은 포화 이진트리
    // 가장 왼쪽 노드부터 가장 오른쪽 노드까지 왼쪽에 있는 순서대로 (전위순회?)
    // 더미노드면 문자열 뒤에 0추가, 아니면 1추가
    //이진수를 십진수로 변환
    //이진트리에서 리프 노드가 아닌 노드는 자신의 왼쪽 자식이 루트인 서브트리의 노드들보다 오른쪽에 있으며
    //자신의 오른쪽 자식이 루트인 서브트리의 노드들보다 왼쪽에
    //수가 주어졌을때 하나의 이진트리로 해당 수를 표현할 수 있는지.
	static List<Integer> a = new ArrayList<>();
    public static int[] solution(long[] numbers) {
        int[] answer = new int[numbers.length];
        Arrays.fill(answer, -1);
        for(int i=0; i<numbers.length; i++) {
        	//[7.5]
        	long target = numbers[i];
        	long treeHeight = 0; //사실
        	long result = (long) Math.pow(2, treeHeight+1) - 1;  //자리수
        	long maxValue = (long)Math.pow(2, result); // 자리수로 만들수 있는 최대값
        	//0층
        	while(maxValue < target) {
        		
        		if(maxValue > result) {
        			treeHeight += 1;
        		}
        		result = (long) Math.pow(2, treeHeight+1) - 1;
        		maxValue = (long)Math.pow(2, result);
        	}
//        	System.out.println(result);
        	
        	//자리수만 구하면 돼 이거 진짜
        	//2의3승
        	String binary = String.format("%0" +result +"d",Long.parseLong(Long.toBinaryString(target)));
//        	System.out.println(binary);
        	dirtn((int) (result+1));
        	
        	while(result != 0) {
        		int root = (int)result/2; // result  동그라미 개수 -> 2의 약수 구할수있나?
        		if(binary.charAt(root) == '0') {
        			answer[i] = 0;
        			break;
        		}
        		for(int j=0; j<a.size(); j++) {
        			System.out.println(a.get(j));
        			if(binary.charAt(a.get(j)-1) == '0') {
        				answer[i] = 0;	
        			}
        		}
        		break;
        		
        	}
        	
        	if(answer[i] == -1) {
        		answer[i] = 1;
        	}
        	a.clear();
        	//2 4 6 = 8
        }
        return answer;
    }
    
    public static void dirtn(int num) {
    	for(int i=1; i<num; i++) {
    		if(i % 2 == 0) {
    			a.add(i);
    		}
    	}
    }
    public static void main(String[] args) {
		System.out.println(Arrays.toString(solution(new long[] {63,111,95})));
	}
}
