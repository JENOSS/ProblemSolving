import java.io.*;
import java.util.ArrayList;
import java.util.*;
import java.util.stream.Collectors;

/**
 * [카카오 인턴십] [레벨 1] 키패드 누르기
 *
 * 위치 설정해 놓고 구현
 **/

public class Main {

    public static void main(String[] args) throws IOException {

    }

    public String solution(int[] numbers, String hand) {
        StringBuilder answer = new StringBuilder();

        HashMap<Integer, Character> handMap = new HashMap<>();
        HashMap<Integer, String> locateMap = new HashMap<>();
        setHand(handMap);
        setLocate(locateMap);

        int currentL = -1;
        int currentR = -2;

        for(int next : numbers){
            if(handMap.get(next) == 'X'){
                int l = calLocate(locateMap.get(next), locateMap.get(currentL));
                int r = calLocate(locateMap.get(next), locateMap.get(currentR));

                if(l < r){
                    answer.append('L');
                    currentL = next;
                }else if (l > r){
                    answer.append('R');
                    currentR = next;
                }else{
                    if(hand.charAt(0) == 'r'){
                        answer.append('R');
                        currentR = next;
                    }else{
                        answer.append('L');
                        currentL = next;
                    }
                }
            }else{
                answer.append(handMap.get(next));
                if(handMap.get(next) == 'L'){
                    currentL = next;
                }else{
                    currentR = next;
                }
            }
        }

        return answer.toString();
    }

    public int calLocate(String x, String h){
        String[] xLocate = x.split(":");
        String[] hLocate = h.split(":");

        return Math.abs(Integer.parseInt(xLocate[0]) - Integer.parseInt(hLocate[0])) +
                Math.abs(Integer.parseInt(xLocate[1]) - Integer.parseInt(hLocate[1]));
    }


    public void setHand(HashMap<Integer, Character> map){
        map.put(1,'L');
        map.put(4,'L');
        map.put(7,'L');

        map.put(2,'X');
        map.put(5,'X');
        map.put(8,'X');
        map.put(0,'X');

        map.put(3,'R');
        map.put(6,'R');
        map.put(9,'R');
    }

    public void setLocate(HashMap<Integer, String> map){
        map.put(1,"1:1");
        map.put(4,"2:1");
        map.put(7,"3:1");

        map.put(2,"1:2");
        map.put(5,"2:2");
        map.put(8,"3:2");
        map.put(0,"4:2");

        map.put(3,"1:3");
        map.put(6,"2:3");
        map.put(9,"3:3");

        map.put(-1,"4:1");
        map.put(-2,"4:3");

    }


}
