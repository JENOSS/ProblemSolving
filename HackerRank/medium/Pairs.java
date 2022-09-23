import java.io.*;
import java.util.*;

/**
 * [Search] [medium] Pairs
 *
 * 이분탐색
 */

public class Main {

    public static void main(String[] args) throws IOException {
        List<Integer> arr = new ArrayList<>();
        arr.add(1);
        arr.add(2);
        arr.add(3);
        arr.add(4);
        arr.add(5);
        System.out.println(pairs(2, arr));
    }

    public static int pairs(int k, List<Integer> arr) {
        // Write your code here
        Collections.sort(arr);

        int cnt = 0;
        for(int i = 0; i < arr.size() - 1; i++){
            if(check(i + 1, arr.size() - 1, arr.get(i) + k, arr))cnt++;
        }

        return cnt;
    }

    public static boolean check(int L, int R, int x, List<Integer> arr){
        boolean find = false;

        while(L <= R){
            int m = (L + R) / 2;
            if(arr.get(m) < x){
                L = m + 1;
            }else if(arr.get(m) > x){
                R = m - 1;
            }else{
                find = true;
                break;
            }
        }

        if(find){

        }

        return false;
    }



}
