import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int node, edge;

    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    static boolean[] visited;
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        node = Integer.parseInt(br.readLine());
        edge = Integer.parseInt(br.readLine());

        visited = new boolean[node+1];

        for(int i=0; i<node+1; i++) {
            graph.add(new ArrayList<>());
        }

        for(int i=0; i<edge; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            graph.get(start).add(end);
            graph.get(end).add(start);
        }

        //1번 컴퓨터가 당했을때
        bfs(1);

        int count = 0;
        for(boolean value : visited) {
            if(value) {
                count++;
            }
        }

        System.out.println(count-1);
    }

    public static void bfs(int start) {
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        visited[start] = true;

        while(!q.isEmpty()) {
            int now = q.poll();

            for(int nextNode : graph.get(now)) {
                if (!visited[nextNode]) {
                    visited[nextNode] = true;
                    q.add(nextNode);
                }
            }
        }
    }


}