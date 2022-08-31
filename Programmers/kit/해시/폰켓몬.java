import java.io.*;
import java.util.HashSet;

/**
 * [kit-hash] 폰켓몬
 *
 **/

public class Main {

    public static void main(String[] args) throws IOException {
        run();
    }

    public static void run(){
       System.out.print(solution(new int[]{3,1,2,3}));
    }

    public static int solution(int[] nums){
        HashSet<Integer> hs = new HashSet<>();
        int kind = 0;
        int n = nums.length / 2;

        for(int next : nums) hs.add(next);
        kind = hs.size();

        return kind > n ? n : kind;
    }

}
