package hash;

import java.util.HashMap;
import java.util.Map;

public class Camouflage {
	public static int solution(String[][] clothes) {
		int answer = 1;
		// [의상의 이름, 의상의 종류]
		Map<String, Integer> clothe = new HashMap<>();
		
		//의상의 종류가 필요하나? 필요없음.
		for(int i=0; i<clothes.length; i++) {//각 의상 종류의 개수가 세팅이 됨.
			if(!clothe.containsKey(clothes[i][1])) {
				clothe.put(clothes[i][1], 1);
			} else {
				clothe.put(clothes[i][1], clothe.get(clothes[i][1]) + 1);
			}
		}
		
		//조합의 수 어케 구할거야?.. a,b,c 종류의 옷이 있을때
		//(1, 2, 3)의 조합은 1*2*3이잖아
		//근데 안입는 경우도 있겠지 그럼 각 조건에 +1 
		//아예 안입을 순 없으니 전체 경우의 수에서 -1
		
		for(Integer value : clothe.values()) {
			answer *= value +1;
		}
        
        return answer - 1;
    }
	
	public static void main(String[] args) {
		String[][] a = {{"yellowhat", "headgear"}, {"bluesunglasses", "eyewear"}, 
				{"green_turban", "headgear"}, {"crowmask", "face"}, {"bluesunglasses", "face"}, {"smoky_makeup", "face"}};
		System.out.println(solution(a)); 
	}
}
