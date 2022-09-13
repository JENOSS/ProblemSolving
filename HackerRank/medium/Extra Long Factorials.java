import java.io.*;
import java.math.BigInteger;

/**
 * [medium] Extra Long Factorials
 *
 * BigInteger를 이용해 해결
 **/

public class Main {

    public static void main(String[] args) throws IOException {
        extraLongFactorials(50);
    }

    public static void extraLongFactorials(int n) {
        // Write your code here
        BigInteger v = new BigInteger(String.valueOf(n));

        for(int i = n - 1; i > 0; i--){
            v = v.multiply(new BigInteger(String.valueOf(i)));
        }

        System.out.println(v);
    }


}
