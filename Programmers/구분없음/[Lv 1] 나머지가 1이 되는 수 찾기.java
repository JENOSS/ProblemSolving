import java.io.*;
import java.util.ArrayList;
import java.util.*;
import java.util.stream.Collectors;

/**
 * [레벨 1] 나머지가 1이 되는 수 찾기
 *
 **/

public class Main {

    public static void main(String[] args) throws IOException {

    }

    public int solution(int n) {
        int answer = 0;
        for(int i = 1; i < n; i++){
            if(n % i == 1) {
                answer = i;
                break;
            }
        }
        return answer;
    }

}
