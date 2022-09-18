import java.io.*;
import java.util.*;


/**
 * [medium] [5] Longest Palindromic Substring
 *
 * Brute force 로 해결
 * 가운데에서 확장하며 palindrome 인지 확인
 * n^2
 *
 **/

public class Main {

    public static void main(String[] args) throws IOException {

    }

    public String answer = "";

    public String longestPalindrome(String s) {
        for(int i = 0; i < s.length(); i++){
            isPalindrome(s, i, i);
            isPalindrome(s, i, i + 1);
        }

        return answer;
    }

    public void isPalindrome(String s, int start, int end){
        if(start < 0) return;
        if(end >= s.length()) return;

        if(s.charAt(start) == s.charAt(end)){
            String sub = s.substring(start, end + 1);
            if(sub.length() > answer.length()) answer = sub;
            isPalindrome(s, start - 1, end + 1);
        }
    }
}
