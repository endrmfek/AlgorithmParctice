package programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class 같은숫자는싫어 {
	public static List<Integer> solution(int []arr) {        
        List<Integer> list = new ArrayList<>();
        int temp = arr[0];
        if (arr.length > 1) {
        	for(int i=1; i<arr.length; i++) {
        		if (temp != arr[i]) {
        			list.add(temp);
        			temp= arr[i];
        		}
        	}
        	list.add(arr[arr.length-1]);
        }
        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
        System.out.println("Hello Java");

        return list;
    }
	
	public static void main(String[] args) {
		List<Integer> a = solution(new int[] {1,1,3,3,0,1,1});
		a.stream().forEach(i -> System.out.println(i));
	}
}
