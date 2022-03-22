package array;

import java.util.Collections;
import java.util.List;

//배열을 입력으로 받을 때 짝수가 앞에 나오게 정렬해라.
public class EvenOdd {
	
	public static void evenOdd(List<Integer> A) {
		int nextEven =0;
		int nextOdd = A.size()-1;
		
		while(nextEven < nextOdd) {
			if(A.get(nextEven) % 2 == 0) {
				//짝수라면
				nextEven++;
			} else { //홀수라면
				Collections.swap(A, nextEven, nextOdd--);
			}
		}
	}
}
