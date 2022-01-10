package com.exmaple.ps;

import java.util.*;

/*
 * answer.stream().mapToInt(i -> i.intValue()).toArray()
 * 스트림으로 리스트를 배열로 출력
 */

public class Main {

    public static void main(String[] args) {
        for(int i : solution(new int[]{3, 3, 2, 1, 5})){
            System.out.print(i+" ");
        }
    }

    public static int[] solution(int[] answers) {

        int[] aStudent = {1,2,3,4,5};
        int[] bStudent = {2,1,2,3,2,4,2,5};
        int[] cStudent = {3,3,1,1,2,2,4,4,5,5};

        int[] score = {0,0,0};
        for(int i = 0 ; i < answers.length; i++){
            int v = answers[i];

            if(v == aStudent[i % 5])   score[0]++;
            if(v == bStudent[i % 8])   score[1]++;
            if(v == cStudent[i % 10])  score[2]++;
        }

        List<Integer> answer = new ArrayList<>();
        int max = Math.max(score[0], Math.max(score[1], score[2]));
        for(int i =0 ; i < score.length; i ++){
            if(max == score[i]) answer.add(i+1);
        }

        return answer.stream().mapToInt(i -> i.intValue()).toArray();
    }

}
