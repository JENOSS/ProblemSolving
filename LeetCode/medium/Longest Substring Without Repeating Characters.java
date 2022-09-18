import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


/**
 * [medium] [3] Longest Substring Without Repeating Characters
 *
 * 투 포인터 사용
 *
 **/

public class Main {

    public static void main(String[] args) throws IOException {

    }

    public int lengthOfLongestSubstring(String s) {
        if(s.length() == 0) return 0;
        if(s.length() == 1) return 1;

        HashMap<Character, Boolean> exist = new HashMap<>();

        int max = 0;

        for(int L = 0, R = 1; L < s.length(); L++){
            char current = s.charAt(L);
            exist.put(current, true);

            while(R < s.length()){
                char next = s.charAt(R);

                if(L != R && exist.getOrDefault(next, false)) break;

                exist.put(next, true);
                R++;
            }

            max = Math.max(max, R - L);
            exist.put(current,false);
        }

        return max;
    }
}
