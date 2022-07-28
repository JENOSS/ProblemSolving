import java.io.*;
import java.util.*;

/**
 * [2637] [위상 정렬] 장난감 조립
 *
 **/

public class Main {

    public static void main(String[] args) throws IOException {
        input();
        run();
    }

    static int N, M;
    static ArrayList<Integer>[] adj;
    static HashMap<Integer, Integer>[] cntHs;
    static int[] inDegree;
    static int[][] cnt;

    static void input() throws IOException{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(in.readLine());
        M = Integer.parseInt(in.readLine());

        inDegree = new int[N + 1];
        cnt = new int[N + 1][N + 1];

        adj = new ArrayList[N + 1];
        cntHs = new HashMap[N + 1];
        for(int i = 1; i <= N; i++){
            adj[i] = new ArrayList<>();
            cntHs[i] = new HashMap<>();
        }

        for(int i = 0; i < M; i++){
            StringTokenizer st = new StringTokenizer(in.readLine(), " ");
            int child = Integer.parseInt(st.nextToken());
            int parent = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            adj[parent].add(child);
            inDegree[child]++;
            cnt[child][parent] = c;
        }

    }

    static void run(){
        HashSet<Integer> base = new HashSet<>();
        int last = 1;

        Queue<Integer> q = new LinkedList<>();
        for(int i = 1; i <= N; i++){
            if(inDegree[i] == 0){
                q.add(i);
                base.add(i);
            }
        }

        while(!q.isEmpty()){
            int current = q.poll();
            last = current;

            for(int next : adj[current]){
                inDegree[next]--;

                if(base.contains(current)){
                    cntHs[next].put(current, cnt[next][current]);
                }else{
                    for(int n : cntHs[current].keySet()){
                        cntHs[next].put(n, cntHs[current].get(n) * cnt[next][current] +
                                cntHs[next].getOrDefault(n, 0));
                    }
                }

                if(inDegree[next] == 0) q.add(next);
            }
        }

        List<Integer> ans = new ArrayList<>(cntHs[last].keySet());
        Collections.sort(ans);

        StringBuilder sb = new StringBuilder();
        for(int n : ans){
            sb.append(n).append(" ").append(cntHs[last].get(n)).append("\n");
        }

        System.out.print(sb);


    }



}
