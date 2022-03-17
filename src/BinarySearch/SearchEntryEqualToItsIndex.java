package BinarySearch;

import java.util.List;

public class SearchEntryEqualToItsIndex {
	// 정렬된 배열에서 인덱스와 값이 같은 엔트리 찾기
	public static int searchEntryEqualToItsIndex(List<Integer> A) {
		int left = 0, right = A.size() -1;
		while(left <= right) {
			int mid = left + ((right-left) / 2);
			int difference = A.get(mid) - mid;
			//difference ==0 이면 A.get(mid) == mid 
			if(difference == 0) {
				return mid;
			} else if(difference > 0) {
				right = mid -1 ;
			} else { //difference <0.
				left = mid + 1;
			}
 		}
		return -1;
	}

}
