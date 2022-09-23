import java.io.*;
import java.util.*;

/**
 * [Search] [medium] Hackerland Radio Transmitters
 *
 * 완전탐색, 갈수 있는 최대 범위까지 가서 count++
 */

public class Main {

    public static void main(String[] args) throws IOException {
    }

    public static int hackerlandRadioTransmitters(List<Integer> x, int k) {
        // Write your code here
        Collections.sort(x);

        int n = x.size();
        int count = 0;
        int i = 0;

        while(i < n){
            int bound = x.get(i) + k;

            while(i < n && x.get(i) <= bound) i++;

            i--;
            bound = x.get(i) + k;

            while(i < n && x.get(i) <= bound) i++;

            count++;
        }

        return count;
    }



}
