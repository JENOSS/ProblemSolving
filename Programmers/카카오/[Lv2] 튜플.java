import java.io.*;
import java.util.ArrayList;
import java.util.*;
import java.util.stream.Collectors;

/**
 * [카카오 인턴십] [레벨 2] 튜플
 *
 * 스트링 전처리
 * split 문자열 길이로 정렬
 * 다 넣고 중복제거
 **/

public class Main {

    public static void main(String[] args) throws IOException {
        int [] result = solution("{{4,2,3},{3},{2,3,4,1},{2,3}}");
        System.out.print(result);
    }

    public static int[] solution(String s) {
        List<Integer> answerList = new ArrayList<>();

        // {4,2,3} , {3}, {2,3,4,1}, {2,3}
        s = s.replaceAll("\\{\\{", "\\{");
        s = s.replaceAll("\\}\\}", "\\}");
        String[] split = s.split("\\},\\{");

        // 4,2,3 / 3 / 2,3,4,1 / 2,3
        for(int i = 0 ; i < split.length; i++){
            split[i] = split[i].replaceAll("\\{", "");
            split[i] = split[i].replaceAll("\\}", "");
        }

        // 3 / 2,3 / 4,2,3 / 2,3,4,1
        Arrays.sort(split, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2){
                return s1.length() - s2.length();
            }
        });

        for(String next : split){
            String[] real = next.split(",");

            for(String v : real){
                answerList.add(Integer.parseInt(v));
            }
        }

        answerList = answerList.stream().distinct().collect(Collectors.toList());

        int[] answer = new int[answerList.size()];
        for(int i = 0; i < answerList.size(); i++){
            answer[i] = answerList.get(i);
        }

        return answer;
    }


}
