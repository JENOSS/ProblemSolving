import java.io.*;
import java.util.*;

/**
 * [easy] 약수의 개수와 덧셈
 *
 */

public class Main {

    public static void main(String[] args) throws IOException {

    }

    public int solution(int left, int right) {
        int answer = 0;

        for(int i = left; i <= right; i++){
            answer += check(i) ? i : -i;
        }
        return answer;
    }

    public boolean check(int n){
        int cnt = 0;
        for(int i = 1; i <= n ; i ++){
            if(n % i == 0) cnt++;
        }

        return cnt % 2 == 0;
    }

}
