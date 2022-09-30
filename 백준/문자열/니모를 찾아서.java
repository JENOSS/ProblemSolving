import java.io.*;

/**
 * [10173] [정규표현식] 니모를 찾아서
 *
 * (?i) : 대소문자 구분 없이
 * .*nemo.* : ~~~nemo~~~~
 */

public class Main {

    public static void main(String[] args) throws IOException {
        input();
    }

    static void input() throws IOException{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while(true){
            String s = in.readLine();
            if(s.equals("EOI")) break;
            run(s, sb);
        }
        System.out.print(sb);
    }

    static void run(String s ,StringBuilder sb){
        String pattern = "(?i).*nemo.*";
        if(s.matches(pattern)) sb.append("Found").append("\n");
        else sb.append("Missing").append("\n");
    }
}
