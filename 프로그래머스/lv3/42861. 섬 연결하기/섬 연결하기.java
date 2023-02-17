import java.util.*;

public class Solution {
    //최소신장트리 -> 크루스칼 알고리즘.
    static int[] parent;
    public static int solution(int n, int[][] costs) {
        int answer = 0;
        parent = new int[n];

        for(int i=0; i<n; i++) {
            parent[i] = i;
        }
        Arrays.sort(costs, (o1,o2)-> {
            return o1[2] - o2[2];
        });

        for(int[] cost : costs) {
            if(find(cost[0]) != find(cost[1])) {
                union(cost[0], cost[1]);
                answer += cost[2];
            }
        }

        return answer;
    }

    public static void union(int start, int end) {
        int x = find(start);
        int y = find(end);
        if(x != y) {
            parent[y] = x;
        }
    }

    public static int find(int number) {
        if(number == parent[number]) {
            return parent[number];
        } else {
            return parent[number] = find(parent[number]);
        }
    }

    public static void main(String[] args) {
        System.out.println(solution(4, new int[][]{{0, 1, 1}, {0, 2, 2}, {1, 2, 5}, {1, 3, 1}, {2, 3, 8}}));
    }
}


