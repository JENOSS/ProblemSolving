import java.io.*;
import java.util.*;


/**
 * [카카오] [easy] CamelCase
 *
 *  Character.toUpperCase() 로 해결
 **/

public class Main {

    public static void main(String[] args) throws IOException {

    }

    public static int camelcase(String s) {
        int cnt = 1;
        for(char next : s.toCharArray()){
            if(isUpperCase(next)) cnt++;
        }

        return cnt;
    }

    public static boolean isUpperCase(Character c){
        Character compare = Character.toUpperCase(c);
        return compare.equals(c);
    }

}
