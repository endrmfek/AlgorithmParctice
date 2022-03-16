package string;

//1. a는 d 두개로 바꾼다. 
//2. b는 삭제한다.
	
public class ReplaceAndRemove {
	//1. 삭제 , 삽입 메소드를 사용 -> 시간복잡도 증가
	//2. 새로운 공간을 사용. -> 공간복잡도 증가.
	
	public static int replaceAndRemove(int size, char[] s) {
		//차례로 읽는다. "b"를 지우고  "a"의 개수를 센다.
		int writeIdx = 0, aCount = 0;	
		for(int i=0; i<size; i++) {
			if(s[i] != 'b') { //B라면? writeidx는 안올라가고 i는 올라감. -> 한칸씩 앞으로 땡겨짐
				s[writeIdx++] = s[i]; 
			}
			if(s[i] == 'a' ) {
				++aCount;
			}
		}
		
		//거꾸로 읽는다.: "a"를 "dd"로 대체한다.
		int curIdx = writeIdx - 1; //현재 인덱스
		writeIdx = writeIdx + aCount - 1; //시작점
		final int finalSize = writeIdx + 1; //최종 사이즈 
		
		while(writeIdx >= 0) {
			if(s[curIdx] == 'a') {
				s[writeIdx--] = 'd';
				s[writeIdx--] = 'd';
			} else {
				s[writeIdx--] = s[curIdx];
			}
			--curIdx;
		}
		return finalSize;
		
	}
	
	
	
	
	
}
