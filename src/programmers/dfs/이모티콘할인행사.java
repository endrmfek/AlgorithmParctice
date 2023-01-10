package programmers.dfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class 이모티콘할인행사 {
    static int emoPlus = 0;
    static int totalPrice = 0;
    static List<int[]> result = new ArrayList<>();
    public static int[] solution(int[][] users, int[] emoticons) {
        int[] answer = new int[users.length];
        int[] arr = new int[] {10,20,30,40};
        int[] discount = new int[emoticons.length];

        dfs(0, arr,discount, users, emoticons);

        result.sort(((o1, o2) -> {
            if(o2[0] == o1[0]) {
                return o2[1] - o1[1];
            }
            return o2[0]-o1[0];
        }));
//        System.out.println(result.get(0)[0] + " " +  result.get(0)[1]);
        return new int[] {result.get(0)[0], result.get(0)[1]};
    }

    private static void dfs(int depth, int[] arr, int[] discount, int[][] users, int[] emoticons) {
        if(depth == discount.length) {
            //할인율 완전탐색
            int emo = 0;
            int price = 0;
//            System.out.println(Arrays.toString(discount));
            for(int[] user : users) {
                int myDiscount = user[0];
                int myPrice = user[1];
                int buy = 0;

                for(int i=0; i<emoticons.length; i++) { // 사람당 이모티콘
                    if (discount[i]>= myDiscount) { // 할인율 높으면 사야지
                        buy += (double)(emoticons[i] /100) * (100- discount[i]);
//                        System.out.print("discount = " + discount[i] + " buy = " + buy + " ");
                    }
                }

                if(buy >= myPrice) {
                    emo++;
                } else {
                    price += buy;
                }
            }
            System.out.println("emo = " + emo + " price = " + price + " ");
            result.add(new int[]{emo, price});
            return;
        }
        //10 10 10 10
        //10 10 10
        //10 10 20 10
        for(int i=0; i<arr.length; i++) {
            discount[depth] = arr[i];
            dfs(depth+1, arr, discount, users, emoticons);
        }
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new int[][]{{40, 10000}, {25, 10000}}, new int[]{7000, 9000})));

    }
}
