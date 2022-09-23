import java.io.*;
import java.util.*;

/**
 * [greedy] [easy] Minimum Absolute Difference in an Array
 */

public class Main {

    public static void main(String[] args) throws IOException {
    }

    public static int minimumAbsoluteDifference(List<Integer> arr) {
        // Write your code here
        Collections.sort(arr);
        int min = Integer.MAX_VALUE;
        for(int i =0 ; i < arr.size()- 1; i++){
            min = Math.min(min, Math.abs(arr.get(i) - arr.get(i + 1)));
        }

        return min;
    }

}
