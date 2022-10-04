import java.util.*;

/**
 * [easy] [5] Build Array from Permutation
 *
 */

public class Main {

    public static void main(String[] args) {

    }

    public int[] buildArray(int[] nums) {
        int[] result = new int[nums.length];
        for(int i = 0; i < nums.length; i++) result[i] = nums[nums[i]];
        return result;
    }

}


