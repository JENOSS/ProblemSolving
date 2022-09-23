import java.io.*;
import java.util.*;

/**
 * [string] [easy] Strong Password
 */

public class Main {

    public static void main(String[] args) throws IOException {
    }

    public static String specialCase = "!@#$%^&*()-+";

    public static int minimumNumber(int n, String password) {
        int length = n - 6;

        boolean minLength = length >= 0;
        boolean digit = false;
        boolean lowerCase = false;
        boolean upperCase = false;
        boolean special = false;

        for(char c : password.toCharArray()){
            if(!digit) digit = Character.isDigit(c);
            if(!lowerCase) lowerCase = Character.isLowerCase(c);
            if(!upperCase) upperCase = Character.isUpperCase(c);
            if(!special) special = specialCase.contains(""+c);
        }

        int ans = 0;

        if(!digit) ans++;
        if(!lowerCase) ans++;
        if(!upperCase) ans++;
        if(!special) ans++;

        if(!minLength) ans = Math.max(ans, -length);
        return ans;
    }


}
