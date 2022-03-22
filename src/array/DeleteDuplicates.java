package array;

import java.util.ArrayList;
import java.util.List;

public class DeleteDuplicates {

	//중복 제거하면 개수 몇개임?
	
	public static int deleteDuplicates(List<Integer> A) {
		if(A.isEmpty()) {
			return 0;
		}
		
		int writeIndex = 1;
		for(int i=1; i<A.size(); i++) {
			if(!A.get(writeIndex-1).equals(A.get(i))) {
				
				A.set(writeIndex++, A.get(i));
				System.out.println(A);
			}
		}
		return writeIndex;
	}
	
	public static void main(String[] args) {
		List<Integer> list = new ArrayList<Integer>(List.of(2,3,5,5,7,11,11,11,13));
		System.out.println(deleteDuplicates(list));
		
	}
}
