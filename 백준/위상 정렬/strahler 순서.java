import java.io.*;
import java.util.*;

/**
 * [9470] [위상 정렬] Strahler 순서
 *
 * 위상 정렬을 이용하여 indegree 가 0 인 것 부터 접근
 * 들어오는 노드의 strhler 순서가 같은 경우 해당 strahler 순서 + 1 세팅
 * 만약 이전에 세팅한 strahler 순서가 더 높으면 이전 값으로 유지
 **/

public class Main {

    public static void main(String[] args) throws IOException {
        input();
    }

    static int K, M, P;
    static ArrayList<Integer>[] adj;
    static int[] inDegree;
    static int[] starhler;
    static HashSet<Integer>[] hs;

    static StringBuilder sb = new StringBuilder();

    static void input() throws IOException{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int test = Integer.parseInt(in.readLine());

        for(int i = 0; i < test; i ++){
            StringTokenizer st = new StringTokenizer(in.readLine(), " ");
            K = Integer.parseInt(st.nextToken()); // 테스트 케이스 넘버
            M = Integer.parseInt(st.nextToken());
            P = Integer.parseInt(st.nextToken());

            inDegree = new int[M + 1];
            starhler = new int[M + 1];
            adj = new ArrayList[M + 1];
            hs = new HashSet[M + 1];

            for(int j = 1 ; j <= M; j++){
                adj[j] = new ArrayList<>();
                hs[j] = new HashSet<>();
            }


            for(int k = 0; k < P; k++){
                st = new StringTokenizer(in.readLine(), " ");
                int v1 = Integer.parseInt(st.nextToken());
                int v2 = Integer.parseInt(st.nextToken());
                adj[v1].add(v2);
                inDegree[v2]++;
            }

            run();
        }

        System.out.print(sb);
    }

    static void run(){
        int max = 1;

        Queue<Integer> q = new LinkedList<>();

        for(int i = 1; i <= M; i++){
            if(inDegree[i] == 0){
                q.add(i);
                starhler[i] = 1;
            }
        }

        while(!q.isEmpty()){
            int current = q.poll();

            for(int next : adj[current]){
                inDegree[next]--;
                if(inDegree[next] == 0){
                    q.add(next);
                }

                if(hs[next].contains(starhler[current])){
                    starhler[next] = Math.max(starhler[next], starhler[current] + 1);
                    max = Math.max(max, starhler[next]);
                }else{
                    hs[next].add(starhler[current]);
                    starhler[next] = starhler[current];
                }
            }
        }

        sb.append(K).append(" ").append(max).append("\n");
    }
}
