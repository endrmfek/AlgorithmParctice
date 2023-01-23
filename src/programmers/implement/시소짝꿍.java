package programmers.implement;

import java.util.*;

public class 시소짝꿍 {

    //시소하나 - 2 ,3 ,4 거리에 좌석 하나씩.
    //같은거리에 있거나 , 2 - 3 , 2 - 4 ,3 - 4
    //탑승한 사람의 무게와 시소 축과 좌석간의 거리의 곱이 양쪽 다 같다면.
    //사람들의 몸무게 목록.
    //weights <= 10만 -> 2중 for문 쓰면 안되잖아
    //ex) 100 , 180, 360, 100, 270
    public static long solution(int[] weights) {
        long answer = 0;
        Arrays.sort(weights);
        Map<Double, Integer> map = new HashMap<>();

        //2중 for문 축소
        for(int weight : weights) {
            double w = (double) weight;

            //먼저 찾아야해. -> 값을 축적 시키고 뒤쪽 인덱스에서 개수 찾아.
            if(map.containsKey(w)) {
                answer+= map.get(w);
            }

            //현재 값으로 만들 수 있는 시소값
            map.put(w , map.getOrDefault(w , 0) + 1); // 같은 거리에 있거나
            map.put(w*3/2 , map.getOrDefault(w*3/2 , 0) + 1); // 2m - 3m
            map.put(w*4/2 , map.getOrDefault(w*4/2 , 0) + 1); //2m -4m
            map.put(w*4/3 , map.getOrDefault(w*4/3 , 0) + 1); //3m -4m
        }

        return answer;
    }


    public static long solution1(int[] weights) {
        long answer = 0;
        Arrays.sort(weights);

        for(int i=0; i<weights.length-1; i++) {
            for(int j=i+1; j<weights.length; j++) {

                if(weights[i] == weights[j]) {
                    answer++;
                }
                else if(weights[i] * 2 == weights[j]) { // 2m - 4m
                    answer++;
                }
                else if(weights[i] * 3 == weights[j] * 2) { // 2m - 3m
                    answer++;
                }
                else if(weights[i] * 4 == weights[j] * 3) { //3m - 4m
                    answer++;
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[] {100,180,360,100,270}));
    }
}
