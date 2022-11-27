package programmers;

import java.util.ArrayList;
import java.util.List;

public class 기둥과보설치 {
    //n = 5~ 100
    //세로 1~1000 , 길이 = 4.
    //[x,y,a,b] 형태.
    //[가로, 세로]
    // a = 0 = 기둥 , a = 1 = 보
    // b = 0 = 삭제 , a = 1 = 설치
    //오른쪽 , 위쪽

    public List<List<Integer>> solution(int n, int[][] build_frame) {
        int[][] answer = {};
        //check 메소드를 어떻게 만들건지가 관건이겠죠
        List<List<Integer>> result = new ArrayList<>();
        for(int[] frame : build_frame)
        {
            int x = frame[0];
            int y = frame[1];
            int product = frame[2]; // 0 기둥 , 1 보
            int construction = frame[3]; //0 삭제 , 1 설치.

            if(construction == 1) { // 설치면?
                result.add(List.of(x,y,product));
                if(!check(result)) result.remove(result.size()-1);
            } else { // 삭제면?
                //해당 인덱스 어떻게 찾아?
                int index = 0;
                for(int i=0; i< result.size(); i++) {
                    if( x == result.get(i).get(0) && y == result.get(i).get(1) && product == result.get(i).get(2)) {
                        index = i;
                    }
                }
                List<Integer> removeList = result.remove(index);
                if(!check(result)) result.add(removeList);
            }
        }

        result.sort((o1, o2) -> {
            if(o1.get(0) == o2.get(0) && o1.get(1) == o2.get(1)) return o1.get(2) - o2.get(2);
           if(o1.get(0) == o2.get(0)) return o1.get(1) - o2.get(1);
           return o1.get(0) - o2.get(0);
        });

        return result;
    }

    //이거 체크 해야돼.
    boolean check(List<List<Integer>> result) {

        for(int i=0; i<result.size(); i++) {
            int x = result.get(i).get(0);
            int y = result.get(i).get(1);
            int product = result.get(i).get(2); // 0 기둥 1 보

            if(product == 1) {
                //보 일때 -> 보는 한쪽 끝 부분이 기둥 위에 있거나, 또는 양쪽 끝 부분이 다른 보와 동시에 연결되어 있어야 합니다.
                boolean check = false;
                boolean left = false;
                boolean right = false;
                for (List<Integer> integers : result) {
                    if (x == integers.get(0) && y - 1 == integers.get(1) && 0 == integers.get(2)) check = true;
                    if (x + 1 == integers.get(0) && y - 1 == integers.get(1) && 0 == integers.get(2)) check = true;
                    if (x - 1 == integers.get(0) && y == integers.get(1) && 1 == integers.get(2)) left = true;
                    if (x + 1 == integers.get(0) && y == integers.get(1) && 1 == integers.get(2)) right = true;
                }
                if(right && left) check = true;
                if(!check) return false;

            } else if(product == 0){
                //기둥은 바닥 위에 있거나 보의 한쪽 끝 부분 위에 있거나, 또는 다른 기둥 위에 있어야 합니다.
                boolean check = false;
                if(y == 0) check = true;
                for (List<Integer> integers : result) {
                    if(x == integers.get(0) && y-1 == integers.get(1) && 0 == integers.get(2)) check = true;
                    if(x == integers.get(0) && y == integers.get(1) && 1 == integers.get(2)) check = true;
                    if(x-1 == integers.get(0) && y == integers.get(1) && 1 == integers.get(2)) check = true;
                }
                if(!check) return false;

            }
        }
        return true;
    }

}
