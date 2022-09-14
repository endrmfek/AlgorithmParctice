package programmers;

import java.util.HashMap;
import java.util.Map;

public class 다단계 {
	
//	public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) { 상속관계를 해결하지 못하고 작렬.
//        //1원 미만이면 분배하지 않ㅇ아.
//        int[] answer = {};
//        Map<String, Integer> money = new HashMap<>();
//        Map<String, String> inheritance = new HashMap<>();
//        
//        for (String person : enroll) {
//        	money.put(person, 0);
//        }
//        
//        for (int i=0; i<referral.length; i++) {
//        	if (referral[i] == "-") continue;
//        	inheritance.put(enroll[i] , referral[i]);
//        }
//        
//        for (int i=0; i<amount.length; i++) {
//        	String sellGuy = seller[i];
//        	int price = amount[i];
//        	
//    		if (price < 10) {
//    			money.put(sellGuy , money.get(sellGuy) + price);
//    			continue;
//    		}
//    		
//    		int remainder = (price * 10) / 100;	 //10퍼센트.
//    		price = price - remainder;	// 원래돈에서 빼는거지.
//    		money.put(sellGuy , money.get(sellGuy) + price);
//    		// 200 -> 180 , 20
//        	while (true) {
//        		//상속자
//        		String inheritPerson = inheritance.get(sellGuy);
//        		
//        		if (price < 10) {
//        			money.put(sellGuy , money.get(sellGuy) + price);
//        			break;
//        		}
//        		
//        		int incentive = money.get(sellGuy) + price;
//        		money.put(sellGuy, incentive);
//        	}
//        	
//        	
//        }
//        return answer;
//    }
	
	public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
		int[] result = new int[enroll.length];
		Map<String , String> parentMap = new HashMap<>();
		Map<String, Integer> memberIndex = new HashMap<>();
		
		//초기화를 해야겠죠?
		for (int i=0; i<enroll.length; i++) {
			parentMap.put(enroll[i], referral[i]); // 자식 : 부모
			memberIndex.put(enroll[i], i);
		}
		
		//계산을 해봅시다.
		for(int i=0; i<seller.length; i++) {
			String person = seller[i];
			int price = amount[i] * 100; // 가격 * 100 .
			
			//계속 물려줘야됨이거.
			while(!person.equals("-")) {
				int priceForParent = price / 10;
				int myPrice = price - priceForParent;
				
				result[memberIndex.get(person)] += myPrice; //결과 반영해주고
				
				price = priceForParent;
				person = parentMap.get(person);
				
				if (price < 1) {
					break;
				}
				
			}
		}
		return result;
	}
}
