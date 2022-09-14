package programmers;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class 완주하지못한선수 {
	public String solution(String[] participant, String[] completion) {
	    Map<String, Integer> players = new HashMap<>();
	    String result = "";
	    for(String player : participant) {
	    	players.put(player , players.getOrDefault(player, 0) + 1);
	    }
	    
	    for(String completePlayer : completion) {
	    	if(players.containsKey(completePlayer)) {
	    		players.put(completePlayer , players.get(completePlayer) -1);
	    	}
	    }
	    
	    for (Entry<String, Integer> p : players.entrySet()) {
	    	if (p.getValue() == 1) {
	    		result = p.getKey();
	    	}
	    }
	    
	    return result;
    }
}
