import java.io.*;
import java.util.*;


/**
 * [카카오] [easy] Electronics Shop
 *
 * 완전 탐색
 **/

public class Main {

    public static void main(String[] args) throws IOException {

    }

    static int getMoneySpent(int[] keyboards, int[] drives, int b) {
        int max = -1;
        for(int keyboard : keyboards){
            for(int drive : drives){
                if(keyboard + drive <= b) max = Math.max(max, keyboard + drive);
            }
        }
        return max;
    }


}
