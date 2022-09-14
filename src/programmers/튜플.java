package programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class 튜플 {
	public int[] solution1(String s) {
        Set<String> set = new HashSet<>();
        String[] arr = s.replaceAll("[{]", " ").replaceAll("[}]", " ").trim().split(" , ");
        Arrays.sort(arr, (a, b)->{return a.length() - b.length();});
        int[] answer = new int[arr.length];
        int idx = 0;
        for(String s1 : arr) {
            for(String s2 : s1.split(",")) {
                if(set.add(s2)) answer[idx++] = Integer.parseInt(s2);
            }
        }
        return answer;
    }
	
	public static int[] solution(String s) {
		Set<String> set = new HashSet<>();
		List<Integer> answer = new ArrayList<>();
		
		String[] arr = s.replaceAll("[{]", "").replaceAll("[}]", "").split(",");
		//Counter만들면 안돼?
		Map<String, Integer> counter = new LinkedHashMap<>();
		for (String i : arr) {
			counter.put(i, counter.getOrDefault(i, 0) + 1);
		}
		List<Entry<String, Integer>> list = new ArrayList<>(counter.entrySet());
		Collections.sort(list, (a,b) -> {
			return b.getValue().compareTo(a.getValue());
		});
		
		for (Entry<String, Integer> entry : list) {
//			System.out.println(entry.getKey() + " : " + entry.getValue());
			answer.add(Integer.parseInt(entry.getKey()));
		}
		return answer.stream().mapToInt(i->i).toArray();
	}
	
	public static void main(String[] args) {
		int[] arr = solution("{{2},{2,1},{2,1,3},{2,1,3,4}}");
		System.out.println(Arrays.toString(arr));
	}
}
