import java.io.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;


/**
 [15663] [완전탐색] N과 M(9)
 **/

public class Main {
    static StringBuilder ans = new StringBuilder();

    public static void main(String[] args) throws IOException {
        input();
        Arrays.sort(nums,1,N + 1);
        recFunc(1);
        System.out.print(ans);
    }


    static void input() throws IOException{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine()," ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        nums = new int[N + 1];
        used = new int[N + 1];
        selected = new int[M + 1];

        st = new StringTokenizer(in.readLine(), " ");
        for(int i = 1; i <= N; i++){
            nums[i] = Integer.parseInt(st.nextToken());
        }
    }

    static int N, M;
    static int[] nums, selected, used;

    static void recFunc(int k){
        if(k == M + 1){
            for(int i = 1; i <= M; i++) ans.append(selected[i]).append(' ');
            ans.append('\n');
        }else{
            int lastCand = 0;
            for(int cand = 1; cand <= N; cand++){
                if(used[cand] == 1) continue;
                if(nums[cand] == lastCand) continue;

                lastCand = nums[cand];
                selected[k] = nums[cand];
                used[cand] = 1;

                recFunc(k + 1);
                selected[k] = 0;
                used[cand] = 0;
            }
        }
    }

}