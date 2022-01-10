package implement;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

//문자인지 아닌지 판별을 해야돼. -> ??..
//문자가 얼마나 있는지 모르기 때문에 ArrayList사용.

public class RearrangeString {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String data = sc.next();
		ArrayList<Character> result = new ArrayList<>();
		int value = 0;
		
		for(int i=0; i<data.length(); i++) {
			if(Character.isLetter(data.charAt(i))) {
				result.add(data.charAt(i));
			} else {
				value += data.charAt(i) -'0';
			}
		}
		
		Collections.sort(result);
		
		for(int i=0; i<result.size(); i++) {
			System.out.print(result.get(i));
		}
		
		if(value != 0) System.out.print(value);
	}
}
