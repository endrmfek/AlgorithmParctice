package programmers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;
import java.util.TreeMap;

public class 주차요금계산 {
	//차량별 주차 요금
	// 요금표, 입차, 출차
	//[기본시간, 기본요금, 단위시간(분), 단위요금(원)]
	//[시각 차량번호 내역]
	// 시각을 기준으로 오름차순.
	/*
	public static int[] solution(int[] fees, String[] records) throws ParseException {
        
        Map<String, Car> map = new HashMap<>();
        Map<String, Car> result = new HashMap<>();
        
        int normalTime = fees[0]; //기본시간
        int normalFee = fees[1];
        int perMinute = fees[2];
        int perFee = fees[3];
        
        SimpleDateFormat f = new SimpleDateFormat("HH:mm",Locale.KOREA);
        
        for(int i=0; i<records.length; i++) {
        	String[] record = records[i].split(" "); // 시각 , 차량번호, 내역
        	//총 소요시간만 구하면 됨.
        	if(record[2].equals("IN")) {
        		map.put(record[1] , new Car(record[0], record[1], 0,0));
        	} else { //나가는경우
        		Car parkingCar = map.remove(record[1]); // 꺼내와
        		Date hi = f.parse(parkingCar.time);
        		Date bye = f.parse(record[0]);
        		long timeDiff = (bye.getTime() - hi.getTime()) / (1000 * 60); //소요시간 구해
        		System.out.println("들어온시간 : " + hi + " 나간시간 : " + bye + "계산 : " + timeDiff);
        		
        		if(result.containsKey(record[1])) { //전에 왔다갔어?
        			Car plusTime = result.remove(record[1]);
        			result.put(record[1], new Car("0" , record[1], plusTime.totalTime + timeDiff , 0));
        		} else {
        			result.put(record[1], new Car("0", record[1], timeDiff, 0));
        		}
        	}
        	
        }
        //출차 안한놈
        for(Entry<String, Car> entry : map.entrySet()) {
    		Car restCar = map.remove(entry.getKey()); // remove or get
    		String carNumber = restCar.carNumber;
    		Date lastTime = f.parse("23:59");
    		Date parkingTime = f.parse(restCar.time);
    		long timeDiff = (lastTime.getTime() - parkingTime.getTime()) / (1000 * 60);
    		
    		if(result.containsKey(carNumber)) { //이미 있던 차
    			Car plusTime = result.remove(carNumber);
    			result.put(carNumber, new Car("0" , carNumber, plusTime.totalTime + timeDiff , 0));
    		} else {
    			result.put(carNumber, new Car("0", carNumber, timeDiff, 0));
    		}
    	}
    	
    	//계산
    	
    	for(Entry<String, Car> entry : result.entrySet()) {
    		Car car = result.get(entry.getKey());
    		int parkingTime =(int) car.totalTime;
    		
    		int calc = (int) Math.ceil((double)( parkingTime - normalTime) / perMinute);
    		if(calc < 0) calc =0;
    		System.out.println(parkingTime - normalTime +" " +calc);
    		int feeSum = normalFee + (calc) * perFee;
    		result.replace(entry.getKey(), new Car(car.time, car.carNumber, car.totalTime, feeSum));
    	}
    	
    	ArrayList<Car> list = new ArrayList<>();
    	
    	for(Entry<String, Car> entry : result.entrySet()) {
    		list.add(result.get(entry.getKey()));
    	}
    	list.sort(Comparator.naturalOrder());
    	int[] answer = new int[list.size()];
    	
    	for(int i=0; i<list.size(); i++) {
    		System.out.println(list.get(i).toString());
    		answer[i] = list.get(i).price;
    	}
        
        return answer;
    }
	
	static class Car implements Comparable<Car>{
		String time;
		String carNumber;
		long totalTime;
		int price;
		
		Car(String time, String carNumber, long totalTime, int price) {
			this.time = time;
			this.carNumber = carNumber;
			this.totalTime = totalTime;
			this.price = price;
		}

		@Override
		public int hashCode() {
			return Objects.hash(carNumber);
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Car other = (Car) obj;
			return Objects.equals(carNumber, other.carNumber);
		}
		@Override
		public int compareTo(Car o) {
			// TODO Auto-generated method stub
			return Integer.parseInt(this.carNumber) -Integer.parseInt(o.carNumber);
		}

		@Override
		public String toString() {
			return "Car [time=" + time + ", carNumber=" + carNumber + ", totalTime=" + totalTime + ", price=" + price
					+ "]";
		}	
		
		
	}
	*/
	
	public int[] solution(int[] fees, String[] records) {
		int normalTime = fees[0]; //기본시간
        int normalFee = fees[1]; //기본요금
        int perMinute = fees[2]; //분당요금
        int perFee = fees[3]; //단위요금
        
        Map<Integer,Integer> map = new HashMap<>();
        Map<Integer,Integer> result = new TreeMap<>();
        
        for(String data: records){
            String[] temp = data.split(" ");
            int bye = cal_time(temp[0]);
            int car_num = Integer.parseInt(temp[1]);
            String state= temp[2];
            if(state.equals("OUT")){
               int hi = map.remove(car_num);;
               int parkingTime = bye - hi;            
                if(result.containsKey(car_num)){
                  int longTimeAgo = result.get(car_num);
                  parkingTime += longTimeAgo;
                }
                result.put(car_num , parkingTime);
                continue;
            }
            map.put(car_num , bye);
        }
        
        for(int num : map.keySet()){
            Integer leftCarTime = map.get(num);
            leftCarTime = leftCarTime == null ? 0 : leftCarTime;

            int start = leftCarTime.intValue();
            int parkingTime = 1439 - start;

            Integer e = result.get(num);
            e = e == null ? 0 : e;

            int total= e.intValue();

            result.put(num,total+parkingTime);
        }
        
        int[] answer = new int[result.size()];
        int i=0;
        for(int data : result.keySet()){
            int time = result.get(data);
 
            if( time <= normalTime){
                time = normalFee; //걍 기본요금
            }
            else{
                time = normalFee + (int)Math.ceil((double)(time-normalTime)/perMinute)*perFee;
            }      
            answer[i]=time;
            i++;
        }
 
        return answer;
        
	}
	
	public int cal_time(String time){
        String[] temp= time.split(":");
        int hour= Integer.parseInt(temp[0])*60;
        int min= Integer.parseInt(temp[1]);       
        return hour+min;
    }
	
	
}
