package programmers.implement;

import java.util.*;

public class 캐시 {
    // 0<=캐시크기<=30
    // LRU? 가장 오랫동안 참조되지 않은 페이지 교체
    //hit =1 , miss = 5
    public static int solution(int cacheSize, String[] cities) {
        int answer = 0;
        Queue<String> cache = new LinkedList<>(); // 순서를 보장하자. (index)

        if(cacheSize == 0) {
            return 5*cities.length;
        }

        for(String c : cities) { // LRU -> 가장 사용안한거 빼버리는거잖아
            String city = c.toLowerCase();
            if(cache.contains(city)) { // cache에 들어있으면
                cache.remove(city);
                cache.add(city);
                answer++;
            } else { //캐시에 없을때
                if(cache.size() == cacheSize) { // 꽉찼는데 없어?
                    cache.poll(); // 맨위에꺼 버리고
                }
                cache.add(city);
                answer+=5;
            }

        }
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution(3, new String[]{"a", "b","a"}));
    }


}
