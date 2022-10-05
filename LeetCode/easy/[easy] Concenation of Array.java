import java.util.*;

/**
 * [easy] Concatenation of Array
 *
 */

public class Main {

    public static void main(String[] args) {
        int[] a = {1,2,1};
        Arrays.stream(a).
    }

    public int[] getConcatenation(int[] nums) {
        int[] result = new int[nums.length * 2];

        for(int i = 0; i < nums.length; i++){
            result[i] = nums[i];
            result[i + nums.length] = nums[i];
        }

        return result;

    }

}


