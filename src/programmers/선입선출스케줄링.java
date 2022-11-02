package programmers;

import java.util.PriorityQueue;

public class 선입선출스케줄링 {
    //하나도 이해 안되쥬 ㅋㅋㅋㅋㅋ
    public int solution1(int n, int[] cores) {
        //n -> cores
        //6 -> [1,2,3]
        //1. n이 cores.length 보다 작을때
        //2. 클때

        int answer = 0;
        int N = n;
        if(N <= cores.length) return N;

        //시간 0 일때 이미 할당하고 시작.
        N -= cores.length;

        PriorityQueue<Core> pq = new PriorityQueue<Core>((o1,o2) -> {
            if(o1.time == o2.time) {
                return o1.index - o2.index;
            }
            return o1.time - o2.time;
        });

        for(int i=0; i< cores.length; i++) {
            pq.add(new Core(i, cores[i])); // [1,2,3]
        }

        int time = 1;
        while(N>0) { //지금 3

            Core now = pq.poll(); // 1

            if(now.time == time) {
                n--; //2
            } else if(now.time > time){
                //현재시간보다 core의 다음처리가 큰 경우
                time = now.time;
                n--;
            }

            if(n == 0) {
                answer = now.index + 1;
            } else {
                pq.add(new Core(now.index , time+cores[now.index]));
            }

            return answer;

        }


        return answer;
    }

    //2분탐색
    public int solution2(int n, int[] cores) {
        //n -> cores
        //6 -> [1,2,3]
        //1. n이 cores.length 보다 작을때
        //2. 클때

        int answer = 0;
        int min = 0;
        int max = cores[0]*n; // 시간의 최대값?

        int time = 0;
        int m=0; // time까지 처리한 작업량?

        while(min <= max) {
            int mid =(min + max) / 2;

            int count = Countwork(mid, cores);

            if(count >= n) {
                max = mid-1;
                time = mid;
                m = count;
            } else {
                min = mid+1;
            }
        }

        m -= n;
        for(int i=cores.length-1; i>=0; i--) {
            if(time % cores[i] == 0) {
                if( m==0) {
                    answer = i+1;
                    break;
                }
                m--;
            }
        }


        return answer;
    }

    private int Countwork(int time, int[] cores) {
        if(time == 0) {
            return cores.length;
        }

        int count = cores.length;

        for(int i=0; i<cores.length; i++) {
            count += (time/cores[i]);
        }
        return count;

    }

}

class Core {
    int index;
    int time;

    Core(int index, int time) {
        this.index = index;
        this.time = time;
    }
}
