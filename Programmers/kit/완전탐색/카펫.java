import java.io.*;
import java.util.*;

/**
 * [kit] [완전탐색] [Lv 2] 카펫
 *
 * 옐로우가 가질 수 있는 width와 width만큼의 개수를 탐색
 * 옐로우의 총 개수의 약수들을 탐색
 * 브라운의 width는 옐로우의 width + 2 브라운의 총 개수는 width * 2 + (옐로우 width row  * 2)
 **/

public class Main {

    public static void main(String[] args) throws IOException {

    }

    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];

        for(int yWidthCnt = 1; yWidthCnt <= yellow; yWidthCnt++){
            if(yellow % yWidthCnt == 0){
                int yWidth = yellow / yWidthCnt;

                int bWidth = yWidth + 2;
                int bTotal = (bWidth * 2) + (yWidthCnt * 2);

                if(brown == bTotal){
                    answer[0] = bWidth;
                    answer[1] = yWidthCnt+2;
                    break;
                }
            }
        }

        return answer;
    }
}

