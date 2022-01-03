package com.exmaple.ps;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;

public class Main {

    public static void main(String[] args) {
        System.out.println(solution(new String[]{"119", "97674223", "1195524421"}));
    }

    public static boolean solution(String[] phone_book) {
        HashSet<String> hs = new HashSet<>();
        boolean answer = true;
        int minSize;

        Arrays.sort(phone_book, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.length() - o2.length();
            }
        });

        minSize = phone_book[0].length();

        for(String p : phone_book){
           if(p.length() == minSize){
               hs.add(p);
           }else{
               for(int i = minSize ; i < p.length() ; i++){
                   if(hs.contains(p.substring(0,i))){
                       answer = false;
                       break;
                   }else if(i == p.length() -1){
                       hs.add(p);
                   }
               }
           }
        }

        return answer;
    }

    // 다른 사람 풀이 단순 비교라서 더 좋은 코드인지는 잘 모르겠다
    public static boolean goodSolution(String[] phone_book){
        for(int i = 0 ; i < phone_book.length -1 ; i++){
            for(int j = i+1 ; j < phone_book.length ; j++){
                if(phone_book[i].startsWith(phone_book[j])) return false;
                if(phone_book[j].startsWith(phone_book[i])) return false;
            }
        }

        return true;
    }

}
