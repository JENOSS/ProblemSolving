import java.io.*;
import java.util.*;

/**
 * [Lv 1] 평균 구하기
 *
 */

public class Main {

    public static void main(String[] args) throws IOException {

    }

    public double solution(int[] arr) {
        return Arrays.stream(arr).average().orElse(0);
    }
}
