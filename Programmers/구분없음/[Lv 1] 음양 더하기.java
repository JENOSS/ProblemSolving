import java.io.*;
import java.util.*;

/**
 * [easy] 음양 더하기
 *
 */

public class Main {

    public static void main(String[] args) throws IOException {

    }

    public int solution(int[] absolutes, boolean[] signs) {
        int answer = 0;

        for(int i = 0; i < absolutes.length; i++){
            answer += signs[i] ? absolutes[i] : -absolutes[i];
        }

        return answer;
    }
}
