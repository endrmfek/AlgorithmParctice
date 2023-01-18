import java.util.*;
class Solution {
    //1<=m<=1439
    //infos <=100 {시작, 끝, 제목, 악보}
    //조건이 일치하는 음악이 여러 개일 때에는 라디오에서 재생된 시간이 제일 긴 음악 제목을 반환한다. 재생된 시간도 같을 경우 먼저 입력된 음악 제목을 반환한다.
    public static String solution(String m, String[] musicinfos) {
        //#이 문제잖아. 지금?

        String answer = "";
        m = m.replaceAll("C#" , "c")
                .replaceAll("D#" , "d")
                .replaceAll("F#", "f")
                .replaceAll("G#" , "g")
                .replaceAll("A#" , "a");

        List<Music> musicList = new ArrayList<>();

        for(String infos : musicinfos) {
            String[] info = infos.split(",");
            int startTime = timeCalc(info[0]);
            int endTime = timeCalc(info[1]);
            String musicName = info[2];
            String note = info[3];
            note = note.replaceAll("C#" , "c")
                    .replaceAll("D#" , "d")
                    .replaceAll("F#", "f")
                    .replaceAll("G#" , "g")
                    .replaceAll("A#" , "a");

            int musicTime = endTime - startTime;
            char[] notes = new char[musicTime];

            for(int i=0; i<musicTime; i++) {
                notes[i] = note.charAt(i % note.length());
            }

            note = new String(notes);
            System.out.println(note);
            if (note.contains(m)) {
                musicList.add(new Music(musicName, musicTime));
            };
        }

        if(musicList.isEmpty()) {
            return "(None)";    
        }else {
            //조건이 일치하는 음악이 여러 개일 때에는 라디오에서 재생된 시간이 제일 긴 음악 제목을 반환한다. 재생된 시간도 같을 경우 먼저 입력된 음악 제목을 반환한다.
            musicList.sort((o1,o2) -> {
                return o2.time-o1.time;
            });
            return musicList.get(0).name;
        }
        
    }

    private static int timeCalc(String time) {
        String[] splitTime = time.split(":");
        int hh = Integer.parseInt(splitTime[0]) * 60;
        int mm = Integer.parseInt(splitTime[1]);
        return hh + mm;
    }
    
    static class Music {
        String name;
        int time;
        
        Music(String name , int time) {
            this.name = name;
            this.time = time;
        }
    }

}