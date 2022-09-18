import java.io.*;
import java.util.*;


/**
 * [카카오] [Lv 1] 성격 유형 검사하기
 *
 *
 **/

public class Main {

    public static void main(String[] args) throws IOException {

    }

    public int[] points = {-1,3,2,1,0,1,2,3};
    public HashMap<Character, Integer> eachPoint = new HashMap<>();
    public char[] personalityA = {'R','C','J','A'};
    public char[] personalityB = {'T','F','M','N'};

    public String solution(String[] survey, int[] choices) {

        for(int i = 0; i < survey.length; i++){
            char n = survey[i].charAt(0);
            char y = survey[i].charAt(1);
            int point = choices[i];

            if(point < 4){
                eachPoint.put(n, eachPoint.getOrDefault(n, 0) + points[point]);
            }else if(point > 4){
                eachPoint.put(y, eachPoint.getOrDefault(y, 0) + points[point]);
            }
        }

        return getPersonality();
    }

    public String getPersonality(){
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < 4; i++){
            char typeA = personalityA[i];
            char typeB = personalityB[i];

            int aPoint = eachPoint.getOrDefault(typeA, 0);
            int bPoint = eachPoint.getOrDefault(typeB, 0);

            if(aPoint > bPoint){
                sb.append(typeA);
            }else if(aPoint < bPoint){
                sb.append(typeB);
            }else{
                sb.append(typeA > typeB ? typeB : typeA);
            }
        }

        return sb.toString();
    }
}
