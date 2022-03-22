package array;

import java.util.List;


//십진수 D를 나타낸 배열 A가 주어졌을때 D+1의 결과를 다시 배열A에 갱신하는 코드
public class PlusOne {
	
	public static List<Integer> plusOne(List<Integer> A) {
		int n = A.size() -1;
		A.set(n, A.get(n)+1);
		for(int i=n; i>0 && A.get(i) == 10; --i) {
			A.set(i, 0);
			A.set(i-1, A.get(i-1) +1);
		}
		
		if(A.get(0) == 10) {
			//최상위 숫자에 올림수가 존재한다면 자리가 더필요함.
			//첫번째 항목을 1로 업데이트하고, 배열 끝에 0을 추가.
			A.set(0, 1);
			A.add(0);
		}
		return A;
	}
}
