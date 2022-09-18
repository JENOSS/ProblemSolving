import java.io.*;
import java.util.*;


/**
 * [medium] Bigger is Greater
 *
 * Brute force 로 해결
 * 작아지는 구간을 잡고 그 char 보다 크면서 가장 작은 char와 교환
 * 교환된 부분 뒤 부터 오름차순으로 정렬
 * n^2
 *
 **/

public class Main {

    public static void main(String[] args) throws IOException {

    }

    static char[] array;

    public static String biggerIsGreater(String w) {
        // Write your code here
        String answer = "no answer";
        array = w.toCharArray();
        int point = 0;
        int minIdx = 0;
        char min = 'z';

        StringBuilder sb = new StringBuilder();
        for(int i = w.length() - 1; i > 0; i--){
            if(array[i] > array[i - 1]){
                point = i - 1;
                for(int j = i; j <= w.length() - 1; j++){
                    if(array[point] < array[j] && min >= array[j]){
                        minIdx = j;
                        min = array[minIdx];
                    }
                }
                swap(minIdx, point);
                Arrays.sort(array,point + 1, array.length);
                for(char a : array) sb.append(a);
                answer = sb.toString();
                break;
            }
        }
        return answer;

    }

    public static void swap(int idx1, int idx2){
        char temp = array[idx1];
        array[idx1] = array[idx2];
        array[idx2] = temp;
    }

}
}
