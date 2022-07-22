import java.io.*;
import java.util.*;

/**
 * [1068] [트리] 트리
 *
 **/

public class Main {

    public static void main(String[] args) throws IOException {
        input();
        run();
    }

    static int V, root, delete, cnt = 0;
    static ArrayList<Integer>[] adj;
    static int[] leaf;
    static boolean[] visit;

    static void input() throws IOException{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        V = Integer.parseInt(in.readLine());
        adj = new ArrayList[V];
        leaf = new int[V];
        visit = new boolean[V];

        for(int i = 0; i < V; i++) adj[i] = new ArrayList<>();

        StringTokenizer st = new StringTokenizer(in.readLine(), " ");

        for(int i = 0; i < V; i++){
            int parent = Integer.parseInt(st.nextToken());
            if(parent == -1){
                root = i;
                continue;
            }
            adj[parent].add(i);
        }

        delete = Integer.parseInt(in.readLine());
    }

    static void run(){
        if(root != delete){
            for(int i = 0 ; i < V; i++){
                if(adj[i].contains(delete)){
                    adj[i].remove((Integer) delete);
                    break;
                }
            }
            dfs(root);
        }
        System.out.println(cnt);
    }

    static void dfs(int x){
        visit[x] = true;
        if(adj[x].size() == 0) cnt++;

        for(int next : adj[x]){
            if(!visit[next]){
                dfs(next);
            }
        }
    }

}
