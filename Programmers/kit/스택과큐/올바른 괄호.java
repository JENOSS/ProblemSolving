import java.io.*;

/**
 * [스택/큐] 올바른 괄호
 *
 **/

public class Main {

    public static void main(String[] args) throws IOException {
        System.out.println(solution("()()"));
    }

    static boolean solution(String s) {
        int left = 0;
        int right = 0;

        for(int i = 0 ; i < s.length(); i++){
            char c = s.charAt(i);

            if(c == '('){
                left++;
            }else{
                if(i == 0) return false;

                right++;

                if(left < right){
                    return false;
                }
            }
        }

        if(left != right){
            return false;
        }

        return true;
    }


}
