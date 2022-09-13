import java.io.*;
import java.util.ArrayList;
import java.util.*;

/**
 * [카카오 인턴십] [레벨 1] 숫자 문자열과 영단어
 *
 * 투포인터 이용
 * 원래는 String.replace 이용하는 문제
 **/

public class Main {

    public static void main(String[] args) throws IOException {

    }

    public int solution(String s) {
        if(s.length() == 1) return Integer.parseInt(s);

        StringBuilder answer = new StringBuilder();

        HashMap<String, Integer> map = new HashMap<>();
        setMap(map);

        int L = 0;
        int R = 1;

        while(L < R && R <= s.length()){
            char c = s.charAt(L);

            if(Character.isDigit(c)){
                answer.append(c);
                L++;
                R++;
            }else{
                String sub = s.substring(L, R);
                Integer v = map.get(sub);

                if(v != null){
                    answer.append(v);
                    L = R;
                }

                R++;
            }

        }


        return Integer.parseInt(answer.toString());
    }

    public void setMap(HashMap<String, Integer> map){
        map.put("zero", 0);
        map.put("one", 1);
        map.put("two", 2);
        map.put("three", 3);
        map.put("four", 4);
        map.put("five", 5);
        map.put("six", 6);
        map.put("seven", 7);
        map.put("eight", 8);
        map.put("nine", 9);
    }

}
