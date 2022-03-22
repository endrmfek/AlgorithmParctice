package array;

import java.util.ArrayList;
import java.util.List;

//잘모르겠는데..

public class CanReachEnd {
	public static boolean canReachEnd(List<Integer> maxAdvanceSteps) {
		int furthestReachSoFar = 0 , lastIndex = maxAdvanceSteps.size() -1;
		for(int i=0; i<=furthestReachSoFar && furthestReachSoFar < lastIndex; i++) {
			furthestReachSoFar = Math.max(furthestReachSoFar, i+maxAdvanceSteps.get(i));
			System.out.println(furthestReachSoFar);
		}
		return furthestReachSoFar >= lastIndex;
	}
	
	public static void main(String[] args) {
		List<Integer> list = List.of(3,3,1,0,2,0,1);
		canReachEnd(list);
	}
}
