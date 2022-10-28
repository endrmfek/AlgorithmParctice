package programmers;

import java.util.*;

public class 혼자놀기의달인 {
    //cards[i]는 i+1번째 상자.
    //1번그룹 상자 x 2번그룹 상자
    //2 <= cards <= 100
    static ArrayList<ArrayList<Integer>> data = new ArrayList<>();
    public int solution(int[] cards) {
        int answer = 0;
        boolean[] visited = new boolean[cards.length+1];

        for(int i=0; i<=cards.length; i++) {
            data.add(new ArrayList<>());
        }
        Queue<Integer> q = new LinkedList<>();
        // [1,2]
        for(int i=0; i<cards.length; i++) {
            if(visited[i+1]) continue;
            q.add(i+1);
            data.get(i+1).add(i+1);
            visited[i+1] = true;
            while(!q.isEmpty()) {
                int index = q.poll(); // 1
                int value = cards[index-1]; // 8

//                if(index == value) {
//                    data.get(i).add(value);
//                    data.add(new ArrayList<>());
//                    continue;
//                }
                if(!visited[value]) { //3-3일땐?..
                    q.add(value);
                    visited[value] = true;
                    data.get(i+1).add(value);
                } else { //그룹으로 묶어야되는데 어떻게 묶을까
                    data.add(new ArrayList<>());
                    break;
                }
            }
        }
        int[] sum = new int[data.size()+1];
        for(int i=1; i<data.size(); i++) {
            sum[i] = data.get(i).size();
        }
        sum = Arrays.stream(sum).boxed().sorted(Collections.reverseOrder()).mapToInt(Integer::intValue).toArray();
        System.out.println(Arrays.toString(sum));



        return sum[0]*sum[1];
    }

    public static void main(String[] args) {
        혼자놀기의달인 a = new 혼자놀기의달인();
        a.solution(new int[] {8,6,3,7,2,5,1,4});
        data.clear();
        a.solution(new int[] {2,1,3});

    }

}
