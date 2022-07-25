import java.io.*;
import java.util.*;

/**
 * [3584] [트리] 가장 가까운 공통 조상
 *
 * Child -> Parent 인접리스트를 구성
 * v1 의 부모들을 먼저 구한 후 v2의 부모가 포함되는지 확인
 **/

public class Main {

    public static void main(String[] args) throws IOException {
        input();
        run();
    }

    static TestCase[] testCases;
    static StringBuilder sb = new StringBuilder();

    static ArrayList<Integer>[] adj;
    static HashSet<Integer> parents;

    static class TestCase{
        int n;
        int v1, v2;
        ArrayList<Integer>[] adj;

        public TestCase(int n, ArrayList<Integer>[] adj, int v1, int v2) {
            this.n = n;
            this.adj = adj;
            this.v1 = v1;
            this.v2 = v2;
        }
    }

    static void input() throws IOException{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(in.readLine());
        testCases = new TestCase[size];

        for(int i = 0; i < size; i++){
            StringTokenizer st;

            int n = Integer.parseInt(in.readLine());
            ArrayList<Integer>[] adj = new ArrayList[n + 1];

            for(int k = 1; k <= n; k++) adj[k] = new ArrayList<>();

            for(int j = 0; j < n - 1; j++){
                st = new StringTokenizer(in.readLine(), " ");
                int p = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());
                adj[c].add(p);
            }

            st = new StringTokenizer(in.readLine(), " ");
            testCases[i] = new TestCase(n, adj, Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }
    }

    static void run(){
        for(TestCase t : testCases){
            parents = new HashSet<>();
            adj = t.adj;

            setDfs(t.v1);
            findDfs(t.v2);
        }

        System.out.print(sb);
    }

    static void setDfs(int start){
        parents.add(start);

        if(adj[start].size() > 0) setDfs(adj[start].get(0));
    }

    static void findDfs(int start){
        if(parents.contains(start)){
            sb.append(start).append("\n");
        }else{
            if(adj[start].size() > 0) findDfs(adj[start].get(0));
        }
    }

}
