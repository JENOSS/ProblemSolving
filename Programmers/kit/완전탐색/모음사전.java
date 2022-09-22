import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        System.out.println(solution("I"));
    }

    static char[] words = {'A', 'E', 'I', 'O', 'U'};
    static char[] result = new char[5];
    static int count = 0;
    static int ans = 0;
    static String compare;

    public static int solution(String word) {
        for(int i = 0; i < 5; i++) result[i] = 'x';
        compare = word;
        dfs(0);
        return ans;
    }

    public static void dfs(int depth){
        if(depth == 5) return;

        for(int i = 0; i < 5; i++){
            count++;
            result[depth] = words[i];
            if(check(depth + 1)){
                ans = count;
            }
            dfs(depth + 1);
        }
    }

    public static boolean check(int n){
        StringBuilder sb = new StringBuilder();
        for(int i = 0 ; i < n; i++){
            sb.append(result[i]);
        }

        return sb.toString().equals(compare);
    }

}

