package programmers;

import java.util.PriorityQueue;

public class 선입선출스케줄링 {
    //마지막 작업을 수행하는 코어의 번호
    //core = {1,2,3}
    public int solution3(int n, int[] core) {
        int cnt = 0;
        while(true){
            for(int i = 0 ; i < core.length ; i++){
                if(cnt % core[i] == 0 && --n == 0) return i+1;
            }
            cnt++;
        }
    }


    //하나도 이해 안되쥬 ㅋㅋㅋㅋㅋ
    public int solution1(int n, int[] cores) {
        //n -> cores
        //6 -> [1,2,3]
        //1. n이 cores.length 보다 작을때
        //2. 클때
        int answer = 0;
        int work = n;
        if(n <= cores.length) {
            return n;
        }
        work -=cores.length;

        //시간순으로 정렬을 하는거 아닐까?
        PriorityQueue<Core> pq = new PriorityQueue<>((o1, o2) -> {
            if(o1.time == o2.time) {
                return o1.index-o2.index;
            }
            return o1.time-o2.time;
        });

        //time = 0일때.
        for(int i=0; i<cores.length; i++) {
            pq.add(new Core(i, cores[i]));
        }

        int time = 1;
        while(work > 0) {
            Core now = pq.poll();

            if (now.time == time) { //지금 시간이 맞으면
                work--;
            } else if(now.time > time) { //지금 시간이 안맞으면
                time = now.time;
                work--;
            }


            if(work == 0) {
                answer = now.index + 1;
            } else {
                pq.add(new Core(now.index , time + cores[now.index]));
            }
        }
        return answer;
    }

    public int solution2(int n, int[] cores) {
        int answer = 0;

        int min = 0;
        int max = cores[0] * n; // 하나하나씩 처리하는게 시간이 제일 오래걸리지.

        int time = 0;
        int m = 0;

        while(min <= max) {
            int mid = (min + max) / 2; // 최적의 시간

            int count = countWork(mid, cores); // 그시간에 작업처리 얼마나?

            if(count >= n) { //max를 구하기때문에
                max = mid-1;
                time = mid; // 최적의 시간에
                m = count; // 몇개를 할건지
            } else {
                min = mid+1;
            }
        }

        m -= n;
        for(int i= cores.length-1; i>=0; i--) {
            if(time % cores[i] == 0) {
                if(m==0) {
                    answer = i+1;
                    break;
                }
                m--;
            }
        }
        return answer;
    }

    int countWork(int time, int[] cores) {
        if(time ==0) {
            return cores.length;
        }
        int count = cores.length;

        for(int i=0; i<cores.length; i++) {
            count += (time / cores[i]);
        }
        return count;
    }

    public int solution(int n, int[] cores) {
        int time = 0;
        while(true) {
            //맨 처음 루틴 -> 0번째엔 모두 다 배치가 가능
            //첫 번째 시간 -> 1 처리하는놈
            //두 번째 시간 -> 1처리하는놈 2처리하는놈
            //세 번째 시간 -> 1처리하는놈 3처리하는놈
            //네 번재 시간 -> 1 , 2, 4처리하는놈
            for(int i=0; i<cores.length; i++) {
                if(time % cores[i] == 0) {
                    n--;
                    if(n == 0) {
                        return i+1;
                    }
                }
            }
            time++;
        }
    }

    public static void main(String[] args) {
        선입선출스케줄링 a = new 선입선출스케줄링();
        System.out.println(a.solution(6, new int[]{1,2,3}));
    }
}



class Core {
    int index;
    int time;
    Core(int index, int time) {
        this.index = index;
        this.time = time;
    }

    @Override
    public String toString() {
        return "Core{" +
                "index=" + index +
                ", time=" + time +
                '}';
    }
}
