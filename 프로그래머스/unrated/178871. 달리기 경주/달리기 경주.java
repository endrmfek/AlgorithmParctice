import java.util.*;
class Solution {
     public String[] solution(String[] players, String[] callings) {

        //for문 2개쓰면 쉽잖아 -> 시간초과
        //list 메서드 -> 시간초과
        Map<String, Integer> userMap = new LinkedHashMap<>();
        for(int i=0; i<players.length; i++) {
            userMap.put(players[i], i);
        }

        for(String call : callings) {
            int callRank = userMap.get(call);
            String frontUser = players[callRank-1];

            players[callRank-1] = call;
            players[callRank] = frontUser;

            userMap.put(call, callRank-1);
            userMap.put(frontUser, callRank);
        }

        return players;
    }
}