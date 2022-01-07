package gridy;

import java.util.Scanner;

// 000011000 이라는 값이 주어질때 모두 0으로 바꾸던가 모두 1로 바꾸던가 해서 최소방법으로 똑같은수로 만들어라
//실패..
//하지만 이해 완료!

//덩어리로 생각해봐.
//첫번째 숫자와 0->1로 바뀔때 , 1->0으로 바뀔때 카운트.
//즉 덩어리의 앞자리만 세면 돼.

public class ReverseString {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String data = sc.nextLine();
		int count1 = 0; // 0->1로 바뀔때
		int count0 = 0; // 1->0로 바뀔때
		
		int first = data.charAt(0) - '0';
		if(first == 0) {
			count1 += 1;
		} else {
			count0 += 1;
		}
		
		for(int i=0; i<data.length()-1; i++) {
			if(data.charAt(i) != data.charAt(i+1)) {
				if(data.charAt(i+1) == '1') { // 0에서 1로 바뀔때
					count0 += 1; 
				} else { //1에서 0으로 바뀔때
					count1 += 1;
				}
			}
		}
		
		System.out.println(Math.min(count0, count1));
		
	}
}
