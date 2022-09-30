import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * [1543] [정규표현식] 문서 검색
 *
 */

public class Main {

    public static void main(String[] args) throws IOException {
        input();
    }

    static void input() throws IOException{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String s = in.readLine();
        String ss = in.readLine();
        System.out.print(run(s,ss));
    }

    static int run(String s, String ss){
        Pattern pattern = Pattern.compile(ss);
        Matcher matcher = pattern.matcher(s);

        int cnt = 0;
        while(matcher.find()) cnt++;
        return cnt;
    }
}
