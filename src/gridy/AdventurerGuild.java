package gridy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

// N명의 모험가 , 공포도 X , 공포도 X인 모험가는 반드시 X이상의 모험가그룹이 필요. 이때 최대 그룹 수.

public class AdventurerGuild {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		ArrayList<Integer> data = new ArrayList<>(); // 동적인 공간이 필요할때.
		
		for(int i=0; i<n; i++) {
			data.add(sc.nextInt());
		}
		Collections.sort(data); // 정렬
		
		int result = 0; //이게 그룹의 수
		int count =0; //그룹 안 멤버 수
		
		for(int i=0; i<n; i++) {
			count += 1;
			if( count >= data.get(i)) {
				result += 1;
				count =0;
			}
		}
	}
}
