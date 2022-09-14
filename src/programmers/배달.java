package programmers;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class 배달 {
	
    //양방향. 
    //road는 길이가 3인 배열이며, 순서대로 (a, b, c)를 나타냅니다
    //두 마을 a, b를 연결하는 도로는 여러 개가 있을 수 있습니다
	public int solution(int N, int[][] road, int K) {
        int cnt=0;
        PriorityQueue<Node> qu = new PriorityQueue<>();
        ArrayList<Node>[] list = new ArrayList[N+1];
        int[] dis = new int[N+1];
        boolean[] visit = new boolean[N+1];
        int INF = 500001;

        //초기화
        for(int i=1;i<N+1;i++){
            list[i] = new ArrayList<>();
            dis[i] = INF;
        }
        dis[1]=0;

        //도로 정보 입력
        for(int i=0;i<road.length;i++){
            int a = road[i][0];
            int b = road[i][1];
            int c = road[i][2];
            list[a].add(new Node(b,c));
            list[b].add(new Node(a,c));
        }

        qu.add(new Node(1,0));
        while(!qu.isEmpty()){
            Node poll = qu.poll();

            if(visit[poll.end] == true)
                continue;

            visit[poll.end] = true;

            int size = list[poll.end].size();
            for(int i=0;i<size;i++){
                Node town = list[poll.end].get(i);
                if(visit[town.end] == false){
                    dis[town.end] = Math.min(dis[town.end] , dis[poll.end] + town.weight);
                    qu.add(new Node(town.end, dis[town.end]));
                }
            }
        }

        for(int i=1;i<N+1;i++){
            if(dis[i] <= K){
                cnt++;
            }
        }

        return cnt;
    }
//		
//	public static void main(String[] args) {
//		System.out.println(solution(6, new int[][] {{1,2,1},{2,3,3},{5,2,2},{1,4,2},{5,3,1},{5,4,2}}, 3)); 
//	}
}

	
class Node implements Comparable<Node>{
	    int end;
	    int weight;
	    public Node(int end, int weight){
	        this.end = end;
	        this.weight = weight;
	    }

	    public int compareTo(Node o){
	        if(this.weight > o.weight)
	            return 1;
	        return -1;
	    }
	}
