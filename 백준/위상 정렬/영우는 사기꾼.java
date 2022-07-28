import java.io.*;
import java.util.*;

/**
 * [14676] [위상 정렬] 영우는 사기꾼?
 *
 **/

public class Main {

    public static void main(String[] args) throws IOException {
        input();
    }

    static int N, M, K;
    static int[] inDegree, cnt, satisfaction;
    static ArrayList<Integer>[] adj;

    static void input() throws IOException{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        adj = new ArrayList[N + 1];
        inDegree = new int[N + 1]; //v의 부모 개수
        cnt = new int[N + 1]; //v의 개수
        satisfaction = new int[N + 1]; //v의 부모가 전부 존재하는지 확인 하기 위함 (부모가 여러개 존재가능)

        for(int i = 1; i <= N; i++) adj[i] = new ArrayList<>();

        for(int j = 0; j < M; j++){
            st = new StringTokenizer(in.readLine(), " ");
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());
            adj[v1].add(v2);
            inDegree[v2]++;
        }

        boolean result = true;

        for(int k = 0; k < K; k++){
            st = new StringTokenizer(in.readLine(), " ");
            int key = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            if(key == 1){
                if(!checkCreate(v)){
                    result = false;
                }
            }else{
                if(!checkDrop(v)){
                    result = false;
                }
            }
        }

        System.out.println(result ? "King-God-Emperor" : "Lier!");
    }

    static boolean checkCreate(int v){
        boolean result = true;

        if(satisfaction[v] < inDegree[v]){
            result = false;
        }

        cnt[v]++;

        if(cnt[v] == 1){
            for(int next : adj[v]){
                satisfaction[next]++;
            }
        }

        return result;
    }

    static boolean checkDrop(int v){
        boolean result = true;

        if(cnt[v] == 0){
            result = false;
        }

        cnt[v]--;

        if(cnt[v] == 0){
            for(int next : adj[v]){
                satisfaction[next]--;
            }
        }

        return result;
    }


}
