import java.io.*;
import java.util.*;

/**
 * [kit] [완전탐색] [Lv 1] 최소직사각형
 *
 * 명함은 가로 세로를 변경할 수 있음
 * 따라서 둘 중 큰 수를 가로로, 작은 수를 세로로 두고 비교
 * 잘 못 생각하면 난이도 급격히 상승
 **/

public class Main {

    public static void main(String[] args) throws IOException {

    }

    public int solution(int[][] sizes) {
        int w = 0;
        int h = 0;

        for(int[] size: sizes){
            int nextW = Math.max(size[0], size[1]);
            int nextH = Math.min(size[0], size[1]);

            if(w < nextW) w = nextW;
            if(h < nextH) h = nextH;
        }


        return w*h;
    }
}

