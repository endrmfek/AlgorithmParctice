package hash;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindAnagrams {
	public static List<List<String>> findAnagrams(List<String> dictionary) {
		
		Map<String, List<String>> sortedStringToAnagrams = new HashMap<>();
		
		for(String s : dictionary) {
			//문자열을 정렬한 뒤, 이 정렬된 문자열을 키값으로 사용한다.
			//그 뒤에 기존 문자열을 해시 테이블의 값에 추가한다.
			char[] sortedCharArray = s.toCharArray(); // String은 불변.
			Arrays.sort(sortedCharArray);
			String sortedStr = new String(sortedCharArray);
			if(!sortedStringToAnagrams.containsKey(sortedStr)) {
				sortedStringToAnagrams.put(sortedStr , new ArrayList<String>());
			}
			sortedStringToAnagrams.get(sortedStr).add(s);
		}
		
		List<List<String>> anagramGroups = new ArrayList<>();
		for(Map.Entry<String, List<String>> p : sortedStringToAnagrams.entrySet()) {
			if(p.getValue().size() >= 2) {
				anagramGroups.add(p.getValue());
			}
		}
		return anagramGroups;
	}
}
