import java.io.*;
import java.util.*;

/**
 * [string] [easy] Super Reduced String
 */

public class Main {

    public static void main(String[] args) throws IOException {
    }

    public static String superReducedString(String s) {

        if(s.isEmpty()) return "Empty String";

        for(int i = 0; i < s.length() - 1; i++){
            if(s.charAt(i) == s.charAt(i + 1)){
                return superReducedString(s.replace(""+s.charAt(i)+s.charAt(i), ""));
            }
        }

        return s;
    }

}
