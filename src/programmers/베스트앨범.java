package programmers;

import java.util.*;

public class 베스트앨범 {
    //장르 별로 가장 많이 재생된 노래를 두 개
    //1.속한 노래가 많이 재생된 장르.
    //2. 장르 내에서 많이 재생된 노래
    //고유번호가 낮은 노래
    //고유번호를 순서대로 return
    public List solution(String[] genres, int[] plays) {
        List<Integer> answer = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();

        for(int i=0; i<genres.length; i++) {
            map.put(genres[i] , map.getOrDefault(genres[i] , 0) + plays[i]);
        }

        List<Map.Entry<String, Integer>> list = new ArrayList<>(map.entrySet());
        //값에 대해 내림차순 정렬
        list.sort((a, b) -> {
            return b.getValue() - (a.getValue()); //내림차순
        });


        for(Map.Entry<String, Integer> entry : list) {
            System.out.println(entry.getKey() + " " + entry.getValue());
            List<Genre> temp = new ArrayList<>();
            String genre = entry.getKey();

            for(int i=0; i<genres.length; i++) {
                if(genres[i].equals(genre)) {
                    temp.add(new Genre(i, plays[i]));
                }
            }
            temp.sort((o1, o2) -> {
                if (o1.play == o2.play) {
                    return o1.index - o2.index;
                }
                return o2.play - o1.play;
            });

            answer.add(temp.get(0).index);
            if(answer.size() != 1) answer.add(temp.get(1).index);

        }
        return answer;
    }

    public static void main(String[] args) {
        베스트앨범 a = new 베스트앨범();
        a.solution(new String[]{"classic", "pop", "classic", "classic", "pop"} , new int[]{500, 600, 150, 800, 2500});
    }
}

class Genre {
    int index;
    int play;

    Genre(int index, int play) {
        this.index = index;
        this.play = play;
    }
}
