import java.io.*;

/**
 * [레벨 1] 없는 숫자 더하기
 *
 **/

public class Main {

    public static void main(String[] args) throws IOException {

    }

    public int solution(int[] numbers) {
        int answer = 0;

        for(int i = 1; i < 10; i++) answer += i;
        for(int next : numbers) answer -= next;

        return answer;
    }

}
