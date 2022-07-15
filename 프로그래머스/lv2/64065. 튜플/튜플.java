import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

class Solution {
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
			answer.add(Integer.parseInt(entry.getKey()));
		}
		return answer.stream().mapToInt(i->i).toArray();
	}
}