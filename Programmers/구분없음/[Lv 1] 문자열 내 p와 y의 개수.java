import java.util.*;

/**
 * [Lv 1] 문자열 내 p와 y의 개수
 *
 */

public class Main {

    public static void main(String[] args) {

    }

    boolean solution(String s) {
        int pC = 0;
        int yC = 0;

        for(char c : s.toCharArray()){
            if(c == 'p' || c == 'P') pC++;
            else if(c == 'y' || c == 'Y') yC++;
        }

        return pC == yC;
    }

}


