package programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class kakao3 {
	// 1/가입자를 최대한 늘려
	// 2/판매액을 최대한 늘려

	// 1번이 우선 2번이 그다음
	// 할인행사
	// n명의 사용자들에게 이모티콘 m개를 할인하여 판매
	// 할인율 10~40퍼
	// 일정비율 이상 할인 -> 모두 구매
	// 구매비용의 합이 일정 가격 이상되면 이모티콘 플러스
	// 행사목적을 최대한으로 달성 -> 이진탐색.
	// 이모티콘의 길이가 최대 7이야.
	// 그럼 이거 dfs걸수있겠어?
	static int join = 0;
	static int elsePrice = 0;
	static List<Info> info = new ArrayList<>();
	public static int[] solution(int[][] users, int[] emoticons) {
		// [할인율 가격] , [티모티콘 가격]
		// [40 10000, 25 10000] , [7000, 9000]
		int[] answer = {};
		int maxPerson = -1;
		
		int[] discountInfo = new int[emoticons.length];
		int[] discount = new int[] { 10, 20, 30, 40 };
		dfs(0,users,discountInfo, discount, emoticons );
		info.sort(Comparator.naturalOrder());
		return new int[] {info.get(0).joinNumber , info.get(0).price};
	}

	public static void dfs(int depth, int[][] users, int[] discountInfo, int[] discount, int[] emoticons) {
		if (depth == discountInfo.length) {
			//[10,10] [7000,9000]
			//각 사람에 대해 
			System.out.println(Arrays.toString(discountInfo));
			for(int i=0; i<users.length; i++) {
				
				int userPer = users[i][0]; //40
				int userPrice = users[i][1]; //10000
				int totalPrice = 0;
				
				for(int j=0; j<discountInfo.length; j++) { // 각 상품들에 대해
					double productDiscount = discountInfo[j] * 0.01; // 10 or ..
					if(userPer <= discountInfo[j]) { // 할인가가 높다면
						//사야지 물건을
						double price = emoticons[j] -( emoticons[j] * productDiscount );
//						System.out.println(price);
						//유저의 가격
						totalPrice += price;
					}
					
				}
				if(totalPrice >= userPrice) {
					//가입 할걸?
					join +=1;
				} else {
					elsePrice += totalPrice;
				}
//				System.out.println(join + " " +elsePrice);
			}
			info.add(new Info(join, elsePrice));
			join =0;
			elsePrice =0;
			
			return;
		} else {
			for (int i = 0; i < discount.length; i++) {
				discountInfo[depth] = discount[i];
				dfs(depth + 1, users, discountInfo, discount, emoticons);
			}

		}
	}
	
	public static void main(String[] args) {
		System.out.println(Arrays.toString(solution(new int[][] {{40, 10000},{25,10000}}, new int[] {7000,9000})));
	}
	
	
}
class Info implements Comparable<Info>{
	int joinNumber;
	int price;
	
	Info(int joinNumber , int price) {
		this.joinNumber = joinNumber;
		this.price = price;
	}
	
	@Override
	public int compareTo(Info o) {
		// TODO Auto-generated method stub
		if (this.joinNumber - o.joinNumber > 0) {
			return -1;
		} else if (this.joinNumber == o.joinNumber) {
			if(this.price -o.price > 0) {
				return -1;
			} else {
				return 1;
			}
		} else {
			return 1;
		}
	}
}
