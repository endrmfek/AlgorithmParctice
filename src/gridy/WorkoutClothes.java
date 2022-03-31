package gridy;

import java.util.Arrays;

public class WorkoutClothes {
	
	public static int solution(int n, int[] lost, int[] reserve) {
		
		int answer = n - lost.length; 
		
		Arrays.sort(lost);
		Arrays.sort(reserve);
		
		//여벌 체육복을 가져온 학생이 도난
		for(int i=0; i<lost.length; i++) {
			for(int j=0; j<reserve.length; j++) {
				if(lost[i] == reserve[j]) {
					answer++;
					lost[i] = -1;
					reserve[j] = -1;
					break;
				}
			}
		}
		
		// 도난당한 학생에게 체육복 빌려주는 경우
        for(int i=0; i<lost.length; i++){
            for(int j=0; j<reserve.length; j++){
                if((lost[i]-1 == reserve[j]) || (lost[i]+1 == reserve[j])){
                    answer++;
                    reserve[j] = -1; 
                    break; 
                }
            }
        }
		
				
        return answer;
    }

	public static void main(String[] args) {
		int[] a = {2,3};
		int[] b = {3};
		System.out.println(solution(5, a,b));
	}
}
