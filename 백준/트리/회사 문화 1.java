import java.io.*;
import java.util.*;

/**
 * [14267] [트리] 회사 문화 1
 *
 * 한 사람이 여러번 칭찬 받는 경우 존재
 * dfs 를 통해 자식의 celeb 을 전부 세팅
 **/

public class Main {

    public static void main(String[] args) throws IOException {
        input();
        run();
    }

    static int N, M;
    static ArrayList<Integer>[] adj;
    static int[] celeb;

    static void input() throws IOException{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        adj = new ArrayList[N + 1];
        celeb = new int[N + 1];

        for(int i = 1; i <= N; i++) adj[i] = new ArrayList<>();

        st = new StringTokenizer(in.readLine(), " ");
        for(int i = 1; i <= N; i++){
            int p = Integer.parseInt(st.nextToken());
            if(p != -1) adj[p].add(i);
        }

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(in.readLine(), " ");
            int n = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            celeb[n] += c;
        }
    }

    static void run(){
        dfs(1);

        StringBuilder sb = new StringBuilder();
        for(int i = 1; i <= N; i++) sb.append(celeb[i]).append(" ");

        System.out.println(sb);
    }

    static void dfs(int parent){

        for(int child : adj[parent]){
            celeb[child] += celeb[parent];
            dfs(child);
        }

    }


}
