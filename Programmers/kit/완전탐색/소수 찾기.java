package com.exmaple.ps;

import java.util.*;

/*
 * 소수는 약수가 1과 자기자신 뿐인 수
 * 0, 1 은 소수가 아니다
 * Integer.partInt("01") == 1
 */

public class Main {

    public static void main(String[] args) {
        System.out.println(solution("123"));
    }

    public static int solution(String numbers) {
        HashSet<Integer> decimal = new HashSet<>();

        int[] numberArray = new int[numbers.length()];
        for(int i = 0 ; i < numbers.length(); i++){
            numberArray[i] = Integer.parseInt(numbers.substring(i,i+1));
        }

        for(int i = 0 ; i < numbers.length() ; i++){
            boolean[] visitList = createVisitArray(numbers.length());
            explore(numberArray[i], i, visitList,numberArray, decimal);
        }

        return decimal.size();
    }

    public static void explore(int n , int idx, boolean[] visit, int[] numbers , HashSet<Integer> decimal) {
        visit[idx] = true;

        if(isDecimal(n)){
            decimal.add(n);
        }

        for(int i = 0 ; i < numbers.length; i++){
            if(!visit[i]){
                int nextNum = numbers[i] + (n*10);
                explore(nextNum,i,visit,numbers,decimal);
                visit[i] = false;
            }
        }


    }

    public static boolean[] createVisitArray(int size){
        boolean[] visitList = new boolean[size];
        for(int i = 0 ; i < size ; i++){
            visitList[i] = false;
        }

        return visitList;
    }

    public static boolean isDecimal(Integer n){

        if (n < 2){
            return false;
        }

        for(int i = 2 ; i*i < n ; i++){
            if(n % i == 0) return false;
        }

        return true;
    }

}
