import java.io.*;

/**
 * [1264] [정규표현식] 모음의 개수
 *
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
            if(s.equals("#")) break;
            run(s, sb);
        }
        System.out.print(sb);
    }

    static void run(String s ,StringBuilder sb){
        String pattern = "[^iIeEaAoOuU]";
        String newString = s.replaceAll(pattern, "");
        sb.append(newString.length()).append("\n");
    }
}
