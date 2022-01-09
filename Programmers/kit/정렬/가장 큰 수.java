package com.exmaple.ps;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        System.out.print(solution(new int[]{6, 10, 2}));
    }

    public static String solution(int[] numbers) {
        List<String> stringNumbers = new ArrayList<>();

        boolean isZero = true;

        for(int n : numbers){
            if(n != 0) isZero = false;
            stringNumbers.add(String.valueOf(n));
        }

        if(isZero) return "0";

        Collections.sort(stringNumbers, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return (o2+o1).compareTo(o1+o2);
            }
        });

        StringBuilder sb = new StringBuilder();
        for(String s : stringNumbers){
            sb.append(s);
        }

        return sb.toString();
    }


}
