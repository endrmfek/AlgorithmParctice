package baisc;

import java.util.Arrays;
import java.util.List;

public class Array { //배열 관련
	
	//임의의 정수값 1 증가시키기. {1,2,9} -> {1,3,0}
	public static List<Integer> plusOne(List<Integer> A) {
		int n = A.size()-1; //자릿수
		A.set(n, A.get(n)+1);
		
		for(int i=n; i>0 && A.get(i)==0; i--) {
			A.set(i,0);
			A.set(i-1, A.get(i-1) + 1);
		}
		
		if(A.get(0) == 10) {
			A.set(0,1);
			A.add(0);
		}
		return A;
	}
	
	//배열에서 이동하기
	public static boolean canReachEnd(List<Integer> maxAdvanceSteps) {
		int furthestReachSoFar = 0, lastIndex = maxAdvanceSteps.size() -1;
		for(int i=0; i<=furthestReachSoFar && furthestReachSoFar < lastIndex; ++i) {
			furthestReachSoFar = Math.max(furthestReachSoFar, i+ maxAdvanceSteps.get(i));
			System.out.print(furthestReachSoFar + " ");
		}
		return furthestReachSoFar >= lastIndex;
	}
	
	public static void main(String[] args) {
		List<Integer> a = Arrays.asList(new Integer[]{3,3,1,0,2,0,1}); 
		Array.canReachEnd(a);
	}

}
