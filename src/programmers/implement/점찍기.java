package programmers.implement;

public class 점찍기 {
    public long solution(int k, int d) {
        long answer = 0;

        for(long x=0; x<=d; x=x+k) {
            long y = (long) Math.sqrt((long) d *d - x*x) / k;
            answer += y+1;
        }
        return answer;
    }

    //x축방향 , y축 방향 -> k만큼 증가시키면 될까?
    public long solution1(int k, int d) {
        long answer = 0;

        for(long x=0; x<=d; x=x+k) { // x좌표
            for(long y=0; y<=d; y=y+k) { // y좌표
                //소수점 때문에 d를 넘어갈 수도 있으니 무조건 반올림해준다.
                long dis = (long) Math.ceil(Math.sqrt(x*x + y*y));
                if(dis <= d) {
                    answer++;
//                    System.out.println("x = "+ x + " y = " + y + " dist = " +dis);
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        점찍기 a = new 점찍기();
        a.solution(2,4);
    }
}
