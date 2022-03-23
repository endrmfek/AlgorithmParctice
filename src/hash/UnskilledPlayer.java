package hash;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class UnskilledPlayer {

	public String solution(String[] participant, String[] completion) {
     
		Map<String, Integer> players = new HashMap<>();
		
		String result = "";
		for(String player : participant) { // 각 선수를 해쉬맵에 넣고
			if(players.containsKey(player)) {
				players.put(player, players.get(player) + 1);
			} else {
				players.put(player, 1);
			}
		}
		
		for(String completePlayer : completion) { // 완료된 선수를 제거.
			if(players.containsKey(completePlayer)) {
				players.put(completePlayer, players.get(completePlayer) - 1);
			}
		}
		
		for(Entry<String, Integer> p : players.entrySet()) {
			if(p.getValue() == 1) {
				result = p.getKey();
			}
		}
		
		return result;
    }
}
