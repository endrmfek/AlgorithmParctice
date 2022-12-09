package programmers.dfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class 모두0으로만들기 {
    //가중치를 0 으로
    //한쪽은 1 증가, 한쪽은 1 감소.
    //판별도 해야돼?.
    //최소 몇번?.
    //가중치 a -> 2<=a <=30만 a[i] i번정점의 가중치
    //[u,v] -> u번 정점과 v정점이 간선으로 연결돼.
    ArrayList<ArrayList<Integer>> tree= new ArrayList<>();
    long[] weight;
    boolean[] visited;
    long answer = 0;
    public long solution(int[] a, int[][] edges) {

        visited = new boolean[a.length];
        weight = new long[a.length];

        // 0으로만들수 없으면 return -1
        long sum = 0;



        // 초기화갈기고
        for(int i=0; i<a.length; i++) {
            sum += a[i];
            weight[i] = a[i];
            tree.add(new ArrayList<>());
        }

        if(sum != 0) {
            return -1;
        }

        for(int[] edge : edges) {
            int start = edge[0];
            int end = edge[1];

            tree.get(start).add(end);
            tree.get(end).add(start);
        }

        //리프노드부터 조져야돼.
        dfs(0);

        return answer;
    }

    public long dfs(int start) {
        visited[start] = true;

        for(int i=0; i<tree.get(start).size(); i++) {
            //인접노드
            int next = tree.get(start).get(i);

            if(!visited[next]) { // 가보지 않았으면
                //마지막 재귀값을 가져오는 방법.
                weight[start] += dfs(next);
            }
        }

        answer += Math.abs(weight[start]);

        return weight[start];
    }


    public long solution2(int[] a, int[][] edges) {
        //체크먼저 갈기고
        if (!isPossible(a)) {
            return -1;
        }

        long answer = 0;
        int len = a.length;
        ArrayList<ArrayList<Integer>> graph = createGraph(len);
        int[] indegree = new int[len]; // 위상정렬?
        long[] numbers = new long[len];
        for (int i = 0; i < len; i++) {
            numbers[i] = a[i];
        }
        for (int[] e : edges) {
            graph.get(e[0]).add(e[1]);
            graph.get(e[1]).add(e[0]);
            indegree[e[0]]++;
            indegree[e[1]]++;
        }

        Queue<Integer> que = new LinkedList<>();
        //진입차수 1 -> 리프노드.
        for (int node = 0; node < len; node++) {
            if (indegree[node] == 1) {
                que.offer(node);
            }
        }

        while (!que.isEmpty()) {
            int current = que.poll();
            long cost = numbers[current];
            indegree[current]--; // 진입차수 줄이고
            answer += Math.abs(cost);
            numbers[current] = 0;

            for (int next : graph.get(current)) {
                if (indegree[next] > 0) {
                    indegree[next]--;
                    numbers[next] += cost;

                    if (indegree[next] == 1) {
                        que.offer(next);
                    }

                    break;
                }

            }
        }

        return answer;
    }

    private ArrayList<ArrayList<Integer>> createGraph(int len) {
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < len; i++) {
            graph.add(new ArrayList<>());
        }

        return graph;
    }

    private boolean isPossible(int[] numbers) {
        long sum = 0;
        for (int i : numbers) {
            sum += i;
        }

        if (sum == 0) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        모두0으로만들기 a = new 모두0으로만들기();
        a.solution(new int[]{-5, 0, 2, 1, 2}, new int[][]{{0, 1}, {3, 4}, {2, 3}, {0, 3}});
    }

}
