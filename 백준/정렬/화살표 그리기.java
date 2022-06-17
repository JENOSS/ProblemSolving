import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

/**
 [15970] [정렬] 화살표 그리기
 **/

public class Main {

    public static void main(String[] args) throws IOException {
        input();
        run();
    }

    static int N;
    static ArrayList<Integer>[] colors;

    static void input() throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(in.readLine());
        colors = new ArrayList[N + 1];

        for(int i = 0; i <= N; i++){
            colors[i] = new ArrayList<>();
        }

        for(int i = 1; i <= N; i++){
            StringTokenizer st = new StringTokenizer(in.readLine(), " ");
            int num = Integer.parseInt(st.nextToken());
            int color = Integer.parseInt(st.nextToken());

            colors[color].add(num);
        }
    }

    static void run(){
        int ans = 0;

        for(ArrayList<Integer> list : colors){
            if(list.size() == 0) continue;
            Collections.sort(list);

            for(int i = 0; i < list.size(); i++){
                int left = Integer.MAX_VALUE;
                int right = Integer.MAX_VALUE;

                if(i - 1 >= 0) left = Math.abs(list.get(i - 1) - list.get(i));
                if(i + 1 < list.size()) right = Math.abs(list.get(i + 1) - list.get(i));

                ans += Math.min(left,right);
            }
        }

        System.out.println(ans);

    }


}