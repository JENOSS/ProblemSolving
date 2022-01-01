package com.exmaple.ps;

import java.util.HashMap;

public class Main {

    public static void main(String[] args) {
        System.out.println(solution(new String[]{"a", "a", "b", "c", "c"},new String[]{"a", "a", "b", "c"}));
    }

    public static String solution(String[] participant, String[] completion) {
        String answer = "";

        HashMap<String,Integer> completionHashMap = new HashMap<>();

        for(String c : completion){
            Integer value = completionHashMap.get(c);
            completionHashMap.put(c,value != null ? value + 1 : 1);
        }

        for(String p : participant){
            Integer value = completionHashMap.get(p);
            if(value == null || value == 0){
                answer = p;
                break;
            }else{
                completionHashMap.put(p,value -1);
            }
        }


        return answer;
    }

    // 다른 유저 방법
    public static String goodSolution(String[] participant, String[] completion){
        String answer = "";

        HashMap<String,Integer> hm = new HashMap<>();
        for(String p : participant) hm.put(p,hm.getOrDefault(p,0) + 1);
        for(String c : completion) hm.put(c,hm.get(c) - 1);

        for(String k : hm.keySet()){
            if(hm.get(k) != 0) answer = k;
        }

        return answer;
    }



}
