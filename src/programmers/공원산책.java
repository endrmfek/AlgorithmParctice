package programmers;

public class 공원산책 {
    public static int[] solution(String[] park, String[] routes) {
        int[] answer = new int[]{0,0};

        //시작점 찾고
        for(int i=0; i<park.length; i++) {
            for(int j=0; j<park[0].length(); j++) {
                if(park[i].charAt(j) == 'S') {
                    answer[0] = i;
                    answer[1] = j;
                }
            }
        }
        //System.out.println(answer[0] + " " + answer[1]);
        for(String route : routes) {
            String[] data = route.split(" ");
            String direction = data[0];
            int num = Integer.parseInt(data[1]);

            if(direction.equals("E")) { //동
                int temp = answer[1] + num;
                boolean ok = true;
                if(temp < park[0].length()) { //X 어떻게 체크해?
                    for(int i=answer[1]; i<=temp; i++) {
                        if(park[answer[0]].charAt(i) =='X') {
                            ok = false;
                            break;
                        }
                    }
                    if(ok) {
                        answer[1] = temp;
                    }
                }
            }
            if(direction.equals("W")) { //서
                int temp = answer[1] - num;
                boolean ok = true;
                if(temp >= 0) { //X 어떻게 체크해?
                    for(int i=answer[1]; i>=temp; i--) {
                        if(park[answer[0]].charAt(i) =='X') {
                            ok = false;
                            break;
                        }
                    }
                    if(ok) {
                        answer[1] = temp;
                    }
                }
            }
            if(direction.equals("S")) { //남
                int temp = answer[0] + num;
                boolean ok = true;
                if(temp < park.length) { //X 어떻게 체크해?
                    for(int i=answer[0]; i<=temp; i++) {
                        if(park[i].charAt(answer[1]) =='X') {
                            ok = false;
                            break;
                        }
                    }
                    if(ok) {
                        answer[0] = temp;
                    }
                }

            }
            if(direction.equals("N")) { //북
                int temp = answer[0] - num;
                boolean ok = true;
                if(temp >= 0) { //X 어떻게 체크해?
                    for(int i=answer[0]; i>=temp; i--) {
                        if(park[i].charAt(answer[1]) =='X') {
                            ok = false;
                            break;
                        }
                    }
                    if(ok) {
                        answer[0] = temp;
                    }
                }

            }
            System.out.println(answer[0] + " " + answer[1]);
        }
        return answer;
    }

    public static void main(String[] args) {
        solution(new String[]{"OSO","OOO","OXO","OOO"}, new String[]{"E 2", "S 3", "W 1"});

    }
}
