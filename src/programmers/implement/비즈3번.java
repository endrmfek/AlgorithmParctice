package programmers.implement;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class 비즈3번 {

    public static int[] solution2(int[][] fruits, int[][] priority) {
        int[] answer = new int[fruits.length];
        List<Fruit> fruitList = new ArrayList<>();
        for(int i=0; i<fruits.length; i++) {
            fruitList.add(new Fruit());
        }

        //초기화
        for(int i=0; i<fruits.length; i++) {
            fruitList.get(i).index = i+1;
            for(int j=0; j<fruits[i].length; j++) {
//                System.out.println(j);

                fruitList.get(i).features.add(new Feature(fruits[i][j] , priority[i][j]));
//                fruitList.get(i).features[j].fruit = fruits[i][j];
//                fruitList.get(i).features[j].priority = priority[i][j];
            }
        }

        //특징 재배열 했고
//        for (Fruit fruit : fruitList) {
//            Arrays.sort(fruit.features, new Comparator<Feature>() {
//                @Override
//                public int compare(Feature o1, Feature o2) {
//                    return o1.priority - o2.priority;
//                }
//            });
//        }

        for (Fruit fruit : fruitList) {
            fruit.features.sort((o1, o2) -> o1.priority - o2.priority);
        }

        for (Fruit fruit : fruitList) {
            System.out.print(fruit.index + " ");
            System.out.print("fruit : ");
            for(int i=0; i< fruit.features.size(); i++) {

                System.out.print(fruit.features.get(i).fruit + " ");
            }

            System.out.print("priority :");

            for(int i=0; i< fruit.features.size(); i++) {
                System.out.print(fruit.features.get(i).priority + " ");
            }
            System.out.println();
        }

        fruitList.sort(new Comparator<Fruit>() {
            @Override
            public int compare(Fruit o1, Fruit o2) {
                for(int i=0; i<o1.features.size(); i++) {
                    if(o1.features.get(i).fruit != o2.features.get(i).fruit) {
                        return Integer.compare(o2.features.get(i).fruit, o1.features.get(i).fruit);
                    }
                }
                return 0;
            }
        });

        for (Fruit fruit : fruitList) {
            System.out.print(fruit.index + " ");
            System.out.print("fruit : ");
            for(int i=0; i< fruit.features.size(); i++) {

                System.out.print(fruit.features.get(i).fruit + " ");
            }

            System.out.print("priority :");

            for(int i=0; i< fruit.features.size(); i++) {
                System.out.print(fruit.features.get(i).priority + " ");
            }
            System.out.println();
        }

        for(int i=0; i< fruits.length; i++) {
            answer[i] = fruitList.get(i).index;
        }

        return answer;
    }

    public static void main(String[] args) {
        solution2(new int[][]{ {1,2,3,4} ,{4,3,2,1} , {1,2,3,4} , {10,10,10,10} } , new int[][]{ {4,3,2,1},{2,1,3,4},{3,4,2,1},{3,1,2,4}});
    }

    static class Fruit {
        int index;
//        Feature[] features;
        List<Feature> features = new ArrayList<>();
    }

    static class Feature {
        int fruit;
        int priority;

        public Feature(int fruit, int priority) {
            this.fruit = fruit;
            this.priority = priority;
        }
    }

}
