import java.io.*;
import java.util.*;

/**
 [1181] [정렬] 단어 정렬
 **/

public class Main {
    static StringBuilder ans = new StringBuilder();

    public static void main(String[] args) throws IOException {
        input();
        run();
    }

    static int N;
    static String[] words;

    static void input() throws IOException{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(in.readLine());
        words = new String[N];

        for(int i = 0; i < N; i++){
            words[i] = in.readLine();
        }
    }

    static void run(){

        Arrays.sort(words, (o1, o2) ->{
           if(o1.length() == o2.length()){
               return o1.compareTo(o2);
           }else{
               return o1.length() - o2.length();
           }
        });

        String preWord = words[0];
        ans.append(preWord).append("\n");

        for(int i = 1; i < N; i++){
            if(!preWord.equals(words[i])){
                ans.append(words[i]).append("\n");
                preWord = words[i];
            }
        }

        System.out.print(ans);
    }


}