package programmers.implement;

public class 옮기기110 {
    //110을 뽑아야되잖아.
    //모든 자리에 110을 넣고 비교해?
    //0이 무조건 앞으로와야돼.
    public String[] solution(String[] s) {
        String[] answer = {};
        for(String data : s) {
            //처음 110빼내고
            int firstIndex = data.indexOf("110");

            data = data.replace("110","");

        }
        return answer;
    }
}
