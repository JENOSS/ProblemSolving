import java.io.*;
import java.util.*;

/**
 [20291] [정렬] 파일 정리
 **/

public class Main {
    static StringBuilder ans = new StringBuilder();

    public static void main(String[] args) throws IOException {
        input();
        run();
    }

    static int N;
    static String[] extensions;

    static void input() throws IOException{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(in.readLine());
        extensions = new String[N];

        for(int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(in.readLine(),".");
            st.nextToken();
            extensions[i] = st.nextToken();
        }
    }

    static void run(){
        Arrays.sort(extensions);

        String mode = extensions[0];
        int cnt = 1;

        for(int i = 1; i < N; i++){
            if(!mode.equals(extensions[i])){
                ans.append(mode).append(" ").append(cnt).append("\n");
                mode = extensions[i];
                cnt = 0;
            }
            cnt++;
        }

        ans.append(mode).append(" ").append(cnt).append("\n");

        System.out.print(ans);
    }

}