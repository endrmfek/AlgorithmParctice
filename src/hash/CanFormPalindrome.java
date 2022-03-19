package hash;

import java.util.HashSet;
import java.util.Set;

public class CanFormPalindrome {

	public static boolean CanFormPalindrome(String s) {
		Set<Character> charsWithOddFrequency = new HashSet<>();
		for(int i=0; i<s.length(); i++) {
			char c = s.charAt(i);
			if(charsWithOddFrequency.contains(c)) {
				//해당 문자가 이미 있을때
				charsWithOddFrequency.remove(c);
			} else {
				//해당 문자가 없을때
				charsWithOddFrequency.add(c);
			}
		}
		
		return charsWithOddFrequency.size() <= 1;
	}
	
	public static void main(String[] args) {
		System.out.println(CanFormPalindrome("edified"));
	}
}
