import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;


/**
 [1759] [완전탐색] 암호 만들기
 **/

public class Main {
    static StringBuilder ans = new StringBuilder();

    public static void main(String[] args) throws IOException {
        input();
        Arrays.sort(chars, 1, C+1);
        recFunc(1);
        System.out.print(ans.toString());
    }

    static void input() throws IOException{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine(), " ");
        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        chars = new char[C + 1];
        selected = new int[L + 1];

        st = new StringTokenizer(in.readLine(), " ");
        for(int i = 1; i <= C; i++){
            chars[i] = st.nextToken().charAt(0);
        }
    }

    static int L, C;
    static char[] chars;
    static int[] selected;

    static void recFunc(int k){
        if(k == L + 1){
            int vowel = 0;
            for(int i = 1; i <= L; i++){
                if(isVowel(chars[selected[i]])) vowel++;
            }

            if(vowel >= 1 && vowel <= L-2){
                for(int i = 1; i <= L; i++){
                    ans.append(chars[selected[i]]);
                }
                ans.append('\n');
            }
        }else{
            for(int cand = selected[k - 1] + 1; cand <= C; cand++){
                selected[k] = cand;
                recFunc(k + 1);
                selected[k] = 0;
            }

        }
    }

    static boolean isVowel(char x){
        return x == 'a' || x == 'e' || x == 'i' || x == 'o' || x == 'u';
    }
}