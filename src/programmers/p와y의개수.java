package programmers;

public class p와y의개수 {
	boolean solution(String s) {
        boolean answer = true;
        int p = 0;
        int y = 0;
        
        
        char[] arr = s.toCharArray();
        
        for(int i=0; i<arr.length; i++) {
        	if (arr[i] == 'p' || arr[i] =='P') {
        		p+=1;
        	}
        	if (arr[i] == 'y' || arr[i] =='Y') {
        		y+=1;
        	}
        }
        
        if ( p != y) {
        	answer = false;
        }
        
        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
        System.out.println("Hello Java");

        return answer;
    }
}
