import java.io.*;
import java.util.ArrayList;
import java.util.*;

/**
 * [leetcode] [medium] [393] UTF-8 Validation
 *
 * 4개를 가져와서 비교 -> 3개를 가져와서 비교 .. 
 **/

public class Main {

    public static void main(String[] args) throws IOException {
        System.out.print(validUtf8(new int[]{115,100,102,231,154,132,13,10}));
    }

    public static boolean validUtf8(int[] data) {
        boolean result = false;

        int L = 0;
        int R = data.length < 4 ? data.length - 1 : 3;

        while(L <= R){
            int size = R - L + 1;

            if(size == 4){
                if(isFourByte(data[L], data[L + 1], data[L + 2], data[L + 3])){
                    L += 4;
                    R = L + 4 > data.length - 1? data.length - 1 : L + 4;
                    result = true;
                }else{
                    R--;
                    result = false;
                }
            }else if(size == 3){
                if(isThreeByte(data[L], data[L + 1], data[L + 2])){
                    L += 3;
                    R = L + 4 > data.length - 1? data.length - 1 : L + 4;
                    result = true;
                }else{
                    R--;
                    result = false;
                }
            }else if(size == 2){
                if(isTwoByte(data[L], data[L + 1])){
                    L += 2;
                    R = L + 4 > data.length - 1? data.length - 1: L + 4;
                    result = true;
                }else{
                    R--;
                    result = false;
                }
            }else {
                if(isOneByte(data[L])){
                    L += 1;
                    R = L + 4 > data.length - 1 ? data.length - 1 : L + 4;
                    result = true;
                }else{
                    R--;
                    result = false;
                }
            }
        }

        return result;
    }


    public static boolean isOneByte(int n){
        return n >> 7 == 0;
    }

    public static boolean isTwoByte(int n1, int n2){
        return n1 >> 5 == 6 && n2 >> 6 == 2;
    }

    public static boolean isThreeByte(int n1, int n2, int n3){
        return n1 >> 4 == 14 && n2 >> 6 == 2 && n3 >> 6 == 2;
    }

    public static boolean isFourByte(int n1, int n2, int n3, int n4){
        return n1 >> 3 == 30 && n2 >> 6 == 2 && n3 >> 6 == 2 && n4 >> 6 == 2;
    }



}
