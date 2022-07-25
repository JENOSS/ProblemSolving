import java.io.*;
import java.util.*;

/**
 * [20364] [트리] 부동산 다툼
 *
 * 끝에서 루트까지 올라오며 검사
 * 부모는 쉬프트 연산으로 확인
 **/

public class Main {

    public static void main(String[] args) throws IOException {
        input();
        run();
    }

    static int N, Q;
    static ArrayList<Integer> lands;
    static HashSet<Integer> hs;

    static void input() throws IOException{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());
        lands = new ArrayList<>();
        hs = new HashSet<>();

        for(int i = 0; i < Q; i++) lands.add(Integer.parseInt(in.readLine()));
    }

    static void run(){
        StringBuilder sb = new StringBuilder();

        for(int next : lands){
            int v = next;
            int res = 0;

            while(next > 0){
                if(hs.contains(next)) res = next;
                next = next >> 1;
            }

            hs.add(v);
            sb.append(res).append("\n");
        }

        System.out.print(sb);
    }


}
