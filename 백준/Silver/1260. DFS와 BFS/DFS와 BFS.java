import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int v = Integer.parseInt(st.nextToken());

        int[][] graph = new int[n+1][n+1];

        for (int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph[a][b] = graph[b][a] = 1;
        }

        boolean[] visited = new boolean[n+1];
        dfs(graph, v, visited);
        System.out.println();
        visited = new boolean[n + 1];
        bfs(graph, v, visited);
    }

    public static void bfs(int[][] graph, int start, boolean[] visited) {
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        visited[start] = true;

        while(!q.isEmpty()) {
            int now = q.poll();
            System.out.print(now + " ");

            for(int next=1; next<graph[now].length; next++) {
                int value = graph[now][next];
                if(value == 1 && !visited[next]) {
                    q.add(next);
                    visited[next] = true;
                }
            }
        }


    }

    public static void dfs(int[][] graph, int start, boolean[] visited) {
        visited[start] = true;
        System.out.print(start + " ");

        for (int next=1; next<graph[start].length; next++) {
            int value = graph[start][next];
            if (value == 1 && !visited[next]) {
                dfs(graph, next, visited);
            }
        }
    }

}